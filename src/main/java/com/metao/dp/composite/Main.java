package com.metao.dp.composite;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        String[] array = {"name1","name2","name3","name4", "name5", "name2"};
        Map<String, Long> collect = Arrays.stream(array)
                .collect(Collectors.groupingBy(s -> s, Collectors.counting()));
        collect.forEach((k, v) -> {
            System.out.println(v);
        });

    }
}
