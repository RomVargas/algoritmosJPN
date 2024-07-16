package com.debuggeando_ideas.lambdas;

public class LambdaApp {
    public static void main(String[] args) {
        Math substract = new Math() {
            @Override
            public Double excecute(Double a, Double b) {
                return a - b;
            }
        };

        Math multiply = (a,b) -> a * b;

        System.out.println(substract.excecute(3.0,1.7));
        System.out.println(multiply.excecute(10.0,10.4));
    }
}
