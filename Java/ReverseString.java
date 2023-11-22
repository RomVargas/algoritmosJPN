import java.util.*;
import java.util.stream.Collectors;

public class ReverseString {
    public static void main(String[] args) {
        System.out.println("Hola Mundo");
        ReverseString test1 = new ReverseString();
        System.out.println(test1.test());
    }

    public int test(){
        try{
            int c = 2/0;
        }catch(Exception e){
            return 0;
        }finally{
            return 5;
        }
    }

    //Utilizando una iteración y concatenación:
    public static String reverseString1(String s) {
    String reversed = "";
    for (int i = s.length() - 1; i >= 0; i--) {
        reversed += s.charAt(i);
    }
    return reversed;
}

// Utilizando el método reverse de la clase StringBuilder
public static String reverseString2(String s) {
    return new StringBuilder(s).reverse().toString();
}

// Utilizando recursión
public static String reverseString3(String s) {
    if (s.length() == 0) {
        return s;
    }
    return reverseString3(s.substring(1)) + s.charAt(0);
}

// Utilizando el método chars de la clase IntStream
public static String reverseString4(String s) {
    return s.chars()
            .mapToObj(c -> Character.toString((char) c))
            .collect(Collectors.joining(""))
            .chars()
            .mapToObj(c -> Character.toString((char) c))
            .collect(Collectors.collectingAndThen(Collectors.toList(), l -> {
                Collections.reverse(l);
                return l.stream();
            }))
            .collect(Collectors.joining());
}

}