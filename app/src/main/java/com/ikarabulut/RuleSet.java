package com.ikarabulut;

public interface RuleSet {

    public boolean willBeAliveNextGeneration(int aliveNeighborsCount, boolean isAlive);

    private boolean isUnderpopulated() { return false; }

    private boolean isFertileLand() { return true; }

    private boolean isOverpopulated() { return false; }
}
