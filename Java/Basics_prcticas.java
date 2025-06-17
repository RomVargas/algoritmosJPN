import java.util.*;
import java.util.LinkedList;

public class Basics_prcticas {
    
    public static void main(String[] args) {
        System.out.println("🎯 PRÁCTICA DE ESTRUCTURAS DE DATOS EN JAVA");
        System.out.println("═══════════════════════════════════════════════\n");
        
        // ✅ DESCOMENTA UNA SECCIÓN A LA VEZ PARA PRACTICAR
        practicarArrayList();
        practicarLinkedList();
        practicarHashMap();
        practicarHashSet();
        practicarQueue();
        practicarStack();
        compararEstructuras();
        ejerciciosPracticos();
        pracicarDeque();
        practicarTreeMap();
        practicarTreeSet();
    }

    public static void practicarTreeSet() {
        System.out.println("📋 PRACTICANDO TREESET");
        System.out.println("──────────────────────");
        
        TreeSet<Integer> myTreeSet = new TreeSet<>();
        myTreeSet.add(1);
        myTreeSet.add(2);
        myTreeSet.add(3);
        System.out.println("TreeSet add: " + myTreeSet);
        myTreeSet.remove(2);
        System.out.println("TreeSet remove: " + myTreeSet);
        myTreeSet.contains(3);
        System.out.println("TreeSet contains: " + myTreeSet);
        myTreeSet.size();
        System.out.println("TreeSet size: " + myTreeSet.size());
        myTreeSet.clear();
        System.out.println("TreeSet clear: " + myTreeSet);
    }

    public static void pracicarDeque() {
        System.out.println("📋 PRACTICANDO DEQUE");
        System.out.println("──────────────────────");
        
        Deque<Integer> myDeque = new LinkedList<>();
        myDeque.add(1);
        System.out.println("Deque add: " + myDeque);
        myDeque.addFirst(0);
        System.out.println("Deque addFirst: " + myDeque);
        myDeque.addLast(2);
        System.out.println("Deque addLast: " + myDeque);
        myDeque.removeFirst();
        System.out.println("Deque removeFirst: " + myDeque);
        myDeque.removeLast();
        System.out.println("Deque removeLast: " + myDeque);
        myDeque.size();
        System.out.println("Deque size: " + myDeque.size());
        myDeque.clear();
        System.out.println("Deque clear: " + myDeque);
        System.out.println("Deque: " + myDeque);
    }


    public static void practicarTreeMap() {
        System.out.println("📋 PRACTICANDO TREEMAP");
        System.out.println("──────────────────────");
        
        TreeMap<String, Integer> myTreeMap = new TreeMap<>();
        myTreeMap.put("apple", 1);
        System.out.println("TreeMap put: " + myTreeMap);
        myTreeMap.put("banana", 2);
        System.out.println("TreeMap put: " + myTreeMap);
        myTreeMap.put("cherry", 3);
        System.out.println("TreeMap put: " + myTreeMap);
        myTreeMap.remove("banana");
        System.out.println("TreeMap remove: " + myTreeMap);
        myTreeMap.containsKey("cherry");
        System.out.println("TreeMap containsKey: " + myTreeMap);
        myTreeMap.size();
        System.out.println("TreeMap size: " + myTreeMap.size());
        myTreeMap.clear();
    }

    public static void compararEstructuras() {
        System.out.println("📋 COMPARANDO ESTRUCTURAS");
        System.out.println("─────────────────────────");
        
        LinkedList<Integer> lista = new LinkedList<>();
        Queue<Integer> cola = new LinkedList<>();
        Deque<Integer> pila = new LinkedList<>();
        
        lista.add(1);
        cola.offer(1);
        pila.push(1);
        
        System.out.println("Lista: " + lista);
        System.out.println("Cola: " + cola);
        System.out.println("Pila: " + pila);
    }

    public static void practicarStack() {
        System.out.println("📋 PRACTICANDO STACK");
        System.out.println("──────────────────────");
        
        Stack<Integer> myStack = new Stack<>();
        myStack.push(1);
        myStack.push(2);
        System.out.println("Stack push: " + myStack);
        myStack.pop();
        System.out.println("Stack pop: " + myStack);
        myStack.peek();
        System.out.println("Stack peek: " + myStack);
        myStack.size();
        System.out.println("Stack size: " + myStack.size());
        myStack.clear();
        System.out.println("Stack clear: " + myStack);
    }

