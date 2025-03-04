package org.example.Task4;

public interface IntSequence {
    int next();

    boolean hasNext();

    static IntSequence of(int... values) {
        return new IntSequence() {
            private int index = 0;

            @Override
            public int next() {
                if (!hasNext()) {
                    throw new IllegalStateException("Нет больше элементов в последовательности");
                }
                return values[index++];
            }

            @Override
            public boolean hasNext() {
                return index < values.length; // Проверяем, есть ли ещё элементы
            }
        };
    }
}
