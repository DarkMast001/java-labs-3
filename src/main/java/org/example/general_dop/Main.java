package org.example.general_dop;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Person> people = Arrays.asList(
                new Person("Dima", 30),
                new Person("Ivan", 25),
                new Person("Nikita", 30),
                new Person("Egor", 25)
        );

        Person p1 = new Person("Dima", 30);
        Person p2 = new Person("Ivan", 25);
        Person p3 = new Person("Nikita", 30);
        Person p4 = new Person("Egor", 25);

        MyComparator<Person> comparator = new PersonComparator();
        System.out.println(comparator.compare(p1, p2));

        comparator = comparator.reversed();
        System.out.println(comparator.compare(p1, p2));
    }
}
