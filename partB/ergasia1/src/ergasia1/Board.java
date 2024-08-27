package ergasia1;
/*
 here we have a class which includes all the methods about the board of the game along with its characteristics (N=dimensions of board,
 S=number of supplies, W=max number of walls, tiles= array with the tiles of the board, supplies= array with the 
 supplies of the board )
 */
public class Board {
	int N;
	int S;
	int W;
	Tile[] tiles;
	Supply[] supplies;

	public Board() {
		N = 0;
		S = 0;
		W = 0;
		tiles = new Tile[N*N];
		supplies = new Supply[S];
	}
	//constructor which creates a board with its dimensions , number of supplies and number of walls given
	public Board(int N, int S, int W) {
		this.N = N;
		this.S = S;
		this.W = W;
		tiles = new Tile[N*N];
		supplies = new Supply[S];
	}
	//constructor which creates a board same as the other board given
	public Board(Board board) {
		this.N = board.getN();
		this.S = board.getS();
		this.W = board.getW();
		this.tiles = board.getTiles();
		this.supplies = board.getSupplies();
	}

	public int getN() {
		return N;
	}

	public void setN(int n) {
		N = n;
	}

	public int getS() {
		return S;
	}

	public void setS(int s) {
		S = s;
	}

	public int getW() {
		return W;
	}

	public void setW(int w) {
		W = w;
	}

	public Tile[] getTiles() {
		return tiles;
	}

	public void setTiles(Tile[] tiles) {
		this.tiles = tiles;
	}

	public Supply[] getSupplies() {
		return supplies;
	}

	public void setSupplies(Supply[] supplies) {
		this.supplies = supplies;
	}
	
