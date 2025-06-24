// ========================================
// STRINGS EN JAVA - GUÍA COMPLETA PARA SENIOR DEVELOPER
// ========================================

/*
🎯 CONCEPTOS FUNDAMENTALES DE STRINGS
=====================================

1. INMUTABILIDAD
   - Los Strings en Java son inmutables (no se pueden modificar)
   - Cada operación crea un nuevo objeto String
   - Beneficios: thread-safety, seguridad, optimización de memoria

2. STRING POOL (STRING INTERNING)
   - Área especial en heap para almacenar literales String únicos
   - Reutiliza objetos String para ahorrar memoria
   - Solo aplica a literales y strings internados

3. MEMORIA Y PERFORMANCE
   - Cada String ocupa memoria en heap
   - Operaciones de concatenación crean múltiples objetos
   - StringBuffer/StringBuilder para operaciones intensivas

4. ENCODING Y CHARACTER SETS
   - UTF-16 internamente (2 bytes por carácter)
   - Soporte para Unicode completo
   - Conversión entre diferentes encodings
*/

public class Strings {
    
    // Códigos de colores ANSI para Windows y Unix
    public static final String RESET = "\u001B[0m";
    public static final String BLACK = "\u001B[30m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String YELLOW = "\u001B[33m";
    public static final String BLUE = "\u001B[34m";
    public static final String PURPLE = "\u001B[35m";
    public static final String CYAN = "\u001B[36m";
    public static final String WHITE = "\u001B[37m";
    public static final String BRIGHT_RED = "\u001B[91m";
    public static final String BRIGHT_GREEN = "\u001B[92m";
    public static final String BRIGHT_YELLOW = "\u001B[93m";
    public static final String BRIGHT_BLUE = "\u001B[94m";
    public static final String BRIGHT_PURPLE = "\u001B[95m";
    public static final String BRIGHT_CYAN = "\u001B[96m";
    public static final String BRIGHT_WHITE = "\u001B[97m";
    public static final String BOLD = "\u001B[1m";
    public static final String UNDERLINE = "\u001B[4m";
    
    public static void main(String[] args) {
        printHeader();
        
        // Ejecutar todos los ejemplos
        stringFundamentals();
        stringPoolExamples();
        stringMethods();
        stringBufferVsStringBuilder();
        performanceComparison();
        advancedStringOperations();
        stringOptimization();
        stringSecurity();
        stringInterviews();
        
        printFooter();
    }
    
    private static void printHeader() {
        clearScreen();
        System.out.println(BRIGHT_CYAN + BOLD + "╔══════════════════════════════════════════════════════════════════════════════╗" + RESET);
        System.out.println(BRIGHT_CYAN + BOLD + "║" + BRIGHT_YELLOW + "                    🎯 STRINGS EN JAVA - GUÍA COMPLETA                    " + BRIGHT_CYAN + "║" + RESET);
        System.out.println(BRIGHT_CYAN + BOLD + "║" + BRIGHT_YELLOW + "                        PARA SENIOR DEVELOPER                           " + BRIGHT_CYAN + "║" + RESET);
        System.out.println(BRIGHT_CYAN + BOLD + "╚══════════════════════════════════════════════════════════════════════════════╝" + RESET);
        System.out.println();
    }
    
    private static void printFooter() {
        System.out.println();
        System.out.println(BRIGHT_CYAN + BOLD + "╔══════════════════════════════════════════════════════════════════════════════╗" + RESET);
        System.out.println(BRIGHT_CYAN + BOLD + "║" + BRIGHT_GREEN + "                              ✅ GUÍA COMPLETADA                              " + BRIGHT_CYAN + "║" + RESET);
        System.out.println(BRIGHT_CYAN + BOLD + "║" + BRIGHT_GREEN + "                    Todos los conceptos han sido demostrados               " + BRIGHT_CYAN + "║" + RESET);
        System.out.println(BRIGHT_CYAN + BOLD + "╚══════════════════════════════════════════════════════════════════════════════╝" + RESET);
    }
    
    private static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
    
    private static void printSectionHeader(String title, String emoji) {
        System.out.println();
        System.out.println(BRIGHT_PURPLE + BOLD + "┌─────────────────────────────────────────────────────────────────────────────────┐" + RESET);
        System.out.println(BRIGHT_PURPLE + BOLD + "│ " + BRIGHT_YELLOW + emoji + " " + title + BRIGHT_PURPLE + " │" + RESET);
        System.out.println(BRIGHT_PURPLE + BOLD + "└─────────────────────────────────────────────────────────────────────────────────┘" + RESET);
        System.out.println();
    }
    
    private static void printSubSection(String title) {
        System.out.println(BRIGHT_BLUE + BOLD + "  📌 " + title + RESET);
        System.out.println(BRIGHT_BLUE + "  " + "─".repeat(title.length() + 4) + RESET);
    }

    // ========================================
    // FUNDAMENTOS DE STRINGS
    // ========================================
    
    public static void stringFundamentals() {
        printSectionHeader("FUNDAMENTOS DE STRINGS", "📋");
        
        // 1. CREACIÓN DE STRINGS
        String str1 = "Hello"; // Literal - va al String Pool
        String str2 = new String("Hello"); // Nuevo objeto en heap
        String str3 = String.valueOf(123); // Conversión desde otros tipos
        String str4 = String.format("Value: %d", 42); // Formateo
        
        printSubSection("1. Creación de Strings");
        System.out.println(BRIGHT_GREEN + "   str1 = " + BRIGHT_WHITE + "\"" + str1 + "\"" + BRIGHT_CYAN + " (String literal - se almacena en String Pool)" + RESET);
        System.out.println(BRIGHT_GREEN + "   str2 = " + BRIGHT_WHITE + "\"" + str2 + "\"" + BRIGHT_CYAN + " (new String() - crea nuevo objeto en heap)" + RESET);
        System.out.println(BRIGHT_GREEN + "   str3 = " + BRIGHT_WHITE + "\"" + str3 + "\"" + BRIGHT_CYAN + " (String.valueOf() - conversión desde int)" + RESET);
        System.out.println(BRIGHT_GREEN + "   str4 = " + BRIGHT_WHITE + "\"" + str4 + "\"" + BRIGHT_CYAN + " (String.format() - formateo con placeholders)" + RESET);
        
        // 2. INMUTABILIDAD
        String original = "Hello";
        String modified = original.toUpperCase(); // Crea nuevo objeto
        printSubSection("2. Inmutabilidad");
        System.out.println(BRIGHT_GREEN + "   Original: " + BRIGHT_WHITE + "\"" + original + "\"" + BRIGHT_CYAN + " (hash: " + System.identityHashCode(original) + ")" + RESET);
        System.out.println(BRIGHT_GREEN + "   Modificado: " + BRIGHT_WHITE + "\"" + modified + "\"" + BRIGHT_CYAN + " (hash: " + System.identityHashCode(modified) + ")" + RESET);
        System.out.println(BRIGHT_GREEN + "   ¿Son el mismo objeto? " + BRIGHT_RED + (original == modified) + BRIGHT_CYAN + " (false = objetos diferentes en memoria)" + RESET);
        System.out.println(BRIGHT_CYAN + "   Explicación: Los Strings son inmutables, cada operación crea un nuevo objeto String" + RESET);
        
        // 3. COMPARACIÓN DE STRINGS
        String a = "Hello";
        String b = "Hello";
        String c = new String("Hello");
        
        printSubSection("3. Comparación de Strings");
        System.out.println(BRIGHT_GREEN + "   a == b: " + BRIGHT_WHITE + (a == b) + BRIGHT_CYAN + " (true = mismo objeto en String Pool)" + RESET);
        System.out.println(BRIGHT_GREEN + "   a == c: " + BRIGHT_WHITE + (a == c) + BRIGHT_CYAN + " (false = objetos diferentes en memoria)" + RESET);
        System.out.println(BRIGHT_GREEN + "   a.equals(c): " + BRIGHT_WHITE + a.equals(c) + BRIGHT_CYAN + " (true = contenido idéntico)" + RESET);
        System.out.println(BRIGHT_GREEN + "   a.equalsIgnoreCase('HELLO'): " + BRIGHT_WHITE + a.equalsIgnoreCase("HELLO") + BRIGHT_CYAN + " (true = contenido igual ignorando mayúsculas)" + RESET);
        System.out.println(BRIGHT_CYAN + "   Explicación: == compara referencias, equals() compara contenido" + RESET);
    }

    // ========================================
    // STRING POOL Y INTERNING
    // ========================================
    
    public static void stringPoolExamples() {
        printSectionHeader("STRING POOL E INTERNING", "🏊");
        
        // 1. STRING POOL
        String s1 = "Java";
        String s2 = "Java";
        String s3 = new String("Java");
        String s4 = s3.intern(); // Fuerza internamiento
        
        printSubSection("1. String Pool");
        System.out.println(BRIGHT_GREEN + "   s1 == s2: " + BRIGHT_WHITE + (s1 == s2) + BRIGHT_CYAN + " (true = mismo objeto en String Pool)" + RESET);
        System.out.println(BRIGHT_GREEN + "   s1 == s3: " + BRIGHT_WHITE + (s1 == s3) + BRIGHT_CYAN + " (false = s3 es nuevo objeto en heap)" + RESET);
        System.out.println(BRIGHT_GREEN + "   s1 == s4: " + BRIGHT_WHITE + (s1 == s4) + BRIGHT_CYAN + " (true = s4 internado al pool)" + RESET);
        System.out.println(BRIGHT_CYAN + "   Explicación: String Pool reutiliza literales únicos para ahorrar memoria" + RESET);
        
        // 2. INTERNING DINÁMICO
        String dynamic1 = "Hello" + "World"; // Compile-time concatenation
        String dynamic2 = "HelloWorld";
        String dynamic3 = "Hello" + new String("World"); // Runtime concatenation
        
        printSubSection("2. Interning Dinámico");
        System.out.println(BRIGHT_GREEN + "   dynamic1 == dynamic2: " + BRIGHT_WHITE + (dynamic1 == dynamic2) + BRIGHT_CYAN + " (true = concatenación en tiempo de compilación)" + RESET);
        System.out.println(BRIGHT_GREEN + "   dynamic1 == dynamic3: " + BRIGHT_WHITE + (dynamic1 == dynamic3) + BRIGHT_CYAN + " (false = concatenación en tiempo de ejecución)" + RESET);
        System.out.println(BRIGHT_CYAN + "   Explicación: El compilador optimiza concatenaciones de literales" + RESET);
        
        // 3. INTERNING MANUAL
        String manual1 = new String("Manual").intern();
        String manual2 = "Manual";
        printSubSection("3. Interning Manual");
        System.out.println(BRIGHT_GREEN + "   manual1 == manual2: " + BRIGHT_WHITE + (manual1 == manual2) + BRIGHT_CYAN + " (true = intern() fuerza internamiento)" + RESET);
        System.out.println(BRIGHT_CYAN + "   Explicación: intern() busca el string en el pool o lo agrega si no existe" + RESET);
    }

    // ========================================
    // MÉTODOS AVANZADOS DE STRING
    // ========================================
    
    public static void stringMethods() {
        printSectionHeader("MÉTODOS AVANZADOS DE STRING", "🔧");
        
        String text = "  Hello World Java Programming  ";
        
        // 1. MANIPULACIÓN BÁSICA
        printSubSection("1. Manipulación Básica");
        System.out.println(BRIGHT_GREEN + "   Original: " + BRIGHT_WHITE + "\"" + text + "\"" + BRIGHT_CYAN + " (longitud: " + text.length() + ")" + RESET);
        System.out.println(BRIGHT_GREEN + "   trim(): " + BRIGHT_WHITE + "\"" + text.trim() + "\"" + BRIGHT_CYAN + " (elimina espacios al inicio y final)" + RESET);
        System.out.println(BRIGHT_GREEN + "   toUpperCase(): " + BRIGHT_WHITE + "\"" + text.toUpperCase() + "\"" + BRIGHT_CYAN + " (convierte a mayúsculas)" + RESET);
        System.out.println(BRIGHT_GREEN + "   toLowerCase(): " + BRIGHT_WHITE + "\"" + text.toLowerCase() + "\"" + BRIGHT_CYAN + " (convierte a minúsculas)" + RESET);
        System.out.println(BRIGHT_GREEN + "   length(): " + BRIGHT_WHITE + text.length() + BRIGHT_CYAN + " (número de caracteres incluyendo espacios)" + RESET);
        
        // 2. BÚSQUEDA Y EXTRACCIÓN
        printSubSection("2. Búsqueda y Extracción");
        System.out.println(BRIGHT_GREEN + "   indexOf('o'): " + BRIGHT_WHITE + text.indexOf('o') + BRIGHT_CYAN + " (primera ocurrencia del carácter 'o')" + RESET);
        System.out.println(BRIGHT_GREEN + "   lastIndexOf('o'): " + BRIGHT_WHITE + text.lastIndexOf('o') + BRIGHT_CYAN + " (última ocurrencia del carácter 'o')" + RESET);
        System.out.println(BRIGHT_GREEN + "   contains('Java'): " + BRIGHT_WHITE + text.contains("Java") + BRIGHT_CYAN + " (verifica si contiene la subcadena 'Java')" + RESET);
        System.out.println(BRIGHT_GREEN + "   startsWith('Hello'): " + BRIGHT_WHITE + text.startsWith("Hello") + BRIGHT_CYAN + " (verifica si comienza con 'Hello' - false por espacios)" + RESET);
        System.out.println(BRIGHT_GREEN + "   endsWith('ing'): " + BRIGHT_WHITE + text.endsWith("ing") + BRIGHT_CYAN + " (verifica si termina con 'ing' - false por espacios)" + RESET);
        System.out.println(BRIGHT_GREEN + "   substring(7, 12): " + BRIGHT_WHITE + "\"" + text.substring(7, 12) + "\"" + BRIGHT_CYAN + " (extrae desde posición 7 hasta 11)" + RESET);
        System.out.println(BRIGHT_GREEN + "   charAt(8): " + BRIGHT_WHITE + "'" + text.charAt(8) + "'" + BRIGHT_CYAN + " (carácter en la posición 8)" + RESET);
        
        // 3. DIVISIÓN Y UNIÓN
        String[] words = text.trim().split("\\s+");
        printSubSection("3. División y Unión");
        System.out.println(BRIGHT_GREEN + "   split(): " + BRIGHT_WHITE + java.util.Arrays.toString(words) + BRIGHT_CYAN + " (divide por espacios usando regex \\s+)" + RESET);
        System.out.println(BRIGHT_GREEN + "   join(): " + BRIGHT_WHITE + "\"" + String.join("-", words) + "\"" + BRIGHT_CYAN + " (une elementos con separador '-')" + RESET);
        
        // 4. REEMPLAZO
        printSubSection("4. Reemplazo");
        System.out.println(BRIGHT_GREEN + "   replace('o', '0'): " + BRIGHT_WHITE + "\"" + text.replace('o', '0') + "\"" + BRIGHT_CYAN + " (reemplaza todas las 'o' por '0')" + RESET);
        System.out.println(BRIGHT_GREEN + "   replaceAll('\\s+', '_'): " + BRIGHT_WHITE + "\"" + text.replaceAll("\\s+", "_") + "\"" + BRIGHT_CYAN + " (reemplaza espacios múltiples por '_')" + RESET);
        System.out.println(BRIGHT_GREEN + "   replaceFirst('o', '0'): " + BRIGHT_WHITE + "\"" + text.replaceFirst("o", "0") + "\"" + BRIGHT_CYAN + " (reemplaza solo la primera 'o' por '0')" + RESET);
        
        // 5. COMPARACIÓN AVANZADA
        printSubSection("5. Comparación Avanzada");
        System.out.println(BRIGHT_GREEN + "   compareTo('Hello'): " + BRIGHT_WHITE + text.trim().compareTo("Hello") + BRIGHT_CYAN + " (comparación lexicográfica - positivo si es mayor)" + RESET);
        System.out.println(BRIGHT_GREEN + "   compareToIgnoreCase('HELLO'): " + BRIGHT_WHITE + text.trim().compareToIgnoreCase("HELLO") + BRIGHT_CYAN + " (comparación ignorando mayúsculas)" + RESET);
        
        // 6. VERIFICACIÓN
        printSubSection("6. Verificación");
        System.out.println(BRIGHT_GREEN + "   isEmpty(): " + BRIGHT_WHITE + text.isEmpty() + BRIGHT_CYAN + " (verifica si está vacío - false porque tiene contenido)" + RESET);
        System.out.println(BRIGHT_GREEN + "   isBlank(): " + BRIGHT_WHITE + text.isBlank() + BRIGHT_CYAN + " (verifica si está en blanco - false porque tiene contenido)" + RESET);
        System.out.println(BRIGHT_GREEN + "   matches('.*Java.*'): " + BRIGHT_WHITE + text.matches(".*Java.*") + BRIGHT_CYAN + " (verifica si coincide con regex)" + RESET);
    }

    // ========================================
    // STRINGBUFFER VS STRINGBUILDER
    // ========================================
    
    public static void stringBufferVsStringBuilder() {
        printSectionHeader("STRINGBUFFER VS STRINGBUILDER", "⚡");
        
        // 1. DIFERENCIAS PRINCIPALES
        printSubSection("1. Diferencias Principales");
        System.out.println(BRIGHT_GREEN + "   " + BRIGHT_YELLOW + "StringBuffer: " + BRIGHT_WHITE + "Thread-safe (synchronized) - más lento pero seguro para concurrencia" + RESET);
        System.out.println(BRIGHT_GREEN + "   " + BRIGHT_YELLOW + "StringBuilder: " + BRIGHT_WHITE + "No thread-safe (más rápido) - ideal para operaciones secuenciales" + RESET);
        System.out.println(BRIGHT_GREEN + "   " + BRIGHT_YELLOW + "String: " + BRIGHT_WHITE + "Inmutable - cada operación crea nuevo objeto" + RESET);
        System.out.println(BRIGHT_CYAN + "   Explicación: StringBuffer usa synchronized, StringBuilder no - por eso la diferencia de velocidad" + RESET);
        
        // 2. EJEMPLOS DE USO
        StringBuffer stringBuffer = new StringBuffer("Hello");
        StringBuilder stringBuilder = new StringBuilder("Hello");
        
        printSubSection("2. Ejemplos de Uso");
        System.out.println(BRIGHT_GREEN + "   StringBuffer original: " + BRIGHT_WHITE + "\"" + stringBuffer + "\"" + RESET);
        System.out.println(BRIGHT_GREEN + "   StringBuilder original: " + BRIGHT_WHITE + "\"" + stringBuilder + "\"" + RESET);
        
        // StringBuffer (thread-safe)
        stringBuffer.append(" World");
        stringBuffer.insert(5, " Beautiful ");
        stringBuffer.reverse();
        System.out.println(BRIGHT_GREEN + "   StringBuffer después de operaciones: " + BRIGHT_WHITE + "\"" + stringBuffer + "\"" + BRIGHT_CYAN + " (append + insert + reverse)" + RESET);
        
        // StringBuilder (más rápido)
        stringBuilder.append(" World");
        stringBuilder.insert(5, " Beautiful ");
        stringBuilder.reverse();
        System.out.println(BRIGHT_GREEN + "   StringBuilder después de operaciones: " + BRIGHT_WHITE + "\"" + stringBuilder + "\"" + BRIGHT_CYAN + " (mismas operaciones, más rápido)" + RESET);
        
        // 3. MÉTODOS COMUNES
        StringBuilder sb = new StringBuilder("Java Programming");
        printSubSection("3. Métodos Comunes");
        System.out.println(BRIGHT_GREEN + "   Original: " + BRIGHT_WHITE + "\"" + sb + "\"" + RESET);
        System.out.println(BRIGHT_GREEN + "   append(' is fun'): " + BRIGHT_WHITE + "\"" + sb.append(" is fun") + "\"" + BRIGHT_CYAN + " (agrega al final)" + RESET);
        System.out.println(BRIGHT_GREEN + "   insert(4, 'Script'): " + BRIGHT_WHITE + "\"" + sb.insert(4, "Script") + "\"" + BRIGHT_CYAN + " (inserta en posición 4)" + RESET);
        System.out.println(BRIGHT_GREEN + "   delete(4, 10): " + BRIGHT_WHITE + "\"" + sb.delete(4, 10) + "\"" + BRIGHT_CYAN + " (elimina desde posición 4 hasta 9)" + RESET);
        System.out.println(BRIGHT_GREEN + "   reverse(): " + BRIGHT_WHITE + "\"" + sb.reverse() + "\"" + BRIGHT_CYAN + " (invierte el orden de caracteres)" + RESET);
        System.out.println(BRIGHT_GREEN + "   capacity(): " + BRIGHT_WHITE + sb.capacity() + BRIGHT_CYAN + " (capacidad actual del buffer interno)" + RESET);
        System.out.println(BRIGHT_GREEN + "   length(): " + BRIGHT_WHITE + sb.length() + BRIGHT_CYAN + " (longitud actual del contenido)" + RESET);
        
        // 4. OPTIMIZACIÓN DE CAPACIDAD
        StringBuilder optimized = new StringBuilder(100); // Capacidad inicial
        optimized.append("Hello").append(" ").append("World");
        printSubSection("4. Optimización de Capacidad");
        System.out.println(BRIGHT_GREEN + "   Capacidad inicial: " + BRIGHT_WHITE + "100" + BRIGHT_CYAN + " (evita redimensionamientos)" + RESET);
        System.out.println(BRIGHT_GREEN + "   Longitud actual: " + BRIGHT_WHITE + optimized.length() + BRIGHT_CYAN + " (caracteres utilizados)" + RESET);
        System.out.println(BRIGHT_GREEN + "   Capacidad actual: " + BRIGHT_WHITE + optimized.capacity() + BRIGHT_CYAN + " (espacio disponible)" + RESET);
        System.out.println(BRIGHT_CYAN + "   Explicación: Capacidad inicial evita redimensionamientos costosos del buffer" + RESET);
    }

    // ========================================
    // COMPARACIÓN DE PERFORMANCE
    // ========================================
    
    public static void performanceComparison() {
        printSectionHeader("COMPARACIÓN DE PERFORMANCE", "🚀");
        
        int iterations = 100000;
        
        // 1. CONCATENACIÓN DE STRINGS
        long startTime = System.currentTimeMillis();
        String result1 = "";
        for (int i = 0; i < iterations; i++) {
            result1 += "a";
        }
        long stringTime = System.currentTimeMillis() - startTime;
        
        // 2. STRINGBUFFER
        startTime = System.currentTimeMillis();
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < iterations; i++) {
            stringBuffer.append("a");
        }
        String result2 = stringBuffer.toString();
        long bufferTime = System.currentTimeMillis() - startTime;
        
        // 3. STRINGBUILDER
        startTime = System.currentTimeMillis();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < iterations; i++) {
            stringBuilder.append("a");
        }
        String result3 = stringBuilder.toString();
        long builderTime = System.currentTimeMillis() - startTime;
        
