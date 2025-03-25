package org.example.general_dop;

import java.util.Comparator;
import java.util.function.Function;
import java.util.function.ToDoubleFunction;
import java.util.function.ToIntFunction;
import java.util.function.ToLongFunction;

public interface MyComparator<T> {

    int compare(T o1, T o2);

    default Comparator<T> toComparator() {
        return this::compare;
    }

    default MyComparator<T> reversed() {
        return (o1, o2) -> this.compare(o2, o1);
    }

    static <T extends Comparable<T>> MyComparator<T> naturalOrder() {
        return Comparable::compareTo;
    }

    static <T extends Comparable<T>> MyComparator<T> reverseOrder() {
        return (o1, o2) -> o2.compareTo(o1);
    }

    default MyComparator<T> thenComparing(MyComparator<T> other) {
        return (o1, o2) -> {
            int result = this.compare(o1, o2);
            return (result != 0) ? result : other.compare(o1, o2);
        };
    }

    // Статический метод для создания компаратора на основе ключа
    static <T, U extends Comparable<? super U>> MyComparator<T> comparing(Function<? super T, ? extends U> keyExtractor) {
        return (o1, o2) -> keyExtractor.apply(o1).compareTo(keyExtractor.apply(o2));
    }

    // Метод для создания компаратора с использованием произвольной функции сравнения
    static <T, U> MyComparator<T> comparing(Function<? super T, ? extends U> keyExtractor, MyComparator<? super U> keyComparator) {
        return (o1, o2) -> keyComparator.compare(keyExtractor.apply(o1), keyExtractor.apply(o2));
    }

    // Метод для сравнения примитивных типов (например, int)
    static <T> MyComparator<T> comparingInt(ToIntFunction<? super T> keyExtractor) {
        return (o1, o2) -> Integer.compare(keyExtractor.applyAsInt(o1), keyExtractor.applyAsInt(o2));
    }

    // Метод для сравнения примитивных типов (например, long)
    static <T> MyComparator<T> comparingLong(ToLongFunction<? super T> keyExtractor) {
        return (o1, o2) -> Long.compare(keyExtractor.applyAsLong(o1), keyExtractor.applyAsLong(o2));
    }

    // Метод для сравнения примитивных типов (например, double)
    static <T> MyComparator<T> comparingDouble(ToDoubleFunction<? super T> keyExtractor) {
        return (o1, o2) -> Double.compare(keyExtractor.applyAsDouble(o1), keyExtractor.applyAsDouble(o2));
    }

    // Метод для сравнения null-значений
    static <T> MyComparator<T> nullsFirst(MyComparator<? super T> comparator) {
        return (o1, o2) -> {
            if (o1 == o2) return 0;
            if (o1 == null) return -1;
            if (o2 == null) return 1;
            return comparator.compare(o1, o2);
        };
    }

    // Метод для сравнения null-значений (null после ненулевых значений)
    static <T> MyComparator<T> nullsLast(MyComparator<? super T> comparator) {
        return (o1, o2) -> {
            if (o1 == o2) return 0;
            if (o1 == null) return 1;
            if (o2 == null) return -1;
            return comparator.compare(o1, o2);
        };
    }
}
