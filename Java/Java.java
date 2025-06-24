import java.util.*;
import java.lang.reflect.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.*;
import java.lang.management.*;

public class Java {
    
    public static void main(String[] args) {
        System.out.println("=== GUÍA COMPLETA DE JAVA PARA ENTREVISTAS SENIOR ===\n");
        
        // Conceptos fundamentales
        demonstrateMemoryManagement();
        demonstrateGarbageCollection();
        demonstrateThreadingAndConcurrency();
        demonstrateCollectionsFramework();
        demonstrateGenericsAndTypeErasure();
        demonstrateReflectionAndAnnotations();
        demonstrateExceptionHandling();
        demonstrateDesignPatterns();
        demonstrateJava8Features();
        demonstratePerformanceOptimization();
        demonstrateSecurityAndBestPractices();
        
        // Preguntas de entrevista comunes
        commonInterviewQuestions();
        
        // Ejemplos prácticos
        practicalExamples();
        
        // Casos de uso avanzados
        advancedUseCases();
    }
    
    // ========================================
    // MANEJO DE MEMORIA - HEAP Y STACK
    // ========================================
    public static void demonstrateMemoryManagement() {
        System.out.println("🧠 MANEJO DE MEMORIA EN JAVA");
        System.out.println("Java maneja automáticamente la memoria, pero es crucial entender cómo funciona:\n");
        
        // Stack - Variables locales y referencias
        System.out.println("📚 STACK (Pila de ejecución):");
        System.out.println("• Almacena variables locales y referencias");
        System.out.println("• LIFO (Last In, First Out)");
        System.out.println("• Cada hilo tiene su propio stack");
        System.out.println("• Tamaño fijo, se llena rápidamente");
        System.out.println("• StackOverflowError si se llena\n");
        
        // Heap - Objetos dinámicos
        System.out.println("🗑️ HEAP (Montón):");
        System.out.println("• Almacena objetos creados con 'new'");
        System.out.println("• Compartido entre todos los hilos");
        System.out.println("• Tamaño configurable (-Xmx, -Xms)");
        System.out.println("• Garbage Collector limpia objetos no referenciados");
        System.out.println("• OutOfMemoryError si se llena\n");
        
        // Ejemplo práctico
        System.out.println("🔍 EJEMPLO PRÁCTICO:");
        System.out.println("public void example() {");
        System.out.println("    int localVar = 42;           // Stack");
        System.out.println("    String str = \"Hello\";       // Stack (referencia) + Heap (objeto)");
        System.out.println("    Object obj = new Object();   // Stack (referencia) + Heap (objeto)");
        System.out.println("    int[] array = new int[1000]; // Stack (referencia) + Heap (array)");
        System.out.println("}");
        
        // Métaspace (antes PermGen)
        System.out.println("\n📖 METASPACE:");
        System.out.println("• Almacena metadatos de clases");
        System.out.println("• Información de métodos, campos, etc.");
        System.out.println("• Garbage collection automático");
        System.out.println("• Tamaño dinámico por defecto\n");
        
        // Configuración de memoria
        System.out.println("⚙️ CONFIGURACIÓN DE MEMORIA:");
        System.out.println("• -Xms: Tamaño inicial del heap");
        System.out.println("• -Xmx: Tamaño máximo del heap");
        System.out.println("• -Xss: Tamaño del stack por hilo");
        System.out.println("• -XX:MaxMetaspaceSize: Tamaño máximo del Metaspace\n");
    }
    
    // ========================================
    // GARBAGE COLLECTOR
    // ========================================
    public static void demonstrateGarbageCollection() {
        System.out.println("♻️ GARBAGE COLLECTOR (GC)");
        System.out.println("Sistema automático de limpieza de memoria:\n");
        
        // Tipos de GC
        System.out.println("🔄 TIPOS DE GARBAGE COLLECTOR:");
        System.out.println("1. Serial GC (-XX:+UseSerialGC):");
        System.out.println("   • Un solo hilo, pausa la aplicación");
        System.out.println("   • Para aplicaciones pequeñas");
        System.out.println("   • -XX:+UseSerialGC\n");
        
        System.out.println("2. Parallel GC (-XX:+UseParallelGC):");
        System.out.println("   • Múltiples hilos, pausa la aplicación");
        System.out.println("   • Para aplicaciones de alto throughput");
        System.out.println("   • -XX:+UseParallelGC\n");
        
        System.out.println("3. CMS GC (-XX:+UseConcMarkSweepGC):");
        System.out.println("   • Concurrente, pausas cortas");
        System.out.println("   • Para aplicaciones que requieren baja latencia");
        System.out.println("   • Deprecado en Java 9\n");
        
        System.out.println("4. G1 GC (-XX:+UseG1GC):");
        System.out.println("   • Generacional, concurrente");
        System.out.println("   • Pausas predecibles");
        System.out.println("   • Default desde Java 9\n");
        
        System.out.println("5. ZGC (-XX:+UseZGC):");
        System.out.println("   • Ultra baja latencia");
        System.out.println("   • Pausas < 10ms");
        System.out.println("   • Disponible desde Java 11\n");
        
        // Generaciones de memoria
        System.out.println("📊 GENERACIONES DE MEMORIA:");
        System.out.println("• Young Generation (Eden + Survivor):");
        System.out.println("  - Objetos nuevos");
        System.out.println("  - Minor GC (rápido)");
        System.out.println("• Old Generation:");
        System.out.println("  - Objetos longevos");
        System.out.println("  - Major GC (lento)");
        System.out.println("• Metaspace:");
        System.out.println("  - Metadatos de clases\n");
        
        // Finalización
        System.out.println("⚠️ FINALIZACIÓN:");
        System.out.println("• finalize() está deprecado");
        System.out.println("• Usar try-with-resources o AutoCloseable");
        System.out.println("• WeakReference, SoftReference, PhantomReference");
        System.out.println("• System.gc() - sugerencia, no garantía\n");
        
        // Monitoreo
        System.out.println("📈 MONITOREO DEL GC:");
        System.out.println("• -verbose:gc: Logs básicos");
        System.out.println("• -XX:+PrintGCDetails: Logs detallados");
        System.out.println("• JVisualVM, JConsole, JMX");
        System.out.println("• GarbageCollectorMXBean\n");
    }
    
