package com.ikarabulut;

public interface RuleSet {

    public boolean willBeAliveNextGeneration(int aliveNeighborsCount, boolean isAlive);

    public void isUnderpopulated();

    public void isFertileLand();

    public void isOverpopulated();
}
