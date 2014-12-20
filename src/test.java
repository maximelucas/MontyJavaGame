import model.*;

public class test {

	public static void main(String[] args) {
		Player fred = new Player(5,3,6);
		System.out.print(fred.getXPosition());
		System.out.print(fred.getPosition().getX());
		Tile tile = new Tile("test");
		System.out.print(tile.getTerrain());
		System.out.print(tile.getOpponent());


	}

}