    // ========================================
    // THREADING Y CONCURRENCIA
    // ========================================
    public static void demonstrateThreadingAndConcurrency() {
        System.out.println("🧵 THREADING Y CONCURRENCIA");
        System.out.println("Java proporciona múltiples mecanismos para concurrencia:\n");
        
        // Estados de Thread
        System.out.println("🔄 ESTADOS DE THREAD:");
        System.out.println("• NEW: Creado pero no iniciado");
        System.out.println("• RUNNABLE: Ejecutándose o listo para ejecutar");
        System.out.println("• BLOCKED: Esperando un lock");
        System.out.println("• WAITING: Esperando indefinidamente");
        System.out.println("• TIMED_WAITING: Esperando con timeout");
        System.out.println("• TERMINATED: Completado\n");
        
        // Sincronización
        System.out.println("🔒 SINCRONIZACIÓN:");
        System.out.println("1. synchronized keyword:");
        System.out.println("   • Método: bloquea toda la instancia");
        System.out.println("   • Bloque: bloquea objeto específico");
        System.out.println("   • Reentrante: mismo hilo puede adquirir el lock\n");
        
        System.out.println("2. Locks (java.util.concurrent.locks):");
        System.out.println("   • ReentrantLock: Lock reentrante");
        System.out.println("   • ReadWriteLock: Lock de lectura/escritura");
        System.out.println("   • StampedLock: Lock optimista\n");
        
        // Colecciones thread-safe
        System.out.println("📦 COLECCIONES THREAD-SAFE:");
        System.out.println("• ConcurrentHashMap: HashMap thread-safe");
        System.out.println("• CopyOnWriteArrayList: Lista thread-safe para lecturas");
        System.out.println("• BlockingQueue: Cola con operaciones bloqueantes");
        System.out.println("• ConcurrentLinkedQueue: Cola no bloqueante\n");
        
        // Executor Framework
        System.out.println("⚙️ EXECUTOR FRAMEWORK:");
        System.out.println("• ExecutorService: Interfaz para ejecutar tareas");
        System.out.println("• ThreadPoolExecutor: Pool de hilos configurable");
        System.out.println("• ScheduledExecutorService: Tareas programadas");
        System.out.println("• ForkJoinPool: Para tareas dividibles\n");
        
        // Atomic classes
        System.out.println("⚛️ CLASES ATÓMICAS:");
        System.out.println("• AtomicInteger: int thread-safe");
        System.out.println("• AtomicLong: long thread-safe");
        System.out.println("• AtomicReference: referencia thread-safe");
        System.out.println("• AtomicBoolean: boolean thread-safe\n");
        
        // CompletableFuture
        System.out.println("🚀 COMPLETABLEFUTURE:");
        System.out.println("• Programación asíncrona");
        System.out.println("• Chaining de operaciones");
        System.out.println("• Manejo de excepciones");
        System.out.println("• Combinación de futures\n");
    }
    
