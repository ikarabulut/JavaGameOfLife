package com.ikarabulut.Rules;

public class ComeAliveWithFour extends RuleSet {

    protected boolean isFertileLand(int aliveNeighborsCount, boolean isAlive) {
        if (isAlive) {
            return aliveNeighborsCount == 2 || aliveNeighborsCount == 3;
        } else {
            return aliveNeighborsCount == 4;
        }
    }

}
