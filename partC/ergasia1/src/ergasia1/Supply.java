package ergasia1;
/*
 class of supplies 
 here we have all the data we need to identify each supply and methods we need 
 to create it and to know its characteristics 
 */
public class Supply {
	int supplyId;
	int x;
	int y;
	int supplyTileId;
	
	public Supply () {
		supplyId = 0;
		x = 0;
		y = 0;
		supplyTileId = 0;
	}
	//constructor where we create a supply same as the other supply given
	public Supply (Supply supply) {
		supplyId = supply.getsupplyId();
		x = supply.getx();
		y = supply.gety();
		supplyTileId = supply.getsupplyTileId();
	}
	//constructor which creates a supply with its id, x, y, id of his tile given
	public Supply (int supplyId, int x, int y, int supplyTileId) {
		this.supplyId = supplyId;
		this.x = x;
		this.y = y;
		this.supplyTileId = supplyTileId;
	}


	public int getsupplyId() {
		return supplyId;
	}
	public int getx() {
		return x;
	}
	public int gety() {
		return y;
	}
	public int getsupplyTileId() {
		return supplyTileId;
	}
	public void setsupplyId(int supplyId) {
		this.supplyId = supplyId;
	}
	public void setx(int x) {
		this.x = x;
	}
	public void sety(int y) {
		this.y = y;
	}
	public void set(int supplyTileId) {
		this.supplyTileId = supplyTileId;
	}
	
}
