import java.util.*;

public class BigO {
    
    public static void main(String[] args) {
        System.out.println("=== GUÍA COMPLETA DE NOTACIÓN BIG O ===\n");
        
        // Ejemplos de cada complejidad
        demonstrateO1();
        demonstrateOLogN();
        demonstrateON();
        demonstrateONLogN();
        demonstrateON2();
        demonstrateON3();
        demonstrateO2N();
        demonstrateONFactorial();
        
        // Comparación de rendimiento
        comparePerformance();
        
        // Conceptos avanzados para senior developers
        advancedConcepts();
        
        // Ejemplos prácticos de análisis
        practicalExamples();
        
        // Optimizaciones comunes
        commonOptimizations();
        
        // Preguntas de entrevista comunes
        interviewQuestions();
        
        // Herramientas y técnicas
        toolsAndTechniques();
        
        // Ejemplos de búsqueda por índice en Map
        mapIndexExamples();
        
        // Ejemplo de uso de IndexedMap
        demonstrateIndexedMap();
    }
    
    // ========================================
    // O(1) - TIEMPO CONSTANTE
    // ========================================
    public static void demonstrateO1() {
        System.out.println("🔵 O(1) - TIEMPO CONSTANTE");
        System.out.println("La complejidad NO cambia sin importar el tamaño de la entrada\n");
        
        // Ejemplo 1: Acceso a array por índice
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int firstElement = array[0];  // O(1) - siempre toma el mismo tiempo
        int lastElement = array[array.length - 1];  // O(1) - siempre toma el mismo tiempo
        
        System.out.println("✅ Ejemplos O(1):");
        System.out.println("   - Acceso a array por índice: array[0]");
        System.out.println("   - Operaciones matemáticas: a + b, a * b");
        System.out.println("   - Acceso a HashMap: map.get(key)");
        System.out.println("   - Push/Pop en Stack: stack.push(), stack.pop()");
        System.out.println("   - Enqueue/Dequeue en Queue: queue.offer(), queue.poll()\n");
    }
    
    // ========================================
    // O(log n) - TIEMPO LOGARÍTMICO
    // ========================================
    public static void demonstrateOLogN() {
        System.out.println("🟢 O(log n) - TIEMPO LOGARÍTMICO");
        System.out.println("El tiempo crece logarítmicamente con el tamaño de la entrada\n");
        
        // Ejemplo: Búsqueda binaria
        int[] sortedArray = {1, 3, 5, 7, 9, 11, 13, 15, 17, 19};
        int target = 13;
        int result = binarySearch(sortedArray, target);
        
        System.out.println("✅ Ejemplos O(log n):");
        System.out.println("   - Búsqueda binaria en array ordenado");
        System.out.println("   - Búsqueda en árbol binario balanceado");
        System.out.println("   - Búsqueda en TreeMap/TreeSet");
        System.out.println("   - Algoritmos de división y conquista");
        System.out.println("   - Búsqueda en heap (PriorityQueue)\n");
    }
    
    // ========================================
    // O(n) - TIEMPO LINEAL
    // ========================================
    public static void demonstrateON() {
        System.out.println("🟡 O(n) - TIEMPO LINEAL");
        System.out.println("El tiempo crece proporcionalmente con el tamaño de la entrada\n");
        
        // Ejemplo: Búsqueda lineal
        int[] array = {4, 2, 7, 1, 9, 3, 8, 5, 6};
        int target = 7;
        int index = linearSearch(array, target);
        
        System.out.println("✅ Ejemplos O(n):");
        System.out.println("   - Búsqueda lineal en array");
        System.out.println("   - Recorrer lista enlazada");
        System.out.println("   - Copiar array: System.arraycopy()");
        System.out.println("   - Imprimir todos los elementos");
        System.out.println("   - Encontrar máximo/mínimo en array\n");
    }
    
