package org.example.task_13;

public class RunnableCombiner {
    public static Runnable combine(Runnable[] tasks) {
        return () -> {
            for (Runnable task : tasks)
                task.run();
        };
    }
}
