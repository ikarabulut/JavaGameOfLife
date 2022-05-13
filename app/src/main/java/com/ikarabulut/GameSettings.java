package com.ikarabulut;

public class GameSettings {
        private int evolutions;
        private int rows;
        private int columns;
        private int aliveSymbol;
        private int deadSymbol;

        public GameSettings() {
            evolutions = 25;
            rows = 10;
            columns = 10;
            aliveSymbol = 1;
            deadSymbol = 0;
        }

        public int getEvolutions() { return evolutions; }

        public int getRows() { return rows; }

        public int getColumns() { return columns; }

        public int getAliveSymbol() { return aliveSymbol; }

        public int getDeadSymbol() { return deadSymbol; }

}
