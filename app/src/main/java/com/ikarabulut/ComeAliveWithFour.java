package com.ikarabulut;

public class ComeAliveWithFour extends RuleSet {

    protected boolean isFertileLand(int aliveNeighborsCount, boolean isAlive) {
        return (aliveNeighborsCount == 2 || aliveNeighborsCount == 3) && isAlive
                || aliveNeighborsCount == 4 && !isAlive;
    }

}
