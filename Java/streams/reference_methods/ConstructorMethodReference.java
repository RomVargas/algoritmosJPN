package com.debuggeando_ideas.reference_methods;

import java.util.function.Supplier;

public class ConstructorMethodReference {
    public static void main(String[] args) {
        Supplier<MyObject> newObject = () -> new MyObject();
        Supplier<MyObject> newObjectRef = MyObject::new;
        System.out.println(newObject.get());
        System.out.println(newObjectRef.get());
    }
}

