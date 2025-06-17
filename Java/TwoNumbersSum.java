import java.io.*; 
import java.util.*;

public class TwoNumbersSum{

    public static void main(String[] args){
        int[] array = {1,2,3,5,6,8,9,-1,-4};
        int[] res = twoNumbersSum2(array, 17);
        System.out.print(Integer.toString(res[0]) + " + ");
        System.out.print(Integer.toString(res[1]));
        System.out.println("");
        int[] res2 = twoNumbersSum2(array, 13);
        System.out.print(Integer.toString(res2[0]) + " + ");
        System.out.print(Integer.toString(res2[1]));
        int[] res3 = twoNumbersSum2(array, 17);
        System.out.println("");
        System.out.print(Integer.toString(res3[0]) + " + ");
        System.out.print(Integer.toString(res3[1]));
        System.out.println("");
    }

    // 🔄 MÉTODO 1: FUERZA BRUTA - O(n²) - Compara cada par de números
    public static int[] twoNumbersSum(int[] array, int targetSum){
        for (int i=0; i < array.length - 1; i++){           // Itera por cada elemento del array (primer número)
            int firstNum = array[i];                         // Guarda el primer número de la pareja
            for (int j = i + 1; j < array.length; j++){      // Itera por los elementos restantes (segundo número)
                int secondNum = array[j];                    // Guarda el segundo número de la pareja
                if(firstNum + secondNum == targetSum){       // Verifica si la suma es igual al objetivo
                    int[] res = {firstNum, secondNum};       // Crea un array con los dos números encontrados
                    return res;                              // Retorna el array con la pareja que suma el objetivo
                }
            }
        }
        return new int[0];                                   // Si no encuentra ninguna pareja, retorna array vacío
    }

// 🗂️ MÉTODO 2: HASH SET - O(n) - Una sola pasada usando tabla hash
public static int[] twoNumbersSum2(int[] array, int targetSum) {
    Set<Integer> nums = new HashSet<>();                     // Crea un HashSet para almacenar números ya visitados
		for (int num : array) {                              // Itera una sola vez por cada número del array
			int potentialMatch = targetSum - num;            // Calcula qué número necesitamos para completar la suma
			if(nums.contains(potentialMatch)) {              // Verifica si ya hemos visto el número complementario
				return new int[] {potentialMatch, num};      // Si lo encontramos, retorna la pareja de números
			} else {
				nums.add(num);                               // Si no lo encontramos, agrega el número actual al set
			}
		}
    return new int[0];                                       // Si no encuentra ninguna pareja, retorna array vacío
  }

 // ↔️ MÉTODO 3: DOS PUNTEROS - O(n log n) - Ordena el array y usa dos punteros
 public static int[] twoNumbersSum3(int[] array, int targetSum) {
    Arrays.sort(array);                                      // Ordena el array de menor a mayor - O(n log n)
		int left = 0;                                        // Puntero izquierdo (inicio del array)
		int right = array.length - 1;                       // Puntero derecho (final del array)
		while (left < right) {                               // Mientras los punteros no se crucen
			int currentSum = array[left] + array[right];     // Suma los valores de ambos punteros
			if (currentSum == targetSum) {                   // Si la suma es igual al objetivo
				return new int[] {array[left], array[right]};// Retorna la pareja de números encontrada
			} else if (currentSum < targetSum) {             // Si la suma es menor que el objetivo
				left++;                                      // Mueve el puntero izquierdo hacia la derecha (aumenta suma)
			} else if(currentSum > targetSum) {              // Si la suma es mayor que el objetivo
				right--;                                     // Mueve el puntero derecho hacia la izquierda (disminuye suma)
			}
		}
    return new int[0];                                       // Si no encuentra ninguna pareja, retorna array vacío
  }
}


