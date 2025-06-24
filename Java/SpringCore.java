// ========================================
// SPRING CORE - GUÍA COMPLETA PARA SENIOR DEVELOPER
// ========================================

/*
🎯 CONCEPTOS FUNDAMENTALES DE SPRING CORE
=========================================

1. INVERSIÓN DE CONTROL (IoC)
   - Spring controla el flujo del programa y la creación de objetos
   - Los objetos no crean sus dependencias, las reciben
   - Permite desacoplamiento y testabilidad

2. INYECCIÓN DE DEPENDENCIAS (DI)
   - Spring inyecta automáticamente las dependencias
   - Tipos: Constructor, Setter, Field
   - Reduce el acoplamiento entre componentes

3. APPLICATION CONTEXT
   - Contenedor principal de Spring
   - Gestiona el ciclo de vida de los beans
   - Proporciona funcionalidades como AOP, eventos, etc.

4. BEAN LIFECYCLE
   - Instanciación → Inyección de dependencias → PostConstruct → Uso → PreDestroy → Destrucción
*/

// ========================================
// TODAS LAS ANOTACIONES DE SPRING CORE
// ========================================

/*
📋 ANOTACIONES DE CONFIGURACIÓN
===============================

@Configuration
- Marca una clase como fuente de definiciones de beans
- Equivalente a un archivo XML de configuración

@Bean
- Método que expone un bean al ApplicationContext
- Retorna un objeto que será gestionado por Spring

@ComponentScan
- Configura el escaneo de componentes en paquetes específicos
- Busca clases anotadas con @Component y sus especializaciones

@Import
- Importa configuraciones de otras clases @Configuration

@PropertySource
- Especifica archivos de propiedades para cargar

@Profile
- Activa beans solo para perfiles específicos

@Conditional
- Condición personalizada para crear beans

@Lazy
- Inicialización diferida del bean

@DependsOn
- Especifica dependencias de inicialización

📋 ANOTACIONES DE COMPONENTES
=============================

@Component
- Marca una clase como bean gestionado por Spring
- Clase base para todas las anotaciones de componentes

@Service
- Especialización de @Component para lógica de negocio
- Indica que la clase es un servicio

@Repository
- Especialización de @Component para acceso a datos
- Habilita traducción de excepciones de persistencia

@Controller
- Especialización de @Component para controladores web
- Indica que la clase es un controlador MVC

@RestController
- Combinación de @Controller y @ResponseBody
- Para APIs REST

📋 ANOTACIONES DE INYECCIÓN
===========================

@Autowired
- Inyección automática de dependencias
- Se puede usar en constructores, setters y campos

@Qualifier
- Especifica qué bean inyectar cuando hay múltiples candidatos
- Se usa junto con @Autowired

@Value
- Inyecta valores desde properties o expresiones SpEL
- Soporta valores por defecto

@Resource
- Inyección por nombre (JSR-250)
- Alternativa a @Autowired

@Inject
- Inyección estándar JSR-330
- Alternativa a @Autowired

📋 ANOTACIONES DE CICLO DE VIDA
===============================

@PostConstruct
- Método a ejecutar después de la inyección de dependencias
- Equivalente a InitializingBean.afterPropertiesSet()

@PreDestroy
- Método a ejecutar antes de destruir el bean
- Equivalente a DisposableBean.destroy()

📋 ANOTACIONES DE SCOPE
=======================

@Scope
- Define el alcance del bean
- Valores: singleton, prototype, request, session, application, websocket

@SessionScope
- Bean con scope de sesión HTTP

@RequestScope
- Bean con scope de request HTTP

@ApplicationScope
- Bean con scope de aplicación web

📋 ANOTACIONES DE CONFIGURACIÓN AVANZADA
========================================

@Primary
- Marca un bean como preferido cuando hay múltiples candidatos

@Order
- Define el orden de los beans en colecciones

@Async
- Ejecuta métodos de forma asíncrona

@Scheduled
- Ejecuta métodos en intervalos programados

@EventListener
- Escucha eventos de ApplicationContext

@Transactional
- Define transacciones (aunque es de Spring Data)

@Cacheable, @CacheEvict, @CachePut
- Anotaciones de caché (aunque son de Spring Cache)

📋 ANOTACIONES DE EXPRESIONES (SpEL)
====================================

@Value con SpEL
- Expresiones como: @Value("#{systemProperties['user.home']}")
- Operadores: #{bean.method()}, #{bean.property}

📋 ANOTACIONES DE TESTING
=========================

@ContextConfiguration
- Especifica configuración para tests

@TestPropertySource
- Properties específicos para tests

@DirtiesContext
- Indica que el contexto debe ser recreado

@ActiveProfiles
- Activa perfiles para tests
*/

