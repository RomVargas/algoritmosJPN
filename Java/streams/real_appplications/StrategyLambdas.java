package com.debuggeando_ideas.real_appplications;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.util.List;

public class StrategyLambdas {

    public static void main(String[] args) {
        var product1 = Product.builder().id(1L).price(18.50).userType("BASIC").build();
        var product2 = Product.builder().id(1L).price(18.50).userType("PLUS").build();
        var product3 = Product.builder().id(1L).price(18.50).userType("PRIME").build();


        var products = List.of(product1,product2,product3);

        products.forEach( product -> {
            switch (product.getUserType()) {
                case "BASIC":
                    product.setDiscountStrategy(Strategies.basicDiscount);
                    break;
                case  "PLUS":
                    product.setDiscountStrategy(Strategies.plusDiscount);
                    break;
                case "PRIME":
                    product.setDiscountStrategy(Strategies.primeDiscount);
                    break;
            }
        }

        );
        products.forEach(product -> {
            System.out.println("Price: " + product.getPrice() + " User Type: " + product.getUserType() + " Discount: " + product.getDiscountStrategy().get(product.getPrice()));
        });
    }
}

@FunctionalInterface
interface ApplyDescount {
    Double get(Double price);
}

class Strategies {
    static ApplyDescount basicDiscount = p -> p*0.02;
    static ApplyDescount plusDiscount = p -> p*0.05;
    static ApplyDescount primeDiscount = p -> p*0.1;
}

@Data
@ToString
@Builder
class Product {
    private Long id;
    private String userType;
    private String name;
    private Double price;
    private Double discount;
    private ApplyDescount  discountStrategy;
}
