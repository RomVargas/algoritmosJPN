package com.debuggeando_ideas.collectors;

import com.debuggeando_ideas.util.Database;
import com.debuggeando_ideas.util.Videogame;

import java.util.IntSummaryStatistics;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectorReduceFunctions {
    public static void main(String[] args) {
        Stream<Videogame> games = Database.videogames.stream();
        //averageFunction(games);
        //sum(games);
        joinFunction(games);
    }

    static void averageFunction(Stream<Videogame> stream) {
        Double avg = stream.collect(Collectors.averagingDouble(Videogame::getPrice));
        System.out.println(avg);
    }

    static void sum(Stream<Videogame> stream) {
        IntSummaryStatistics sum = stream.collect(Collectors.summarizingInt(
                v -> v.getReviews().size()
        ));
        System.out.println(sum.getSum());
        System.out.println(sum.getMax());
        System.out.println(sum.getMin());
        System.out.println(sum.getAverage());
        System.out.println(sum.getCount());
    }

    static void joinFunction(Stream<Videogame> stream) {
        String r = stream.map(
                Videogame::toString
        ).collect(Collectors.joining("\n"));
        System.out.println(r);
    }
}
