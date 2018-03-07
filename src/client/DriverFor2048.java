package client;

import java.util.Scanner;

import exceptions.InvalidMoveException;
import models.Direction;
import services.Play2048Service;

public class DriverFor2048 {

	public static void main(String[] args) throws InvalidMoveException {
		System.out.println("Enter grid size: ");
		Scanner sc = new Scanner(System.in);
		int size = sc.nextInt();
		Play2048Service service = new Play2048Service(size);
		
		service.showGrid();
//		
//		service.moveTile(Direction.UP);
//		service.moveTile(Direction.DOWN);
//		service.moveTile(Direction.RIGHT);
//		service.moveTile(Direction.LEFT);
//		
//		service.reset();
		
		System.out.println("Okay Your turn now, play. Enter UP, DOWN, LEFT, RIGHT");
		
		try {
			while(true) {
				String move = sc.next();
				service.moveTile(Direction.valueOf(move));
			}			 
		} catch(IllegalArgumentException e) {
			System.out.println("Thank you for playing! Your score was " + service.getCurrentScore());
			service.exit();
		}
		
	}
}
