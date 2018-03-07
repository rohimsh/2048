package services;

import exceptions.InvalidMoveException;
import models.Direction;
import models.Grid;
import models.Tile;

public class Play2048Service implements IPlay2048Service{

	private Grid grid;
	
	public Play2048Service(int size) {
		this.grid = new Grid(size);
		init();
	}
	
	@Override
	public int getCurrentScore() {
		return grid.getHighScore();
	}


	@Override
	public void moveTile(Direction dir) throws InvalidMoveException {
		if(!move(dir)) {
			generateAndSetTile();
			showGrid();
		} else {
			showGrid();
			System.out.println("Congratulations! You have made " + grid._2048);
			exit();
		}
	}
	
	private boolean move(Direction dir) throws InvalidMoveException {
		
		Tile[][] arr = grid.getArray();
		
		if(Direction.LEFT.equals(dir)) {
			for(int i = 0; i < arr.length; i++) {
				int last = -1;
				for(int j = 0; j < arr.length; j++) {
					if(arr[i][j] != null) {
						if(last >= 0 && arr[i][j].getValue() == arr[i][last].getValue()) {
							int newValue = 2 * arr[i][j].getValue();
							if(newValue > grid.getHighScore())
								grid.setHighScore(newValue);
							arr[i][last].setValue(newValue);
							arr[i][j] = null;
							if(arr[i][last].getValue() == grid._2048)
								return true;
						} else {
							last++;
							if(last != j) {
								arr[i][last] = arr[i][j];
								arr[i][j] = null;
							}
						}
					}
				}
			}
		} else if(Direction.RIGHT.equals(dir)){
			for(int i = 0; i < arr.length; i++) {
				int last = arr.length;
				for(int j = arr.length - 1; j >= 0; j--) {
					if(arr[i][j] != null) {
						if(last < arr.length && arr[i][j].getValue() == arr[i][last].getValue()) {
							int newValue = 2 * arr[i][j].getValue();
							if(newValue > grid.getHighScore())
								grid.setHighScore(newValue);
							arr[i][last].setValue(newValue);
							arr[i][j] = null;
							if(arr[i][last].getValue() == grid._2048)
								return true;
						} else {
							last--;
							if(last != j) {
								arr[i][last] = arr[i][j];
								arr[i][j] = null;
							}
						}
					}
				}
			}			
		} else if(Direction.UP.equals(dir)) {
			for(int i = 0; i < arr.length; i++) {
				int last = -1;
				for(int j = 0; j < arr.length; j++) {
					if(arr[j][i] != null) {
						if(last >= 0 && arr[j][i].getValue() == arr[last][i].getValue()) {
							int newValue = 2 * arr[j][i].getValue();
							if(newValue > grid.getHighScore())
								grid.setHighScore(newValue);
							arr[last][i].setValue(newValue);
							arr[j][i] = null;
							if(arr[last][i].getValue() == grid._2048)
								return true;
						} else {
							last++;
							if(last != j) {
								arr[last][i] = arr[j][i];
								arr[j][i] = null;
							}
						}
					}
				}
			}
		} else if(Direction.DOWN.equals(dir)) {
			for(int i = 0; i < arr.length; i++) {
				int last = arr.length;
				for(int j = arr.length - 1; j >= 0; j--) {
					if(arr[j][i] != null) {
						if(last < arr.length && arr[j][i].getValue() == arr[last][i].getValue()) {
							int newValue = 2 * arr[j][i].getValue();
							if(newValue > grid.getHighScore())
								grid.setHighScore(newValue);
							arr[last][i].setValue(newValue);
							arr[j][i] = null;
							if(arr[last][i].getValue() == grid._2048)
								return true;
						} else {
							last--;
							if(last != j) {
								arr[last][i] = arr[j][i];
								arr[j][i] = null;
							}
						}
					}
				}
			}
		} else {
			throw new InvalidMoveException();
		}
		
		return false;
		
	}


	@Override
	public void reset() {
		grid.setArray(new Tile[grid.getSize()][grid.getSize()]);
		init();
	}

	private void init() {
		generateAndSetTile();
		generateAndSetTile();
	}
	
	private void generateAndSetTile() {
		Tile tile = grid.generateRandomTile();
		grid.setTile(tile);
	}

	@Override
	public void exit() {
		System.exit(0);
	}

	@Override
	public void showGrid() {
		Tile[][] arr = grid.getArray();
		System.out.println();
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < arr.length; j++) {
				if(arr[i][j] != null) {
					System.out.print(arr[i][j].getValue() + " ");
				} else {
					System.out.print("* ");					
				}

			}
			System.out.println();
		}
	}

}
