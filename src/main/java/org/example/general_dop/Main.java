package org.example.general_dop;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Person> peopleWithNulls = Arrays.asList(
                new Person("Alice", 30),
                new Person("Bob", 25),
                new Person("Charlie", 35),
                new Person("Alice", 20),
                null,
                new Person("David", null)
        );

        List<Person> peopleWithoutNulls = Arrays.asList(
                new Person("Alice", 30),
                new Person("Bob", 25),
                new Person("Charlie", 35),
                new Person("Alice", 20)
        );

        // Тестируем все методы MyComparator

        System.out.println("=== 1. Сортировка по возрасту ===");
        testSort(peopleWithoutNulls, MyComparator.comparing(Person::getAge, MyComparator.naturalOrder()));

        System.out.println("\n=== 2. Сортировка по имени ===");
        testSort(peopleWithoutNulls, MyComparator.comparing(Person::getName));

        System.out.println("\n=== 3. Обратный порядок (по возрасту) ===");
        testSort(peopleWithoutNulls, MyComparator.comparing(Person::getAge).reversed());

        System.out.println("\n=== 4. Сортировка по возрасту, затем по имени ===");
        testSort(peopleWithoutNulls, MyComparator.comparing(Person::getAge).thenComparing(MyComparator.comparing(Person::getName)));

        System.out.println("\n=== 5. Сортировка примитивных типов (int) ===");
        testSort(peopleWithoutNulls, MyComparator.comparingInt(p -> p != null ? p.getAge() : 0));

        System.out.println("\n=== 6. Обработка null-значений (nullsFirst) ===");
        testSort(peopleWithNulls, MyComparator.nullsFirst(MyComparator.comparing(Person::getName)));

        System.out.println("\n=== 7. Обработка null-значений (nullsLast) ===");
        testSort(peopleWithNulls, MyComparator.nullsLast(MyComparator.comparing(Person::getName)));

    }

    private static void testSort(List<Person> people, MyComparator<Person> comparator) {
        people.stream()
                .sorted(comparator.toComparator())
                .forEach(System.out::println);
    }
}
