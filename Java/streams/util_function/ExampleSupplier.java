package com.debuggeando_ideas.util_function;

import lombok.ToString;

import java.util.Random;
import java.util.function.Supplier;

public class ExampleSupplier {
    static Supplier<Integer> randomInt = () -> new Random().nextInt(100);
    static  Supplier<Producto> productoSupplier = () -> new Producto(100, "smartphopne");
    public static void main(String[] args) {
        System.out.println(randomInt.get());
        System.out.println(randomInt.get());
        System.out.println(productoSupplier.get());

    }
}

@ToString
class Producto {
    Integer precio;
    String nombre;

    public Producto(Integer precio, String nombre) {
        this.precio = precio;
        this.nombre = nombre;
    }
}