// ========================================
// EJEMPLOS PRÁCTICOS AVANZADOS
// ========================================

/*
🔧 EJEMPLO 1: CONFIGURACIÓN AVANZADA CON JAVA CONFIG
===================================================

@Configuration
@PropertySource("classpath:application.properties")
@ComponentScan(basePackages = "com.example")
@EnableAsync
@EnableScheduling
public class AppConfig {
    
    @Value("${app.name}")
    private String appName;
    
    @Bean
    @Primary
    @Lazy
    public DataSource dataSource() {
        return new HikariDataSource();
    }
    
    @Bean
    @ConditionalOnProperty(name = "cache.enabled", havingValue = "true")
    public CacheManager cacheManager() {
        return new ConcurrentMapCacheManager();
    }
    
    @Bean
    @DependsOn("dataSource")
    public JdbcTemplate jdbcTemplate(DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }
}

🔧 EJEMPLO 2: SERVICIO CON INYECCIÓN AVANZADA
=============================================

@Service
@Transactional
public class UserService {
    
    private final UserRepository userRepository;
    private final EmailService emailService;
    private final CacheManager cacheManager;
    
    @Value("${app.email.enabled:true}")
    private boolean emailEnabled;
    
    @Autowired
    public UserService(
            @Qualifier("userRepository") UserRepository userRepository,
            EmailService emailService,
            CacheManager cacheManager) {
        this.userRepository = userRepository;
        this.emailService = emailService;
        this.cacheManager = cacheManager;
    }
    
    @PostConstruct
    public void init() {
        System.out.println("UserService initialized with email enabled: " + emailEnabled);
    }
    
    @Async
    public CompletableFuture<User> createUserAsync(User user) {
        User savedUser = userRepository.save(user);
        if (emailEnabled) {
            emailService.sendWelcomeEmail(savedUser);
        }
        return CompletableFuture.completedFuture(savedUser);
    }
    
    @Scheduled(fixedRate = 300000) // 5 minutos
    public void cleanupInactiveUsers() {
        // Lógica de limpieza
    }
    
    @EventListener
    public void handleUserCreatedEvent(UserCreatedEvent event) {
        // Manejar evento
    }
    
    @PreDestroy
    public void cleanup() {
        // Limpieza antes de destruir
    }
}

🔧 EJEMPLO 3: REPOSITORIO CON SCOPE PERSONALIZADO
================================================

@Repository
@Scope("prototype")
public class UserRepository {
    
    @Value("#{systemProperties['db.url'] ?: 'jdbc:h2:mem:test'}")
    private String dbUrl;
    
    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    @Cacheable("users")
    public User findById(Long id) {
        return jdbcTemplate.queryForObject(
            "SELECT * FROM users WHERE id = ?",
            new Object[]{id},
            new UserRowMapper()
        );
    }
    
    @CacheEvict(value = "users", allEntries = true)
    public void save(User user) {
        // Lógica de guardado
    }
}

🔧 EJEMPLO 4: CONFIGURACIÓN CONDICIONAL AVANZADA
===============================================

@Configuration
public class ConditionalConfig {
    
    @Bean
    @ConditionalOnClass(name = "com.mysql.cj.jdbc.Driver")
    @ConditionalOnProperty(name = "database.type", havingValue = "mysql")
    public DataSource mysqlDataSource() {
        return new MysqlDataSource();
    }
    
    @Bean
    @ConditionalOnClass(name = "org.postgresql.Driver")
    @ConditionalOnProperty(name = "database.type", havingValue = "postgres")
    public DataSource postgresDataSource() {
        return new PostgresDataSource();
    }
    
    @Bean
    @ConditionalOnMissingBean(DataSource.class)
    public DataSource h2DataSource() {
        return new H2DataSource();
    }
}

🔧 EJEMPLO 5: FACTORY BEAN PERSONALIZADO
=======================================

@Component
public class ConnectionFactoryBean implements FactoryBean<Connection> {
    
    @Value("${db.url}")
    private String dbUrl;
    
    @Value("${db.username}")
    private String username;
    
    @Value("${db.password}")
    private String password;
    
    @Override
    public Connection getObject() throws Exception {
        return DriverManager.getConnection(dbUrl, username, password);
    }
    
    @Override
    public Class<?> getObjectType() {
        return Connection.class;
    }
    
    @Override
    public boolean isSingleton() {
        return false; // Nueva conexión cada vez
    }
}

🔧 EJEMPLO 6: BEAN POST PROCESSOR
=================================

@Component
public class LoggingBeanPostProcessor implements BeanPostProcessor {
    
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) {
        System.out.println("Before initialization: " + beanName);
        return bean;
    }
    
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) {
        System.out.println("After initialization: " + beanName);
        return bean;
    }
}

🔧 EJEMPLO 7: EVENTOS PERSONALIZADOS
====================================

public class UserCreatedEvent extends ApplicationEvent {
    private final User user;
    
    public UserCreatedEvent(Object source, User user) {
        super(source);
        this.user = user;
    }
    
    public User getUser() {
        return user;
    }
}

@Component
public class UserEventPublisher {
    
    @Autowired
    private ApplicationEventPublisher eventPublisher;
    
    public void publishUserCreated(User user) {
        eventPublisher.publishEvent(new UserCreatedEvent(this, user));
    }
}

🔧 EJEMPLO 8: EXPRESIONES SpEL AVANZADAS
========================================

@Component
public class SpELExample {
    
    @Value("#{T(java.lang.Math).random() * 100}")
    private double randomNumber;
    
    @Value("#{systemProperties['user.home']}")
    private String userHome;
    
    @Value("#{userService.getActiveUserCount()}")
    private int activeUsers;
    
    @Value("#{userService.users.?[age > 18]}")
    private List<User> adultUsers;
    
    @Value("#{userService.users.![name]}")
    private List<String> userNames;
}

🔧 EJEMPLO 9: CONFIGURACIÓN DE PERFILES
=======================================

@Configuration
@Profile("development")
public class DevelopmentConfig {
    
    @Bean
    public DataSource dataSource() {
        return new H2DataSource();
    }
}

@Configuration
@Profile("production")
public class ProductionConfig {
    
    @Bean
    public DataSource dataSource() {
        return new HikariDataSource();
    }
}

🔧 EJEMPLO 10: BEAN DEFINITION REGISTRY
=======================================

@Component
public class DynamicBeanRegistrar {
    
    @Autowired
    private BeanDefinitionRegistry registry;
    
    public void registerBean(String beanName, Class<?> beanClass) {
        BeanDefinitionBuilder builder = BeanDefinitionBuilder
            .genericBeanDefinition(beanClass);
        
        BeanDefinition beanDefinition = builder.getBeanDefinition();
        registry.registerBeanDefinition(beanName, beanDefinition);
    }
}
*/