    // ========================================
    // FRAMEWORK DE COLECCIONES
    // ========================================
    public static void demonstrateCollectionsFramework() {
        System.out.println("📚 FRAMEWORK DE COLECCIONES");
        System.out.println("Java proporciona una rica biblioteca de estructuras de datos:\n");
        
        // List implementations
        System.out.println("📋 LIST IMPLEMENTATIONS:");
        System.out.println("• ArrayList: Array dinámico, O(1) acceso, O(n) inserción");
        System.out.println("• LinkedList: Lista enlazada, O(n) acceso, O(1) inserción");
        System.out.println("• Vector: ArrayList thread-safe (legacy)");
        System.out.println("• CopyOnWriteArrayList: Thread-safe para lecturas frecuentes\n");
        
        // Set implementations
        System.out.println("🔍 SET IMPLEMENTATIONS:");
        System.out.println("• HashSet: Hash table, O(1) promedio");
        System.out.println("• TreeSet: Árbol rojo-negro, O(log n)");
        System.out.println("• LinkedHashSet: HashSet con orden de inserción");
        System.out.println("• ConcurrentHashMap.newKeySet(): Thread-safe\n");
        
        // Map implementations
        System.out.println("🗺️ MAP IMPLEMENTATIONS:");
        System.out.println("• HashMap: Hash table, O(1) promedio");
        System.out.println("• TreeMap: Árbol rojo-negro, O(log n)");
        System.out.println("• LinkedHashMap: HashMap con orden");
        System.out.println("• ConcurrentHashMap: Thread-safe");
        System.out.println("• WeakHashMap: Referencias débiles\n");
        
        // Queue implementations
        System.out.println("🎫 QUEUE IMPLEMENTATIONS:");
        System.out.println("• LinkedList: Queue básica");
        System.out.println("• PriorityQueue: Cola de prioridad");
        System.out.println("• ArrayBlockingQueue: Cola bloqueante con array");
        System.out.println("• LinkedBlockingQueue: Cola bloqueante con lista");
        System.out.println("• ConcurrentLinkedQueue: Cola no bloqueante\n");
        
        // Comparadores y ordenamiento
        System.out.println("📊 COMPARADORES Y ORDENAMIENTO:");
        System.out.println("• Comparable: Ordenamiento natural");
        System.out.println("• Comparator: Ordenamiento personalizado");
        System.out.println("• Collections.sort(): Ordenamiento estable");
        System.out.println("• Arrays.sort(): Ordenamiento in-place\n");
    }
    
    // ========================================
    // GENERICS Y TYPE ERASURE
    // ========================================
    public static void demonstrateGenericsAndTypeErasure() {
        System.out.println("🔤 GENERICS Y TYPE ERASURE");
        System.out.println("Los genéricos proporcionan type safety en tiempo de compilación:\n");
        
        // Type Erasure
        System.out.println("🧹 TYPE ERASURE:");
        System.out.println("• Los genéricos se eliminan en tiempo de ejecución");
        System.out.println("• List<String> se convierte en List en bytecode");
        System.out.println("• Información de tipo se pierde en runtime");
        System.out.println("• Casting automático en puntos de uso\n");
        
        // Wildcards
        System.out.println("❓ WILDCARDS:");
        System.out.println("• <?>: Tipo desconocido (solo lectura)");
        System.out.println("• <? extends T>: T o subtipo de T");
        System.out.println("• <? super T>: T o supertipo de T");
        System.out.println("• PECS: Producer Extends, Consumer Super\n");
        
        // Bounded Type Parameters
        System.out.println("🔗 BOUNDED TYPE PARAMETERS:");
        System.out.println("• <T extends Comparable<T>>: T debe implementar Comparable");
        System.out.println("• <T extends Number>: T debe ser Number o subtipo");
        System.out.println("• Múltiples bounds: <T extends A & B & C>\n");
        
        // Type Tokens
        System.out.println("🎫 TYPE TOKENS:");
        System.out.println("• Class<T>: Representa el tipo en runtime");
        System.out.println("• TypeToken (Gson): Preserva información de tipo");
        System.out.println("• Reflection: Acceso a información de tipo\n");
    }
    
    // ========================================
    // REFLECTION Y ANNOTATIONS
    // ========================================
    public static void demonstrateReflectionAndAnnotations() {
        System.out.println("🔍 REFLECTION Y ANNOTATIONS");
        System.out.println("Permiten inspección y manipulación dinámica del código:\n");
        
        // Reflection
        System.out.println("🪞 REFLECTION:");
        System.out.println("• Class<T>: Representa una clase");
        System.out.println("• Method: Representa un método");
        System.out.println("• Field: Representa un campo");
        System.out.println("• Constructor: Representa un constructor");
        System.out.println("• Modifier: Información sobre modificadores\n");
        
        // Annotations
        System.out.println("🏷️ ANNOTATIONS:");
        System.out.println("• @Override: Sobrescribe método de superclase");
        System.out.println("• @Deprecated: Marca como obsoleto");
        System.out.println("• @SuppressWarnings: Suprime warnings");
        System.out.println("• @FunctionalInterface: Interfaz funcional");
        System.out.println("• Annotations personalizadas\n");
        
        // Annotation Processing
        System.out.println("⚙️ ANNOTATION PROCESSING:");
        System.out.println("• Procesamiento en tiempo de compilación");
        System.out.println("• Generación de código automática");
        System.out.println("• Lombok, MapStruct, etc.");
        System.out.println("• APT (Annotation Processing Tool)\n");
    }
    