	/*
	 here we create the tiles of the array tiles.Every tile gets his characteristics (id,x,y)and 
	 his walls randomly.
	 We start by creating an array with tiles in which there aren't any wall.
	 After this we add walls on the tiles on the corners of the board
	 and the external walls.
	 On the next step we add walls  
	 randomly on the internal tiles
	 numofw is the number of walls we have already added 
	 o is a counter which helps us count how many walls every tile has 
	 */
	public void createTile() {
		int k=0;
		for (int i = 0; i<N; i++ ) {
			for (int j=0; j<N; j++ ) {
				boolean up=false;
				boolean down=false;
				boolean left=false;
				boolean right=false;
				tiles[k] = new Tile ( k, i, j, up, down, left, right);
				
				k++;
			}
		}
		int numofw=0;
		tiles[0].setLeft(true);
		tiles[N-1].setDown(true);
		tiles[N-1].setRight(true);
		tiles[N*(N-1)].setLeft(true);
		tiles[N*(N-1)].setUp(true);
		tiles[N*(N-1)+N-1].setRight(true);
		tiles[N*(N-1)+N-1].setUp(true);
		numofw=7;
		for(int i=1;i<N-1;i++) {
			tiles[i].setDown(true);
			numofw++;
		}
		for(int i=(N-1)*N+1;i<N*N-1;i++) {
			tiles[i].setUp(true);
			numofw++;			
		}
		for(int i=N;i<N*(N-1);i=i+N) {
			tiles[i].setLeft(true);
			numofw++;
		}
		for(int i=2*N-1;i<N*N-1;i=i+N) {
			tiles[i].setRight(true);
			numofw++;				
		}
		
		if(numofw<W-1) {
			for(int i=1;i<N-1;i++) {
				while(true) {
					if(numofw<W-1) {	
						tiles[i].setUp(Math.random()<0.5);
						tiles[i].setRight(Math.random()<0.5);
						tiles[i].setLeft(tiles[i-1].getRight());
						tiles[i+N].setDown(tiles[i].getUp());
						if (i==N-2) {
							tiles[i].setRight(false);
						}
						if(tiles[i].getUp()==false && tiles[i].getLeft()==false && tiles[i].getRight()==false) {
							break;
						}
						if(tiles[i].getUp() && tiles[i].getLeft()==false && tiles[i].getRight()==false) {
							numofw= numofw+2;
							break;
						}
						if(tiles[i].getUp()==false && tiles[i].getLeft() && tiles[i].getRight()==false) {
							numofw++;
							break;
						}
						if(tiles[i].getUp()==false && tiles[i].getLeft()==false && tiles[i].getRight()) {
							numofw++;
							break;
						}
					}
					else break;
			
				}
			}
		}
		if(numofw<W-1) {
			for(int i=(N-1)*N+1;i<N*N-1;i++) {
				while(true) {
					if(numofw<W-1) {
							tiles[i].setDown(Math.random()<0.5);
							tiles[i].setRight(Math.random()<0.5);
							tiles[i].setLeft(tiles[i-1].getRight());
							tiles[i-N].setUp(tiles[i].getDown());
							if (i==N*N-2) {
								tiles[i].setRight(false);
							}
							if(tiles[i].getDown()==false && tiles[i].getLeft()==false && tiles[i].getRight()==false) {
								break;
							}
							if(tiles[i].getDown() && tiles[i].getLeft()==false && tiles[i].getRight()==false) {
								numofw=numofw+2;
								break;
							}
							if(tiles[i].getDown()==false && tiles[i].getLeft() && tiles[i].getRight()==false) {
								numofw++;
								break;
							}
							if(tiles[i].getDown()==false && tiles[i].getLeft()==false && tiles[i].getRight()) {
								numofw++;
								break;
							}
					}
					else break;
				}
				
			}
		}
		if(numofw<W-1) {
			for(int i=N;i<N*(N-1);i=i+N) {
				while(true) {
					if(numofw<W-1) {
						tiles[i].setUp(Math.random()<0.5);
						tiles[i].setDown(tiles[i-N].getUp());
						tiles[i].setRight(Math.random()<0.5);
						tiles[i+1].setLeft(tiles[i].getRight());
						if (i==N*(N-2)) {
							tiles[i].setUp(false);
						}
						if(tiles[i].getDown()==false && tiles[i].getUp()==false && tiles[i].getRight()==false) {
							break;
						}
						if(tiles[i].getDown() && tiles[i].getUp()==false && tiles[i].getRight()==false) {
							numofw++;
							break;
						}
						if(tiles[i].getDown()==false && tiles[i].getUp() && tiles[i].getRight()==false) {
							numofw++;
							break;
						}
						if(tiles[i].getDown()==false && tiles[i].getUp()==false && tiles[i].getRight()) {
							numofw=numofw+2;
							break;
						}
					}
					else break;
				}
						
			}
		}
		if(numofw<W-1) {
			for(int i=2*N-1;i<N*N-1;i=i+N) {
				while(true) {
					if(numofw<W-1) {
						tiles[i].setUp(Math.random()<0.5);
						tiles[i].setDown(tiles[i-N].getUp());
						tiles[i].setLeft(Math.random()<0.5);
						tiles[i-1].setRight(tiles[i].getLeft());
						if (i==N*(N-1)-1) {
							tiles[i].setUp(false);
						}
						if(tiles[i].getDown()==false && tiles[i].getUp()==false && tiles[i].getLeft()==false) {
							break;
						}
						if(tiles[i].getDown() && tiles[i].getUp()==false && tiles[i].getLeft()==false) {
							numofw++;
							break;
						}
						if(tiles[i].getDown()==false && tiles[i].getUp() && tiles[i].getLeft()==false) {
							numofw++;
							break;
						}
						if(tiles[i].getDown()==false && tiles[i].getUp()==false && tiles[i].getLeft()) {
							numofw=numofw+2;
							break;
						}
					}
					else break;
				}
						
			}
	}
		while(true) {
			int x=(int)(Math.random()*(N-2)+1);
			int y=(int)(Math.random()*(N-2)+1);
			//tiles[x*N+y]
			boolean u=tiles[x*N+y].getUp(),d=tiles[x*N+y].getDown(),l=tiles[x*N+y].getLeft(),r=tiles[x*N+y].getRight();
			if(numofw<W-1&&(u==false&&d&&l==false&&r==false) || (u==false&&d==false&&l&&r==false)||(u==false&&d==false&&l==false&&r)||(u==false&&d==false&&l==false&&r==false)||((u&&d==false&&l==false&&r==false)) ) {
				
				Tile pu=tiles[x*N+y+N];
				Tile pd=tiles[x*N+y-N];
				Tile pr=tiles[(x*N)+y+1];
				Tile pl=tiles[(x*N)+y-1];
					int o=0;
					if (u) {
						o++;
					}
					if(d) {
						o++;
					}
					if(l) {
						o++;
					}
					if(r) {
						o++;
					}
					if(numofw<W-2&&o<2&&u==false&&((pu.getLeft()==false&&pu.getRight()==false)||(pu.getLeft()==false&&pu.getUp()==false)||(pu.getRight()==false&&pu.getUp()==false))) {
						tiles[x*N+y].setUp(Math.random()<0.5);
						tiles[x*N+y+N].setDown(tiles[x*N+y].getUp());
						if(tiles[x*N+y].getUp()) {
							o++;
							numofw=numofw+2;
						}
					}
					if(numofw<W-2&&o<2&&d==false&&((pd.getLeft()==false&&pd.getRight()==false)||(pd.getLeft()==false&&pd.getDown()==false)||(pd.getRight()==false&&pd.getDown()==false))) {
						tiles[x*N+y].setDown(Math.random()<0.5);
						tiles[x*N+y-N].setUp(tiles[x*N+y].getDown());
						if(tiles[x*N+y].getDown()) {	
							o++;
							numofw=numofw+2;
						}
					}
					
					if(numofw<W-2&&o<2&&l==false&&((pl.getLeft()==false&&pl.getUp()==false)||(pl.getLeft()==false&&pl.getDown()==false)||(pl.getUp()==false&&pl.getDown()==false))) {
						tiles[x*N+y].setLeft(Math.random()<0.5);
						tiles[x*N+y-1].setRight(tiles[x*N+y].getLeft());
						if(tiles[x*N+y].getLeft()) {
							o++;
							numofw=numofw+2;
						}
					}
					if(numofw<W-2&&o<2&&r==false&&((pr.getRight()==false&&pr.getUp()==false)||(pr.getRight()==false&&pr.getDown()==false)||(pr.getUp()==false&&pr.getDown()==false))) {
						tiles[x*N+y].setRight(Math.random()<0.5);
						tiles[x*N+y+1].setLeft(tiles[x*N+y].getRight());
						if (tiles[x*N+y].getRight()) {
							o++;
							numofw=numofw+2;
						}
					
						
					
				}
					if (numofw>=W-2) {
						break;
					}
			}
		}
	}
	