// ========================================
// PATRONES AVANZADOS Y BEST PRACTICES
// ========================================

/*
🎯 PATRONES AVANZADOS
=====================

1. FACTORY PATTERN CON SPRING
   - Usar FactoryBean para beans complejos
   - Configuración condicional con @Conditional

2. BUILDER PATTERN
   - Beans con múltiples parámetros opcionales
   - Uso de @Builder en entidades

3. OBSERVER PATTERN
   - Eventos de ApplicationContext
   - @EventListener para manejar eventos

4. TEMPLATE METHOD PATTERN
   - Clases abstractas con métodos template
   - Hooks con @PostConstruct

5. STRATEGY PATTERN
   - Múltiples implementaciones de una interfaz
   - Selección con @Qualifier o @Primary

🎯 BEST PRACTICES
=================

1. CONFIGURACIÓN
   - Usar Java Config en lugar de XML
   - Separar configuraciones por módulos
   - Usar @Profile para diferentes entornos

2. INYECCIÓN DE DEPENDENCIAS
   - Preferir inyección por constructor
   - Usar @Autowired solo cuando sea necesario
   - Evitar inyección circular

3. SCOPE MANAGEMENT
   - Usar singleton por defecto
   - Prototype solo cuando sea necesario
   - Manejar lifecycle de beans con scope

4. PERFORMANCE
   - Usar @Lazy para beans costosos
   - Implementar BeanPostProcessor para optimizaciones
   - Usar @Async para operaciones bloqueantes

5. TESTING
   - Usar @ContextConfiguration para tests
   - Mockear dependencias con @MockBean
   - Usar @TestPropertySource para configuración de tests
*/

