package view;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import model.Enemy;
import model.Helper;
import model.Position;
import model.Tile;
import model.Trophy;


@SuppressWarnings("serial")
public class TileRenderer extends JButton {
	
	public final int TILE_SIZE = 40; //in px
	public final Color grassGreen = new Color(25, 143, 37);
	public final Color roadGrey = new Color(119, 136, 153);
	private ImageIcon icon = new ImageIcon(""); // image of player or else
	
	public TileRenderer() {
		setBackground(grassGreen);
		setFocusable(false);
	}
	
	public TileRenderer(String terrain) {
		switch(terrain) {
		case "grass":
			setBackground(grassGreen);
			break;
		case "road":
			setBackground(roadGrey);
			break;
		default:
			;
		}
		this.setFocusable(false);
	}
	
	public void draw(Color color) {
		this.setBackground(color);
	}

	/*
	 * update tile display when needed
	 */
	public void update(Tile tile, Position position, Position activePosition, int scope) {
		Icons icons = new Icons();
		if (Position.manhattanDistance(position, activePosition) <= scope ) {
			if (tile.getPlayer()==null && tile.getOpponent()==null) {
				setIcon(icon);
			} else if (tile.getPlayer()!=null) {
				setIcon(icons.player);
			} else if (tile.getPlayer()==null && tile.getOpponent() instanceof Helper) {
				setIcon(icons.helper);
			} else if (tile.getPlayer()==null && tile.getOpponent() instanceof Enemy) {
				setIcon(icons.enemy);
			} else if (tile.getPlayer()==null && tile.getOpponent() instanceof Trophy) {
				setIcon(icons.trophy);
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
			this.setBackground(Color.black);
		}
	}
}
