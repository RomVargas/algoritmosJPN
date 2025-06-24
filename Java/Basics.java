import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;
import java.util.Hashtable;
import java.util.ArrayDeque;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Basics {
    public static void main(String[] args) {
        // crea una variable primitiva de cada tipo en java
        byte myByte = 127;
        short myShort = 32767;
        int myInt = 2147483647;
        long myLong = 9223372036854775807L;
        float myFloat = 3.14f;
        double myDouble = 3.141592653589793;
        String myString = "Hello, World!";
        char myChar = 'A';
        boolean myBoolean = true;

        /*
         * ═══════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════
         * 📋 TABLA COMPARATIVA: ESTRUCTURAS DE DATOS EN JAVA
         * ═══════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════
         * 
         * ┌─────────────────────┬─────────────────┬─────────────────┬─────────────────┬─────────────────┬─────────────────┬─────────────────┬─────────────────┬─────────────────┬─────────────────┬─────────────────┬─────────────────┬─────────────────┬─────────────────┐
         * │    CARACTERÍSTICA   │      LIST       │   ARRAYLIST     │      MAP        │    HASHMAP      │    TREEMAP      │      SET        │    HASHSET      │    TREESET      │     QUEUE       │   LINKEDLIST    │     STACK       │      DEQUE      │   ARRAYDEQUE    │
         * ├─────────────────────┼─────────────────┼─────────────────┼─────────────────┼─────────────────┼─────────────────┼─────────────────┼─────────────────┼─────────────────┼─────────────────┼─────────────────┼─────────────────┼─────────────────┼─────────────────┤
         * │ Tipo                │ Interfaz        │ Clase           │ Interfaz        │ Clase           │ Clase           │ Interfaz        │ Clase           │ Clase           │ Interfaz        │ Clase           │ Clase           │ Interfaz        │ Clase           │
         * ├─────────────────────┼─────────────────┼─────────────────┼─────────────────┼─────────────────┼─────────────────┼─────────────────┼─────────────────┼─────────────────┼─────────────────┼─────────────────┼─────────────────┼─────────────────┼─────────────────┤
         * │ Thread-Safe         │ Depende         │ ❌ NO           │ Depende         │ ❌ NO           │ ❌ NO           │ Depende         │ ❌ NO           │ ❌ NO           │ Depende         │ ❌ NO           │ ✅ SÍ           │ Depende         │ ❌ NO           │
         * ├─────────────────────┼─────────────────┼─────────────────┼─────────────────┼─────────────────┼─────────────────┼─────────────────┼─────────────────┼─────────────────┼─────────────────┼─────────────────┼─────────────────┼─────────────────┼─────────────────┤
         * │ Orden               │ Sí (inserción)  │ Sí (índices)    │ No garantizado  │ No garantizado  │ ✅ Ordenado     │ No              │ No garantizado  │ ✅ Ordenado     │ FIFO            │ FIFO/LIFO       │ LIFO            │ FIFO/LIFO       │ FIFO/LIFO       │
         * ├─────────────────────┼─────────────────┼─────────────────┼─────────────────┼─────────────────┼─────────────────┼─────────────────┼─────────────────┼─────────────────┼─────────────────┼─────────────────┼─────────────────┼─────────────────┼─────────────────┤
         * │ Duplicados          │ Permitidos      │ Permitidos      │ No (claves)     │ No (claves)     │ No (claves)     │ No              │ No              │ No              │ Permitidos      │ Permitidos      │ Permitidos      │ Permitidos      │ Permitidos      │
         * ├─────────────────────┼─────────────────┼─────────────────┼─────────────────┼─────────────────┼─────────────────┼─────────────────┼─────────────────┼─────────────────┼─────────────────┼─────────────────┼─────────────────┼─────────────────┼─────────────────┤
         * │ Acceso por índice   │ Sí              │ Sí              │ No              │ No              │ No              │ No              │ No              │ No              │ No              │ Sí (como List)  │ Sí (herencia)   │ No              │ No              │
         * ├─────────────────────┼─────────────────┼─────────────────┼─────────────────┼─────────────────┼─────────────────┼─────────────────┼─────────────────┼─────────────────┼─────────────────┼─────────────────┼─────────────────┼─────────────────┼─────────────────┤
         * │ Implementación      │ Depende         │ Array dinámico  │ Depende         │ Tabla hash      │ Red-Black Tree  │ Depende         │ Tabla hash      │ Red-Black Tree  │ Depende         │ Lista enlazada  │ Array (Vector)  │ Depende         │ Array circular  │
         * ├─────────────────────┼─────────────────┼─────────────────┼─────────────────┼─────────────────┼─────────────────┼─────────────────┼─────────────────┼─────────────────┼─────────────────┼─────────────────┼─────────────────┼─────────────────┼─────────────────┤
         * │ Complejidad get()   │ O(1)            │ O(1)            │ O(1) promedio   │ O(1) promedio   │ O(log n)        │ —               │ —               │ —               │ O(1) / O(n)     │ O(n)            │ O(1)            │ O(1)            │ O(1)            │
         * ├─────────────────────┼─────────────────┼─────────────────┼─────────────────┼─────────────────┼─────────────────┼─────────────────┼─────────────────┼─────────────────┼─────────────────┼─────────────────┼─────────────────┼─────────────────┼─────────────────┤
         * │ Complejidad add()   │ O(1) / O(n)     │ O(1) amortizado │ O(1) promedio   │ O(1) promedio   │ O(log n)        │ O(1)            │ O(1) promedio   │ O(log n)        │ O(1) / O(n)     │ O(1) extremos   │ O(1)            │ O(1) extremos   │ O(1) amortizado │
         * ├─────────────────────┼─────────────────┼─────────────────┼─────────────────┼─────────────────┼─────────────────┼─────────────────┼─────────────────┼─────────────────┼─────────────────┼─────────────────┼─────────────────┼─────────────────┼─────────────────┤
         * │ Permite null?       │ Sí              │ Sí              │ Sí              │ Sí              │ ❌ NO           │ Sí              │ Sí              │ ❌ NO           │ Sí              │ Sí              │ Sí              │ Sí              │ ❌ NO           │
         * └─────────────────────┴─────────────────┴─────────────────┴─────────────────┴─────────────────┴─────────────────┴─────────────────┴─────────────────┴─────────────────┴─────────────────┴─────────────────┴─────────────────┴─────────────────┴─────────────────┘
         * 
         * ═══════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════
         * 🛠️ RECOMENDACIONES PRÁCTICAS
         * ═══════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════
         * 
         * ✅ Usa List como tipo de referencia para ArrayList o LinkedList si solo necesitas una lista.
         * ✅ Prefiere HashMap cuando necesites acceso rápido por clave sin importar el orden.
         * ✅ Utiliza HashSet cuando quieras eliminar duplicados y no te importe el orden.
         * 🌳 Usa TreeMap cuando necesites un mapa ordenado por claves (ideal para rangos y ordenamiento).
         * 🌳 Usa TreeSet cuando necesites un conjunto ordenado sin duplicados.
         * ⚠️  Evita Stack para nuevas implementaciones. Usa Deque (LinkedList o ArrayDeque) para comportamiento LIFO más eficiente.
         * ⚠️  TreeMap y TreeSet NO permiten elementos null y son más lentos que sus equivalentes Hash.
         * 🔄 Usa ArrayDeque como implementación de Deque cuando necesites operaciones eficientes en ambos extremos.
         * 🔄 Prefiere ArrayDeque sobre LinkedList para implementar colas y pilas (más eficiente en memoria y CPU).
         * ⚠️  ArrayDeque NO permite elementos null y tiene un tamaño fijo que se redimensiona automáticamente.
         * 
         * 🔒 ALTERNATIVAS THREAD-SAFE:
         * ✅ Vector (en lugar de ArrayList) - Sincronizado pero más lento
         * ✅ ConcurrentHashMap (en lugar de HashMap) - Optimizado para concurrencia
         * ✅ Collections.synchronizedList(new ArrayList<>()) - Wrapper sincronizado
         * ✅ Collections.synchronizedMap(new HashMap<>()) - Wrapper sincronizado
         * ✅ Collections.synchronizedSet(new HashSet<>()) - Wrapper sincronizado
         * ✅ CopyOnWriteArrayList - Para casos con muchas lecturas y pocas escrituras
         * 
         */

        // crea una estructura de datos de cada tipo en java 
        List<Integer> myList = new ArrayList<>();
        Map<String, Integer> myMap = new HashMap<>();
        Set<Integer> mySet = new HashSet<>();
        Queue<Integer> myQueue = new LinkedList<>();
        Stack<Integer> myStack = new Stack<>();
        TreeMap<String, Integer> myTreeMap = new TreeMap<>();
        TreeSet<Integer> myTreeSet = new TreeSet<>();
        LinkedList<Integer> myLinkedList = new LinkedList<>();

        // Es como si tuvieras UNA caja, pero la puedes usar para:

        LinkedList<String> caja = new LinkedList<>();

        // 📝 Como LISTA (leer documentos en orden)
        List<String> documentos = caja;
        documentos.add("Doc1");
        documentos.get(0);

        // 🎫 Como COLA (fila del banco - FIFO)
        Queue<String> filaDelBanco = caja;
        filaDelBanco.offer("Cliente1");
        filaDelBanco.poll(); // Atiende al primero

        // 📚 Como PILA (libros apilados - LIFO)
        Deque<String> pilaLibros = caja;
        pilaLibros.push("Libro1");
        pilaLibros.pop(); // Toma el de arriba

        // Queue es INTERFAZ, tiene MÚLTIPLES implementaciones:

        Queue<String> cola1 = new LinkedList<>();    // ✅ Más común
        Queue<String> cola2 = new ArrayDeque<>();    // ✅ Más eficiente
        Queue<String> cola3 = new PriorityQueue<>(); // ✅ Con prioridades

        // agrega 5 elementos a cada estructura de datos
        myList.add(1);
        myList.add(2);
        myList.add(3);
        myList.add(4);
        myList.add(5);
        
        myMap.put("one", 1);
        myMap.put("two", 2);
        myMap.put("three", 3);
        myMap.put("four", 4);
        myMap.put("five", 5);
        myMap.get("one");
        // obtener por indice de myMap

        System.out.println("valor" + myMap.get("one"));
        
        mySet.add(1);
        mySet.add(2);
        mySet.add(3);
        mySet.add(4);
        mySet.add(5);
        mySet.add(5);

        myQueue.add(1);
        myQueue.add(2);
        myQueue.add(3);
        myQueue.add(4);
        myQueue.add(5);
        myQueue.stream().forEach(System.out::println);
        myQueue.stream().count();

        myStack.push(1);
        myStack.push(2);
        myStack.push(3);
        myStack.push(4);
        myStack.push(5);

        myTreeMap.put("one", 1);
        myTreeMap.put("two", 2);
        myTreeMap.put("three", 3);
        myTreeMap.put("four", 4);
        myTreeMap.put("five", 5);
        
        myLinkedList.add(1);
        myLinkedList.add(2);
        myLinkedList.add(3);
        myLinkedList.add(4);
        myLinkedList.add(5);

        myTreeSet.add(1);
        myTreeSet.add(2);
        myTreeSet.add(3);
        myTreeSet.add(4);
        myTreeSet.add(5);

        // ✅ SEGURO: Usando Collections sincronizadas
        List<Integer> safeList = Collections.synchronizedList(new ArrayList<>());

        List<String> lista1 = new ArrayList<>();     // ❌ NO thread-safe
        List<String> lista2 = new Vector<>();        // ✅ SÍ thread-safe  
        List<String> lista3 = new LinkedList<>();    // ❌ NO thread-safe
        List<String> lista4 = Collections.synchronizedList(new ArrayList<>()); // ✅ SÍ thread-safe

        Map<String, Integer> mapa1 = new HashMap<>();           // ❌ NO thread-safe
        Map<String, Integer> mapa2 = new ConcurrentHashMap<>(); // ✅ SÍ thread-safe
        Map<String, Integer> mapa3 = new Hashtable<>();         // ✅ SÍ thread-safe (obsoleto)
        Map<String, Integer> mapa4 = new TreeMap<>();           // ❌ NO thread-safe

        Set<Integer> set1 = new HashSet<>();                    // ❌ NO thread-safe
        Set<Integer> set2 = new TreeSet<>();                    // ❌ NO thread-safe
        Set<Integer> set3 = Collections.synchronizedSet(new HashSet<>()); // ✅ SÍ thread-safe
        Set<Integer> set4 = ConcurrentHashMap.newKeySet();      // ✅ SÍ thread-safe

        Queue<String> queue1 = new LinkedList<>();           // ❌ NO thread-safe
        Queue<String> queue2 = new ArrayDeque<>();           // ❌ NO thread-safe
        Queue<String> queue3 = new ConcurrentLinkedQueue<>(); // ✅ SÍ thread-safe
        Queue<String> queue4 = new LinkedBlockingQueue<>();   // ✅ SÍ thread-safe
    }
}