// ========================================
// CONCEPTOS AVANZADOS PARA ENTREVISTAS
// ========================================

/*
🚀 CONCEPTOS PARA ENTREVISTAS SENIOR
====================================

1. BEAN LIFECYCLE DETALLADO
   - Instanciación → Inyección → PostConstruct → Uso → PreDestroy → Destrucción
   - BeanPostProcessor hooks
   - InitializingBean y DisposableBean interfaces

2. APPLICATION CONTEXT HIERARCHY
   - Parent-child context relationships
   - Bean inheritance y override
   - Context refresh y close

3. BEAN DEFINITION
   - Metadata de beans
   - BeanDefinitionRegistry
   - Custom BeanFactoryPostProcessor

4. AOP INTEGRATION
   - Proxies dinámicos vs CGLIB
   - Pointcut expressions
   - Advice types

5. TRANSACTION MANAGEMENT
   - Transaction propagation
   - Isolation levels
   - Rollback rules

6. EVENT SYSTEM
   - ApplicationEventPublisher
   - Custom events
   - Event listeners

7. EXPRESSION LANGUAGE (SpEL)
   - Syntax y operadores
   - Bean references
   - Collection projections

8. CONDITIONAL CONFIGURATION
   - @ConditionalOnClass, @ConditionalOnProperty
   - Custom conditions
   - Profile-based configuration

9. ASYNC PROCESSING
   - @Async configuration
   - Thread pool management
   - Exception handling

10. CACHING INTEGRATION
    - Cache abstraction
    - Cache providers
    - Cache annotations
*/

public class SpringCore {
    
    public static void main(String[] args) {
        System.out.println("🎯 SPRING CORE - GUÍA COMPLETA PARA SENIOR DEVELOPER");
        System.out.println("=====================================================");
        System.out.println();
        System.out.println("📋 Esta guía incluye:");
        System.out.println("   • Conceptos fundamentales de IoC y DI");
        System.out.println("   • Todas las anotaciones de Spring Core");
        System.out.println("   • Ejemplos prácticos avanzados");
        System.out.println("   • Patrones y best practices");
        System.out.println("   • Conceptos para entrevistas senior");
        System.out.println();
        System.out.println("🔧 Los ejemplos están en comentarios para referencia");
        System.out.println("   y práctica. Descomenta y ejecuta según necesites.");
    }
}
