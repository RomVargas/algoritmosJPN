package com.debuggeando_ideas.streams;

import com.debuggeando_ideas.util.Database;
import com.debuggeando_ideas.util.Videogame;

import java.util.*;
import java.util.stream.Stream;

public class StreamFinalOperators {

    public static void main(String[] args) {
        Stream<Videogame> videogames = Database.videogames.stream();
        Stream<String> nombres = Arrays.asList("roman","alex").stream();
        List<String> names = Arrays.asList("Petter", "David");
        //countOperator(videogames);
        ////forEchaOperator(videogames);
        //anyMatchOperator(videogames);
        //allMatachOperator(videogames);
        //noneMatchOperator(videogames);
        //findFirstOperator(videogames);
        //reduceOperator(videogames);
        maxOperator(videogames);
     }

    static void countOperator(Stream<Videogame> stream){
        System.out.println(stream.count());
    }

    static void forEchaOperator(Stream<Videogame> stream) {
        stream.forEach(System.out::println);
    }

    static void anyMatchOperator(Stream<Videogame> stream){
        boolean result = stream.anyMatch(v -> v.getTotalSold() > 1000000);
        System.out.println(result);
    }

    static void allMatachOperator(Stream<Videogame> stream) {
        boolean result = stream.allMatch(v -> v.getIsDiscount());
    }

    static void noneMatchOperator(Stream<Videogame> stream) {
        boolean result = stream.noneMatch(v -> v.getReviews().isEmpty());
    }

    static  void findFirstOperator(Stream<Videogame> stream) {
        Optional<Videogame> result = stream.findFirst();
        System.out.println(stream.findFirst());
    }

    static void findAnyOperator(Stream<Videogame> stream) {
        Optional<Videogame> result = stream.findAny();
        System.out.println(stream.findAny());
    }

    static void maxOperator(Stream<Videogame> stream) {
        Optional<Videogame> result = stream.max(Comparator.comparing(Videogame::getName));
        System.out.println(result.get().getName());
    }

    static void minOperator(Stream<Videogame> stream) {
        Optional<Videogame> result = stream.min(Comparator.comparing(Videogame::getName));
        System.out.println(result.get().getName());
    }

    static void reduceOperator(Stream<Videogame> stream) {
        /*Optional<Integer> result = stream
                .filter(Videogame::getIsDiscount)
                .map(Videogame::getTotalSold)
                .reduce(Integer::sum);*/
        Optional<Integer> sindescuento = stream
                .filter(v -> !v.getIsDiscount())
                .map(Videogame::getTotalSold)
                .reduce(Integer::sum);
        //System.out.println("Videojuegos con descuento" + result);
        System.out.println("Videojuegos sin descuento" + sindescuento);
    }
}