    // ========================================
    // MANEJO DE EXCEPCIONES
    // ========================================
    public static void demonstrateExceptionHandling() {
        System.out.println("⚠️ MANEJO DE EXCEPCIONES");
        System.out.println("Sistema robusto para manejo de errores:\n");
        
        // Jerarquía de excepciones
        System.out.println("📊 JERARQUÍA DE EXCEPCIONES:");
        System.out.println("• Throwable: Clase base");
        System.out.println("  ├── Error: Errores del sistema (no recuperables)");
        System.out.println("  │   ├── OutOfMemoryError");
        System.out.println("  │   ├── StackOverflowError");
        System.out.println("  │   └── VirtualMachineError");
        System.out.println("  └── Exception: Excepciones recuperables");
        System.out.println("      ├── RuntimeException: No checked");
        System.out.println("      │   ├── NullPointerException");
        System.out.println("      │   ├── ArrayIndexOutOfBoundsException");
        System.out.println("      │   └── IllegalArgumentException");
        System.out.println("      └── Checked Exceptions: Deben ser manejadas");
        System.out.println("          ├── IOException");
        System.out.println("          ├── SQLException");
        System.out.println("          └── ClassNotFoundException\n");
        
        // Try-with-resources
        System.out.println("🔧 TRY-WITH-RESOURCES:");
        System.out.println("• Recursos se cierran automáticamente");
        System.out.println("• Implementa AutoCloseable");
        System.out.println("• Múltiples recursos en un try");
        System.out.println("• Excepciones suprimidas\n");
        
        // Best practices
        System.out.println("✅ BEST PRACTICES:");
        System.out.println("• No capturar Exception genérica");
        System.out.println("• Usar excepciones específicas");
        System.out.println("• Logging apropiado");
        System.out.println("• Cleanup en finally o try-with-resources");
        System.out.println("• No ignorar excepciones\n");
    }
    
    // ========================================
    // PATRONES DE DISEÑO
    // ========================================
    public static void demonstrateDesignPatterns() {
        System.out.println("🏗️ PATRONES DE DISEÑO");
        System.out.println("Soluciones probadas para problemas comunes:\n");
        
        // Creational Patterns
        System.out.println("🏭 CREATIONAL PATTERNS:");
        System.out.println("• Singleton: Una sola instancia");
        System.out.println("• Factory Method: Creación delegada");
        System.out.println("• Abstract Factory: Familias de objetos");
        System.out.println("• Builder: Construcción compleja");
        System.out.println("• Prototype: Clonación de objetos\n");
        
        // Structural Patterns
        System.out.println("🏛️ STRUCTURAL PATTERNS:");
        System.out.println("• Adapter: Interfaz incompatible");
        System.out.println("• Bridge: Abstracción e implementación");
        System.out.println("• Composite: Estructura jerárquica");
        System.out.println("• Decorator: Funcionalidad dinámica");
        System.out.println("• Facade: Interfaz simplificada");
        System.out.println("• Flyweight: Objetos compartidos");
        System.out.println("• Proxy: Control de acceso\n");
        
        // Behavioral Patterns
        System.out.println("🎭 BEHAVIORAL PATTERNS:");
        System.out.println("• Chain of Responsibility: Cadena de handlers");
        System.out.println("• Command: Encapsular requests");
        System.out.println("• Iterator: Acceso secuencial");
        System.out.println("• Mediator: Comunicación centralizada");
        System.out.println("• Observer: Notificaciones");
        System.out.println("• State: Estados de objeto");
        System.out.println("• Strategy: Algoritmos intercambiables");
        System.out.println("• Template Method: Esqueleto de algoritmo");
        System.out.println("• Visitor: Operaciones en objetos\n");
    }
    
    // ========================================
    // CARACTERÍSTICAS DE JAVA 8+
    // ========================================
    public static void demonstrateJava8Features() {
        System.out.println("🚀 CARACTERÍSTICAS DE JAVA 8+");
        System.out.println("Funcionalidades modernas de Java:\n");
        
        // Lambda expressions
        System.out.println("λ LAMBDA EXPRESSIONS:");
        System.out.println("• Sintaxis concisa para interfaces funcionales");
        System.out.println("• Captura de variables efectivamente finales");
        System.out.println("• Method references: Class::method");
        System.out.println("• Constructor references: Class::new\n");
        
        // Streams
        System.out.println("🌊 STREAMS:");
        System.out.println("• Operaciones funcionales en colecciones");
        System.out.println("• Lazy evaluation");
        System.out.println("• Parallel streams");
        System.out.println("• Collectors para agrupación\n");
        
        // Optional
        System.out.println("📦 OPTIONAL:");
        System.out.println("• Contenedor para valores nullables");
        System.out.println("• Métodos: orElse, orElseGet, orElseThrow");
        System.out.println("• Métodos funcionales: map, flatMap, filter");
        System.out.println("• Evita NullPointerException\n");
        
        // Default methods
        System.out.println("⚡ DEFAULT METHODS:");
        System.out.println("• Implementación por defecto en interfaces");
        System.out.println("• Evolución de APIs");
        System.out.println("• Diamond problem con interfaces");
        System.out.println("• Reglas de resolución\n");
        
        // Date/Time API
        System.out.println("📅 DATE/TIME API:");
        System.out.println("• LocalDate, LocalTime, LocalDateTime");
        System.out.println("• ZonedDateTime, Instant");
        System.out.println("• Period, Duration");
        System.out.println("• DateTimeFormatter\n");
        
        // CompletableFuture
        System.out.println("🚀 COMPLETABLEFUTURE:");
        System.out.println("• Programación asíncrona mejorada");
        System.out.println("• Chaining de operaciones");
        System.out.println("• Combinación de futures");
        System.out.println("• Manejo de excepciones\n");
    }
    
