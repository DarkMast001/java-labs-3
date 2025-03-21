package org.example.task_1_from_list.interafce_good;

public class Main {
    public static void makeMove(Vehicle vehicle) {
        vehicle.move();
    }

    public static void main(String[] args) {
        Vehicle car = new Car();
        Vehicle bicycle = new Bicycle();
        Vehicle train = new Train();

        makeMove(car);
        makeMove(bicycle);
        makeMove(train);
    }
}
