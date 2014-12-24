package main;

import model.Board;
import view.MainWindow;
import controller.Controller;

public class Main {

	public static void main(String[] args) {
		Board board = new Board();
		MainWindow gui = new MainWindow();
		Controller controller = new Controller(board, gui);
		
		System.out.print("\n"+board.countObservers());
		System.out.print("\n"+board.countObservers());
	}

}