	/*
	  here we create supplies of the array "supplies"
	  we put x and y (positions on the board) randomly so that every supply is on a 
	  different tile with other supplies and the initial positions of the players 
	  t helps us know if the supply can't be on the place we have randomly chosen  
	 */
	
	public void createSupply() {
		for (int i = 0; i < S; i++) {
			
			
			int x=0,y=0;
			while ( true ) {
				boolean t = true;
				y = (int)(Math.random()*N);
				x = (int)(Math.random()*N);
				supplies[i]=new Supply(i, x , y,x * N + y);
				for (int j=0; j<i; j++) {
					
					if (supplies[i].getsupplyTileId() == supplies[j].getsupplyTileId() ) {
						t = false ; 
					}
				}
				if (supplies[i].getsupplyTileId() == 0 || supplies[i].getsupplyTileId() == (( N*N -1)/2 )) {
					t = false;					
				}
				
				if (t) {
					break;
				}
			}
			
	
		}
				
	}
	
	//here we create the board with the two other methods to create tiles and supplies randomly 
	public void createBoard() {
		
		createTile();
		createSupply();			
	}
	
	
	 /*
	  
	  here we create a array (2*N+1 x N)
	  in this array every odd line have the vertical walls and the player or/and the supply which is on that tile 
	  every even and zero line have the horizontal walls   
	  first we create the horizontal walls and after that all the other things we need
	  for the odd lines we check first if the tile which we represent has wall on the left 
	  and after that we check if it contains any player or/and (if player is minotaur) supply 
	  sup is true id there is supply on the tile we represent 
	  and id gets the id of that supply   
	   
	  */
	public String[][] getStringRepresentation(int theseusTile, int minotaurTile){
		
		String  st [][] = new String [2*N+1][N] ;
		
		
		for(int i=0;i<N;i++) {
			if (tiles[i].getDown()) {
				if(i==N-1) {
					st[0][i] ="+---+";
				}
				else {
					st[0][i] ="+---";
			
				}
			}
			else {
				st[0][i] ="+   ";
			}
		}
		int k=0;
		for (int i=2;i<2*N+1;i=i+2) {
			
			for (int j=0;j<N;j++) {
				
				if(tiles[k].getUp()) {
					if (j==N-1) {
						st[i][j] ="+---+";
					}
					else {
						st[i][j] ="+---";
					}
				}
				else {
					if (j==N-1) {
						st[i][j] ="+   +";
					}
					else {
						st[i][j] ="+   ";
					}
				}
				k++;
			}
			
			
		}
		k=0;
		for (int i=1;i<2*N+1;i=i+2) {
			for (int j=0;j<N;j++) {
				if(tiles[k].getLeft()) {
					if (theseusTile==tiles[k].getTileId()) {
						if (j==N-1) {
							st[i][j] ="| T |";
						}
						else {
							st[i][j] ="| T ";
						}
					}
					else if(minotaurTile==tiles[k].getTileId()) {
						boolean sup=false;
						int id=-1;
						for (int m=0;m<S;m++) {
							if(supplies[m].getsupplyTileId()==tiles[k].getTileId()) {
								sup=true;
								id=supplies[m].getsupplyId();							}
						}
						if (sup) {
							if (j==N-1) {
								st[i][j] ="|MS"+(id+1)+"|";
							}
							else {
								st[i][j] ="|MS"+(id+1);
							}
						}
						else if (j==N-1) {
							st[i][j] ="| M |";
						}
						else {
							st[i][j] ="| M ";
						}
					}
					
					else {
						boolean sup=false;
						int id=-1;
						for (int m=0;m<S;m++) {
							if(supplies[m].getsupplyTileId()==tiles[k].getTileId()) {
								sup=true;
								id=supplies[m].getsupplyId();							}
						}
						if (sup) {
							if (j==N-1) {
								st[i][j] ="| S"+(id+1)+"|";
							}
							else {
								st[i][j] ="| S"+(id+1);
							}
						}
						else {
							if (j==N-1) {
								st[i][j] ="|   |";
							}
							else {
								st[i][j] ="|   ";
							}
						}
						
					}
					
				}
				else {
					if (theseusTile==tiles[k].getTileId()) {
						if (j==N-1) {
							st[i][j] ="  T |";
						}
						else {
							st[i][j] ="  T ";
						}
					}
					else if(minotaurTile==tiles[k].getTileId()) {
						boolean sup=false;
						int id=-1;
						for (int m=0;m<S;m++) {
							if(supplies[m].getsupplyTileId()==tiles[k].getTileId()) {
								sup=true;
								id=supplies[m].getsupplyId();							}
						}
						if (sup) {
							if (j==N-1) {
								st[i][j] =" MS"+(id+1)+"|";
							}
							else {
								st[i][j] =" MS"+(id+1);
							}
						}
						
				
						else if (j==N-1) {
							st[i][j] ="  M |";
						}
						else {
							st[i][j] ="  M ";
						}
					}
					
					else {
						boolean sup=false;
						int id=-1;
						for (int m=0;m<S;m++) {
							if(supplies[m].getsupplyTileId()==tiles[k].getTileId()) {
								sup=true;
								id=supplies[m].getsupplyId();							}
						}
						if (sup) {
							if (j==N-1) {
								st[i][j] ="  S"+(id+1)+"|";
							}
							else {
								st[i][j] ="  S"+(id+1);
							}
						}
						else {
							if (j==N-1) {
								st[i][j] ="    |";
							}
							else {
								st[i][j] ="    ";
							}
						}
						
					}
				}
				k++;
			}
			
			
		}
		
		
	return st;	
	}
	
	}

