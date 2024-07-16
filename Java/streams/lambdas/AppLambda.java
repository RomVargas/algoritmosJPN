package com.debuggeando_ideas.lambdas;

import java.util.List;
import java.util.Locale;

public class AppLambda {
    public static void main(String[] args) {
        List<String> countries = List.of("Mexico","Colombia","Argentina","Chile","Uruguay");
        for (String country : countries){
            System.out.println(country);
        }

        countries.forEach(country -> System.out.println(country.toUpperCase(Locale.ROOT)));
    }
}
