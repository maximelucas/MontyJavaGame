package controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import model.Board;
import model.Position;
import view.MainWindow;

public class Controller implements KeyListener {
	

	Board board;
	MainWindow gui;
	
	// CONSTRUCTOR 
	
	public Controller(Board board, MainWindow gui) {
		this.board = board;
		this.gui = gui;
		board.addObserver(gui.getBoardRenderer());
		board.addObserver(gui.getInfoPanel());
		board.initBoard();
		gui.addKeyListener(this);
		gui.setFocusable(true);
		gui.requestFocus();      // Give the panel focus.
		
	}
	
	
    @Override
    public void keyPressed(KeyEvent e) {
    	
    	System.out.print("\n key pressed !"+board.getPlayer().getPosition());
    	String direction = "";
    	Position destination;
        int code = e.getKeyCode();

        if (code == KeyEvent.VK_DOWN) {
        	direction = "down";
        } else if (code == KeyEvent.VK_UP) {
        	direction = "up";
        } else if (code == KeyEvent.VK_LEFT) {
        	direction = "left";
        } else if (code == KeyEvent.VK_RIGHT) {
        	direction = "right";
        }
        System.out.print(direction+"\t");

        if (direction!="") {
        	destination = board.computeDestination(direction);

        	board.makeMove(destination);
        	board.handleInteraction(board.getPlayer());
        }

    }
	
    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
	}
    
}
	
