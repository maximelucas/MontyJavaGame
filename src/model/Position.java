package model;

public class Position {
	
	// VARIABLES
	int x;
	int y;
	
	// CONSTRUCTOR
	public Position(int x, int y) {
		this.x = x;
		this.y = y;
	}

	// METHODS 
	public void add(int dx, int dy) {
		x += dx;
		y += dy;
	}
	
	
	public Position plus(int x2, int y2) {
		int finalX = x + x2;
		int finalY = y + y2;
		return (new Position(finalX, finalY));
	}
	
	public Position plus(Position position2) {
		int x2 = position2.getX();
		int y2 = position2.getY();
		int finalX = x + x2;
		int finalY = y + y2;
		return (new Position(finalX, finalY));
	}
	
	public Position minus(Position position2) {
		int x2 = position2.getX();
		int y2 = position2.getY();
		int finalX = x - x2;
		int finalY = y - y2;
		return (new Position(finalX, finalY));
	}
	
	public void reverse() {
		x = -x;
		y = -y;
	}
	
	public Position differenceVector(Position destination) {
		Position result = this.minus(destination);
		result.reverse();
		return result;
	}
	
	
	
	public boolean equals(Position position2) {
		return (x == position2.getX()
				&& y == position2.getY());
	}
	
	
	// GETTERS
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	// SETTERS 
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
	
	public String toString() {
		return "["+x+","+y+"]";
	}
}
