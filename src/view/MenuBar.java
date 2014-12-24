package view;

import java.awt.FlowLayout;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class MenuBar extends JPanel {
	
	// VARIABLES
	
	private final MyButton newGame = new MyButton("new game");
	private final MyButton pause = new MyButton("pause");
	private final MyButton reset = new MyButton("reset");
	
	// CONSTRUCTOR
	
	public MenuBar() {
		this.setLayout(new FlowLayout());
		this.add(newGame);
		this.add(pause);
		this.add(reset);	
	}
	
	// GETTERS 
	
}
