package main;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {

        List<Integer> numbers =  IntStream.rangeClosed(1, 10).boxed().collect(Collectors.toList());

        //System.out.println(numbers);

        Stream.iterate(1, i -> i <= 20, i -> i + 1).forEach(System.out::println);

        String rows = "- - -";

        System.out.println(rows.replaceAll("\\s", ""));
    }
}