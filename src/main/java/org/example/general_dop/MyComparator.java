package org.example.general_dop;

import java.util.Comparator;
import java.util.function.Function;

public interface MyComparator<T> {

    int compare(T o1, T o2);

    default MyComparator<T> reversed() {
        return (o1, o2) -> this.compare(o2, o1);
    }

    // Статический метод для естественного порядка сравнения
    static <T extends Comparable<T>> MyComparator<T> naturalOrder() {
        return (o1, o2) -> o1.compareTo(o2);
    }

    // Статический метод для обратного естественного порядка
    static <T extends Comparable<T>> MyComparator<T> reverseOrder() {
        return (o1, o2) -> o2.compareTo(o1);
    }

    // Дефолтный метод для добавления вторичного компаратора
    default MyComparator<T> thenComparing(MyComparator<T> other) {
        return (o1, o2) -> {
            int result = this.compare(o1, o2);
            return (result != 0) ? result : other.compare(o1, o2);
        };
    }

    // Статический метод для создания компаратора на основе ключа
    static <T, U extends Comparable<U>> MyComparator<T> comparing(Function<T, U> keyExtractor) {
        return (o1, o2) -> keyExtractor.apply(o1).compareTo(keyExtractor.apply(o2));
    }
}
