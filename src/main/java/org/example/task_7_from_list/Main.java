package org.example.task_7_from_list;

import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

public class Main {
    public static <T> void processElements(Iterator<T> iterator, Consumer<T> action) {
        while (iterator.hasNext()) {
            T element = iterator.next();
            action.accept(element);
        }
    }

    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5);

        Iterator<Integer> iterator = numbers.iterator();

        processElements(iterator, value -> System.out.println("Элемент: " + value));

        processElements(numbers.iterator(), value -> System.out.println("Удвоенное значение: " + (value * 2)));
    }
}