    // ========================================
    // OPTIMIZACIÓN DE RENDIMIENTO
    // ========================================
    public static void demonstratePerformanceOptimization() {
        System.out.println("⚡ OPTIMIZACIÓN DE RENDIMIENTO");
        System.out.println("Técnicas para mejorar el rendimiento:\n");
        
        // JVM tuning
        System.out.println("🔧 JVM TUNING:");
        System.out.println("• Heap size: -Xms, -Xmx");
        System.out.println("• GC selection: -XX:+UseG1GC");
        System.out.println("• GC tuning: -XX:MaxGCPauseMillis");
        System.out.println("• JIT compilation: -XX:+TieredCompilation\n");
        
        // Profiling
        System.out.println("📊 PROFILING:");
        System.out.println("• JVisualVM: Profiler visual");
        System.out.println("• JProfiler: Profiler comercial");
        System.out.println("• YourKit: Profiler comercial");
        System.out.println("• JMH: Microbenchmarking\n");
        
        // Code optimization
        System.out.println("💻 CODE OPTIMIZATION:");
        System.out.println("• String concatenation: StringBuilder");
        System.out.println("• Boxing/unboxing: Evitar autoboxing");
        System.out.println("• Collections: Elegir la correcta");
        System.out.println("• Caching: Memoización");
        System.out.println("• Object pooling: Para objetos costosos\n");
        
        // Memory optimization
        System.out.println("💾 MEMORY OPTIMIZATION:");
        System.out.println("• Object reuse: Pooling");
        System.out.println("• Weak references: Para caches");
        System.out.println("• Off-heap memory: DirectByteBuffer");
        System.out.println("• Memory leaks: Identificar y corregir\n");
    }
    
    // ========================================
    // SEGURIDAD Y BEST PRACTICES
    // ========================================
    public static void demonstrateSecurityAndBestPractices() {
        System.out.println("🔒 SEGURIDAD Y BEST PRACTICES");
        System.out.println("Prácticas recomendadas para código seguro:\n");
        
        // Security
        System.out.println("🛡️ SEGURIDAD:");
        System.out.println("• Input validation: Validar entradas");
        System.out.println("• SQL injection: PreparedStatement");
        System.out.println("• XSS: Escapar output");
        System.out.println("• CSRF: Tokens de protección");
        System.out.println("• Authentication: JWT, OAuth");
        System.out.println("• Authorization: Roles y permisos\n");
        
        // Best practices
        System.out.println("✅ BEST PRACTICES:");
        System.out.println("• SOLID principles");
        System.out.println("• DRY (Don't Repeat Yourself)");
        System.out.println("• KISS (Keep It Simple, Stupid)");
        System.out.println("• Clean Code: Nombres descriptivos");
        System.out.println("• Unit testing: Cobertura alta");
        System.out.println("• Code review: Revisión de pares");
        System.out.println("• Documentation: JavaDoc\n");
        
        // Code quality
        System.out.println("📏 CODE QUALITY:");
        System.out.println("• SonarQube: Análisis estático");
        System.out.println("• Checkstyle: Estilo de código");
        System.out.println("• PMD: Detección de problemas");
        System.out.println("• SpotBugs: Detección de bugs\n");
    }
    
