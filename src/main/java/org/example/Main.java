package org.example;

import org.example.Task1.Measurable;
import org.example.Task7.LuckySort;
import org.example.Task8.Greeter;

import java.util.*;

public class Main {

   public static double average(Measurable[] objects) {
       if (objects == null || objects.length == 0) {
           return 0.0;
       }

       double sum = 0.0;
       for (Measurable obj : objects) {
           sum += obj.getMeasure();
       }

       return sum / objects.length;
   }

   public static Measurable largest(Measurable[] objects) {
       if (objects == null || objects.length == 0) {
           return null;
       }

       double max = Double.MIN_VALUE;
       Measurable target = null;
       for (Measurable obj : objects) {
           if (obj.getMeasure() > max) {
               max = obj.getMeasure();
               target = obj;
           }
       }

       return target;
   }

    public static void runTogether(Runnable... tasks) {
        for (Runnable task : tasks) {
            Thread thread = new Thread(task);
            thread.start();
        }
    }

    public static void runInOrder(Runnable... tasks) {
        for (Runnable task : tasks) {
            task.run();
        }
    }

    public static void main(String[] args) {
        // 141

        Scanner in = new Scanner(System.in);
        int n = 1;
        while (n != 0) {
            n = in.nextInt();
            switch (n) {
                case 0:
                    break;
                case 7:
                    ArrayList<String> strings = new ArrayList<>();
                    strings.add("banana");
                    strings.add("apple");
                    strings.add("cherry");

                    Comparator<String> comp = Comparator.naturalOrder();

                    System.out.println("До сортировки: " + strings);
                    LuckySort.luckySort(strings, comp);
                    System.out.println("После сортировки: " + strings);
                    break;
                case 8:
                    Runnable task1 = new Greeter(3, "thread 1");
                    Runnable task2 = new Greeter(3, "thread 2");
                    Thread thread1 = new Thread(task1);
                    Thread thread2 = new Thread(task2);
                    thread1.start();
                    thread2.start();
                    break;
                case 9:
                    Runnable taskOther1 = new Greeter(3, "Task 1");
                    Runnable taskOther2 = new Greeter(3, "Task 2");
                    Runnable taskOther3 = new Greeter(3, "Task 3");

                    System.out.println("Запускаем task вместе:");
                    runTogether(taskOther1, taskOther2, taskOther3);

                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        System.out.println("Главный поток был прерван.");
                    }

                    System.out.println("\nЗапускаем задачи последовательно:");
                    runInOrder(taskOther1, taskOther2, taskOther3);
                    break;
                default:
                    System.out.println("Wrong!");
            }
        }
    }
}