package model;

public class Position {
	
	int x;
	int y;
	
	public Position(int x, int y) {
		this.x = x;
		this.y = y;
	}

	/*
	 * return new instance which is the difference of two positions
	 */
	public Position plus(int x2, int y2) {
		int finalX = x + x2;
		int finalY = y + y2;
		return (new Position(finalX, finalY));
	}
	
	/*
	 * return new instance which is the sum of two positions
	 */
	public Position plus(Position position2) {
		int x2 = position2.getX();
		int y2 = position2.getY();
		int finalX = x + x2;
		int finalY = y + y2;
		return (new Position(finalX, finalY));
	}
	
	/*
	 * return new instance which is the difference of two positions
	 */
	public Position minus(Position position2) {
		int x2 = position2.getX();
		int y2 = position2.getY();
		int finalX = x - x2;
		int finalY = y - y2;
		return (new Position(finalX, finalY));
	}
	
	/*
	 * compute manhattan distance between two positions
	 */
	public static int manhattanDistance(Position pos1, Position pos2) {
		Position deltaPos = pos1.minus(pos2);
		int deltaX = deltaPos.getX();
		int deltaY = deltaPos.getY();
		return Math.abs(deltaX) + Math.abs(deltaY);
	}
	
	/*
	 * return true if positions are equal
	 */
	public boolean equals(Position position2) {
		return (x == position2.getX()
				&& y == position2.getY());
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public void setPosition(int newX, int newY) {
		x = newX;
		y = newY;
	}
	
	public void setX(int newX) {
		x = newX;
	}
	
	public void setY(int newY) {
		y = newY;
	}
}
