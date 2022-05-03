# Conway's Game of Life

Conway’s Game of Life (GoL) is what is known as a zero-player game based on a system called a cellular automation. A player sets up an initial pattern on a board, based on alive or dead cells, and the board evolves through a series of generations.

The game is based on 4 simple rules:

1. If a living cell has less than two living neighbors, it is dead in the next generation, as if by underpopulation.
2. If a living cell has two or three living neighbors, it stays alive in the next generation.
3. If a living cell has more than three living neighbors, it is dead in teh next generation, as if by overcrowding.
4. If a dead cell has exactly three living neighbors, it comes to life in the next generation

Each evolution will run through these above rules and will determine the state of the world in the next generation.

## Requirements

- Java installed locally
  - To check which Java version you have installed run `java -version` in your command line
  - If you do not have java installed, you can use homebrew by running `brew install java`
- Local runtime environment, I use OpenJDK
  - To check if you JDK run `javac -version` in your command line
  - If you recieve the prompt `javac not found` then you can follow the homebrew install above which should configure the JDK for you.

For more information on Java installation please review the documentation: https://www.oracle.com/java/technologies/downloads/