    public static void practicarLinkedList() {
        System.out.println("📋 PRACTICANDO LINKEDLIST");
        System.out.println("─────────────────────────");
        
        LinkedList<Integer> myLinkedList = new LinkedList<>();
        myLinkedList.add(1);
        myLinkedList.add(2);
        myLinkedList.add(3);
        System.out.println("LinkedList add: " + myLinkedList);
        myLinkedList.remove(1);
        System.out.println("LinkedList remove: " + myLinkedList);
        myLinkedList.addFirst(0);
        System.out.println("LinkedList addFirst: " + myLinkedList);
        myLinkedList.addLast(4);
        System.out.println("LinkedList addLast: " + myLinkedList);
        myLinkedList.removeFirst();
        System.out.println("LinkedList removeFirst: " + myLinkedList);
        myLinkedList.removeLast();
        System.out.println("LinkedList removeLast: " + myLinkedList);
        myLinkedList.set(1, 2);
        System.out.println("LinkedList set: " + myLinkedList);
        myLinkedList.get(1);
        System.out.println("LinkedList get: " + myLinkedList);
        myLinkedList.size();
        System.out.println("LinkedList size: " + myLinkedList.size());
    }

    public static void practicarHashSet() {
        System.out.println("📋 PRACTICANDO HASHSET");
        System.out.println("──────────────────────");
        
        HashSet<String> myHashSet = new HashSet<>();
        myHashSet.add("apple");
        myHashSet.add("banana");
        myHashSet.add("cherry");
        System.out.println("HashSet add: " + myHashSet);
        myHashSet.remove("banana");
        System.out.println("HashSet remove: " + myHashSet);
        myHashSet.contains("cherry");
        System.out.println("HashSet contains: " + myHashSet);
        myHashSet.size();
        System.out.println("HashSet size: " + myHashSet.size());
        myHashSet.clear();
        System.out.println("HashSet clear: " + myHashSet);
    }

    public static void practicarQueue() {
        System.out.println("📋 PRACTICANDO QUEUE");
        System.out.println("──────────────────────");
        
        Queue<String> myQueue = new LinkedList<>();
        myQueue.add("apple");
        myQueue.add("banana");
        myQueue.add("cherry");
        System.out.println("Queue add: " + myQueue);
        myQueue.remove();
        System.out.println("Queue remove: " + myQueue);
        myQueue.size();
        System.out.println("Queue size: " + myQueue.size());
        myQueue.clear();
        System.out.println("Queue clear: " + myQueue);
    }
    
    // ═══════════════════════════════════════════════════════════════════════════════
    // 📋 SECCIÓN 1: ARRAYLIST - OPERACIONES BÁSICAS
    // ═══════════════════════════════════════════════════════════════════════════════
    public static void practicarArrayList() {
        System.out.println("📋 PRACTICANDO ARRAYLIST");
        System.out.println("─────────────────────────");
        
        // TODO: Declara un ArrayList de enteros llamado 'numeros'
        List<Integer> numeros = new ArrayList<>();
        
        // TODO: Agrega los números 1, 2, 3, 4, 5 usando add()
        numeros.add(1);
        numeros.add(2);
        numeros.add(3);
        numeros.add(4);
        numeros.add(5);
        
        System.out.println("Lista inicial: " + numeros);
        
        // TODO: Agrega el número 10 en la posición 2 usando add(index, element)
        numeros.add(2, 10);
        System.out.println("Después de insertar 10 en posición 2: " + numeros);
        
        // TODO: Obtén el elemento en la posición 3 usando get(index)
        int elemento = numeros.get(3);
        System.out.println("Elemento en posición 3: " + elemento);
        
        // TODO: Cambia el elemento en posición 1 a 99 usando set(index, element)
        numeros.set(1, 99);
        System.out.println("Después de cambiar posición 1 a 99: " + numeros);
        
        // TODO: Elimina el elemento en posición 0 usando remove(index)
        numeros.remove(0);
        System.out.println("Después de eliminar posición 0: " + numeros);
        
        // TODO: Verifica si contiene el número 10 usando contains()
        boolean contiene10 = numeros.contains(10);
        System.out.println("¿Contiene 10? " + contiene10);
        
        // TODO: Obtén el tamaño usando size()
        int tamaño = numeros.size();
        System.out.println("Tamaño actual: " + tamaño);
        
        System.out.println("\n" + "=".repeat(50) + "\n");
    }
    
