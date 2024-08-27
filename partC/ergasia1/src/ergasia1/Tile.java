package ergasia1;
/*
 here we have a class where we have the characteristics of tiles ( id , x, y and walls ) and the methods we need
 to create the tile and know its characteristics 
 */
public class Tile {
	int tileId;
	int x;
	int y;
	boolean up;
	boolean down;
	boolean left;
	boolean right;
	
	public Tile () {
	tileId = 0;
	x = 0;
	y = 0;
	up = false;
	down = false;
	left = false;
	right = false;
	}
	//constructor which creates a tile with its id, x, y, walls given
	public Tile (int tileId, int x, int y, boolean up, boolean down, boolean left , boolean right ) {
		this.tileId = tileId;
		this.x = x;
		this.y = y;
		this.up = up;
		this.down = down;
		this.left = left;
		this.right = right;
		}
	//constructor which creates a tile same as the other tile given
	public Tile (Tile tile) {
		tileId = tile.getTileId();
		x = tile.getX();
		y = tile.getY();
		up = tile.getUp();
		down = tile.getDown();
		left = tile.getLeft();
		right = tile.getRight();
		}
	public int getTileId() {
		return tileId;
	}
	public void setTileId(int tileId) {
		this.tileId = tileId;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public boolean getUp() {
		return up;
	}
	public void setUp(boolean up) {
		this.up = up;
	}
	public boolean getDown() {
		return down;
	}
	public void setDown (boolean down) {
		this.down = down;
	}
	public boolean getLeft() {
		return left;
	}
	public void setLeft(boolean left) {
		this.left = left;
	}
	public boolean getRight() {
		return right;
	}
	public void setRight(boolean right) {
		this.right = right;
	}
	
}