    // ========================================
    // O(n log n) - TIEMPO LINEALÍTMICO
    // ========================================
    public static void demonstrateONLogN() {
        System.out.println("🟠 O(n log n) - TIEMPO LINEALÍTMICO");
        System.out.println("Combinación de lineal y logarítmico - muy común en algoritmos de ordenamiento\n");
        
        // Ejemplo: Merge Sort
        int[] array = {64, 34, 25, 12, 22, 11, 90};
        System.out.println("Array original: " + Arrays.toString(array));
        mergeSort(array, 0, array.length - 1);
        System.out.println("Array ordenado: " + Arrays.toString(array));
        
        System.out.println("✅ Ejemplos O(n log n):");
        System.out.println("   - Merge Sort");
        System.out.println("   - Quick Sort (caso promedio)");
        System.out.println("   - Heap Sort");
        System.out.println("   - Tree Sort");
        System.out.println("   - Algoritmos de división y conquista\n");
    }
    
    // ========================================
    // O(n²) - TIEMPO CUADRÁTICO
    // ========================================
    public static void demonstrateON2() {
        System.out.println("🔴 O(n²) - TIEMPO CUADRÁTICO");
        System.out.println("El tiempo crece cuadráticamente - evítalo en arrays grandes\n");
        
        // Ejemplo: Bubble Sort
        int[] array = {64, 34, 25, 12, 22, 11, 90};
        System.out.println("Array original: " + Arrays.toString(array));
        bubbleSort(array);
        System.out.println("Array ordenado: " + Arrays.toString(array));
        
        System.out.println("✅ Ejemplos O(n²):");
        System.out.println("   - Bubble Sort");
        System.out.println("   - Selection Sort");
        System.out.println("   - Insertion Sort");
        System.out.println("   - Búsqueda de subarrays");
        System.out.println("   - Comparación de todos los pares\n");
    }
    
    // ========================================
    // O(n³) - TIEMPO CÚBICO
    // ========================================
    public static void demonstrateON3() {
        System.out.println("🟣 O(n³) - TIEMPO CÚBICO");
        System.out.println("Muy lento - solo para problemas pequeños\n");
        
        // Ejemplo: Multiplicación de matrices
        int[][] matrix1 = {{1, 2}, {3, 4}};
        int[][] matrix2 = {{5, 6}, {7, 8}};
        int[][] result = multiplyMatrices(matrix1, matrix2);
        
        System.out.println("✅ Ejemplos O(n³):");
        System.out.println("   - Multiplicación de matrices");
        System.out.println("   - Algoritmo de Floyd-Warshall");
        System.out.println("   - Problemas de 3 sumas");
        System.out.println("   - Algoritmos de programación dinámica\n");
    }
    
    // ========================================
    // O(2ⁿ) - TIEMPO EXPONENCIAL
    // ========================================
    public static void demonstrateO2N() {
        System.out.println("⚫ O(2ⁿ) - TIEMPO EXPONENCIAL");
        System.out.println("Extremadamente lento - evítalo a toda costa\n");
        
        // Ejemplo: Fibonacci recursivo (sin memoización)
        int n = 10;
        long startTime = System.nanoTime();
        int fibResult = fibonacciRecursive(n);
        long endTime = System.nanoTime();
        
        System.out.println("Fibonacci(" + n + ") = " + fibResult);
        System.out.println("Tiempo: " + (endTime - startTime) / 1000000 + " ms");
        
        System.out.println("✅ Ejemplos O(2ⁿ):");
        System.out.println("   - Fibonacci recursivo (sin memoización)");
        System.out.println("   - Problema de la mochila (fuerza bruta)");
        System.out.println("   - Generación de todos los subconjuntos");
        System.out.println("   - Algoritmos de backtracking sin optimización\n");
    }
    
    // ========================================
    // O(n!) - TIEMPO FACTORIAL
    // ========================================
    public static void demonstrateONFactorial() {
        System.out.println("🔴⚫ O(n!) - TIEMPO FACTORIAL");
        System.out.println("El peor caso posible - solo para n muy pequeños\n");
        
        // Ejemplo: Generar todas las permutaciones
        int[] array = {1, 2, 3}; // Solo 3 elementos para evitar explosión
        System.out.println("Permutaciones de " + Arrays.toString(array) + ":");
        generatePermutations(array, 0);
        
        System.out.println("✅ Ejemplos O(n!):");
        System.out.println("   - Problema del viajante (fuerza bruta)");
        System.out.println("   - Generación de todas las permutaciones");
        System.out.println("   - Problemas de asignación");
        System.out.println("   - Algoritmos de fuerza bruta\n");
    }
    
