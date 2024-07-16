import java.util.ArrayList;
import java.util.List;

public class MagicalStairs {
    public static void findPaths(int n, int currentStep, List<Integer> path) {
        if (currentStep == n) {
            // Ha alcanzado el n-ésimo paso exactamente, imprimir el camino
            System.out.println(path);
            return;
        }
        
        if (currentStep > n) {
            // Si se pasa del n-ésimo paso, no es un camino válido
            return;
        }
        
        // Determinar el último salto
        int lastJump = path.isEmpty() ? 0 : path.get(path.size() - 1);
        
        // Probar todos los posibles próximos saltos (lastJump + 1, lastJump + 2, ...)
        for (int i = lastJump + 1; i <= n - currentStep; i++) {
            path.add(i);
            findPaths(n, currentStep + i, path);
            path.remove(path.size() - 1);  // Backtrack
        }
    }
    
    public static void main(String[] args) {
        int n = 5; // Ejemplo: piso al que queremos llegar
        List<Integer> path = new ArrayList<>();
        
        System.out.println("Posibles caminos para llegar al piso " + n + ":");
        findPaths(n, 0, path);
    }
}
