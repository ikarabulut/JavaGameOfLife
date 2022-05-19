package com.ikarabulut;

public interface RuleSet {

    public boolean willBeAliveNextGeneration(int aliveNeighborsCount, boolean isAlive);

    public default boolean isUnderpopulated() { return false; }

    public default boolean isFertileLand() { return true; }

    public default boolean isOverpopulated() { return false; }
}
