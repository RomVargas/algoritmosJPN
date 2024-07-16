package com.debuggeando_ideas.util_function;

import java.util.function.BiPredicate;

public class ExampleBiPredicate {

    static BiPredicate<String, String> myEqual = (s1,s2) -> s1.concat(s2).equals("Hola Mundo");

    public static void main(String[] args) {
        String s1 = "Hola ";
        String s2 = "Mundo";
        // se valida que la concatenecion sea "Hola Mundo"
        System.out.println(myEqual.test(s1,s2));
    }
}
