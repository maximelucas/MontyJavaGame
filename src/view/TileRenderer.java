package view;

import java.awt.Color;
import java.awt.Insets;

import javax.swing.ImageIcon;
import javax.swing.JButton;

@SuppressWarnings("serial")
public class TileRenderer extends JButton {
	
	
	// VARIABLES
	 
	int TILE_SIZE;
	Color color = new Color(20, 20, 40);
	ImageIcon icon;
	
	// CONSTRUCTOR
	
	public TileRenderer() {
		this.setMargin(new Insets(0,0,0,0));
		this.setBackground(color);
	}
	
	public TileRenderer(String text) {
		super(text);
		this.setMargin(new Insets(0,0,0,0));
		this.setBackground(color);
	}
	
	
	public TileRenderer(Color color) {
		this.setMargin(new Insets(0,0,0,0));
		this.setBackground(color);
	}
	
	// METHODS 

	public void draw(Color color, ImageIcon icon) {
		this.setBackground(color);
		if (icon != null) {
			this.setIcon(icon);
		}
	}
	
	public void redraw(ImageIcon icon) {
		this.setIcon(icon);
	}
	
	
	// GETTERS
	
	// SETTERS 
	
	
}
