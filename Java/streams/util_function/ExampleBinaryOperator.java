package com.debuggeando_ideas.util_function;

import java.util.function.BiFunction;
import java.util.function.BinaryOperator;

public class ExampleBinaryOperator {

    public static void main(String[] args) {
        BiFunction<String,String,String> normalize = (a,b) -> a.toUpperCase() + " - " + b.toLowerCase();
        System.out.println(normalize.apply("hola", "mundo"));

        BinaryOperator<String> normalizer = (a, b) -> a.toUpperCase() + " - " + b.toLowerCase();
        System.out.println(normalizer.apply("hola", "mundo"));
    }
}
