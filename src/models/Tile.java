package models;

public class Tile {
	
	private int value;
	private int x; 
	private int y;

	
	public Tile(int value, int x, int y) {
		this.value = value;
		this.x = x;
		this.y = y;
	}
	
	public Tile(int x, int y) {
		this.value = 0;
		this.x = x;
		this.y = y;
	}
	
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	
}