    // ========================================
    // COMPARACIÓN DE RENDIMIENTO
    // ========================================
    public static void comparePerformance() {
        System.out.println("📊 COMPARACIÓN DE RENDIMIENTO");
        System.out.println("Tiempo aproximado para diferentes tamaños de entrada:\n");
        
        System.out.println("n = 10:");
        System.out.println("  O(1):      ~0.001 ms");
        System.out.println("  O(log n):  ~0.001 ms");
        System.out.println("  O(n):      ~0.001 ms");
        System.out.println("  O(n log n): ~0.01 ms");
        System.out.println("  O(n²):     ~0.1 ms");
        System.out.println("  O(n³):     ~1 ms");
        System.out.println("  O(2ⁿ):     ~1 ms");
        System.out.println("  O(n!):     ~3.6 ms\n");
        
        System.out.println("n = 100:");
        System.out.println("  O(1):      ~0.001 ms");
        System.out.println("  O(log n):  ~0.001 ms");
        System.out.println("  O(n):      ~0.01 ms");
        System.out.println("  O(n log n): ~0.1 ms");
        System.out.println("  O(n²):     ~1 ms");
        System.out.println("  O(n³):     ~1000 ms (1 segundo)");
        System.out.println("  O(2ⁿ):     ~4×10²³ años (imposible)");
        System.out.println("  O(n!):     ~9×10¹⁵⁷ años (imposible)\n");
        
        System.out.println("n = 1000:");
        System.out.println("  O(1):      ~0.001 ms");
        System.out.println("  O(log n):  ~0.001 ms");
        System.out.println("  O(n):      ~0.1 ms");
        System.out.println("  O(n log n): ~1 ms");
        System.out.println("  O(n²):     ~100 ms");
        System.out.println("  O(n³):     ~1000000 ms (16.7 minutos)");
        System.out.println("  O(2ⁿ):     Imposible de calcular");
        System.out.println("  O(n!):     Imposible de calcular\n");
    }
    
    // ========================================
    // MÉTODOS AUXILIARES
    // ========================================
    