        printSubSection("1. Tiempo de Ejecución (" + iterations + " iteraciones)");
        System.out.println(BRIGHT_GREEN + "   " + BRIGHT_RED + "String concatenation: " + BRIGHT_WHITE + stringTime + "ms" + BRIGHT_CYAN + " (lento - crea " + iterations + " objetos temporales)" + RESET);
        System.out.println(BRIGHT_GREEN + "   " + BRIGHT_YELLOW + "StringBuffer: " + BRIGHT_WHITE + bufferTime + "ms" + BRIGHT_CYAN + " (medio - thread-safe pero synchronized)" + RESET);
        System.out.println(BRIGHT_GREEN + "   " + BRIGHT_GREEN + "StringBuilder: " + BRIGHT_WHITE + builderTime + "ms" + BRIGHT_CYAN + " (rápido - sin overhead de synchronized)" + RESET);
        System.out.println(BRIGHT_GREEN + "   " + BRIGHT_CYAN + "StringBuilder es " + BRIGHT_WHITE + (stringTime / builderTime) + "x más rápido que String" + BRIGHT_CYAN + " (diferencia dramática)" + RESET);
        
        // 4. USO DE MEMORIA
        printSubSection("2. Uso de Memoria");
        System.out.println(BRIGHT_GREEN + "   " + BRIGHT_RED + "String: " + BRIGHT_WHITE + "Crea " + iterations + " objetos temporales" + BRIGHT_CYAN + " (memory leak potencial)" + RESET);
        System.out.println(BRIGHT_GREEN + "   " + BRIGHT_YELLOW + "StringBuffer: " + BRIGHT_WHITE + "1 objeto + buffer interno" + BRIGHT_CYAN + " (eficiente en memoria)" + RESET);
        System.out.println(BRIGHT_GREEN + "   " + BRIGHT_GREEN + "StringBuilder: " + BRIGHT_WHITE + "1 objeto + buffer interno" + BRIGHT_CYAN + " (más eficiente - sin synchronized)" + RESET);
        System.out.println(BRIGHT_CYAN + "   Explicación: String concatenation es ineficiente para operaciones repetitivas" + RESET);
    }

    // ========================================
    // OPERACIONES AVANZADAS
    // ========================================
    
    public static void advancedStringOperations() {
        printSectionHeader("OPERACIONES AVANZADAS", "🔬");
        
        // 1. STRING FORMATTING
        printSubSection("1. String Formatting");
        String formatted = String.format("Name: %s, Age: %d, Salary: %.2f", "John", 30, 50000.50);
        System.out.println(BRIGHT_GREEN + "   " + BRIGHT_WHITE + "\"" + formatted + "\"" + BRIGHT_CYAN + " (formateo con placeholders: %s=string, %d=int, %.2f=float)" + RESET);
        
        // 2. STRING JOIN (Java 8+)
        String[] names = {"Alice", "Bob", "Charlie"};
        String joined = String.join(" -> ", names);
        printSubSection("2. String Join (Java 8+)");
        System.out.println(BRIGHT_GREEN + "   " + BRIGHT_WHITE + "\"" + joined + "\"" + BRIGHT_CYAN + " (une array con separador personalizado)" + RESET);
        
        // 3. STRING LINES (Java 11+)
        String multiline = "Line 1\nLine 2\nLine 3";
        printSubSection("3. String Lines (Java 11+)");
        System.out.println(BRIGHT_CYAN + "   Procesando líneas individuales:" + RESET);
        multiline.lines().forEach(line -> System.out.println(BRIGHT_GREEN + "   " + BRIGHT_WHITE + "\"" + line + "\"" + RESET));
        
        // 4. STRING REPEAT (Java 11+)
        String repeated = "=".repeat(20);
        printSubSection("4. String Repeat (Java 11+)");
        System.out.println(BRIGHT_GREEN + "   " + BRIGHT_WHITE + "\"" + repeated + "\"" + BRIGHT_CYAN + " (repite el carácter '=' 20 veces)" + RESET);
        
        // 5. STRING STRIP (Java 11+)
        String whitespace = "  \t\n  Hello World  \t\n  ";
        printSubSection("5. String Strip (Java 11+)");
        System.out.println(BRIGHT_GREEN + "   Original: " + BRIGHT_WHITE + "\"" + whitespace + "\"" + BRIGHT_CYAN + " (con espacios, tabs y saltos de línea)" + RESET);
        System.out.println(BRIGHT_GREEN + "   strip(): " + BRIGHT_WHITE + "\"" + whitespace.strip() + "\"" + BRIGHT_CYAN + " (elimina espacios Unicode al inicio y final)" + RESET);
        System.out.println(BRIGHT_GREEN + "   stripLeading(): " + BRIGHT_WHITE + "\"" + whitespace.stripLeading() + "\"" + BRIGHT_CYAN + " (solo al inicio)" + RESET);
        System.out.println(BRIGHT_GREEN + "   stripTrailing(): " + BRIGHT_WHITE + "\"" + whitespace.stripTrailing() + "\"" + BRIGHT_CYAN + " (solo al final)" + RESET);
        
        // 6. STRING INDENT (Java 12+)
        String text = "Hello\nWorld\nJava";
        printSubSection("6. String Indent (Java 12+)");
        System.out.println(BRIGHT_GREEN + "   Original:" + RESET);
        System.out.println(BRIGHT_WHITE + text + RESET);
        System.out.println(BRIGHT_GREEN + "   Indented (4 espacios):" + RESET);
        System.out.println(BRIGHT_WHITE + text.indent(4) + RESET);
        
        // 7. STRING TRANSFORM (Java 12+)
        String transformed = "hello world"
            .transform(String::toUpperCase)
            .transform(s -> s.replace(" ", "_"));
        printSubSection("7. String Transform (Java 12+)");
        System.out.println(BRIGHT_GREEN + "   " + BRIGHT_WHITE + "\"" + transformed + "\"" + BRIGHT_CYAN + " (transformación en cadena: toUpperCase + replace)" + RESET);
        System.out.println(BRIGHT_CYAN + "   Explicación: transform() permite encadenar operaciones de forma funcional" + RESET);
    }

    // ========================================
    // OPTIMIZACIÓN DE STRINGS
    // ========================================
    
    public static void stringOptimization() {
        printSectionHeader("OPTIMIZACIÓN DE STRINGS", "⚡");
        
        // 1. CONCATENACIÓN OPTIMIZADA
        printSubSection("1. Concatenación Optimizada");
        
        // ❌ Malo - crea muchos objetos temporales
        String bad = "";
        for (int i = 0; i < 1000; i++) {
            bad += "a";
        }
        
        // ✅ Bueno - usa StringBuilder internamente
        String good = "a".repeat(1000);
        
        // ✅ Mejor - StringBuilder explícito
        StringBuilder best = new StringBuilder();
        for (int i = 0; i < 1000; i++) {
            best.append("a");
        }
        String bestResult = best.toString();
        
        System.out.println(BRIGHT_GREEN + "   " + BRIGHT_GREEN + "✅ Usando repeat(): " + BRIGHT_WHITE + good.length() + " caracteres" + BRIGHT_CYAN + " (método optimizado de Java 11+)" + RESET);
        System.out.println(BRIGHT_GREEN + "   " + BRIGHT_GREEN + "✅ Usando StringBuilder: " + BRIGHT_WHITE + bestResult.length() + " caracteres" + BRIGHT_CYAN + " (control explícito del buffer)" + RESET);
        System.out.println(BRIGHT_CYAN + "   Explicación: repeat() es más legible y optimizado para repeticiones simples" + RESET);
        
        // 2. STRING POOL OPTIMIZACIÓN
        printSubSection("2. String Pool Optimización");
        
        // ❌ Malo - crea nuevo objeto
        String bad1 = new String("Hello");
        String bad2 = new String("Hello");
        
        // ✅ Bueno - reutiliza del pool
        String good1 = "Hello";
        String good2 = "Hello";
        
        System.out.println(BRIGHT_GREEN + "   " + BRIGHT_RED + "❌ new String(): " + BRIGHT_WHITE + (bad1 == bad2) + BRIGHT_CYAN + " (false - objetos diferentes)" + RESET);
        System.out.println(BRIGHT_GREEN + "   " + BRIGHT_GREEN + "✅ String literal: " + BRIGHT_WHITE + (good1 == good2) + BRIGHT_CYAN + " (true - mismo objeto del pool)" + RESET);
        System.out.println(BRIGHT_CYAN + "   Explicación: Los literales se reutilizan del String Pool, new String() crea objetos separados" + RESET);
        
        // 3. COMPARACIÓN OPTIMIZADA
        printSubSection("3. Comparación Optimizada");
        
        String test1 = "Hello";
        String test2 = "Hello";
        String test3 = new String("Hello");
        
        // ✅ Para comparación de contenido
        boolean contentEqual = test1.equals(test3);
        
        // ✅ Para comparación de referencia (solo cuando apropiado)
        boolean referenceEqual = test1 == test2;
        
        System.out.println(BRIGHT_GREEN + "   " + BRIGHT_GREEN + "✅ equals(): " + BRIGHT_WHITE + contentEqual + BRIGHT_CYAN + " (comparación de contenido - siempre correcta)" + RESET);
        System.out.println(BRIGHT_GREEN + "   " + BRIGHT_GREEN + "✅ == (pool): " + BRIGHT_WHITE + referenceEqual + BRIGHT_CYAN + " (comparación de referencia - solo para literales)" + RESET);
        System.out.println(BRIGHT_CYAN + "   Explicación: equals() es seguro para cualquier String, == solo para literales del pool" + RESET);
        
        // 4. MEMORY LEAKS PREVENTION
        printSubSection("4. Memory Leaks Prevention");
        
        // ❌ Potencial memory leak
        String largeString = "Very large string...".repeat(10000);
        
        // ✅ Liberar referencia cuando no se necesite
        largeString = null;
        
        System.out.println(BRIGHT_GREEN + "   " + BRIGHT_GREEN + "✅ Referencia liberada para garbage collection" + BRIGHT_CYAN + " (previene memory leaks)" + RESET);
        System.out.println(BRIGHT_CYAN + "   Explicación: Asignar null permite al GC liberar memoria de objetos grandes" + RESET);
    }

    // ========================================
    // SEGURIDAD DE STRINGS
    // ========================================
    
    public static void stringSecurity() {
        printSectionHeader("SEGURIDAD DE STRINGS", "🔒");
        
        // 1. SENSITIVE DATA HANDLING
        printSubSection("1. Sensitive Data Handling");
        
        // ❌ Malo - password en String (persiste en memoria)
        String password = "secret123";
        
        // ✅ Bueno - usar char[] para passwords
        char[] passwordChars = "secret123".toCharArray();
        
        // Limpiar array después de uso
        java.util.Arrays.fill(passwordChars, '0');
        
        System.out.println(BRIGHT_GREEN + "   " + BRIGHT_GREEN + "✅ Password en char[]: más seguro" + BRIGHT_CYAN + " (no persiste en String Pool)" + RESET);
        System.out.println(BRIGHT_GREEN + "   " + BRIGHT_GREEN + "✅ Array limpiado después de uso" + BRIGHT_CYAN + " (previene acceso a datos sensibles)" + RESET);
        System.out.println(BRIGHT_CYAN + "   Explicación: char[] se puede limpiar, String permanece en memoria hasta GC" + RESET);
        
        // 2. SQL INJECTION PREVENTION
        printSubSection("2. SQL Injection Prevention");
        
        String userInput = "'; DROP TABLE users; --";
        
        // ❌ Malo - concatenación directa
        String badSql = "SELECT * FROM users WHERE name = '" + userInput + "'";
        
        // ✅ Bueno - PreparedStatement (no mostrado aquí)
        System.out.println(BRIGHT_GREEN + "   " + BRIGHT_GREEN + "✅ Usar PreparedStatement para queries SQL" + BRIGHT_CYAN + " (previene SQL injection)" + RESET);
        System.out.println(BRIGHT_CYAN + "   Explicación: PreparedStatement escapa automáticamente los parámetros" + RESET);
        
        // 3. XSS PREVENTION
        printSubSection("3. XSS Prevention");
        
        String userContent = "<script>alert('XSS')</script>";
        
        // ✅ Escapar HTML
        String escaped = userContent
            .replace("&", "&amp;")
            .replace("<", "&lt;")
            .replace(">", "&gt;")
            .replace("\"", "&quot;")
            .replace("'", "&#x27;");
        
        System.out.println(BRIGHT_GREEN + "   Original: " + BRIGHT_WHITE + "\"" + userContent + "\"" + BRIGHT_CYAN + " (contenido malicioso)" + RESET);
        System.out.println(BRIGHT_GREEN + "   Escapado: " + BRIGHT_WHITE + "\"" + escaped + "\"" + BRIGHT_CYAN + " (HTML escapado - seguro)" + RESET);
        System.out.println(BRIGHT_CYAN + "   Explicación: Escapar caracteres especiales previene ejecución de scripts maliciosos" + RESET);
        
        // 4. INPUT VALIDATION
        printSubSection("4. Input Validation");
        
        String email = "user@example.com";
        
        // ✅ Validar formato
        boolean isValidEmail = email.matches("^[A-Za-z0-9+_.-]+@(.+)$");
        System.out.println(BRIGHT_GREEN + "   Email válido: " + BRIGHT_WHITE + isValidEmail + BRIGHT_CYAN + " (validación con regex)" + RESET);
        
        // ✅ Sanitizar input
        String sanitized = email.trim().toLowerCase();
        System.out.println(BRIGHT_GREEN + "   Sanitizado: " + BRIGHT_WHITE + "\"" + sanitized + "\"" + BRIGHT_CYAN + " (normalizado y limpiado)" + RESET);
        System.out.println(BRIGHT_CYAN + "   Explicación: Validar y sanitizar inputs previene ataques y errores" + RESET);
    }

    // ========================================
    // PREGUNTAS DE ENTREVISTA
    // ========================================
    
    public static void stringInterviews() {
        printSectionHeader("PREGUNTAS DE ENTREVISTA SENIOR", "🎯");
        
        System.out.println(BRIGHT_GREEN + "   1. " + BRIGHT_YELLOW + "¿Por qué los Strings son inmutables en Java?" + RESET);
        System.out.println(BRIGHT_GREEN + "      " + BRIGHT_WHITE + "• Thread-safety: Múltiples hilos pueden leer sin sincronización" + RESET);
        System.out.println(BRIGHT_GREEN + "      " + BRIGHT_WHITE + "• String Pool optimization: Reutilización de literales únicos" + RESET);
        System.out.println(BRIGHT_GREEN + "      " + BRIGHT_WHITE + "• Security: Passwords y URLs no pueden ser modificadas" + RESET);
        System.out.println(BRIGHT_GREEN + "      " + BRIGHT_WHITE + "• Caching hash codes: Hash code calculado una sola vez" + RESET);
        
        System.out.println(BRIGHT_GREEN + "   2. " + BRIGHT_YELLOW + "¿Cuándo usar String vs StringBuffer vs StringBuilder?" + RESET);
        System.out.println(BRIGHT_GREEN + "      " + BRIGHT_WHITE + "• String: Inmutable, thread-safe, para valores constantes y literales" + RESET);
        System.out.println(BRIGHT_GREEN + "      " + BRIGHT_WHITE + "• StringBuffer: Mutable, thread-safe, para operaciones concurrentes" + RESET);
        System.out.println(BRIGHT_GREEN + "      " + BRIGHT_WHITE + "• StringBuilder: Mutable, no thread-safe, para operaciones secuenciales" + RESET);
        
        System.out.println(BRIGHT_GREEN + "   3. " + BRIGHT_YELLOW + "¿Cómo funciona el String Pool?" + RESET);
        System.out.println(BRIGHT_GREEN + "      " + BRIGHT_WHITE + "• Área especial en heap para almacenar literales String únicos" + RESET);
        System.out.println(BRIGHT_GREEN + "      " + BRIGHT_WHITE + "• Reutiliza objetos para ahorrar memoria y mejorar performance" + RESET);
        System.out.println(BRIGHT_GREEN + "      " + BRIGHT_WHITE + "• Solo aplica a literales y strings internados con intern()" + RESET);
        
        System.out.println(BRIGHT_GREEN + "   4. " + BRIGHT_YELLOW + "¿Cuál es la diferencia entre == y equals()?" + RESET);
        System.out.println(BRIGHT_GREEN + "      " + BRIGHT_WHITE + "• ==: Compara referencias de objetos (direcciones de memoria)" + RESET);
        System.out.println(BRIGHT_GREEN + "      " + BRIGHT_WHITE + "• equals(): Compara contenido de strings (valores de caracteres)" + RESET);
        
        System.out.println(BRIGHT_GREEN + "   5. " + BRIGHT_YELLOW + "¿Cómo optimizar concatenación de strings?" + RESET);
        System.out.println(BRIGHT_GREEN + "      " + BRIGHT_WHITE + "• Usar StringBuilder para múltiples concatenaciones en loops" + RESET);
        System.out.println(BRIGHT_GREEN + "      " + BRIGHT_WHITE + "• Usar String.join() para unir arrays o colecciones" + RESET);
        System.out.println(BRIGHT_GREEN + "      " + BRIGHT_WHITE + "• Usar String.format() para formateo complejo con placeholders" + RESET);
        
        System.out.println(BRIGHT_GREEN + "   6. " + BRIGHT_YELLOW + "¿Cómo manejar strings en aplicaciones de alta concurrencia?" + RESET);
        System.out.println(BRIGHT_GREEN + "      " + BRIGHT_WHITE + "• StringBuffer para operaciones concurrentes compartidas" + RESET);
        System.out.println(BRIGHT_GREEN + "      " + BRIGHT_WHITE + "• Thread-local StringBuilder para operaciones por hilo" + RESET);
        System.out.println(BRIGHT_GREEN + "      " + BRIGHT_WHITE + "• Aprovechar la inmutabilidad de String como ventaja natural" + RESET);
        
        System.out.println(BRIGHT_GREEN + "   7. " + BRIGHT_YELLOW + "¿Cuáles son las mejores prácticas para strings?" + RESET);
        System.out.println(BRIGHT_GREEN + "      " + BRIGHT_WHITE + "• Usar literales cuando sea posible para aprovechar String Pool" + RESET);
        System.out.println(BRIGHT_GREEN + "      " + BRIGHT_WHITE + "• Preferir StringBuilder sobre concatenación para operaciones repetitivas" + RESET);
        System.out.println(BRIGHT_GREEN + "      " + BRIGHT_WHITE + "• Validar y sanitizar inputs para prevenir vulnerabilidades" + RESET);
        System.out.println(BRIGHT_GREEN + "      " + BRIGHT_WHITE + "• Usar char[] para datos sensibles como passwords" + RESET);
    }
}
