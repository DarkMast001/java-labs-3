package org.example;

import org.example.task_1.Measurable;
import org.example.task_10_11.DirectoryLister;
import org.example.task_13.RunnableCombiner;
import org.example.task_15.IntSequenceExample;
import org.example.task_4.IntSequence;
import org.example.task_7.LuckySort;
import org.example.task_8.Greeter;
import org.example.task_14.Employee;

import java.io.File;
import java.util.*;
import java.util.function.BiPredicate;

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
                case 10:
                    File directory = new File("../");
                    File[] subdirectories = DirectoryLister.getSubdirectories(directory);
                    Arrays.stream(subdirectories).forEach(System.out::println);
                    break;
                case 11:
                    File directoryNew = new File("../");
                    String extension = "pdf";

                    String[] files = DirectoryLister.getFilesWithExtension(directoryNew, extension);
                    System.out.println("Файлы с расширением ." + extension + ":");
                    for (String file : files) {
                        System.out.println(file);
                    }
                    break;
                case 12:
                    File[] filesArray = {
                            new File("./testsFor12/file3.txt"),
                            new File("./testsFor12/folder1"),
                            new File("./testsFor12/file1.txt"),
                            new File("./testsFor12/folder2"),
                            new File("./testsFor12/file2.txt")
                    };

                    Arrays.sort(filesArray, (f1, f2) -> {
                        if (f1.isDirectory() && !f2.isDirectory()) {
                            return -1; // Каталог идет раньше файла
                        } else if (!f1.isDirectory() && f2.isDirectory()) {
                            return 1;  // Файл идет после каталога
                        } else {
                            return f1.getPath().compareTo(f2.getPath()); // Сортировка по пути
                        }
                    });

                    for (File file : filesArray) {
                        System.out.println(file.getPath());
                    }
                    break;
                case 13:
                    Runnable task_1 = () -> System.out.println("Задача 1 выполнена");
                    Runnable task_2 = () -> System.out.println("Задача 2 выполнена");
                    Runnable task_3 = () -> System.out.println("Задача 3 выполнена");

                    Runnable combinedTask = RunnableCombiner.combine(new Runnable[]{task_1, task_2, task_3});

                    combinedTask.run();
                    break;
                case 14:
                    Employee[] employees = {
                            new Employee("Dima", 50000),
                            new Employee("Ivan", 60000),
                            new Employee("Nikita", 50000),
                            new Employee("Egor", 70000)
                    };

                    Arrays.sort(employees, Comparator
                            .comparing(Employee::getSalary)
                            .thenComparing(Employee::getName)
                    );

                    System.out.println("Сортировка по зарплате и имени:");
                    Arrays.stream(employees).forEach(System.out::println);

                    Arrays.sort(employees, Comparator
                            .comparing(Employee::getSalary)
                            .thenComparing(Employee::getName)
                            .reversed()
                    );

                    System.out.println("\nСортировка в обратном порядке:");
                    Arrays.stream(employees).forEach(System.out::println);
                    break;
                case 15:
                    IntSequence sequence = IntSequenceExample.randomInts(1, 10);

                    for (int i = 0; i < 10; i++) {
                        System.out.print(sequence.next() + " ");
                    }
                    System.out.println("");
                    break;
                default:
                    System.out.println("Wrong!");
            }
        }
    }
}