    // ========================================
    // PREGUNTAS DE ENTREVISTA COMUNES
    // ========================================
    public static void commonInterviewQuestions() {
        System.out.println("🎯 PREGUNTAS DE ENTREVISTA COMUNES");
        System.out.println("Preguntas típicas en entrevistas de Java Senior:\n");
        
        System.out.println("❓ '¿Cuál es la diferencia entre == y equals()?'");
        System.out.println("✅ == compara referencias, equals() compara contenido");
        System.out.println("   • ==: Comparación de identidad");
        System.out.println("   • equals(): Comparación de igualdad");
        System.out.println("   • String pool: Strings literales compartidos\n");
        
        System.out.println("❓ '¿Qué es la inmutabilidad y por qué es importante?'");
        System.out.println("✅ Objetos que no pueden cambiar después de la creación");
        System.out.println("   • Thread-safe por defecto");
        System.out.println("   • Simplifica programación concurrente");
        System.out.println("   • String, Integer, BigDecimal son inmutables\n");
        
        System.out.println("❓ '¿Cómo funciona el garbage collector?'");
        System.out.println("✅ Sistema automático de limpieza de memoria");
        System.out.println("   • Marca objetos no referenciados");
        System.out.println("   • Libera memoria automáticamente");
        System.out.println("   • Diferentes algoritmos disponibles");
        System.out.println("   • Configurable con parámetros JVM\n");
        
        System.out.println("❓ '¿Cuál es la diferencia entre HashMap y ConcurrentHashMap?'");
        System.out.println("✅ Thread-safety y rendimiento");
        System.out.println("   • HashMap: No thread-safe, más rápido");
        System.out.println("   • ConcurrentHashMap: Thread-safe, segmentado");
        System.out.println("   • No bloquea toda la tabla");
        System.out.println("   • Iterator fail-safe\n");
        
        System.out.println("❓ '¿Qué es el diamond problem?'");
        System.out.println("✅ Conflicto con herencia múltiple");
        System.out.println("   • Ocurre con default methods");
        System.out.println("   • Java resuelve con reglas específicas");
        System.out.println("   • Debe implementar el método conflictivo\n");
        
        System.out.println("❓ '¿Cómo optimizarías una aplicación Java lenta?'");
        System.out.println("✅ Enfoque sistemático:");
        System.out.println("   1. Profiling para identificar bottlenecks");
        System.out.println("   2. Optimizar algoritmos y estructuras de datos");
        System.out.println("   3. Tuning de JVM y GC");
        System.out.println("   4. Optimizar I/O y base de datos");
        System.out.println("   5. Caching y pooling\n");
        
        System.out.println("❓ '¿Qué patrones de diseño has usado?'");
        System.out.println("✅ Ejemplos prácticos:");
        System.out.println("   • Singleton: Configuración global");
        System.out.println("   • Factory: Creación de objetos");
        System.out.println("   • Observer: Event handling");
        System.out.println("   • Strategy: Algoritmos intercambiables");
        System.out.println("   • Builder: Construcción compleja\n");
        
        System.out.println("❓ '¿Cómo manejarías una OutOfMemoryError?'");
        System.out.println("✅ Diagnóstico y solución:");
        System.out.println("   1. Heap dump para análisis");
        System.out.println("   2. Identificar memory leaks");
        System.out.println("   3. Aumentar heap size temporalmente");
        System.out.println("   4. Optimizar uso de memoria");
        System.out.println("   5. Implementar caching inteligente\n");
    }
    
    // ========================================
    // EJEMPLOS PRÁCTICOS
    // ========================================
    public static void practicalExamples() {
        System.out.println("🔧 EJEMPLOS PRÁCTICOS");
        
        // Ejemplo de memory leak
        demonstrateMemoryLeak();
        
        // Ejemplo de concurrencia
        demonstrateConcurrency();
        
        // Ejemplo de generics
        demonstrateGenerics();
        
        // Ejemplo de reflection
        demonstrateReflection();
        
        // Ejemplo de streams
        demonstrateStreams();
        
        // Ejemplo de performance
        demonstratePerformance();
    }
    
    // Ejemplo de memory leak
    public static void demonstrateMemoryLeak() {
        System.out.println("\n💾 EJEMPLO DE MEMORY LEAK:");
        System.out.println("// Memory leak común: Listeners no removidos");
        System.out.println("public class MemoryLeakExample {");
        System.out.println("    private static List<EventListener> listeners = new ArrayList<>();");
        System.out.println("    ");
        System.out.println("    public void addListener(EventListener listener) {");
        System.out.println("        listeners.add(listener); // Nunca se remueve");
        System.out.println("    }");
        System.out.println("    ");
        System.out.println("    // Solución: Usar WeakHashMap o remover listeners");
        System.out.println("    public void removeListener(EventListener listener) {");
        System.out.println("        listeners.remove(listener);");
        System.out.println("    }");
        System.out.println("}");
    }
    
    // Ejemplo de concurrencia
    public static void demonstrateConcurrency() {
        System.out.println("\n🧵 EJEMPLO DE CONCURRENCIA:");
        System.out.println("// Race condition");
        System.out.println("public class Counter {");
        System.out.println("    private int count = 0;");
        System.out.println("    ");
        System.out.println("    public void increment() {");
        System.out.println("        count++; // No thread-safe");
        System.out.println("    }");
        System.out.println("    ");
        System.out.println("    // Solución 1: synchronized");
        System.out.println("    public synchronized void incrementSafe() {");
        System.out.println("        count++;");
        System.out.println("    }");
        System.out.println("    ");
        System.out.println("    // Solución 2: AtomicInteger");
        System.out.println("    private AtomicInteger atomicCount = new AtomicInteger(0);");
        System.out.println("    public void incrementAtomic() {");
        System.out.println("        atomicCount.incrementAndGet();");
        System.out.println("    }");
        System.out.println("}");
    }
    
    // Ejemplo de generics
    public static void demonstrateGenerics() {
        System.out.println("\n🔤 EJEMPLO DE GENERICS:");
        System.out.println("// Generic class");
        System.out.println("public class Box<T> {");
        System.out.println("    private T content;");
        System.out.println("    ");
        System.out.println("    public void set(T content) {");
        System.out.println("        this.content = content;");
        System.out.println("    }");
        System.out.println("    ");
        System.out.println("    public T get() {");
        System.out.println("        return content;");
        System.out.println("    }");
        System.out.println("    ");
        System.out.println("    // Bounded type parameter");
        System.out.println("    public static <T extends Comparable<T>> T max(T a, T b) {");
        System.out.println("        return a.compareTo(b) > 0 ? a : b;");
        System.out.println("    }");
        System.out.println("}");
    }
    
