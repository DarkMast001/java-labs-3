package org.example.task_1_from_list.interafce_bad;

public class Main {
    public static void startMoving(Car car) {
        car.move();
    }

    public static void startMoving(Bicycle bicycle) {
        bicycle.move();
    }

    public static void startMoving(Train train) {
        train.move();
    }

    public static void main(String[] args) {
        Car car = new Car();
        Bicycle bicycle = new Bicycle();
        Train train = new Train();

        startMoving(car);
        startMoving(bicycle);
        startMoving(train);
    }
}
