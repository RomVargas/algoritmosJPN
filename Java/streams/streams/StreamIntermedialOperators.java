package com.debuggeando_ideas.streams;

import com.debuggeando_ideas.util.BasicVideogame;
import com.debuggeando_ideas.util.Database;
import com.debuggeando_ideas.util.Videogame;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamIntermedialOperators {

    public static void main(String[] args) {
        Stream<Videogame> videogame = Database.videogames.stream();
        //distincOperator(videogame);
        //limitOperators(videogame);
        //skipOperators(videogame);
        sortedOperator(videogame);
    }

    static void distincOperator(Stream<Videogame> stream) {
        System.out.println(stream.distinct().count());
    }

    static void limitOperators(Stream<Videogame> stream) {
        List<Videogame> result = stream.limit(5).collect(Collectors.toList());
        result.forEach(System.out::println);
    }

    static void skipOperators(Stream<Videogame> stream) {
        List<Videogame> result = stream.skip(15).collect(Collectors.toList());
        result.forEach(System.out::println);
    }

    static void filterOperator(Stream<Videogame> stream) {
        List<Videogame> result = stream
                .filter(v -> v.getPrice() > 5)
                .filter(v -> !v.getIsDiscount())
                .filter(v -> v.getOfficialWebsite().contains("forza"))
                .collect(Collectors.toList());

        result.forEach(System.out::println);
    }

    static void mapOperator(Stream<Videogame> stream) {
        List<BasicVideogame> result = stream
                .map(videogame -> {
                    return BasicVideogame.builder()
                            .name(videogame.getName())
                            .price(videogame.getPrice())
                            .console(videogame.getConsole())
                            .build();
                }).collect(Collectors.toList());
        result.forEach(System.out::println);
    }

    static void flatMapOperator(Stream<Videogame> stream) {
        var r = stream.flatMap(v -> v.getReviews().stream()).collect(Collectors.toList());
        System.out.println(r);
    }

    static void mapVSFlatMapOperator(Stream<Videogame> stream) {
        Long totalReviews = stream.flatMap(v -> v.getReviews().stream()).count();
        System.out.println(totalReviews);
    }

    static void peekOpertaor(Stream<Videogame> stream) {
        stream.peek(System.out::println).collect(Collectors.toList());
    }

    static void sortedOperator(Stream<Videogame> stream) {
        List<Videogame> lista = stream
                .sorted(Comparator.comparing(v -> v.getReviews().size()))
                .collect(Collectors.toList());
        lista.forEach(System.out::println);
    }

    static void takeWhileOperator(Stream<Videogame> stream) {
        List<Videogame> r = stream
                .sorted(Comparator.comparing(Videogame::getName))
                .takeWhile(v -> !v.getName().startsWith("M"))
                .collect(Collectors.toList());
        r.forEach(System.out::println);
    }

    static void dropWhileOperator(Stream<Videogame> stream) {
        List<Videogame> r = stream
                .sorted(Comparator.comparing(Videogame::getName))
                .dropWhile(v -> !v.getName().startsWith("M"))
                .collect(Collectors.toList());
        r.forEach(System.out::println);
    }
}
