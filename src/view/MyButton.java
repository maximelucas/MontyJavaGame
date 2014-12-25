package view;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;

@SuppressWarnings("serial")
public class MyButton extends JButton{
	
	Color colour1 = Color.blue;
	Color colour2 = Color.white;
	Font font = new Font("Helvetica", Font.PLAIN, 16);
	
	// CONSTRUCTOR
	
	public MyButton(String text) {
		super(text);
		this.setFont(font);
		this.setBackground(colour1);
		this.setForeground(colour2);
		this.setFocusPainted(false);
		this.setActionCommand(text);
	}
	
}
