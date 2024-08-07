package com.debuggeando_ideas.streams;

import com.debuggeando_ideas.util.Database;
import com.debuggeando_ideas.util.Videogame;

import java.util.Arrays;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ConstructorsStreams {
    public static void main(String[] args) {
        Stream<Videogame> myStream = Database.videogames.stream();
        myStream.forEach(System.out::println);

        System.out.println("------");

        Integer[] myArray = {1,2,3,4,5,6,7,8,9};

        Stream<Integer> intStream = Arrays.stream(myArray);
        intStream.forEach(System.out::println);

        Stream.of("Hola", "Mundo").forEach(System.out::println);

        DoubleStream myDouble = DoubleStream.of(20.3,15.4,12.4);
    }
}