    // Ejemplo de reflection
    public static void demonstrateReflection() {
        System.out.println("\n🪞 EJEMPLO DE REFLECTION:");
        System.out.println("// Inspección dinámica de clase");
        System.out.println("public class ReflectionExample {");
        System.out.println("    public void inspectClass(String className) {");
        System.out.println("        try {");
        System.out.println("            Class<?> clazz = Class.forName(className);");
        System.out.println("            Method[] methods = clazz.getDeclaredMethods();");
        System.out.println("            Field[] fields = clazz.getDeclaredFields();");
        System.out.println("            ");
        System.out.println("            // Crear instancia dinámicamente");
        System.out.println("            Object instance = clazz.newInstance();");
        System.out.println("            ");
        System.out.println("            // Invocar método dinámicamente");
        System.out.println("            Method method = clazz.getMethod(\"methodName\");");
        System.out.println("            method.invoke(instance);");
        System.out.println("        } catch (Exception e) {");
        System.out.println("            e.printStackTrace();");
        System.out.println("        }");
        System.out.println("    }");
        System.out.println("}");
    }
    
    // Ejemplo de streams
    public static void demonstrateStreams() {
        System.out.println("\n🌊 EJEMPLO DE STREAMS:");
        System.out.println("// Operaciones funcionales");
        System.out.println("List<String> names = Arrays.asList(\"Alice\", \"Bob\", \"Charlie\");");
        System.out.println("");
        System.out.println("// Filter y map");
        System.out.println("List<String> upperNames = names.stream()");
        System.out.println("    .filter(name -> name.length() > 3)");
        System.out.println("    .map(String::toUpperCase)");
        System.out.println("    .collect(Collectors.toList());");
        System.out.println("");
        System.out.println("// Reduce");
        System.out.println("int totalLength = names.stream()");
        System.out.println("    .mapToInt(String::length)");
        System.out.println("    .sum();");
        System.out.println("");
        System.out.println("// Grouping");
        System.out.println("Map<Integer, List<String>> grouped = names.stream()");
        System.out.println("    .collect(Collectors.groupingBy(String::length));");
    }
    
    // Ejemplo de performance
    public static void demonstratePerformance() {
        System.out.println("\n⚡ EJEMPLO DE PERFORMANCE:");
        System.out.println("// String concatenation - Ineficiente");
        System.out.println("String result = \"\";");
        System.out.println("for (int i = 0; i < 1000; i++) {");
        System.out.println("    result += i; // Crea muchos objetos String");
        System.out.println("}");
        System.out.println("");
        System.out.println("// String concatenation - Eficiente");
        System.out.println("StringBuilder sb = new StringBuilder();");
        System.out.println("for (int i = 0; i < 1000; i++) {");
        System.out.println("    sb.append(i); // Reutiliza el mismo objeto");
        System.out.println("}");
        System.out.println("String result = sb.toString();");
        System.out.println("");
        System.out.println("// Boxing/unboxing - Ineficiente");
        System.out.println("Integer sum = 0;");
        System.out.println("for (int i = 0; i < 1000000; i++) {");
        System.out.println("    sum += i; // Autoboxing en cada iteración");
        System.out.println("}");
        System.out.println("");
        System.out.println("// Boxing/unboxing - Eficiente");
        System.out.println("int sum = 0;");
        System.out.println("for (int i = 0; i < 1000000; i++) {");
        System.out.println("    sum += i; // Sin autoboxing");
        System.out.println("}");
    }
    
    // ========================================
    // CASOS DE USO AVANZADOS
    // ========================================
    public static void advancedUseCases() {
        System.out.println("\n🚀 CASOS DE USO AVANZADOS");
        
        // Singleton thread-safe
        demonstrateThreadSafeSingleton();
        
        // Custom annotation processor
        demonstrateCustomAnnotation();
        
        // Custom collector
        demonstrateCustomCollector();
        
        // Custom executor
        demonstrateCustomExecutor();
        
        // Memory monitoring
        demonstrateMemoryMonitoring();
    }
    
    // Singleton thread-safe
    public static void demonstrateThreadSafeSingleton() {
        System.out.println("\n🔒 SINGLETON THREAD-SAFE:");
        System.out.println("public class ThreadSafeSingleton {");
        System.out.println("    private static volatile ThreadSafeSingleton instance;");
        System.out.println("    private static final Object lock = new Object();");
        System.out.println("    ");
        System.out.println("    private ThreadSafeSingleton() {}");
        System.out.println("    ");
        System.out.println("    public static ThreadSafeSingleton getInstance() {");
        System.out.println("        if (instance == null) {");
        System.out.println("            synchronized (lock) {");
        System.out.println("                if (instance == null) {");
        System.out.println("                    instance = new ThreadSafeSingleton();");
        System.out.println("                }");
        System.out.println("            }");
        System.out.println("        }");
        System.out.println("        return instance;");
        System.out.println("    }");
        System.out.println("}");
    }
    
