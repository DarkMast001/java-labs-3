package org.example.task_10_from_list;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3);
        Iterator<Integer> iterator = numbers.iterator();

        MappingIterator<Integer> mappingIterator = MappingIterator.fromIterator(iterator);

//        while (mappingIterator.hasNext()) {
//            System.out.println(mappingIterator.next() instanceof Integer);
//        }

        MappingIterator<String> stringIterator = mappingIterator.map(Object::toString);

        while (stringIterator.hasNext()) {
            String str = stringIterator.next();
            System.out.println(str);
        }
    }
}
