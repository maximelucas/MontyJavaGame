package view;

import java.awt.Font;

import javax.swing.JButton;

@SuppressWarnings("serial")
public class MyButton extends JButton{
	
	Font font = new Font("Helvetica", Font.PLAIN, 16);
	
	public MyButton(String text) {
		super(text);
		this.setFont(font);
		this.setBackground(MainWindow.color1);
		this.setForeground(MainWindow.color3);
		this.setFocusPainted(false);
		this.setActionCommand(text);
	}
	
}
