package com.ikarabulut;

public class Rules {

    private static boolean isAliveNextGeneration;

    public static boolean determineFate(int aliveNeighborsCount, boolean isAlive) {
        if (aliveNeighborsCount < 2) {
            isUnderpopulated();
        } else if (isAlive && aliveNeighborsCount == 2 || aliveNeighborsCount == 3) {
            isFertileLand();
        } else {
            isOverpopulated();
        }
        return isAliveNextGeneration;
    }

    private static void isUnderpopulated() {
        isAliveNextGeneration = false;
    }

    private static void isFertileLand() {
        isAliveNextGeneration = true;
    }

    private static void isOverpopulated() {
        isAliveNextGeneration = false;
    }

}
