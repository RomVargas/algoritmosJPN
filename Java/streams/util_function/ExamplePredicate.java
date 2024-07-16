package com.debuggeando_ideas.util_function;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class ExamplePredicate {

    static Predicate<Integer> isGraterThan100 = n -> n > 100;
    static Predicate<Integer> isLessThan10 = n -> n < 10;
    static Predicate<Integer> isBetween10and100 = isGraterThan100.or(isLessThan10);

    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>(Arrays.asList(1,2,3,5,9,10,345,500));

        numbers.removeIf(isBetween10and100);
        // List<Integer> filtrados = (List<Integer>) numbers.stream().filter(n -> n > 10);
        System.out.println(numbers);
    }



}