    // ═══════════════════════════════════════════════════════════════════════════════
    // 📋 SECCIÓN 2: HASHMAP - CLAVE-VALOR
    // ═══════════════════════════════════════════════════════════════════════════════
    public static void practicarHashMap() {
        System.out.println("📋 PRACTICANDO HASHMAP");
        System.out.println("──────────────────────");
        
        // TODO: Declara un HashMap<String, Integer> llamado 'edades'
        Map<String, Integer> edades = new HashMap<>();
        
        // TODO: Agrega pares clave-valor usando put()
        edades.put("Ana", 25);
        edades.put("Bob", 30);
        edades.put("Carlos", 35);
        
        System.out.println("Edades: " + edades);
        
        // TODO: Obtén un valor por clave usando get()
        Integer edadAna = edades.get("Ana");
        System.out.println("Edad de Ana: " + edadAna);
        
        // TODO: Verifica si existe una clave usando containsKey()
        boolean tieneCarlos = edades.containsKey("Carlos");
        System.out.println("¿Tiene Carlos? " + tieneCarlos);
        
        // TODO: Actualiza un valor existente
        edades.put("Ana", 26);
        System.out.println("Después de actualizar Ana: " + edades);
        
        // TODO: Elimina por clave usando remove()
        Integer edadEliminada = edades.remove("Bob");
        System.out.println("Edad eliminada de Bob: " + edadEliminada);
        
        System.out.println("\n" + "=".repeat(50) + "\n");
    }
    
    // ═══════════════════════════════════════════════════════════════════════════════
    // 📊 EJERCICIOS PRÁCTICOS
    // ═══════════════════════════════════════════════════════════════════════════════
    public static void ejerciciosPracticos() {
        System.out.println("🎯 EJERCICIOS PRÁCTICOS");
        System.out.println("═══════════════════════");
        
        // EJERCICIO 1: Contador de palabras
        System.out.println("📝 Ejercicio 1: Contador de palabras");
        String texto = "java python java javascript python java";
        Map<String, Integer> contador = contarPalabras(texto);
        System.out.println("Resultado: " + contador);
        
        System.out.println("\n" + "=".repeat(50) + "\n");
    }
    
    // TODO: Implementa este método
    public static Map<String, Integer> contarPalabras(String texto) {
        Map<String, Integer> contador = new HashMap<>();
        String[] palabras = texto.split(" ");
        
        for (String palabra : palabras) {
            contador.put(palabra, contador.getOrDefault(palabra, 0) + 1);
        }
        
        return contador;
    }
}

/*
🎯 PLAN DE PRÁCTICA EFICAZ:
═══════════════════════════════════════════════════════════════════════════════

📅 METODOLOGÍA RECOMENDADA:

1️⃣ EJECUTA UNA SECCIÓN A LA VEZ
   - Descomenta solo practicarArrayList() primero
   - Ejecuta y observa los resultados
   - Modifica valores para experimentar

2️⃣ PRÁCTICA ACTIVA
   - Antes de ver la implementación, trata de predecir el resultado
   - Modifica los valores intencionalmente
   - Trata de "romper" el código para entender los límites

3️⃣ EXPLICA EN VOZ ALTA
   - Lee cada línea y explica qué hace
   - Esto simula una entrevista técnica real
   - Ayuda a identificar gaps en tu conocimiento

4️⃣ CRONOGRAMA SUGERIDO:
   📅 Día 1: ArrayList (30 min)
   📅 Día 2: HashMap (30 min)  
   📅 Día 3: Resto de estructuras (45 min)
   📅 Día 4: Ejercicios prácticos (45 min)
   📅 Día 5: Repaso y comparaciones (30 min)

💡 TIPS PARA MAXIMIZAR APRENDIZAJE:
- Cambia los tipos de datos (String, Integer, Double)
- Agrega más elementos para ver comportamiento
- Usa debugger para ver paso a paso
- Crea tus propios ejercicios similares
- Implementa los métodos TODO desde cero
*/
