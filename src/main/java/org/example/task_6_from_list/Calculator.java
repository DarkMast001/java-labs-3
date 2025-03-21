package org.example.task_6_from_list;

// Обычный класс. Нефункциональный интерфейс
public class Calculator implements MultiOperation{
    @Override
    public int add(int a, int b) {
        return a + b;
    }

    @Override
    public int subtract(int a, int b) {
        return a - b;
    }
}
