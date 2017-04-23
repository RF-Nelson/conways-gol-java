import java.util.Scanner;
import java.io.*;

public class GameOfLife {
	public static void main(String args[]) {
    // rows
    final int M = 25;
    // columns
    final int N = 75;
    String quitMessage = "You chose to leave the game of life :(";
		Scanner in = new Scanner(System.in);
		boolean quit = false;
		int genNum = 0;
		char[][] previousGeneration = new char[M + 2][N + 2];

		System.out.println("Enter a filename that contains a game world: ");
		Scanner fileReader = null;
		boolean fileFound = false;

		while (!fileFound) {
			String filename = in.next();

			if (filename.equalsIgnoreCase("q")) {
				System.out.println("\nExiting...\n");
				System.exit(0);
			}

			File file = new File(filename);

			try {
		    	fileReader = new Scanner (file);
					fileFound = true;
			} catch (Exception e) {
		    	System.out.println("\nThe file " + file + " does not exist in the present working directory.");
		    	System.out.println("Please enter a valid filename or type Q to quit.");
			}
		}

		for (int row = 0; row < previousGeneration.length; row++) {
			if (row == 0 || row == (previousGeneration.length-1)){
				for (int col = 0; col < previousGeneration[0].length; col++){
					previousGeneration[row][col] = '.';
				}
			} else {
				String line = "." + fileReader.nextLine() + ".";
				previousGeneration[row] = line.toCharArray();
			}
		}
		printWorld(previousGeneration, genNum, M, N);

		while(!quit){
			System.out.println("Would you like to see another generation? (y/n)");
			String input = in.next();
			if (input.equalsIgnoreCase("n")) {
				quit = true;
			} else if (input.equalsIgnoreCase("y")) {
				char[][] newGen = new char[M + 2][N + 2];
				genNum++;

				for (int row = 0; row < newGen.length; row++){
					for (int col = 0; col < newGen[0].length; col++){
						if(row == 0 || row == (newGen.length-1)){
							newGen[row][col] = '.';
						} else if(col == 0 || col == (newGen[0].length-1)){
							newGen[row][col] = '.';
						} else {
							int neighbors = getNeighbors(previousGeneration, row, col);
							if (previousGeneration[row][col] == 'X'){
								if (neighbors == 2 || neighbors == 3){
									newGen[row][col] = 'X';
								} else {
									newGen[row][col] = '.';
								}
							} else {
								if(neighbors == 3){
									newGen[row][col] = 'X';
								} else {
									newGen[row][col] = '.';
								}
							}
						}
					}
				}

        if (isChanged(newGen, previousGeneration)){
					quitMessage = "The world has not changed since the previous generation.";
					quit = true;
				}

				if (isEmpty(newGen)){
					quitMessage = "The world is empty.";
					quit = true;
				}

        printWorld(newGen, genNum, M, N);
				previousGeneration = newGen;
			} else {
        System.out.println("Invalid input. Please type 'Y' to see another generation or 'N' to quit.");
      }
		}
    System.out.println(quitMessage);
		System.out.println("Have a nice day!");
	}

	public static int getNeighbors(char[][] world, int row, int col){
		int count = 0;
		for (int i = - 1; i <= 1; i++){
			for (int j = -1; j <= 1; j++) {
				if(i == 0 && j == 0){
					count = count;
				} else if (world[row + i][col + j] == 'X'){
					count++;
				}
			}
		}
		return count;
	}

	public static boolean isEmpty(char[][] world){
		for(int row = 0; row < world.length; row++){
			for (int col = 0; col < world[0].length; col++){
				if(world[row][col] == 'X'){
					return false;
				}
			}
		}
		return true;
	}

  public static boolean isChanged(char[][] world, char[][] previousGeneration){
		for(int row = 0; row < world.length; row++){
			for (int col = 0; col < world[0].length; col++){
				if(world[row][col] != previousGeneration[row][col]){
					return false;
				}
			}
		}
		return true;
	}

	public static void printWorld(char[][] world, int genNum, int M, int N){
		System.out.println("\nGeneration #" + genNum + ":");

		for (int row = 1; row <= M; row++) {
			for (int col = 1; col <= N; col++){
				System.out.print(world[row][col]);
			}
			System.out.print("\n");
		}
		System.out.print("\n");
	}
}
