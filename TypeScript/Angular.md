# Guía Angular para Desarrolladores Senior - Entrevistas Técnicas

## 📚 Índice
1. [Arquitectura Angular](#arquitectura-angular)
2. [Componentes Avanzados](#componentes-avanzados)
3. [Servicios y Dependency Injection](#servicios-y-dependency-injection)
4. [RxJS y Programación Reactiva](#rxjs-y-programación-reactiva)
5. [Routing Avanzado](#routing-avanzado)
6. [Formularios y Validaciones](#formularios-y-validaciones)
7. [HTTP y Estado](#http-y-estado)
8. [Optimización de Performance](#optimización-de-performance)
9. [Testing Avanzado](#testing-avanzado)
10. [Angular Universal y SSR](#angular-universal-y-ssr)
11. [NgRx State Management](#ngrx-state-management)
12. [Custom Directives y Pipes](#custom-directives-y-pipes)
13. [Microfrontends](#microfrontends)
14. [Seguridad](#seguridad)
15. [Preguntas Típicas de Entrevista](#preguntas-típicas-de-entrevista)

---

## 🏗️ Arquitectura Angular

### Conceptos Core
- **Modules**: Organización de la aplicación
- **Components**: Bloques de construcción de la UI
- **Services**: Lógica de negocio compartida
- **Dependency Injection**: Sistema de inyección de dependencias
- **Decorators**: Metadatos para clases (@Component, @Injectable, etc.)

### Lifecycle Hooks Avanzados
```typescript
export class AdvancedComponent implements OnInit, OnDestroy, AfterViewInit, OnChanges {
  @Input() data: any;
  
  // Orden de ejecución de hooks
  ngOnChanges(changes: SimpleChanges) {
    // Se ejecuta cuando cambian los @Input()
    console.log('OnChanges:', changes);
  }
  
  ngOnInit() {
    // Inicialización del componente
    console.log('OnInit');
  }
  
  ngAfterViewInit() {
    // Vista completamente inicializada
    console.log('AfterViewInit');
  }
  
  ngOnDestroy() {
    // Limpieza antes de destruir el componente
    console.log('OnDestroy');
  }
}
```

### Zone.js y Change Detection
```typescript
// Estrategias de Change Detection
@Component({
  selector: 'app-optimized',
  changeDetection: ChangeDetectionStrategy.OnPush,
  template: `
    <div>{{ data | json }}</div>
    <button (click)="updateData()">Update</button>
  `
})
export class OptimizedComponent {
  @Input() data: any;
  
  constructor(private cdr: ChangeDetectorRef) {}
  
  updateData() {
    // Forzar detección de cambios
    this.cdr.markForCheck();
    // O ejecutar fuera de Zone.js
    this.ngZone.runOutsideAngular(() => {
      // Operaciones pesadas
    });
  }
}
```

---

## 🧩 Componentes Avanzados

### Content Projection Avanzado
```typescript
// Multi-slot projection
@Component({
  selector: 'app-card',
  template: `
    <div class="card">
      <header>
        <ng-content select="[slot=header]"></ng-content>
      </header>
      <main>
        <ng-content></ng-content>
      </main>
      <footer>
        <ng-content select="[slot=footer]"></ng-content>
      </footer>
    </div>
  `
})
export class CardComponent {}

// Uso
/*
<app-card>
  <h2 slot="header">Título</h2>
  <p>Contenido principal</p>
  <button slot="footer">Acción</button>
</app-card>
*/
```

### ViewChild y ContentChild Avanzado
```typescript
@Component({
  template: `
    <app-child #childRef></app-child>
    <ng-content></ng-content>
  `
})
export class ParentComponent implements AfterViewInit {
  @ViewChild('childRef', { static: false }) childComponent!: ChildComponent;
  @ViewChildren(ChildComponent) children!: QueryList<ChildComponent>;
  @ContentChild(SomeDirective) directive!: SomeDirective;
  
  ngAfterViewInit() {
    // Acceso a elementos del template
    this.childComponent.someMethod();
    
    // Escuchar cambios en la QueryList
    this.children.changes.subscribe(list => {
      console.log('Children changed:', list);
    });
  }
}
```

### Dynamic Components
```typescript
@Component({
  template: `<div #dynamicContainer></div>`
})
export class DynamicHostComponent implements OnInit {
  @ViewChild('dynamicContainer', { read: ViewContainerRef }) 
  container!: ViewContainerRef;
  
  constructor(private componentFactoryResolver: ComponentFactoryResolver) {}
  
  ngOnInit() {
    this.loadComponent();
  }
  
  loadComponent() {
    const factory = this.componentFactoryResolver.resolveComponentFactory(DynamicComponent);
    const componentRef = this.container.createComponent(factory);
    
    // Pasar datos al componente dinámico
    componentRef.instance.data = { message: 'Hello Dynamic!' };
    
    // Escuchar eventos
    componentRef.instance.eventEmitter.subscribe(data => {
      console.log('Event from dynamic component:', data);
    });
  }
}
```

---

## 💉 Servicios y Dependency Injection

### Providers Avanzados
```typescript
// Factory Provider
export function createLogger(isDev: boolean): Logger {
  return isDev ? new DevLogger() : new ProdLogger();
}

@NgModule({
  providers: [
    {
      provide: Logger,
      useFactory: createLogger,
      deps: [IS_DEV_MODE]
    },
    {
      provide: IS_DEV_MODE,
      useValue: !environment.production
    },
    // Class Provider
    { provide: ApiService, useClass: MockApiService },
    // Value Provider
    { provide: API_URL, useValue: 'https://api.example.com' },
    // Existing Provider
    { provide: NewService, useExisting: OldService }
  ]
})
export class AppModule {}
```

### Injection Tokens
```typescript
// Crear tokens personalizados
export const API_CONFIG = new InjectionToken<ApiConfig>('api.config');

interface ApiConfig {
  baseUrl: string;
  timeout: number;
}

@Injectable()
export class ApiService {
  constructor(@Inject(API_CONFIG) private config: ApiConfig) {}
  
  get(endpoint: string) {
    return this.http.get(`${this.config.baseUrl}/${endpoint}`);
  }
}

// Configuración en el módulo
@NgModule({
  providers: [
    {
      provide: API_CONFIG,
      useValue: {
        baseUrl: environment.apiUrl,
        timeout: 5000
      }
    }
  ]
})
export class AppModule {}
```

### Tree-shakable Providers
```typescript
@Injectable({
  providedIn: 'root'
})
export class GlobalService {}

@Injectable({
  providedIn: 'any'
})
export class InstancePerInjectorService {}

// Provider con factory
@Injectable({
  providedIn: 'root',
  useFactory: () => new CustomService(environment.config)
})
export class CustomService {}
```

---

## 🔄 RxJS y Programación Reactiva

### Operadores Avanzados
```typescript
@Injectable()
export class DataService {
  private subject = new Subject<any>();
  
  // CombineLatest - Combinar múltiples observables
  getCombinedData() {
    return combineLatest([
      this.getUsers(),
      this.getPermissions(),
      this.getSettings()
    ]).pipe(
      map(([users, permissions, settings]) => ({
        users, permissions, settings
      }))
    );
  }
  
  // SwitchMap vs MergeMap vs ConcatMap
  searchWithSwitch(term: string) {
    return this.searchSubject.pipe(
      debounceTime(300),
      distinctUntilChanged(),
      switchMap(term => this.api.search(term)) // Cancela requests anteriores
    );
  }
  
  searchWithMerge(term: string) {
    return this.searchSubject.pipe(
      mergeMap(term => this.api.search(term)) // Todos los requests en paralelo
    );
  }
  
  searchWithConcat(term: string) {
    return this.searchSubject.pipe(
      concatMap(term => this.api.search(term)) // Requests secuenciales
    );
  }
  
  // ExhaustMap - Ignora nuevos valores hasta que complete el anterior
  saveWithExhaust(data: any) {
    return this.saveSubject.pipe(
      exhaustMap(data => this.api.save(data))
    );
  }
}
```

### Custom Operators
```typescript
// Operador personalizado para retry con delay exponencial
function retryWithBackoff(maxRetries: number = 3) {
  return (source: Observable<any>) => source.pipe(
    retryWhen(errors =>
      errors.pipe(
        scan((acc, error) => {
          if (acc >= maxRetries) {
            throw error;
          }
          return acc + 1;
        }, 0),
        delay(1000)
      )
    )
  );
}

// Uso
this.api.getData().pipe(
  retryWithBackoff(3),
  catchError(error => of(null))
).subscribe();
```

### Subjects Avanzados
```typescript
export class StateService {
  // BehaviorSubject - Mantiene el último valor
  private userState = new BehaviorSubject<User | null>(null);
  user$ = this.userState.asObservable();
  
  // ReplaySubject - Mantiene histórico
  private actionsHistory = new ReplaySubject<Action>(10);
  actions$ = this.actionsHistory.asObservable();
  
  // AsyncSubject - Emite solo el último valor al completarse
  private asyncResult = new AsyncSubject<Result>();
  result$ = this.asyncResult.asObservable();
  
  updateUser(user: User) {
    this.userState.next(user);
  }
  
  logAction(action: Action) {
    this.actionsHistory.next(action);
  }
}
```

---

## 🛣️ Routing Avanzado

### Guards Avanzados
```typescript
@Injectable()
export class AuthGuard implements CanActivate, CanActivateChild, CanLoad {
  constructor(private auth: AuthService, private router: Router) {}
  
  canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): 
    Observable<boolean | UrlTree> {
    return this.auth.isAuthenticated$.pipe(
      map(isAuth => {
        if (isAuth) {
          return true;
        }
        return this.router.createUrlTree(['/login'], {
          queryParams: { returnUrl: state.url }
        });
      })
    );
  }
  
  canActivateChild = this.canActivate;
  
  canLoad(route: Route): Observable<boolean> {
    return this.auth.hasPermission(route.data?.['permission']);
  }
}

// Resolver para pre-cargar datos
@Injectable()
export class UserResolver implements Resolve<User> {
  constructor(private userService: UserService) {}
  
  resolve(route: ActivatedRouteSnapshot): Observable<User> {
    const id = route.paramMap.get('id');
    return this.userService.getUser(id!).pipe(
      catchError(() => EMPTY) // Navegar aunque falle
    );
  }
}
```

### Routing Configuration Avanzado
```typescript
const routes: Routes = [
  {
    path: 'admin',
    loadChildren: () => import('./admin/admin.module').then(m => m.AdminModule),
    canLoad: [AdminGuard],
    data: { preload: true }
  },
  {
    path: 'user/:id',
    component: UserComponent,
    resolve: { user: UserResolver },
    canActivate: [AuthGuard],
    canDeactivate: [UnsavedChangesGuard]
  },
  {
    path: '',
    redirectTo: '/dashboard',
    pathMatch: 'full'
  },
  {
    path: '**',
    component: NotFoundComponent
  }
];

// Preloading Strategy personalizada
export class CustomPreloadingStrategy implements PreloadingStrategy {
  preload(route: Route, load: () => Observable<any>): Observable<any> {
    if (route.data && route.data['preload']) {
      return load();
    }
    return of(null);
  }
}
```

---

## 📝 Formularios y Validaciones

### Reactive Forms Avanzados
```typescript
export class AdvancedFormComponent implements OnInit {
  userForm!: FormGroup;
  
  constructor(private fb: FormBuilder) {}
  
  ngOnInit() {
    this.userForm = this.fb.group({
      personal: this.fb.group({
        name: ['', [Validators.required, Validators.minLength(2)]],
        email: ['', [Validators.required, Validators.email], [this.emailValidator.bind(this)]]
      }),
      address: this.fb.group({
        street: ['', Validators.required],
        city: ['', Validators.required],
        country: ['', Validators.required]
      }),
      preferences: this.fb.array([])
    });
    
    // Escuchar cambios
    this.userForm.get('personal.email')?.valueChanges.pipe(
      debounceTime(300),
      distinctUntilChanged(),
      switchMap(email => this.validateEmailExists(email))
    ).subscribe();
  }
  
  // Validador asíncrono personalizado
  emailValidator(control: AbstractControl): Observable<ValidationErrors | null> {
    if (!control.value) {
      return of(null);
    }
    
    return this.userService.checkEmailExists(control.value).pipe(
      map(exists => exists ? { emailExists: true } : null),
      catchError(() => of(null))
    );
  }
  
  // FormArray dinámico
  get preferences() {
    return this.userForm.get('preferences') as FormArray;
  }
  
  addPreference() {
    const preference = this.fb.group({
      category: ['', Validators.required],
      value: ['', Validators.required]
    });
    this.preferences.push(preference);
  }
  
  removePreference(index: number) {
    this.preferences.removeAt(index);
  }
}
```

### Custom Form Controls
```typescript
@Component({
  selector: 'app-rating',
  template: `
    <div class="rating">
      <span *ngFor="let star of stars; let i = index"
            [class.filled]="i < value"
            (click)="rate(i + 1)">
        ⭐
      </span>
    </div>
  `,
  providers: [
    {
      provide: NG_VALUE_ACCESSOR,
      useExisting: forwardRef(() => RatingComponent),
      multi: true
    }
  ]
})
export class RatingComponent implements ControlValueAccessor {
  stars = Array(5).fill(0);
  value = 0;
  
  private onChange = (value: number) => {};
  private onTouched = () => {};
  
  rate(rating: number) {
    this.value = rating;
    this.onChange(this.value);
    this.onTouched();
  }
  
  writeValue(value: number) {
    this.value = value || 0;
  }
  
  registerOnChange(fn: (value: number) => void) {
    this.onChange = fn;
  }
  
  registerOnTouched(fn: () => void) {
    this.onTouched = fn;
  }
}
```

---

## 🌐 HTTP y Estado

### HTTP Interceptors Avanzados
```typescript
@Injectable()
export class AuthInterceptor implements HttpInterceptor {
  constructor(private auth: AuthService) {}
  
  intercept(req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
    // Agregar token de autorización
    const authReq = req.clone({
      headers: req.headers.set('Authorization', `Bearer ${this.auth.token}`)
    });
    
    return next.handle(authReq).pipe(
      retry(2),
      catchError((error: HttpErrorResponse) => {
        if (error.status === 401) {
          // Redirect to login
          this.auth.logout();
        }
        return throwError(error);
      })
    );
  }
}

@Injectable()
export class CacheInterceptor implements HttpInterceptor {
  private cache = new Map<string, HttpResponse<any>>();
  
  intercept(req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
    if (req.method === 'GET') {
      const cachedResponse = this.cache.get(req.url);
      if (cachedResponse) {
        return of(cachedResponse);
      }
    }
    
    return next.handle(req).pipe(
      tap(event => {
        if (event instanceof HttpResponse && req.method === 'GET') {
          this.cache.set(req.url, event);
        }
      })
    );
  }
}
```

### Estado Global sin NgRx
```typescript
@Injectable({
  providedIn: 'root'
})
export class AppStateService {
  private state = new BehaviorSubject({
    user: null,
    loading: false,
    error: null
  });
  
  state$ = this.state.asObservable();
  
  // Selectores
  user$ = this.state$.pipe(map(state => state.user));
  loading$ = this.state$.pipe(map(state => state.loading));
  error$ = this.state$.pipe(map(state => state.error));
  
  // Acciones
  setUser(user: User) {
    this.updateState({ user });
  }
  
  setLoading(loading: boolean) {
    this.updateState({ loading });
  }
  
  setError(error: string | null) {
    this.updateState({ error });
  }
  
  private updateState(partialState: Partial<any>) {
    this.state.next({
      ...this.state.value,
      ...partialState
    });
  }
}
```

---

## ⚡ Optimización de Performance

### OnPush Strategy y Trackby
```typescript
@Component({
  selector: 'app-optimized-list',
  changeDetection: ChangeDetectionStrategy.OnPush,
  template: `
    <div *ngFor="let item of items; trackBy: trackByFn" 
         [class.selected]="item.selected">
      {{ item.name }}
    </div>
  `
})
export class OptimizedListComponent {
  @Input() items: Item[] = [];
  
  // TrackBy function para optimizar ngFor
  trackByFn(index: number, item: Item): any {
    return item.id; // Usar identificador único
  }
}
```

### Lazy Loading y Code Splitting
```typescript
// Feature module con lazy loading
const routes: Routes = [
  {
    path: 'features',
    loadChildren: () => import('./features/features.module').then(m => m.FeaturesModule)
  },
  {
    path: 'admin',
    loadComponent: () => import('./admin/admin.component').then(c => c.AdminComponent)
  }
];

// Preload modules basado en condiciones
export class SelectivePreloadingStrategy implements PreloadingStrategy {
  preload(route: Route, load: () => Observable<any>): Observable<any> {
    if (route.data?.['preload'] && this.shouldPreload()) {
      return load();
    }
    return of(null);
  }
  
  private shouldPreload(): boolean {
    // Lógica personalizada: conexión rápida, tiempo disponible, etc.
    return navigator.connection?.effectiveType === '4g';
  }
}
```

### Virtual Scrolling
```typescript
@Component({
  template: `
    <cdk-virtual-scroll-viewport itemSize="50" class="viewport">
      <div *cdkVirtualFor="let item of items; trackBy: trackByFn">
        {{ item.name }}
      </div>
    </cdk-virtual-scroll-viewport>
  `,
  styles: [`
    .viewport {
      height: 200px;
      width: 200px;
    }
  `]
})
export class VirtualScrollComponent {
  items = Array.from({length: 100000}).map((_, i) => ({
    id: i,
    name: `Item ${i}`
  }));
  
  trackByFn = (index: number, item: any) => item.id;
}
```

### Web Workers
```typescript
// web-worker.worker.ts
/// <reference lib="webworker" />

addEventListener('message', ({ data }) => {
  const result = heavyComputation(data);
  postMessage(result);
});

function heavyComputation(data: any[]) {
  // Procesamiento pesado
  return data.map(item => ({ ...item, processed: true }));
}

// Componente usando Web Worker
@Component({})
export class WorkerComponent {
  constructor() {
    if (typeof Worker !== 'undefined') {
      const worker = new Worker(new URL('./web-worker.worker', import.meta.url));
      
      worker.postMessage(this.heavyData);
      
      worker.onmessage = ({ data }) => {
        this.processedData = data;
      };
    }
  }
}
```

---

## 🧪 Testing Avanzado

### Component Testing con Angular Testing Utilities
```typescript
describe('UserComponent', () => {
  let component: UserComponent;
  let fixture: ComponentFixture<UserComponent>;
  let userService: jasmine.SpyObj<UserService>;

  beforeEach(async () => {
    const spy = jasmine.createSpyObj('UserService', ['getUser', 'updateUser']);

    await TestBed.configureTestingModule({
      declarations: [UserComponent],
      imports: [ReactiveFormsModule, HttpClientTestingModule],
      providers: [
        { provide: UserService, useValue: spy }
      ]
    }).compileComponents();

    fixture = TestBed.createComponent(UserComponent);
    component = fixture.componentInstance;
    userService = TestBed.inject(UserService) as jasmine.SpyObj<UserService>;
  });

  it('should load user data on init', fakeAsync(() => {
    const mockUser = { id: 1, name: 'Test User' };
    userService.getUser.and.returnValue(of(mockUser));

    component.ngOnInit();
    tick();

    expect(component.user).toEqual(mockUser);
    expect(userService.getUser).toHaveBeenCalledWith(1);
  }));

  it('should handle form submission', async () => {
    component.userForm.patchValue({ name: 'Updated Name' });
    userService.updateUser.and.returnValue(of({}));

    await component.onSubmit();

    expect(userService.updateUser).toHaveBeenCalledWith(
      jasmine.objectContaining({ name: 'Updated Name' })
    );
  });
});
```

### Service Testing con HTTP
```typescript
describe('ApiService', () => {
  let service: ApiService;
  let httpMock: HttpTestingController;

  beforeEach(() => {
    TestBed.configureTestingModule({
      imports: [HttpClientTestingModule],
      providers: [ApiService]
    });
    
    service = TestBed.inject(ApiService);
    httpMock = TestBed.inject(HttpTestingController);
  });

  afterEach(() => {
    httpMock.verify();
  });

  it('should fetch users', () => {
    const mockUsers = [{ id: 1, name: 'User 1' }];

    service.getUsers().subscribe(users => {
      expect(users).toEqual(mockUsers);
    });

    const req = httpMock.expectOne('/api/users');
    expect(req.request.method).toBe('GET');
    req.flush(mockUsers);
  });

  it('should handle error responses', () => {
    service.getUsers().subscribe({
      next: () => fail('Should have failed'),
      error: (error) => {
        expect(error.status).toBe(500);
      }
    });

    const req = httpMock.expectOne('/api/users');
    req.flush('Error', { status: 500, statusText: 'Server Error' });
  });
});
```

### E2E Testing con Cypress
```typescript
// cypress/integration/user-flow.spec.ts
describe('User Flow', () => {
  beforeEach(() => {
    cy.visit('/login');
  });

  it('should complete user registration flow', () => {
    // Login
    cy.get('[data-cy=email]').type('user@example.com');
    cy.get('[data-cy=password]').type('password');
    cy.get('[data-cy=login-btn]').click();

    // Navigate to profile
    cy.url().should('include', '/dashboard');
    cy.get('[data-cy=profile-link]').click();

    // Update profile
    cy.get('[data-cy=name-input]').clear().type('Updated Name');
    cy.get('[data-cy=save-btn]').click();

    // Verify success
    cy.get('[data-cy=success-message]').should('be.visible');
    cy.get('[data-cy=name-display]').should('contain', 'Updated Name');
  });

  it('should handle API errors gracefully', () => {
    cy.intercept('POST', '/api/users', { statusCode: 500 }).as('serverError');
    
    cy.get('[data-cy=create-user-btn]').click();
    cy.wait('@serverError');
    
    cy.get('[data-cy=error-message]').should('contain', 'Server error');
  });
});
```

---

## 📦 NgRx State Management

### Store Setup
```typescript
// State interface
export interface AppState {
  users: UserState;
  auth: AuthState;
}

export interface UserState {
  users: User[];
  selectedUser: User | null;
  loading: boolean;
  error: string | null;
}

// Actions
export const loadUsers = createAction('[User] Load Users');
export const loadUsersSuccess = createAction(
  '[User] Load Users Success',
  props<{ users: User[] }>()
);
export const loadUsersFailure = createAction(
  '[User] Load Users Failure',
  props<{ error: string }>()
);

// Reducer
const initialState: UserState = {
  users: [],
  selectedUser: null,
  loading: false,
  error: null
};

export const userReducer = createReducer(
  initialState,
  on(loadUsers, state => ({ ...state, loading: true, error: null })),
  on(loadUsersSuccess, (state, { users }) => ({
    ...state,
    users,
    loading: false
  })),
  on(loadUsersFailure, (state, { error }) => ({
    ...state,
    loading: false,
    error
  }))
);
```

### Effects
```typescript
@Injectable()
export class UserEffects {
  loadUsers$ = createEffect(() =>
    this.actions$.pipe(
      ofType(loadUsers),
      switchMap(() =>
        this.userService.getUsers().pipe(
          map(users => loadUsersSuccess({ users })),
          catchError(error => of(loadUsersFailure({ error: error.message })))
        )
      )
    )
  );

  constructor(
    private actions$: Actions,
    private userService: UserService
  ) {}
}
```

### Selectors
```typescript
export const selectUserState = (state: AppState) => state.users;

export const selectAllUsers = createSelector(
  selectUserState,
  (state: UserState) => state.users
);

export const selectUserLoading = createSelector(
  selectUserState,
  (state: UserState) => state.loading
);

export const selectActiveUsers = createSelector(
  selectAllUsers,
  (users: User[]) => users.filter(user => user.active)
);

// Selector con parámetros
export const selectUserById = (id: number) => createSelector(
  selectAllUsers,
  (users: User[]) => users.find(user => user.id === id)
);
```

---

## 🎨 Custom Directives y Pipes

### Directivas Estructurales
```typescript
@Directive({
  selector: '[appIf]'
})
export class IfDirective {
  private hasView = false;

  constructor(
    private templateRef: TemplateRef<any>,
    private viewContainer: ViewContainerRef
  ) {}

  @Input() set appIf(condition: boolean) {
    if (condition && !this.hasView) {
      this.viewContainer.createEmbeddedView(this.templateRef);
      this.hasView = true;
    } else if (!condition && this.hasView) {
      this.viewContainer.clear();
      this.hasView = false;
    }
  }
}

// Uso: <div *appIf="showElement">Content</div>
```

### Directivas de Atributo
```typescript
@Directive({
  selector: '[appHighlight]'
})
export class HighlightDirective implements OnInit {
  @Input() appHighlight = 'yellow';
  @Input() defaultColor = 'transparent';

  constructor(private el: ElementRef, private renderer: Renderer2) {}

  ngOnInit() {
    this.renderer.setStyle(this.el.nativeElement, 'backgroundColor', this.defaultColor);
  }

  @HostListener('mouseenter') onMouseEnter() {
    this.highlight(this.appHighlight);
  }

  @HostListener('mouseleave') onMouseLeave() {
    this.highlight(this.defaultColor);
  }

  private highlight(color: string) {
    this.renderer.setStyle(this.el.nativeElement, 'backgroundColor', color);
  }
}
```

### Pipes Personalizados
```typescript
@Pipe({
  name: 'exponentialStrength',
  pure: true // Para performance
})
export class ExponentialStrengthPipe implements PipeTransform {
  transform(value: number, exponent = 1): number {
    return Math.pow(value, exponent);
  }
}

@Pipe({
  name: 'asyncFilter',
  pure: false // Para datos que cambian
})
export class AsyncFilterPipe implements PipeTransform {
  private lastFilter = '';
  private lastResult: any[] = [];

  transform(items: any[], filter: string): any[] {
    if (!items || !filter) {
      return items;
    }

    if (filter === this.lastFilter) {
      return this.lastResult;
    }

    this.lastFilter = filter;
    this.lastResult = items.filter(item => 
      item.name.toLowerCase().includes(filter.toLowerCase())
    );

    return this.lastResult;
  }
}
```

---

## 🔧 Microfrontends

### Module Federation Setup
```typescript
// webpack.config.js para Host
const ModuleFederationPlugin = require("@module-federation/webpack");

module.exports = {
  plugins: [
    new ModuleFederationPlugin({
      name: "host",
      remotes: {
        "mfe1": "mfe1@http://localhost:4201/remoteEntry.js",
        "mfe2": "mfe2@http://localhost:4202/remoteEntry.js",
      },
    }),
  ],
};

// Cargar microfrontend dinámicamente
@Component({
  template: '<div #container></div>'
})
export class MicrofrontendComponent implements OnInit {
  @ViewChild('container', { read: ViewContainerRef }) 
  container!: ViewContainerRef;

  async ngOnInit() {
    const { RemoteComponent } = await import('mfe1/Component');
    const componentRef = this.container.createComponent(RemoteComponent);
  }
}
```

### Comunicación entre Microfrontends
```typescript
@Injectable({
  providedIn: 'root'
})
export class MicrofrontendBridge {
  private eventBus = new Subject<any>();
  
  // Método para enviar eventos
  emit(event: string, data: any) {
    this.eventBus.next({ event, data });
  }
  
  // Método para escuchar eventos
  on(event: string): Observable<any> {
    return this.eventBus.pipe(
      filter(message => message.event === event),
      map(message => message.data)
    );
  }
}
```

---

## 🔐 Seguridad

### Content Security Policy
```typescript
// Configuración CSP en index.html
/*
<meta http-equiv="Content-Security-Policy" 
      content="default-src 'self'; 
               script-src 'self' 'unsafe-inline'; 
               style-src 'self' 'unsafe-inline';">
*/

// Sanitización de contenido
@Component({
  template: `
    <div [innerHTML]="sanitizedContent"></div>
  `
})
export class SafeContentComponent {
  constructor(private sanitizer: DomSanitizer) {}
  
  get sanitizedContent() {
    return this.sanitizer.sanitize(SecurityContext.HTML, this.userContent);
  }
}
```

### JWT Token Management
```typescript
@Injectable()
export class AuthService {
  private tokenKey = 'auth_token';
  
  setToken(token: string) {
    // Almacenar en httpOnly cookie sería más seguro
    localStorage.setItem(this.tokenKey, token);
  }
  
  getToken(): string | null {
    return localStorage.getItem(this.tokenKey);
  }
  
  isTokenExpired(): boolean {
    const token = this.getToken();
    if (!token) return true;
    
    try {
      const payload = JSON.parse(atob(token.split('.')[1]));
      return payload.exp * 1000 < Date.now();
    } catch {
      return true;
    }
  }
  
  logout() {
    localStorage.removeItem(this.tokenKey);
    this.router.navigate(['/login']);
  }
}
```

---

## ❓ Preguntas Típicas de Entrevista

### 1. **¿Cuál es la diferencia entre OnPush y Default change detection?**
- **Default**: Angular verifica todos los componentes en cada ciclo de detección
- **OnPush**: Solo verifica cuando:
  - Cambian las referencias de @Input()
  - Se dispara un evento
  - Se ejecuta un Observable/Promise
  - Se llama manualmente a markForCheck()

### 2. **¿Cómo optimizarías una aplicación Angular lenta?**
- Implementar OnPush strategy
- Usar trackBy en ngFor
- Lazy loading de módulos
- Tree shaking y bundle analysis
- Virtual scrolling para listas grandes
- Preloading strategies
- Web Workers para cálculos pesados
- Service Workers para caching

### 3. **¿Cuándo usarías BehaviorSubject vs Subject vs ReplaySubject?**
- **Subject**: Stream básico, no mantiene valor
- **BehaviorSubject**: Mantiene último valor, ideal para estado
- **ReplaySubject**: Mantiene histórico de valores
- **AsyncSubject**: Emite solo el último valor al completarse

### 4. **¿Cómo implementarías un cache en Angular?**
```typescript
@Injectable()
export class CacheService {
  private cache = new Map<string, { data: any, expiry: number }>();
  
  get(key: string): any {
    const item = this.cache.get(key);
    if (item && item.expiry > Date.now()) {
      return item.data;
    }
    this.cache.delete(key);
    return null;
  }
  
  set(key: string, data: any, ttl: number = 300000) {
    this.cache.set(key, {
      data,
      expiry: Date.now() + ttl
    });
  }
}
```

### 5. **¿Cómo manejarías el estado global sin NgRx?**
- Servicios con BehaviorSubject
- Patrón Observer
- Akita (alternativa a NgRx)
- Context API pattern

### 6. **¿Cuál es la diferencia entre ViewChild y ContentChild?**
- **ViewChild**: Elementos del template del componente
- **ContentChild**: Elementos proyectados via ng-content

### 7. **¿Cómo implementarías autenticación con JWT?**
- Interceptor para agregar token
- Guard para proteger rutas
- Manejo de refresh tokens
- Almacenamiento seguro (httpOnly cookies)

### 8. **¿Qué estrategias de testing usas?**
- Unit tests (Jasmine/Karma)
- Integration tests
- E2E tests (Cypress/Protractor)
- Visual regression testing
- Performance testing

### 9. **¿Cómo comunicarías componentes hermanos?**
- Servicio compartido
- @Output() al padre y @Input() al hermano
- EventBus service
- Estado global (NgRx)

### 10. **¿Cuándo usarías Reactive Forms vs Template-driven Forms?**
- **Reactive**: Validaciones complejas, forms dinámicos, testing
- **Template-driven**: Forms simples, prototipado rápido

---

## 📝 Consejos para la Entrevista

1. **Conoce el ciclo de vida completo** de componentes y directivas
2. **Domina RxJS** - es fundamental en Angular
3. **Entiende la arquitectura** - modules, components, services, DI
4. **Practica optimización** - performance es clave para seniors
5. **Conoce testing** - unit, integration, e2e
6. **Estudia patrones de diseño** aplicados a Angular
7. **Mantente actualizado** con las últimas versiones
8. **Practica coding** - implementa componentes desde cero
