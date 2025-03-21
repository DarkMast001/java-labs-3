package org.example.task_1_from_list.interafce_good;

public class Train implements Vehicle{
    @Override
    public void move() {
        System.out.println("Поезд движется по рельсам.");
    }
}
