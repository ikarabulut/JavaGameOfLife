package com.ikarabulut;

public class Rules {

    private static boolean aliveNextGeneration;

    public static boolean aliveCheck(int aliveNeighborsCount) {
        if (aliveNeighborsCount < 2) {
            isUnderpopulated();
        } else if (aliveNeighborsCount == 2 || aliveNeighborsCount == 3) {
            isFertileLand();
        } else {
            isOverpopulated();
        }
        return aliveNextGeneration;
    }

    public static boolean deadCheck(int aliveNeighborsCount) {
        if (aliveNeighborsCount == 3) {
            isFertileLand();
        } else { aliveNextGeneration = false; }
        return aliveNextGeneration;
    }

    private static void isUnderpopulated() {
        aliveNextGeneration = false;
    }

    private static void isFertileLand() {
        aliveNextGeneration = true;
    }

    private static void isOverpopulated() {
        aliveNextGeneration = false;
    }

}
