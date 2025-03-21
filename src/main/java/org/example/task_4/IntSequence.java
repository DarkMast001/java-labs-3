package org.example.task_4;

public interface IntSequence {

    int next();

    default boolean hasNext() {
        return true;
    }

    static IntSequence of(int value) {
        int[] tmp = {0};

        return () -> {
            tmp[0]++;
            return value + tmp[0];
        };
    }

//    static IntSequence of(int... values) {
//        return new IntSequence() {
//            private int index = 0;
//
//            @Override
//            public int next() {
//                if (!hasNext()) {
//                    throw new IllegalStateException("Нет больше элементов в последовательности");
//                }
//                return values[index++];
//            }
//
//            @Override
//            public boolean hasNext() {
//                return index < values.length; // Проверяем, есть ли ещё элементы
//            }
//        };
//    }
}
