package models;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Grid {
	public static final int _2048 = 2048;
	private int size;
	private int highScore;
	private Tile[][] array;
	private Random random;
	
	public Grid(int size) {
		super();
		this.size = size;
		this.highScore = 0;
		this.array = new Tile[size][size];
		this.random = new Random();
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public int getHighScore() {
		return highScore;
	}

	public void setHighScore(int highScore) {
		this.highScore = highScore;
	}

	public Tile[][] getArray() {
		return array;
	}

	public void setArray(Tile[][] array) {
		this.array = array;
	}
	
	public Tile generateRandomTile() {
		List<String> listOfEmptyCells = new ArrayList<String>();
		for(int i = 0; i < size; i++) {
			for(int j = 0; j < size; j++) {
				if(array[i][j] == null)
					listOfEmptyCells.add(i + "," + j);
			}
		}
		
		int randomPosition = random.nextInt(listOfEmptyCells.size());
		
		String[] str = listOfEmptyCells.get(randomPosition).split(",");
		
		int x = Integer.parseInt(str[0]);
		int y = Integer.parseInt(str[1]);
		
		return new Tile(generateBiasedNumber(), x, y);
		
	}

	private int generateBiasedNumber() {
		int rand = random.nextInt(100);

		if(rand < 90)
			return 2;
		else 
			return 4;
	}

	public void setTile(Tile tile) {
		array[tile.getX()][tile.getY()] = tile;
	}
}
