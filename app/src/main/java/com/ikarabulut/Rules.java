package com.ikarabulut;

public class Rules {

    private static boolean isAliveNextGeneration;

    public static boolean aliveCheck(int aliveNeighborsCount) {
        if (aliveNeighborsCount < 2) {
            isUnderpopulated();
        } else if (aliveNeighborsCount == 2 || aliveNeighborsCount == 3) {
            isFertileLand();
        } else {
            isOverpopulated();
        }
        return isAliveNextGeneration;
    }

    public static boolean deadCheck(int aliveNeighborsCount) {
        if (aliveNeighborsCount == 3) {
            isFertileLand();
        } else { isAliveNextGeneration = false; }
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
