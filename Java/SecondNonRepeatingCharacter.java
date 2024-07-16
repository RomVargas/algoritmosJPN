import java.util.HashMap;
import java.util.Map;

public class SecondNonRepeatingCharacter {

    public static void main(String[] args) {
        String str = "success";
        System.out.println(findSecondNonrRepeatingChareacter(str));
    }
    
     public static char findSecondNonrRepeatingChareacter(String str) {

        Map<Character, Integer> charCount = new HashMap<>();
        Character[] char_array = new Character[str.length()];
        for (int i = 0; i <= str.length() -1; i ++){
            char_array[i] = str.charAt(i);
            charCount.put(char_array[i], charCount.getOrDefault(char_array[i], 0) + 1);
        }

        /*for (char c : str.toCharArray()) {
            charCount.put(c, charCount.getOrDefault(c, 0) + 1);
        }*/

        System.out.println(charCount);
        char output = 'a';
        int nonRepeatingCount = 0;
        for (Map.Entry<Character, Integer> entry : charCount.entrySet()) {
            if (entry.getValue() == 1) {
                nonRepeatingCount++;
                if (nonRepeatingCount == 2) {
                    output = entry.getKey();
                }
            }
        }
        return output;
     }
     
}
