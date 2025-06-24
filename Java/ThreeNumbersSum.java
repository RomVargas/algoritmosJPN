// O(n^2) time | O(n) space - Complejidad temporal cuadrática, espacial lineal
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class ThreeNumbersSum {
  
  /** 
   * Encuentra todas las combinaciones de tres números que sumen el valor objetivo
   * @param array - Array de números enteros
   * @param targetSum - Suma objetivo que deben alcanzar los tres números
   * @return List<Integer[]> - Lista de arrays con las combinaciones encontradas
   */
  public static List<Integer[]> threeNumberSum(int[] array, int targetSum) {
 		// Ordenamos el array para poder usar la técnica de dos punteros
 		Arrays.sort(array);
		
		// Lista que almacenará todas las combinaciones encontradas
		List<Integer[]> triplets = new ArrayList<Integer[]>();
		
		// Iteramos hasta length-2 porque necesitamos al menos 3 elementos
		for (int i = 0; i < array.length -2; i++){
			// Puntero izquierdo que empieza después del elemento actual
			int left = i + 1;
			// Puntero derecho que empieza desde el final del array
			int right = array.length - 1;
			
			// Mientras los punteros no se crucen
			while (left < right) {
				// Calculamos la suma de los tres elementos actuales
				int currentSum = array[i] + array[left] + array[right];
				
				// Si encontramos una combinación que suma el objetivo
				if (currentSum == targetSum ) {
					// Creamos un nuevo array con la combinación encontrada
					Integer[] newTriplet = {array[i], array[left], array[right]};
					// Agregamos la combinación a la lista de resultados
					triplets.add(newTriplet);
					// Movemos ambos punteros para buscar más combinaciones
					left++;
					right--;
				} 
				// Si la suma es menor que el objetivo, necesitamos un número mayor
				else if (currentSum < targetSum){
					left++; // Movemos el puntero izquierdo hacia la derecha
				} 
				// Si la suma es mayor que el objetivo, necesitamos un número menor
				else if (currentSum > targetSum) {
					right--; // Movemos el puntero derecho hacia la izquierda
				}
			}
		}
     // Retornamos todas las combinaciones encontradas
     return triplets;
  }
  
  // Método main para probar el algoritmo
  public static void main(String[] args) {
    // Ejemplo de uso para threeNumberSum
    int[] array = {12, 3, 1, 2, -6, 5, -8, 6};
    int targetSum = 0;
    
    List<Integer[]> result = threeNumberSum(array, targetSum);
    
    System.out.println("Combinaciones que suman " + targetSum + ":");
    for (Integer[] triplet : result) {
      System.out.println(Arrays.toString(triplet));
    }
    
    // Ejemplo de uso para fourNumberSum con Streams
    System.out.println("\n=== Probando fourNumberSum con Streams ===");
    int[] array4 = {7, 6, 4, -1, 1, 2};
    int targetSum4 = 16;
    
    List<List<Integer>> result4 = fourNumberSum(array4, targetSum4);
    System.out.println("Combinaciones de 4 números que suman " + targetSum4 + " (Streams):");
    result4.forEach(System.out::println);
    
    // Probando la versión alternativa con Streams
    System.out.println("\n=== Probando versión alternativa con Streams ===");
    List<List<Integer>> result4Alt = fourNumberSumAlternative(array4, targetSum4);
    System.out.println("Combinaciones de 4 números (versión alternativa Streams):");
    result4Alt.forEach(System.out::println);
    
    // Probando la versión tradicional sin Streams
    System.out.println("\n=== Probando versión tradicional sin Streams ===");
    List<List<Integer>> result4Trad = fourNumberSumTraditional(array4, targetSum4);
    System.out.println("Combinaciones de 4 números (tradicional):");
    result4Trad.forEach(System.out::println);
    
    // Probando la versión optimizada sin Streams
    System.out.println("\n=== Probando versión optimizada sin Streams ===");
    List<List<Integer>> result4Opt = fourNumberSumOptimized(array4, targetSum4);
    System.out.println("Combinaciones de 4 números (optimizada):");
    result4Opt.forEach(System.out::println);
  }

  public static List<List<Integer>> fourNumberSum(int[] array, int targetSum) {
    // Convertimos el array primitivo a List<Integer> para poder usar Streams
    List<Integer> numbers = Arrays.stream(array).boxed().collect(Collectors.toList());
    
    // Generamos todas las combinaciones posibles de 4 números usando índices
    return IntStream.range(0, numbers.size())                    // Genera índices del 0 al size-1
            .boxed()                                             // Convierte IntStream a Stream<Integer>
            .flatMap(i -> IntStream.range(i + 1, numbers.size()) // Para cada i, genera índices j > i
                    .boxed()                                     // Convierte a Stream<Integer>
                    .flatMap(j -> IntStream.range(j + 1, numbers.size()) // Para cada j, genera índices k > j
                            .boxed()                             // Convierte a Stream<Integer>
                            .flatMap(k -> IntStream.range(k + 1, numbers.size()) // Para cada k, genera índices l > k
                                    .boxed()                     // Convierte a Stream<Integer>
                                    .map(l -> Arrays.asList(     // Crea una lista con los 4 números
                                            numbers.get(i),      // Primer número (índice i)
                                            numbers.get(j),      // Segundo número (índice j)
                                            numbers.get(k),      // Tercer número (índice k)
                                            numbers.get(l)       // Cuarto número (índice l)
                                    ))
                            )
                    )
            )
            // Filtramos solo las combinaciones que suman exactamente el targetSum
            .filter(combination -> combination.stream()          // Convertimos la combinación a stream
                    .mapToInt(Integer::intValue)                // Convertimos a IntStream para poder sumar
                    .sum() == targetSum)                        // Verificamos si la suma es igual al target
            // Ordenamos cada combinación de menor a mayor
            .map(combination -> combination.stream()             // Convertimos cada combinación a stream
                    .sorted()                                   // Ordenamos los números
                    .collect(Collectors.toList()))              // Recolectamos en una nueva lista
            // Eliminamos combinaciones duplicadas (mismos números en diferente orden)
            .distinct()                                         // Elimina duplicados basándose en equals()
            // Recolectamos todas las combinaciones en una lista final
            .collect(Collectors.toList());                      // Convierte el stream a List<List<Integer>>
  }
  
  // Versión alternativa más legible usando valores directamente en lugar de índices
  public static List<List<Integer>> fourNumberSumAlternative(int[] array, int targetSum) {
    // Convertimos el array a List para poder usar Streams
    List<Integer> numbers = Arrays.stream(array).boxed().collect(Collectors.toList());
    
    return numbers.stream()                                     // Stream de todos los números
            .flatMap(a -> numbers.stream()                      // Para cada número 'a', tomamos todos los demás
                    .filter(b -> numbers.indexOf(b) > numbers.indexOf(a)) // Solo números que vienen después de 'a'
                    .flatMap(b -> numbers.stream()              // Para cada 'b', tomamos todos los demás
                            .filter(c -> numbers.indexOf(c) > numbers.indexOf(b)) // Solo números que vienen después de 'b'
                            .flatMap(c -> numbers.stream()      // Para cada 'c', tomamos todos los demás
                                    .filter(d -> numbers.indexOf(d) > numbers.indexOf(c)) // Solo números que vienen después de 'c'
                                    .map(d -> Arrays.asList(a, b, c, d)) // Creamos la combinación de 4 números
                            )
                    )
            )
            // Filtramos solo las combinaciones que suman el targetSum
            .filter(combination -> combination.stream()          // Convertimos a stream para operaciones
                    .mapToInt(Integer::intValue)                // Convertimos a IntStream
                    .sum() == targetSum)                        // Verificamos la suma
            // Ordenamos cada combinación
            .map(combination -> combination.stream()             // Stream de cada combinación
                    .sorted()                                   // Ordenamos los números
                    .collect(Collectors.toList()))              // Recolectamos en lista ordenada
            // Eliminamos duplicados
            .distinct()                                         // Elimina combinaciones repetidas
            // Recolectamos el resultado final
            .collect(Collectors.toList());                      // Lista final de combinaciones
  }

  // Solución tradicional sin Streams - O(n^4) time | O(n) space
  public static List<List<Integer>> fourNumberSumTraditional(int[] array, int targetSum) {
    // Ordenamos el array para poder usar técnicas de optimización
    Arrays.sort(array);
    
    // Lista para almacenar todas las combinaciones encontradas
    List<List<Integer>> quadruplets = new ArrayList<>();
    
    // Primer bucle: seleccionamos el primer número
    for (int i = 0; i < array.length - 3; i++) {
      // Evitamos duplicados saltando elementos iguales
      if (i > 0 && array[i] == array[i - 1]) continue;
      
      // Segundo bucle: seleccionamos el segundo número
      for (int j = i + 1; j < array.length - 2; j++) {
        // Evitamos duplicados saltando elementos iguales
        if (j > i + 1 && array[j] == array[j - 1]) continue;
        
        // Tercer bucle: seleccionamos el tercer número
        for (int k = j + 1; k < array.length - 1; k++) {
          // Evitamos duplicados saltando elementos iguales
          if (k > j + 1 && array[k] == array[k - 1]) continue;
          
          // Cuarto bucle: seleccionamos el cuarto número
          for (int l = k + 1; l < array.length; l++) {
            // Evitamos duplicados saltando elementos iguales
            if (l > k + 1 && array[l] == array[l - 1]) continue;
            
            // Calculamos la suma de los cuatro números
            int currentSum = array[i] + array[j] + array[k] + array[l];
            
            // Si encontramos una combinación que suma el objetivo
            if (currentSum == targetSum) {
              // Creamos una nueva lista con la combinación encontrada
              List<Integer> quadruplet = Arrays.asList(array[i], array[j], array[k], array[l]);
              // Agregamos la combinación a la lista de resultados
              quadruplets.add(quadruplet);
            }
          }
        }
      }
    }
    
    // Retornamos todas las combinaciones encontradas
    return quadruplets;
  }
  
  // Solución optimizada usando técnica de dos punteros - O(n^3) time | O(n) space
  public static List<List<Integer>> fourNumberSumOptimized(int[] array, int targetSum) {
    // Ordenamos el array para poder usar la técnica de dos punteros
    Arrays.sort(array);
    
    // Lista para almacenar todas las combinaciones encontradas
    List<List<Integer>> quadruplets = new ArrayList<>();
    
    // Primer bucle: seleccionamos el primer número
    for (int i = 0; i < array.length - 3; i++) {
      // Evitamos duplicados saltando elementos iguales
      if (i > 0 && array[i] == array[i - 1]) continue;
      
      // Segundo bucle: seleccionamos el segundo número
      for (int j = i + 1; j < array.length - 2; j++) {
        // Evitamos duplicados saltando elementos iguales
        if (j > i + 1 && array[j] == array[j - 1]) continue;
        
        // Calculamos la suma objetivo para los dos números restantes
        int targetForTwo = targetSum - array[i] - array[j];
        
        // Usamos dos punteros para encontrar los dos números restantes
        int left = j + 1;  // Puntero izquierdo
        int right = array.length - 1;  // Puntero derecho
        
        // Mientras los punteros no se crucen
        while (left < right) {
          // Calculamos la suma de los dos números actuales
          int currentSum = array[left] + array[right];
          
          // Si encontramos una combinación que suma el objetivo
          if (currentSum == targetForTwo) {
            // Creamos una nueva lista con la combinación encontrada
            List<Integer> quadruplet = Arrays.asList(array[i], array[j], array[left], array[right]);
            // Agregamos la combinación a la lista de resultados
            quadruplets.add(quadruplet);
            
            // Movemos ambos punteros para buscar más combinaciones
            left++;
            right--;
            
            // Evitamos duplicados saltando elementos iguales
            while (left < right && array[left] == array[left - 1]) left++;
            while (left < right && array[right] == array[right + 1]) right--;
          } 
          // Si la suma es menor que el objetivo, necesitamos un número mayor
          else if (currentSum < targetForTwo) {
            left++; // Movemos el puntero izquierdo hacia la derecha
          } 
          // Si la suma es mayor que el objetivo, necesitamos un número menor
          else {
            right--; // Movemos el puntero derecho hacia la izquierda
          }
        }
      }
    }
    
    // Retornamos todas las combinaciones encontradas
    return quadruplets;
  }
}

/*
EJERCICIO PARA PRACTICAR:

Implementa una función llamada `fourNumberSum` que encuentre todas las combinaciones 
de CUATRO números que sumen un valor objetivo.

Requisitos:
- La función debe recibir un array de enteros y un targetSum
- Debe retornar una List<List<Integer>> con todas las combinaciones
- Cada combinación debe contener exactamente 4 números
- Los números en cada combinación deben estar en orden ascendente
- No debe haber combinaciones duplicadas

Ejemplo:
Input: array = [7, 6, 4, -1, 1, 2], targetSum = 16
Output: [[-1, 1, 6, 10], [-1, 2, 4, 11], [1, 2, 4, 9]]

Pista: Puedes usar una técnica similar pero con dos bucles anidados y dos punteros,
o usar un HashMap para optimizar la búsqueda.

¿Puedes implementar esta función?
*/