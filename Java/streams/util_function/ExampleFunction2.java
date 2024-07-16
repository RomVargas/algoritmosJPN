package com.debuggeando_ideas.util_function;

import lombok.ToString;

import java.io.*;
import java.util.Arrays;
import java.util.function.Function;

public class ExampleFunction2 {
    static Function<Person, ByteArrayOutputStream> serializer = person -> {
        ByteArrayOutputStream inMemoryBites = new ByteArrayOutputStream();
        try (ObjectOutputStream outputStream = new ObjectOutputStream(inMemoryBites)) {
            outputStream.writeObject(person);
            outputStream.flush();
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        }
        return inMemoryBites;
    };

    static Function<ByteArrayInputStream, Person> deserializer = byteArrayOutputStream -> {
        Person person = new Person("roman", 41);
        try (ObjectInputStream inputStream = new ObjectInputStream(byteArrayOutputStream)) {
            return (Person) inputStream.readObject();
        } catch (IOException | ClassNotFoundException ex) {
            System.err.println(ex.getMessage());
        }
        return person;
    };

    public static void main(String[] args) {
        ByteArrayOutputStream objectSerialized = serializer.apply((new Person("Roman", 41)));
        System.out.println(Arrays.toString(objectSerialized.toByteArray()));
        Person objectDeserialized = deserializer.apply(new ByteArrayInputStream(objectSerialized.toByteArray()));
        System.out.println(objectDeserialized);
    }
}