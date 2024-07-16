package com.debuggeando_ideas.real_appplications;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class ComparatorLambdas {

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(4,3,2,5,6,8,7,1,9);
        numbers.sort((a,b) -> a - b);
        System.out.println(numbers);

        List<String> names = Arrays.asList("Max", "Alex", "Roman");
        names.sort(String::compareTo);
        System.out.println(names);
        names.sort(Comparator.reverseOrder());
        System.out.println(names);

        List<Person> persons = Arrays.asList(
                new Person("Robaert",31),
                new Person("Andy", 32),
                new Person("Mandy", 32),
                new Person("Peter", 27)
        );
         persons.sort(Comparator.comparingInt(Person::getAge).thenComparing(Person::getName));

         System.out.println(persons);
    }
}

@Data
@AllArgsConstructor
@ToString
class Person {
    private String name;
    private Integer age;
}
