package view;

import java.awt.FlowLayout;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class MenuPanel extends JPanel {
	
	// VARIABLES
	
	private final MyButton newGame = new MyButton("new game");
	private final MyButton pause = new MyButton("pause");
	private final MyButton reset = new MyButton("reset");
	
	private ActionListener actionListener;
	
	// CONSTRUCTOR
	
	public MenuPanel() {
		setLayout(new FlowLayout());
		add(newGame);
		add(pause);
		add(reset);
	}
	
	// GETTERS 
	
	public MyButton getPause() {
		return pause;
	}
	
	public ActionListener getActionListener() {
		return actionListener;
	}
	
	// SETTERS

	public void setActionListener(ActionListener actionListener) {
		this.actionListener = actionListener;
		newGame.addActionListener(actionListener);
		pause.addActionListener(actionListener);
		reset.addActionListener(actionListener);
	}
	
}
