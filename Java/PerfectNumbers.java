public class PerfectNumbers {

    // Método para verificar si un número es perfecto
    public static boolean isPerfect(int number) {
        int sum = 0;
        
        // Calcular la suma de los divisores propios del número
        for (int i = 1; i <= number / 2; i++) {
            if (number % i == 0) {
                sum += i;
            }
        }
        
        // Comparar la suma con el número
        return sum == number;
    }

    public static void main(String[] args) {
        System.out.println("Perfect numbers between 1 and 100 are:");
        
        // Iterar sobre el rango de 1 a 100
        for (int i = 1; i <= 100; i++) {
            // Verificar si el número es perfecto y si lo es, imprimirlo
            if (isPerfect(i)) {
                System.out.println(i);
            }
        }
    }
}
