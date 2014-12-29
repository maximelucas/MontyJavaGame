package view;

import java.awt.Color;
import java.awt.Insets;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import model.Enemy;
import model.Helper;
import model.Position;
import model.Tile;
import model.Trophy;


@SuppressWarnings("serial")
public class TileRenderer extends JButton {
	
	
	// VARIABLES
	 
	public final int TILE_SIZE = 40;
	public final Color grassGreen = new Color(25, 143, 37);
	public final Color roadGrey = new Color(119, 136, 153);
	private ImageIcon icon = new ImageIcon("");
	//private static Icons icons = new Icons();
	// CONSTRUCTOR
	
	public TileRenderer() {
		this.setMargin(new Insets(0,0,0,0));
		this.setBackground(grassGreen);
		this.setFocusable(false);
	}
	
	public TileRenderer(String text) {
		this.setMargin(new Insets(0,0,0,0));
		this.setBackground(grassGreen);
		this.setFocusable(false);
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
	
	public void update(Tile tile) {
		
		if (tile.getPlayer()==null && tile.getOpponent()==null) {
			this.setIcon(icon);
		} else if (tile.getPlayer()!=null) {
			this.setIcon(Icons.player);
		} else if (tile.getPlayer()==null && tile.getOpponent() instanceof Helper) {
			this.setIcon(Icons.helper);
		} else if (tile.getPlayer()==null && tile.getOpponent() instanceof Enemy) {
			this.setIcon(Icons.enemy);
		} else if (tile.getPlayer()==null && tile.getOpponent() instanceof Trophy) {
			this.setIcon(Icons.trophy);
		}
	}
		
	public void update(Tile tile, Position position, Position activePosition, int scope) {
		
		if (Position.manhattanDistance(position, activePosition) <= scope ) {
			//System.out.print(position);
			if (tile.getPlayer()==null && tile.getOpponent()==null) {
				this.setIcon(icon);
			} else if (tile.getPlayer()!=null) {
				this.setIcon(Icons.player);
			} else if (tile.getPlayer()==null && tile.getOpponent() instanceof Helper) {
				this.setIcon(Icons.helper);
			} else if (tile.getPlayer()==null && tile.getOpponent() instanceof Enemy) {
				this.setIcon(Icons.enemy);
			} else if (tile.getPlayer()==null && tile.getOpponent() instanceof Trophy) {
				this.setIcon(Icons.trophy);
			}
			switch(tile.getTerrain()) {
			case "grass": 
				this.setBackground(grassGreen);
				break;
			case "road":
				this.setBackground(roadGrey);
				break;
			default:
				;			
			}
		} else {
			//System.out.print("-");
			//System.out.print(position);

			this.setBackground(Color.black);
		}
	}
	
	
	// GETTERS
	
	// SETTERS 
	
	
}