    // Búsqueda binaria - O(log n)
    public static int binarySearch(int[] array, int target) {
        int left = 0;
        int right = array.length - 1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (array[mid] == target) return mid;
            if (array[mid] < target) left = mid + 1;
            else right = mid - 1;
        }
        return -1;
    }
    
    // Búsqueda lineal - O(n)
    public static int linearSearch(int[] array, int target) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == target) return i;
        }
        return -1;
    }
    
    // Merge Sort - O(n log n)
    public static void mergeSort(int[] array, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            mergeSort(array, left, mid);
            mergeSort(array, mid + 1, right);
            merge(array, left, mid, right);
        }
    }
    
    public static void merge(int[] array, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;
        
        int[] leftArray = new int[n1];
        int[] rightArray = new int[n2];
        
        for (int i = 0; i < n1; i++) leftArray[i] = array[left + i];
        for (int j = 0; j < n2; j++) rightArray[j] = array[mid + 1 + j];
        
        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            if (leftArray[i] <= rightArray[j]) {
                array[k] = leftArray[i];
                i++;
            } else {
                array[k] = rightArray[j];
                j++;
            }
            k++;
        }
        
        while (i < n1) {
            array[k] = leftArray[i];
            i++;
            k++;
        }
        
        while (j < n2) {
            array[k] = rightArray[j];
            j++;
            k++;
        }
    }
    
    // Bubble Sort - O(n²)
    public static void bubbleSort(int[] array) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }
    
    // Multiplicación de matrices - O(n³)
    public static int[][] multiplyMatrices(int[][] a, int[][] b) {
        int rowsA = a.length;
        int colsA = a[0].length;
        int colsB = b[0].length;
        
        int[][] result = new int[rowsA][colsB];
        
        for (int i = 0; i < rowsA; i++) {
            for (int j = 0; j < colsB; j++) {
                for (int k = 0; k < colsA; k++) {
                    result[i][j] += a[i][k] * b[k][j];
                }
            }
        }
        return result;
    }
    
    // Fibonacci recursivo - O(2ⁿ)
    public static int fibonacciRecursive(int n) {
        if (n <= 1) return n;
        return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
    }
    
    // Generar permutaciones - O(n!)
    public static void generatePermutations(int[] array, int index) {
        if (index == array.length - 1) {
            System.out.println("  " + Arrays.toString(array));
            return;
        }
        
        for (int i = index; i < array.length; i++) {
            // Intercambiar elementos
            int temp = array[index];
            array[index] = array[i];
            array[i] = temp;
            
            // Generar permutaciones recursivamente
            generatePermutations(array, index + 1);
            
            // Deshacer el intercambio (backtracking)
            temp = array[index];
            array[index] = array[i];
            array[i] = temp;
        }
    }
    
    // ========================================
    // CONCEPTOS AVANZADOS PARA SENIOR DEVELOPERS
    // ========================================
    public static void advancedConcepts() {
        System.out.println("🚀 CONCEPTOS AVANZADOS DE BIG O");
        System.out.println("Lo que todo programador senior debe saber:\n");
        
        // Reglas de simplificación
        System.out.println("📋 REGLAS DE SIMPLIFICACIÓN:");
        System.out.println("1. Ignorar constantes: O(2n) = O(n)");
        System.out.println("2. Ignorar términos menores: O(n² + n) = O(n²)");
        System.out.println("3. Mantener el peor término: O(n³ + n² + n) = O(n³)");
        System.out.println("4. Producto de complejidades: O(n) × O(m) = O(n×m)\n");
        
        // Complejidades espaciales
        System.out.println("💾 COMPLEJIDADES ESPACIALES:");
        System.out.println("O(1):   Variables simples, sin estructuras de datos");
        System.out.println("O(n):   Arrays, listas, copias de datos");
        System.out.println("O(n²):  Matrices 2D, arrays de arrays");
        System.out.println("O(log n): Stack de recursión (árbol balanceado)\n");
        
        // Casos especiales
        System.out.println("🎯 CASOS ESPECIALES:");
        System.out.println("• Amortizado: O(1) promedio aunque algunos casos sean O(n)");
        System.out.println("• Peor caso vs Caso promedio vs Mejor caso");
        System.out.println("• Complejidad temporal vs espacial (trade-offs)\n");
    }
    
    // ========================================
    // EJEMPLOS PRÁCTICOS DE ANÁLISIS
    // ========================================
    public static void practicalExamples() {
        System.out.println("🔍 EJEMPLOS PRÁCTICOS DE ANÁLISIS");
        
        // Ejemplo 1: Algoritmo con múltiples operaciones
        System.out.println("\n📝 Ejemplo 1: Algoritmo con múltiples operaciones");
        System.out.println("for (int i = 0; i < n; i++) {           // O(n)");
        System.out.println("    for (int j = 0; j < n; j++) {       // O(n)");
        System.out.println("        System.out.println(i + j);      // O(1)");
        System.out.println("    }");
        System.out.println("}");
        System.out.println("Complejidad total: O(n) × O(n) × O(1) = O(n²)\n");
        
        // Ejemplo 2: Algoritmo con operaciones secuenciales
        System.out.println("📝 Ejemplo 2: Operaciones secuenciales");
        System.out.println("for (int i = 0; i < n; i++) {           // O(n)");
        System.out.println("    System.out.println(i);");
        System.out.println("}");
        System.out.println("for (int i = 0; i < n; i++) {           // O(n)");
        System.out.println("    for (int j = 0; j < n; j++) {       // O(n)");
        System.out.println("        System.out.println(i + j);");
        System.out.println("    }");
        System.out.println("}");
        System.out.println("Complejidad total: O(n) + O(n²) = O(n²)\n");
        
        // Ejemplo 3: Algoritmo con condiciones
        System.out.println("📝 Ejemplo 3: Algoritmo con condiciones");
        System.out.println("if (condition) {");
        System.out.println("    for (int i = 0; i < n; i++) {       // O(n)");
        System.out.println("        // operación");
        System.out.println("    }");
        System.out.println("} else {");
        System.out.println("    for (int i = 0; i < n; i++) {       // O(n²)");
        System.out.println("        for (int j = 0; j < n; j++) {");
        System.out.println("            // operación");
        System.out.println("        }");
        System.out.println("    }");
        System.out.println("}");
        System.out.println("Complejidad total: O(n²) (peor caso)\n");
    }
    
    // ========================================
    // OPTIMIZACIONES COMUNES
    // ========================================
    public static void commonOptimizations() {
        System.out.println("⚡ OPTIMIZACIONES COMUNES");
        
        System.out.println("🔄 DE O(n²) A O(n log n):");
        System.out.println("• Bubble Sort → Merge Sort/Quick Sort");
        System.out.println("• Búsqueda lineal → Búsqueda binaria (en datos ordenados)");
        System.out.println("• Comparación de todos los pares → Algoritmos de división y conquista\n");
        
        System.out.println("🔄 DE O(n) A O(log n):");
        System.out.println("• Lista enlazada → Árbol binario de búsqueda");
        System.out.println("• Array no ordenado → Array ordenado + búsqueda binaria");
        System.out.println("• HashMap → TreeMap (cuando necesitas orden)\n");
        
        System.out.println("🔄 DE O(2ⁿ) A O(n):");
        System.out.println("• Fibonacci recursivo → Fibonacci iterativo");
        System.out.println("• Recursión sin memoización → Con memoización");
        System.out.println("• Fuerza bruta → Programación dinámica\n");
        
        System.out.println("🔄 TRADE-OFFS IMPORTANTES:");
        System.out.println("• Tiempo vs Espacio: Más memoria para menos tiempo");
        System.out.println("• Simplicidad vs Eficiencia: Código más complejo para mejor rendimiento");
        System.out.println("• Lectura vs Escritura: Optimizar según el caso de uso\n");
    }
    
    // ========================================
    // PREGUNTAS DE ENTREVISTA COMUNES
    // ========================================
    public static void interviewQuestions() {
        System.out.println("🎯 PREGUNTAS DE ENTREVISTA COMUNES");
        
        System.out.println("❓ '¿Cuál es la complejidad de este código?'");
        System.out.println("✅ Respuesta estructurada:");
        System.out.println("   1. Identificar bucles anidados");
        System.out.println("   2. Contar operaciones por iteración");
        System.out.println("   3. Aplicar reglas de simplificación");
        System.out.println("   4. Considerar casos especiales\n");
        
        System.out.println("❓ '¿Cómo optimizarías este algoritmo?'");
        System.out.println("✅ Respuesta estructurada:");
        System.out.println("   1. Identificar el cuello de botella");
        System.out.println("   2. Proponer estructuras de datos alternativas");
        System.out.println("   3. Considerar algoritmos más eficientes");
        System.out.println("   4. Evaluar trade-offs\n");
        
        System.out.println("❓ '¿Cuándo usarías O(n²) vs O(n log n)?'");
        System.out.println("✅ Respuesta:");
        System.out.println("   • O(n²): Datos pequeños (< 100 elementos), simplicidad");
        System.out.println("   • O(n log n): Datos grandes, rendimiento crítico");
        System.out.println("   • Considerar: Tamaño de datos, frecuencia de uso, mantenimiento\n");
    }
    
    // ========================================
    // HERRAMIENTAS Y TÉCNICAS
    // ========================================
    public static void toolsAndTechniques() {
        System.out.println("🛠️ HERRAMIENTAS Y TÉCNICAS");
        
        System.out.println("📊 MEDICIÓN DE RENDIMIENTO:");
        System.out.println("• System.nanoTime() - Medición precisa");
        System.out.println("• System.currentTimeMillis() - Medición en milisegundos");
        System.out.println("• Profilers (JProfiler, VisualVM) - Análisis detallado");
        System.out.println("• Benchmarking frameworks (JMH) - Pruebas rigurosas\n");
        
        System.out.println("🔍 ANÁLISIS DE CÓDIGO:");
        System.out.println("• Contar bucles anidados");
        System.out.println("• Identificar operaciones dominantes");
        System.out.println("• Considerar casos límite");
        System.out.println("• Analizar complejidad espacial\n");
        
        System.out.println("📈 PATRONES DE OPTIMIZACIÓN:");
        System.out.println("• Memoización (caching de resultados)");
        System.out.println("• Tabulation (programación dinámica)");
        System.out.println("• Sliding Window (ventana deslizante)");
        System.out.println("• Two Pointers (dos punteros)");
        System.out.println("• Binary Search (búsqueda binaria)\n");
    }
    
    // ========================================
    // EJEMPLOS DE BÚSQUEDA POR ÍNDICE EN MAP
    // ========================================
    public static void mapIndexExamples() {
        System.out.println("🗺️ BÚSQUEDA POR ÍNDICE EN MAP");
        System.out.println("Los Map no permiten acceso directo por índice, pero hay alternativas:\n");
        
        // Crear un Map de ejemplo
        Map<String, Integer> map = new HashMap<>();
        map.put("uno", 1);
        map.put("dos", 2);
        map.put("tres", 3);
        map.put("cuatro", 4);
        map.put("cinco", 5);
        
        System.out.println("Map original: " + map);
        
        // MÉTODO 1: Convertir a List de claves
        System.out.println("\n📋 MÉTODO 1: Convertir a List de claves");
        List<String> keys = new ArrayList<>(map.keySet());
        List<Integer> values = new ArrayList<>(map.values());
        
        int index = 2; // Buscar elemento en índice 2
        if (index < keys.size()) {
            String key = keys.get(index);
            Integer value = values.get(index);
            System.out.println("Índice " + index + ": " + key + " = " + value);
        }
        
        // MÉTODO 2: Usar Iterator con contador
        System.out.println("\n📋 MÉTODO 2: Iterator con contador");
        Iterator<Map.Entry<String, Integer>> iterator = map.entrySet().iterator();
        int targetIndex = 3;
        int currentIndex = 0;
        
        while (iterator.hasNext() && currentIndex <= targetIndex) {
            Map.Entry<String, Integer> entry = iterator.next();
            if (currentIndex == targetIndex) {
                System.out.println("Índice " + targetIndex + ": " + entry.getKey() + " = " + entry.getValue());
                break;
            }
            currentIndex++;
        }
        
        // MÉTODO 3: Stream con limit y skip
        System.out.println("\n📋 MÉTODO 3: Stream con limit y skip");
        int streamIndex = 1;
        map.entrySet().stream()
            .skip(streamIndex)
            .limit(1)
            .forEach(entry -> System.out.println("Índice " + streamIndex + ": " + entry.getKey() + " = " + entry.getValue()));
        
        // MÉTODO 4: LinkedHashMap (mantiene orden de inserción)
        System.out.println("\n📋 MÉTODO 4: LinkedHashMap (mantiene orden)");
        Map<String, Integer> linkedMap = new LinkedHashMap<>();
        linkedMap.put("primero", 1);
        linkedMap.put("segundo", 2);
        linkedMap.put("tercero", 3);
        
        List<String> linkedKeys = new ArrayList<>(linkedMap.keySet());
        int linkedIndex = 1;
        if (linkedIndex < linkedKeys.size()) {
            String key = linkedKeys.get(linkedIndex);
            Integer value = linkedMap.get(key);
            System.out.println("Índice " + linkedIndex + ": " + key + " = " + value);
        }
        
        // MÉTODO 5: TreeMap (ordenado por claves)
        System.out.println("\n📋 MÉTODO 5: TreeMap (ordenado alfabéticamente)");
        Map<String, Integer> treeMap = new TreeMap<>();
        treeMap.put("zebra", 26);
        treeMap.put("apple", 1);
        treeMap.put("banana", 2);
        
        List<String> treeKeys = new ArrayList<>(treeMap.keySet());
        int treeIndex = 0;
        if (treeIndex < treeKeys.size()) {
            String key = treeKeys.get(treeIndex);
            Integer value = treeMap.get(key);
            System.out.println("Índice " + treeIndex + ": " + key + " = " + value);
        }
        
        // COMPARACIÓN DE COMPLEJIDADES
        System.out.println("\n📊 COMPLEJIDADES DE ACCESO:");
        System.out.println("HashMap: O(1) para get(key), NO permite acceso por índice");
        System.out.println("LinkedHashMap: O(1) para get(key), O(n) para acceso por índice");
        System.out.println("TreeMap: O(log n) para get(key), O(n) para acceso por índice");
        System.out.println("Convertir a List: O(n) para conversión, O(1) para acceso por índice\n");
    }
    
    // ========================================
    // CLASE UTILITARIA PARA MAP CON ÍNDICES
    // ========================================
    public static class IndexedMap<K, V> {
        private final Map<K, V> map;
        private final List<K> keys;
        private final List<V> values;
        
        public IndexedMap(Map<K, V> originalMap) {
            this.map = new LinkedHashMap<>(originalMap); // Mantiene orden
            this.keys = new ArrayList<>(this.map.keySet());
            this.values = new ArrayList<>(this.map.values());
        }
        
        public V getByIndex(int index) {
            if (index < 0 || index >= keys.size()) {
                throw new IndexOutOfBoundsException("Índice: " + index + ", Tamaño: " + keys.size());
            }
            return values.get(index);
        }
        
        public K getKeyByIndex(int index) {
            if (index < 0 || index >= keys.size()) {
                throw new IndexOutOfBoundsException("Índice: " + index + ", Tamaño: " + keys.size());
            }
            return keys.get(index);
        }
        
        public Map.Entry<K, V> getEntryByIndex(int index) {
            if (index < 0 || index >= keys.size()) {
                throw new IndexOutOfBoundsException("Índice: " + index + ", Tamaño: " + keys.size());
            }
            return new AbstractMap.SimpleEntry<>(keys.get(index), values.get(index));
        }
        
        public int size() {
            return keys.size();
        }
        
        public void put(K key, V value) {
            map.put(key, value);
            if (!keys.contains(key)) {
                keys.add(key);
                values.add(value);
            } else {
                int index = keys.indexOf(key);
                values.set(index, value);
            }
        }
        
        public V removeByIndex(int index) {
            if (index < 0 || index >= keys.size()) {
                throw new IndexOutOfBoundsException("Índice: " + index + ", Tamaño: " + keys.size());
            }
            K key = keys.remove(index);
            V value = values.remove(index);
            map.remove(key);
            return value;
        }
        
        @Override
        public String toString() {
            return map.toString();
        }
    }
    
    // ========================================
    // EJEMPLO DE USO DE IndexedMap
    // ========================================
    public static void demonstrateIndexedMap() {
        System.out.println("🔧 EJEMPLO DE USO DE IndexedMap");
        
        // Crear un Map normal
        Map<String, Integer> originalMap = new HashMap<>();
        originalMap.put("a", 1);
        originalMap.put("b", 2);
        originalMap.put("c", 3);
        originalMap.put("d", 4);
        
        // Convertir a IndexedMap
        IndexedMap<String, Integer> indexedMap = new IndexedMap<>(originalMap);
        
        System.out.println("Map original: " + originalMap);
        System.out.println("IndexedMap: " + indexedMap);
        
        // Acceso por índice
        System.out.println("\nAcceso por índice:");
        for (int i = 0; i < indexedMap.size(); i++) {
            String key = indexedMap.getKeyByIndex(i);
            Integer value = indexedMap.getByIndex(i);
            System.out.println("Índice " + i + ": " + key + " = " + value);
        }
        
        // Obtener entrada completa por índice
        Map.Entry<String, Integer> entry = indexedMap.getEntryByIndex(2);
        System.out.println("\nEntrada en índice 2: " + entry.getKey() + " = " + entry.getValue());
        
        // Agregar nuevo elemento
        indexedMap.put("e", 5);
        System.out.println("\nDespués de agregar 'e': " + indexedMap);
        
        // Remover por índice
        Integer removed = indexedMap.removeByIndex(1);
        System.out.println("Elemento removido en índice 1: " + removed);
        System.out.println("Después de remover: " + indexedMap);
    }
}
