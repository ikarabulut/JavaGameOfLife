package com.ikarabulut;

public class Tests {

    private static boolean aliveNextGeneration;

    public static boolean aliveCheck(int aliveNeighborsCount) {
        if (aliveNeighborsCount < 2) {
            isUnderpopulated();
        } else if (aliveNeighborsCount == 2 || aliveNeighborsCount == 3) {
            isFertileLand();
        }
        return aliveNextGeneration;
    }

    private static void isUnderpopulated() {
        aliveNextGeneration = false;
    }

    private static void isFertileLand() {
        aliveNextGeneration = true;
    }

}
