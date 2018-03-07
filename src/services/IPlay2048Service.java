package services;

import exceptions.InvalidMoveException;
import models.Direction;
import models.Tile;

public interface IPlay2048Service {

 	public int getCurrentScore();
 	
 	public void reset();
 	
 	public void exit();
 	
 	public void showGrid();

	public void moveTile(Direction dir) throws InvalidMoveException;
	
}
