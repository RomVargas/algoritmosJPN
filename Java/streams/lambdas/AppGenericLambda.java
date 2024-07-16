package com.debuggeando_ideas.lambdas;

import com.debuggeando_ideas.fundamentals.Product;

public class AppGenericLambda {

    public static void main(String[] args) {
        Printer<String> printString = string -> System.out.println(string);
        Printer<Product> printProduct = product -> System.out.println(product);

        Product product = new Product();
        product.setId(21321L);
        product.setName("smartPhone");
        product.setPrice(500.40);

        printString.print("Hola Mundo desde lamnda");
        printProduct.print(product);
    }
}
