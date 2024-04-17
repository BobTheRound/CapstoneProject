package application;

import java.util.Random;

import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;

public class StrokeType {
	Random rand = new Random();
	Player player = new Player();
	//hint writing time
	   //diagonal
//	private String stroke = "Block";
 public StrokeType(String stroke) {
	
}

 public StrokeType() {
	
}

 void sliceMethod(GridPane pane, int col, int row, Button hint) {
	 hint.setMinSize(50, 50);
 	int picker = rand.nextInt(6);
 	int colOne = 0;
		int rowOne = 0;
		int colTwo = 0;
		int rowTwo = 0;
		
			switch (picker){
			case 5 ://top of button and left of ball
				System.out.println("slice case 5");
				colOne = col;
				rowOne = row - 1;
				colTwo = col - 1;
				rowTwo = row;
				break;
			case 4 ://top right corner and bottom left corner
				System.out.println("slice case 4");
				colOne = col + 1;
				rowOne = row - 1;
				colTwo = col - 1;
				rowTwo = row + 1;
				break;
			case 3 ://Bottom of ball and left of ball
				System.out.println("slice case 3");
				colOne = col;
				rowOne = row + 1;
				colTwo = col - 1;
				rowTwo = row;
				break;
			case 2 ://top of ball and right of ball
				System.out.println("slice case 2");
				colOne = col;
				rowOne = row - 1;
				colTwo = col + 1;
				rowTwo = row;
				break;
			case 1 ://bottom of ball and right of ball
				System.out.println("slice case 1");
				colOne = col;
				rowOne = row + 1;
				colTwo = col + 1;
				rowTwo = row;
				break;
			default://top left corner and bottom right corner of ball
				System.out.println("slice case default");
				colOne = col - 1;
				rowOne = row - 1;
				colTwo = col + 1;
				rowTwo = row + 1;
				
			}
			player.getHint(pane, colOne, rowOne);
			player.getHint(pane, colTwo, rowTwo);
 }
 
 //vertical
 void chopMethod(GridPane pane, int col, int row, Button hint) {
	 hint.setMinSize(50, 50);
 	int picker = rand.nextInt(7);
 	int colOne = 0;
		int rowOne = 0;
		int colTwo = 0;
		int rowTwo = 0;
			switch (picker){
			case 6 ://top left of ball and left of ball
				System.out.println("chop case 6");
				colOne = col - 1;
				rowOne = row - 1;
				colTwo = col - 1;
				rowTwo = row;
				break;
			case 5 ://top left of ball and bottom left of ball
				System.out.println("chop case 5");
				colOne = col - 1;
				rowOne = row - 1;
				colTwo = col - 1;
				rowTwo = row + 1;
				break;
			case 4 ://left of ball and bottom left of ball
				System.out.println("chop case 4");
				colOne = col - 1;
				rowOne = row;
				colTwo = col - 1;
				rowTwo = row + 1;
				break;
			case 3 ://top of ball and bottom of ball
				System.out.println("chop case 3");
				colOne = col;
				rowOne = row - 1;
				colTwo = col;
				rowTwo = row + 1;
				break;
			case 2 ://right top of ball and right of ball
				System.out.println("chop case 2");
				colOne = col + 1;
				rowOne = row - 1;
				colTwo = col + 1;
				rowTwo = row;
				break;
			case 1 ://top right of ball and lower right of ball
				System.out.println("chop case 1");
				colOne = col + 1;
				rowOne = row - 1;
				colTwo = col + 1;
				rowTwo = row + 1;
				break;
			default://right of ball and lower right of ball
				System.out.println("chop case default");
				colOne = col + 1;
				rowOne = row - 1;
				colTwo = col + 1;
				rowTwo = row;
				break;
				
			}
			player.getHint(pane, colOne, rowOne);
			player.getHint(pane, colTwo, rowTwo);
 }

