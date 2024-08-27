package ergasia1;
/*
 here we have a class where we have all the methods we need in the game about the players
 */
public class Player {

	int playerId;
	String name;
	Board board;
	int score;
	int x;
	int y;
	
	public Player(){
		playerId = 0;
		name = "   ";
		board.createBoard(); 
		score = 0;
		x = 0;
		y = 0;
	}
	//constructor which create player with his id, name, score, x,y and the board of the game given
	public Player(int playerId, String name, Board board, int score, int x, int y) {
		this.playerId = playerId;
		this.name = name;
		this.board = board; 
		this.score = score;
		this.x = x;
		this.y = y;
	}

	public int getPlayerId() {
		return playerId;
	}

	public void setPlayerId(int playerId) {
		this.playerId = playerId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Board getBoard() {
		return board;
	}

	public void setBoard(Board board) {
		this.board = board;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
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
	/*
	 in this method we create an array in which we put the id , x, y of the tile each player goes after his move 
	 and the id of the supply he takes (if there is a supply there)
	 in this method we choose randomly the move of each player and check if he can move.
	 also we check if there is any supply on the tile he goes. 	 
	 */
	public int[] move(int id) {
		Tile p[] =  board.getTiles();
		boolean u,d,l,r;
		int m[]=new int [4] ;
		int a = (int)(Math.random() * 4);
		u = p[id].getUp();
		d = p[id].getDown();
		l = p[id].getLeft();
		r = p[id].getRight();
		a=2*a+1;
		if (a==1) {
			if (u && playerId==1) {
				System.out.println("Theseus can't move!");
			}
			else if (u && playerId==2) {
				System.out.println("Minotaur can't move!");
			}
			else {
				x = x + 1;
			}
		}
		if(a==3) {
			if (r && playerId==1) {
				System.out.println("Theseus can't move!");
			}
			else if (r && playerId==2) {
				System.out.println("Minotaur can't move!");
			}
			else y=y+1;
			
		}
		if(a==5) {
			if (d && playerId==1) {
				System.out.println("Theseus can't move!");
			}
			else if (d && playerId==2) {
				System.out.println("Minotaur can't move!");
			}
			else { 
				if (x==0&&y==0) {
					if (playerId==1) {
						System.out.println("Theseus can't move!");
					}
					else if (playerId==2) {
						System.out.println("Minotaur can't move!");
					}
				}
				else {
					x=x-1;
				}
			}
		}
		if(a==7) {
			if (l && playerId==1) {
				System.out.println("Theseus can't move!");
			}
			else if (l && playerId==2) {
				System.out.println("Minotaur can't move!");
			}
			else y=y-1;
			
		}
		if (playerId==1 && x*board.getN()+y!=0 ) {
			for(int i=0; i<board.getS(); i++) {	
				if (x*board.getN()+y==board.getSupplies()[i].getsupplyTileId()) {
					System.out.println("Theseus took a new supply!");
					score++;
					board.getSupplies()[i].set(-1);
					board.getSupplies()[i].sety(-1);
					board.getSupplies()[i].setx(-1);
					m[3]=board.getSupplies()[i].getsupplyTileId();			}
			}
		}
		m[0]=x*board.getN()+y;
		m[1]=x;
		m[2]=y;
		
		return m;
		
	}	
	
	
	public int whereTo(int dice, int id) {
        int res = id;
        if (dice == 1 && board.getTiles()[id].up == false) {
            res = id + board.getN();
        }else if (dice == 3 && board.getTiles()[id].right == false) {
            res = id + 1;
        }else if (dice == 5 && board.getTiles()[id].down == false) {
            res = id - board.getN();
        }else if (dice == 7 && board.getTiles()[id].left == false) {
            res = id - 1;
        }else {
            System.out.println("The number of Dice is: " + dice + ". I can't move there is a wall blocking me");
        }
        return res;
    }

    int[] moven(int id,int pid, int dice) {
        int[] result = new int[4];
        for (int i = 0; i < result.length; i++) {
            result[i] = 0;
        }
        result[0] = whereTo(dice,id);
        for(int i = 0; i<board.getSupplies().length;i++) {
            if(board.getSupplies()[i].getsupplyTileId() == result[0]) {
                board.getSupplies()[i].set(-100);
                board.getSupplies()[i].setx(-100);
                board.getSupplies()[i].sety(-100);
                score = score + 1;
              
                result[3] = board.getSupplies()[i].getsupplyId();
            }
        }
       
        result[1] = result[0] / board.getN();
        result[2] = result[0] % board.getN();
        return result;
    }
		
}