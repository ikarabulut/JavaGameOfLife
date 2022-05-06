package com.ikarabulut;

public class Tests {

    private static boolean aliveNextGeneration;

    public static boolean aliveCheck(int aliveNeighborsCount) {
        if (aliveNeighborsCount < 2) {
            isUnderpopulated();
        }
        return aliveNextGeneration;
    }

    private static void isUnderpopulated() {
        aliveNextGeneration = false;
    }

}
