package org.example.task_6_from_list;

public class Main {
    public static void main(String[] args) {

        // Обычный класс. Функциональный интерфейс
//        Operation addition = new Addition();
//        System.out.println("Сложение: " + addition.calculate(5, 3));

        // Анонимный класс. Функциональный интерфейс
//        Operation subtraction = new Operation() {
//            @Override
//            public int calculate(int a, int b) {
//                return a- b;
//            }
//        };
//        System.out.println("Вычитание: " + subtraction.calculate(5, 3));

        // Лямбда выражение. Функциональный интерфейс
//        Operation multiplication = (a, b) -> a * b;
//        System.out.println("Умножение: " + multiplication.calculate(5, 3));

        //=========================================//

        // Обычный класс. Нефункциональный интерфейс
//        MultiOperation calculator = new Calculator();
//        System.out.println("Сложение: " + calculator.add(5, 3));
//        System.out.println("Вычитание: " + calculator.subtract(5, 3));

        // Анонимный класс. Нефункциональный интерфейс
//        MultiOperation calculator = new MultiOperation() {
//            @Override
//            public int add(int a, int b) {
//                return a + b;
//            }
//
//            @Override
//            public int subtract(int a, int b) {
//                return a - b;
//            }
//        };
//
//        System.out.println("Сложение: " + calculator.add(5, 3));
//        System.out.println("Вычитание: " + calculator.subtract(5, 3));
    }
}
