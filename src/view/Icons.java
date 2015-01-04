package view;

import javax.swing.ImageIcon;

public class Icons {
		
	public final static String imagesSrc = "/resources/";
	
	public final ImageIcon player = new ImageIcon(getClass().getResource(imagesSrc + "player.png"));
	public final ImageIcon helper = new ImageIcon(getClass().getResource(imagesSrc + "helper.png"));
	public final ImageIcon enemy = new ImageIcon(getClass().getResource(imagesSrc + "enemy.png"));
	public final ImageIcon trophy = new ImageIcon(getClass().getResource(imagesSrc + "trophy.png"));
	
}
