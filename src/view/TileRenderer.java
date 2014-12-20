package view;

import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JButton;

@SuppressWarnings("serial")
public class TileRenderer extends JButton {
	
	
	// VARIABLES
	 
	Color color = new Color(20, 20, 40);
	ImageIcon icon;
	
	// CONSTRUCTOR
	
	public TileRenderer() {
		
	}
	
	public TileRenderer(Color color) {
		this.setBackground(color);
	}
	
	// METHODS 

	public void draw(Color color, ImageIcon icon) {
		this.setBackground(color);
		this.setIcon(icon);
	}
	
	public void redraw(ImageIcon icon) {
		this.setIcon(icon);
	}
	
	
	// GETTERS
	
	// SETTERS 
	
	
}
