package org.example.task_10_from_list;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.function.Function;

public interface MappingIterator<T> extends Iterator<T> {

    static <T> MappingIterator<T> fromIterator(Iterator<T> iterator) {
        return new MappingIterator<T>() {
            private final Iterator<T> it = iterator;

            @Override
            public T next() {
                return it.next();
            }

            @Override
            public boolean hasNext() {
                return it.hasNext();
            }
        };
    }

    default <TO> MappingIterator<TO> map(Function<T, TO> mapper) {
        return new MappingIterator<>(){
            @Override
            public TO next() {
                return mapper.apply(MappingIterator.this.next());
            }

            @Override
            public boolean hasNext() {
                return MappingIterator.this.hasNext();
            }
        };
    }
}
