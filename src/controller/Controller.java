package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;

import javax.swing.JOptionPane;

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
		gui.setFocusable(true);
		gui.requestFocus();      // Give the panel focus.
		
	}
	
	// METHODS 
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String action = e.getActionCommand();
		//System.out.println("Something happened!");

		
		switch(action) {
		case "New Game" :	System.out.print(action);
							board.initBoard();
							break;
		case "High Scores"	: 	System.out.print(action);
							break;
		case "Exit" 	: 	System.out.print(action);
							// ask for confirmation
							gui.askExitConfirmation();
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
        		EndOfGameDialogBox box = new EndOfGameDialogBox(gui.getBoardRenderer());
        		System.out.print(box.getChoice());
        		
        		switch (box.getChoice()) {
    			//close
    			case -1 :	;
    						break;
    			//new game
    			case 0 :	board.initBoard(); 
    					 	break;
    			//high scores
    			case 1 :	;	
    						break;
    			//close
    			case 2 : 	gui.askExitConfirmation();
    						break;
        			
        			
        		}
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
	