 //horizontal
 void sideLoopMethod(GridPane pane, int col, int row, Button hint) {
	 hint.setMinSize(50, 50);
 	int picker = rand.nextInt(7);
 	int colOne = 0;
		int rowOne = 0;
		int colTwo = 0;
		int rowTwo = 0;
			switch (picker){
			case 6 ://top left of button and top of button
				System.out.println("sideLoop case 6");
				colOne = col - 1;
				rowOne = row - 1;
				colTwo = col;
				rowTwo = row - 1;
				break;
			case 5 ://top left of button and top right of button
				System.out.println("sideLoop case 5");
				colOne = col - 1;
				rowOne = row - 1;
				colTwo = col + 1;
				rowTwo = row - 1;
				break;
			case 4 ://top of button and top right of button
				System.out.println("sideLoop case 4");
				colOne = col;
				rowOne = row - 1;
				colTwo = col + 1;
				rowTwo = row - 1;
				break;
			case 3 ://left of button and right of button
				System.out.println("sideLoop case 3");
				colOne = col - 1;
				rowOne = row; 
				colTwo = col + 1;
				rowTwo = row;
				break;
			case 2 ://lower left of button and bottom of button
				System.out.println("sideLoop case 2");
				colOne = col - 1;
				rowOne = row + 1;
				colTwo = col;
				rowTwo = row + 1;
				break;
			case 1 ://lower left of button and lower right of button
				System.out.println("sideLoop case 1");
				colOne = col - 1;
				rowOne = row + 1;
				colTwo = col + 1;
				rowTwo = row + 1;
				break;
			default://bottom of button and lower right of button
				System.out.println("sideLoop case default");
				colOne = col;
				rowOne = row + 1;
				colTwo = col + 1;
				rowTwo = row + 1;
				break;
				
			}
			player.getHint(pane, colOne, rowOne);
			player.getHint(pane, colTwo, rowTwo);
 }
 
 //any adjacent square
 //4 are corner touching
 //8 are linear touching
 void smashMethod(GridPane pane, int col, int row, Button hint) {
	 hint.setMinSize(50, 50);
 	int picker = rand.nextInt(12);
 	int colOne = 0;
		int rowOne = 0;
		int colTwo = 0;
		int rowTwo = 0;
			switch (picker){
			case 11 ://top of button and left of button
				System.out.println("smash case 11");
				colOne = col;
				rowOne = row - 1;
				colTwo = col - 1;
				rowTwo = row;
				break;
			case 10 ://top of button and right of button
				System.out.println("smash case 10");
				colOne = col;
				rowOne = row - 1;
				colTwo = col + 1;
				rowTwo = row;
				break;
			case 9 ://bottom of button and left of button
				System.out.println("smash case 9");
				colOne = col;
				rowOne = row + 1;
				colTwo = col - 1;
				rowTwo = row;
				break;
			case 8 ://bottom of button and right of button
				System.out.println("smash case 8");
				colOne = col;
				rowOne = row + 1;
				colTwo = col + 1;
				rowTwo = row;
				break;
			case 7 ://top left of button and top of button
				System.out.println("smash case 7");
				colOne = col - 1;
				rowOne = row - 1;
				colTwo = col;
				rowTwo = row - 1;
				break;
			case 6 ://top of button and top right of button
				System.out.println("smash case 6");
				colOne = col;
				rowOne = row - 1;
				colTwo = col + 1;
				rowTwo = row - 1;
				break;
			case 5 ://top right of button and right of button
				System.out.println("smash case 5");
				colOne = col + 1;
				rowOne = row - 1;
				colTwo = col + 1;
				rowTwo = row;
				break;
			case 4 ://right of button and lower right of button
				System.out.println("smash case 4");
				colOne = col + 1;
				rowOne = row;
				colTwo = col + 1;
				rowTwo = row + 1;
				break;
			case 3 ://lower right of button and bottom of button
				System.out.println("smash case 3");
				colOne = col + 1;
				rowOne = row + 1;
				colTwo = col;
				rowTwo = row + 1;
				break;
			case 2 ://bottom of button and lower left of button
				System.out.println("smash case 2");
				colOne = col;
				rowOne = row + 1;
				colTwo = col - 1;
				rowTwo = row + 1;
				break;
			case 1 ://lower left of button and left of button
				System.out.println("smash case 1");
				colOne = col - 1;
				rowOne = row + 1;
				colTwo = col - 1;
				rowTwo = row;
				break;
			default://left of button and top left of button
				System.out.println("smash case default");
				colOne = col - 1;
				rowOne = row;
				colTwo = col - 1;
				rowTwo = row - 1;
				break;
				
			}
			player.getHint(pane, colOne, rowOne);
			player.getHint(pane, colTwo, rowTwo);
 }
 //guess +1
 //this method should simply call a different hit type based on case.
 void blockMethod(GridPane pane, int col, int row, Button hint) {
 	for(int i = 0; i < 2; i++) {
 	int picker = rand.nextInt(4);
			switch (picker){
			case 3 ://sliceMethod
				System.out.println("block case 3");
				sliceMethod(pane, col, row, hint);
				break;
			case 2 ://chopMethod
				System.out.println("block case 2");
				chopMethod(pane, col, row, hint);
				break;
			case 1 ://sideLoopMethod
				System.out.println("block case 1");
				sideLoopMethod(pane, col, row, hint);
				break;
			default://smashMethod
				System.out.println("block case default");
				smashMethod(pane, col, row, hint);
				break;	
			}
 	}
 		
 }
 
 
}
