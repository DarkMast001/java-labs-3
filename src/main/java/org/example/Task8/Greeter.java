package org.example.Task8;

public class Greeter implements Runnable {
    int n;
    String target;

    public Greeter(int n, String target) {
        this.n = n;
        this.target = target;
    }

    @Override
    public void run() {
        // 123
        for (int i = 0; i < n; i++) {
            System.out.println("Hello " + target);
        }
    }
}