    // Custom annotation
    public static void demonstrateCustomAnnotation() {
        System.out.println("\n🏷️ CUSTOM ANNOTATION:");
        System.out.println("@Retention(RetentionPolicy.RUNTIME)");
        System.out.println("@Target(ElementType.METHOD)");
        System.out.println("public @interface LogExecutionTime {");
        System.out.println("    String value() default \"\";");
        System.out.println("}");
        System.out.println("");
        System.out.println("// Uso con reflection");
        System.out.println("public class LoggingAspect {");
        System.out.println("    public static Object logExecutionTime(Method method, Object[] args) {");
        System.out.println("        long start = System.currentTimeMillis();");
        System.out.println("        Object result = method.invoke(target, args);");
        System.out.println("        long end = System.currentTimeMillis();");
        System.out.println("        System.out.println(method.getName() + \" took \" + (end - start) + \"ms\");");
        System.out.println("        return result;");
        System.out.println("    }");
        System.out.println("}");
    }
    
    // Custom collector
    public static void demonstrateCustomCollector() {
        System.out.println("\n📦 CUSTOM COLLECTOR:");
        System.out.println("public class CustomCollector {");
        System.out.println("    public static <T> Collector<T, ?, Map<String, List<T>>>");
        System.out.println("            groupByFirstLetter() {");
        System.out.println("        return Collector.of(");
        System.out.println("            HashMap::new,");
        System.out.println("            (map, item) -> {");
        System.out.println("                String key = String.valueOf(item.toString().charAt(0));");
        System.out.println("                map.computeIfAbsent(key, k -> new ArrayList<>()).add(item);");
        System.out.println("            },");
        System.out.println("            (map1, map2) -> {");
        System.out.println("                map2.forEach((k, v) -> map1.merge(k, v, (v1, v2) -> {");
        System.out.println("                    v1.addAll(v2);");
        System.out.println("                    return v1;");
        System.out.println("                }));");
        System.out.println("                return map1;");
        System.out.println("            }");
        System.out.println("        );");
        System.out.println("    }");
        System.out.println("}");
    }
    
    // Custom executor
    public static void demonstrateCustomExecutor() {
        System.out.println("\n⚙️ CUSTOM EXECUTOR:");
        System.out.println("public class CustomExecutor {");
        System.out.println("    private final ExecutorService executor;");
        System.out.println("    private final BlockingQueue<Runnable> queue;");
        System.out.println("    ");
        System.out.println("    public CustomExecutor(int corePoolSize, int maxPoolSize) {");
        System.out.println("        this.queue = new LinkedBlockingQueue<>(1000);");
        System.out.println("        this.executor = new ThreadPoolExecutor(");
        System.out.println("            corePoolSize, maxPoolSize,");
        System.out.println("            60L, TimeUnit.SECONDS,");
        System.out.println("            queue,");
        System.out.println("            new ThreadPoolExecutor.CallerRunsPolicy()");
        System.out.println("        );");
        System.out.println("    }");
        System.out.println("    ");
        System.out.println("    public <T> CompletableFuture<T> submit(Callable<T> task) {");
        System.out.println("        return CompletableFuture.supplyAsync(() -> {");
        System.out.println("            try {");
        System.out.println("                return task.call();");
        System.out.println("            } catch (Exception e) {");
        System.out.println("                throw new CompletionException(e);");
        System.out.println("            }");
        System.out.println("        }, executor);");
        System.out.println("    }");
        System.out.println("}");
    }
    
    // Memory monitoring
    public static void demonstrateMemoryMonitoring() {
        System.out.println("\n📊 MEMORY MONITORING:");
        System.out.println("public class MemoryMonitor {");
        System.out.println("    public static void printMemoryInfo() {");
        System.out.println("        Runtime runtime = Runtime.getRuntime();");
        System.out.println("        long totalMemory = runtime.totalMemory();");
        System.out.println("        long freeMemory = runtime.freeMemory();");
        System.out.println("        long usedMemory = totalMemory - freeMemory;");
        System.out.println("        ");
        System.out.println("        System.out.println(\"Total Memory: \" + totalMemory / 1024 / 1024 + \" MB\");");
        System.out.println("        System.out.println(\"Used Memory: \" + usedMemory / 1024 / 1024 + \" MB\");");
        System.out.println("        System.out.println(\"Free Memory: \" + freeMemory / 1024 / 1024 + \" MB\");");
        System.out.println("        ");
        System.out.println("        // GC MXBean");
        System.out.println("        List<GarbageCollectorMXBean> gcBeans = ManagementFactory.getGarbageCollectorMXBeans();");
        System.out.println("        for (GarbageCollectorMXBean gcBean : gcBeans) {");
        System.out.println("            System.out.println(gcBean.getName() + \": \" + gcBean.getCollectionCount());");
        System.out.println("        }");
        System.out.println("    }");
        System.out.println("}");
    }
}
