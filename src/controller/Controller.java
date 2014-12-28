package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

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
		
		switch(action) {
		case "New Game":	
			board.initBoard();
			break;
		case "High Scores": 	
			break;
		case "Exit": 	
			gui.askExitConfirmation(); // ask for confirmation
			break;
		default:
			;
		}
		gui.requestFocus(); //ensure reaction to arrow keys pressed again
	}
	
	
	
    @Override
    public void keyPressed(KeyEvent e) {
    	
    	String direction = "";
    	Position destination;
        int code = e.getKeyCode();

        if (!board.getGameFinished()) { // keep moving only is game not finished
        	
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
	        	if (board.getGameFinished()) {
	        		this.handleEndOfGame();
	        	}
	        }
        }
    }
	
    @Override
    public void keyTyped(KeyEvent e) {
    	;
    }

    @Override
    public void keyReleased(KeyEvent e) {
    	;
	}
    
    public void handleEndOfGame() {
    	String title;
    	String message;
    	if (board.getTrophy().getWon()) {
    		title = "Victory !";
    		message = "You won !\n"+
    				  "Your score is " + board.getPlayer().getScore();
    	} else {
    		title = "Defeat !";
    		message = "You lost !\n"+
    				  "Your score is " + board.getPlayer().getScore()+".";
    	}
    	
    	JOptionPane.showMessageDialog(	gui.getBoardRenderer(), 
    									message, 
										title,
										JOptionPane.INFORMATION_MESSAGE);
    			
    	if (board.getHighScoreManager().isHighScore()) {
    	    String name =JOptionPane.showInputDialog(	gui.getBoardRenderer(), 
    	    											"You beat the high score !\n"+
    	    											"Please, enter your name.",
    	    											"Save High Score",
    	    											JOptionPane.QUESTION_MESSAGE);
    	    board.getHighScoreManager().storeScore(name);
    	}
    	
    	EndOfGameDialogBox box = new EndOfGameDialogBox(gui.getBoardRenderer());
		
		switch (box.getChoice()) { // take action depending on user's answer to dialog
		case -1: //close
			;
			break;
		case 0: //new game
			board.initBoard(); 
		 	break;
		case 1:	//high scores
			;	
			break;
		case 2: //close	
			gui.askExitConfirmation();
			break;
		default:
			;
		}
    	
    }
    

}
	
