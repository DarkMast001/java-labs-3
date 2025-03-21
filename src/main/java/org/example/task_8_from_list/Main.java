package org.example.task_8_from_list;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {

        // Класс::СтатическийМетод
        Function<String, Integer> methodRef1 = Integer::parseInt;
        System.out.println(methodRef1.apply("13"));

        // Объект::МетодЭкземпляра
        StringBuilder sb1 = new StringBuilder();
        Consumer<String> methodRef2 = sb1::append;
        methodRef2.accept("qwerty");
        System.out.println(sb1);

        // Класс::МетодЭкземпляра
        Function<String, Integer> methodRef3 = String::length;
        System.out.println(methodRef3.apply("qwerty"));

        // Класс::new
        Supplier<StringBuilder> methodRef4 = StringBuilder::new;
        StringBuilder sb2 = methodRef4.get();
        sb2.append("qwerty");
        System.out.println(sb2);
    }
}
