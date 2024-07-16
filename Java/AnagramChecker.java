import java.util.Arrays;

public class AnagramChecker {
   public static boolean areAnagrams(String str1, String str2) {
        // Eliminar espacios en blanco y convertir a minúsculas
        str1 = str1.replaceAll("\\s", "").toLowerCase();
        str2 = str2.replaceAll("\\s", "").toLowerCase();

        // Si las longitudes son diferentes, no pueden ser anagramas
        if (str1.length() != str2.length()) {
            return false;
        }

        // Convertir las cadenas a arreglos de caracteres
        char[] charArray1 = str1.toCharArray();
        char[] charArray2 = str2.toCharArray();

        // Ordenar los arreglos de caracteres
        Arrays.sort(charArray1);
        Arrays.sort(charArray2);

        // Comparar los arreglos de caracteres
        return Arrays.equals(charArray1, charArray2);
    }

    public static void main(String[] args) {
        String str1 = "Listen";
        String str2 = "Silent";

        if (areAnagrams(str1, str2)) {
            System.out.println(str1 + " y " + str2 + " son anagramas.");
        } else {
            System.out.println(str1 + " y " + str2 + " no son anagramas.");
        }
    } 
}
