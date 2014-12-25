package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import model.Board;
import model.Position;
import view.EndOfGameDialogBox;
import view.MainWindow;

public class Controller implements KeyListener, ActionListener {
	

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
		gui.getMenuPanel().setActionListener(this);
		System.out.print(gui.getMenuPanel().getPause().getActionListeners());
		System.out.print(gui.getMenuPanel().getActionListener());
		gui.setFocusable(true);
		gui.requestFocus();      // Give the panel focus.
		
	}
	
	// METHODS 
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String action = e.getActionCommand();
		//System.out.println("Something happened!");

		
		switch(action) {
			case "new game" :	System.out.print(action);
								board.initBoard();
								break;
			case "reset"	: 	System.out.print(action);
								break;
			case "exit" 	: 	System.out.print(action);
								break;
		}
		gui.requestFocus();
	}
	
	
	
    @Override
    public void keyPressed(KeyEvent e) {
    	
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

        if (direction!="") {
        	destination = board.computeDestination(direction);

        	board.makeMove(destination);
        	board.handleInteraction(board.getPlayer());
        	if (board.isGameOver()) {
        		new EndOfGameDialogBox(gui.getBoardRenderer());
        	}
        }

    }
	
    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
	}
    
}
	
