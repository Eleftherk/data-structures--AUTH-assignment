package ergasia1;

import java.util.ArrayList;

//class HeuristicPlayer contains everything we need to create a smarter played (methods we need for his actions and an array list with some info we need about his mooves)
//this class inherits class player
public class HeuristicPlayer extends Player {
	ArrayList<Integer[]> path;
	// a constructor where we create a HeuristicPlayer 
	public HeuristicPlayer(){
		super();
		path = new ArrayList<Integer[]>();
	}
	// a constructor where we create a HeuristicPlayer with his characteristics given 
	public HeuristicPlayer(int playerId, String name, Board board, int score, int x, int y){
		super(playerId, name, board, score, x, y);
		path = new ArrayList<Integer[]>();
	}
	//in this method we evaluate the move for the given dice for the given position 
	public double evaluate(int currentPos, int dice,int minotaurtileid) {
		double points;
		double m=0, s=0;
		if(dice == 1) {
			if(board.getTiles()[currentPos].getUp() == false ) {
				if (minotaurtileid - currentPos == board.getN()) {
					m = -1;
				}
				for(int i=0; i<board.getS();i++) {
					if(board.getSupplies()[i].getsupplyTileId() - currentPos == board.getN()) {
						s+=1;
						break;
					}
				}
				if (board.getTiles()[currentPos + board.getN()].getUp() == false ) {
					if(minotaurtileid - currentPos == 2*board.getN()) {
						m = -0.5;
					}
					for(int i=0; i<board.getS();i++) {
						if(board.getSupplies()[i].getsupplyTileId() - currentPos == 2*board.getN()) {
							s+=0.5;
							break;
						}
					}
					if(board.getTiles()[currentPos + 2*board.getN()].getUp() == false) {
						if (minotaurtileid - currentPos == 3*board.getN()) {
							m = -0.3;
						}
						for(int i=0; i<board.getS();i++) {
							if(board.getSupplies()[i].getsupplyTileId() - currentPos == 3*board.getN()) {
								s+=0.3;
								break;
							}
						}
					}
				}
				
			}
		}
		else if(dice == 3) {
			if(board.getTiles()[currentPos].getRight() == false ) {
				if (minotaurtileid - currentPos == 1) {
					m = -1;
				}
				for(int i=0; i<board.getS();i++) {
					if(board.getSupplies()[i].getsupplyTileId() - currentPos == 1) {
						s+=1;
						break;
					}
				}
				if (board.getTiles()[currentPos + 1].getRight() == false ) {
					if(minotaurtileid - currentPos == 2) {
						m = -0.5;
					}
					for(int i=0; i<board.getS();i++) {
						if(board.getSupplies()[i].getsupplyTileId() - currentPos == 2) {
							s+=0.5;
							break;
						}
					}
					if(board.getTiles()[currentPos + 2].getRight() == false) {
						if (minotaurtileid - currentPos == 3) {
							m = -0.3;
						}
						for(int i=0; i<board.getS();i++) {
							if(board.getSupplies()[i].getsupplyTileId() - currentPos == 3) {
								s+=0.3;
								break;
							}
						}
					}
				}
				
			}
			
		}
		else if(dice == 5) {
			if(board.getTiles()[currentPos].getDown() == false ) {
				if (minotaurtileid - currentPos == -board.getN()) {
					m = -1;
				}
				for(int i=0; i<board.getS();i++) {
					if(board.getSupplies()[i].getsupplyTileId() - currentPos == -board.getN()) {
						s+=1;
						break;
					}
				}
				if (board.getTiles()[currentPos - board.getN()].getDown() == false ) {
					if(minotaurtileid - currentPos == -2*board.getN()) {
						m = -0.5;
					}
					for(int i=0; i<board.getS();i++) {
						if(board.getSupplies()[i].getsupplyTileId() - currentPos == -2*board.getN()) {
							s+=0.5;
							break;
						}
					}
					if(board.getTiles()[currentPos - 2*board.getN()].getDown() == false) {
						if (minotaurtileid - currentPos == -3*board.getN()) {
							m = -0.3;
						}
						for(int i=0; i<board.getS();i++) {
							if(board.getSupplies()[i].getsupplyTileId() - currentPos == -3*board.getN()) {
								s+=0.3;
								break;
							}
						}
					}
				}
				
			}
			
		}
		else if(dice == 7) {
			if(board.getTiles()[currentPos].getLeft() == false ) {
				if (minotaurtileid - currentPos == -1) {
					m = -1;
				}
				for(int i=0; i<board.getS();i++) {
					if(board.getSupplies()[i].getsupplyTileId() - currentPos == -1) {
						s+=1;
						break;
					}
				}
				if (board.getTiles()[currentPos - 1].getLeft() == false ) {
					if(minotaurtileid - currentPos == -2) {
						m = -0.5;
					}
					for(int i=0; i<board.getS();i++) {
						if(board.getSupplies()[i].getsupplyTileId() - currentPos == -2) {
							s+=0.5;
							break;
						}
					}
					if(board.getTiles()[currentPos - 2].getLeft() == false) {
						if (minotaurtileid - currentPos == -3) {
							m = -0.3;
						}
						for(int i=0; i<board.getS();i++) {
							if(board.getSupplies()[i].getsupplyTileId() - currentPos == -3) {
								s+=0.3;
								break;
							}
						}
					}
				}
			}
		}
		points = s*0.46 + m*0.54;
		if (s==1 && m==1 && score==board.getS()-1) {
			points = 100;
		}
		
		if(dice == 0) {
			points = -100;
		}
		return points ;
	}
	//in this method we move the player in the best new position with the help of method evaluate and save some info in our array list 
	int getNextMove(int currentPos , int minotaurtileid){
		 double p[] = new double [8];
		 double eval[] = new double[4];
		 int j=0;
		 Integer k[]= new Integer [4];
		 p[0]=1;
		 p[1]=3;
		 p[2]=5;
		 p[3]=7;
		 if (currentPos==0) {
			 p[2]=0;
		 }
		 if (board.getTiles()[currentPos].getUp()) {
			 p[0] = 0;			 
		 }
		 
		 if (board.getTiles()[currentPos].getRight()) {
			 p[1] = 0;			 
		 }
		 
		 if (board.getTiles()[currentPos].getDown()) {
			 p[2] = 0;			 
		 }
		 
		 if (board.getTiles()[currentPos].getLeft()) {
			 p[3] = 0;			 
		 }
		 p[4]=evaluate(currentPos, (int)p[0], minotaurtileid);
		 p[5]=evaluate(currentPos, (int)p[1], minotaurtileid);
		 p[6]=evaluate(currentPos, (int)p[2], minotaurtileid);
		 p[7]=evaluate(currentPos, (int)p[3], minotaurtileid);
		
		 
		 for (int i=4;i<8;i++) {
			 eval[j]=p[i];
			 j++;
		 }
		 
		 for(int i=0;i<4;i++) {
			 for (j=i+1;j<4;j++) {
				 if(eval[i]<eval[j]) {
					 double temp = eval[i];
					 eval[i] = eval[j];
					 eval[j] = temp;
				 }
			 }
		 }
		
		 if(eval[0] != eval[1]) {
			 for(int i=4; i<8;i++) {
				 if (p[i] == eval[0]) {
					 j=i;
					 break;
				 }
			 }
			 
			 if ((int)p[j-4]==1) {
			 	x = x + 1;
			 }
			 if ((int)p[j-4]==3) {
				 y=y+1;
			 }
			 if ((int)p[j-4]==5) {
				 x=x-1;
			 }
			 if ((int)p[j-4]==7) {
				 y=y-1;
			 }
			 int tempscore = score;
			 for (int i=0;i<board.getS();i++) {
				 if(board.getSupplies()[i].getsupplyTileId() == x*board.getN()+y) {
					 score+=1;
					 board.getSupplies()[i].set(-10);
					 board.getSupplies()[i].setx(-10);
					 board.getSupplies()[i].sety(-10);
				 }
			 }
			 
			 k[0] =(int) p[j-4];
			 if(score - tempscore == 1) {
				 k[1]=1;
				 
			 }
			 else 
			 k[1]= 0;
			
			 
			 
		 }
		 else if (eval[0]==eval[1] && eval[0]==eval[2] && eval[0]==eval[3]) { 
			 int a = (int)(Math.random() * 4);	
			 if ((int)p[a]==1) {
				x = x + 1;
			 }
			 if ((int)p[a]==3) {
				 y=y+1;
			 }
			 if ((int)p[a]==5) {
				 x=x-1;
			 }
			 if ((int)p[a]==7) {
				 y=y-1;
			 }
			 
			
			 k[0]=(int)p[a];
			 int tempscore = score;
			 for (int i=0;i<board.getS();i++) {
				 if(board.getSupplies()[i].getsupplyTileId() == x*board.getN()+y) {
					 score+=1;
					 board.getSupplies()[i].set(-10);
					 board.getSupplies()[i].setx(-10);
					 board.getSupplies()[i].sety(-10);
				 }
			 }
			 if(score - tempscore == 1) {
				 k[1]=1;
			 }
			 else 
			 k[1]= 0;
		 }
		 else if(eval[0]==eval[1] && eval[0]==eval[2] ) {
			 for (int i=4;i<8;i++) {
				 if (eval[3]==p[i]) {
					 j=i;
					 break;
				 }
			 }
			 
			 int a=0;
			 while (true) {
				a = (int)(Math.random() * 4);
				if(a!=j-4) {
					break;
				}
			 }
			 if ((int)p[a]==1) {
				 x = x + 1;
			}
			 if ((int)p[a]==3) {
				 y=y+1;
			 }
			 if ((int)p[a]==5) {
				 x=x-1;
			 }
			 if ((int)p[a]==7) {
				 y=y-1;
			 } 
		 
		
			 k[0]=(int)p[a];
			 int tempscore = score;
			 for (int i=0;i<board.getS();i++) {
				 if(board.getSupplies()[i].getsupplyTileId() == x*board.getN()+y) {
					 score+=1;
					 board.getSupplies()[i].set(-10);
					 board.getSupplies()[i].setx(-10);
					 board.getSupplies()[i].sety(-10);
				 }
			 }
			 if(score - tempscore == 1) {
				 k[1]=1;
			 }
			 else 
			 k[1]= 0;
		 }
		 else if(eval[0]==eval[1] ) {
			 
			 int z=0,a=0;
			 for (int i=4;i<8;i++) {
				 if (eval[2]==p[i] && z==0) {
					 z=i;
				 }
				 if (eval[3]==p[i]) {
					 j=i;
				 }
			 }
			 while (true) {
					a = (int)(Math.random() * 4);
					if(a!=j-4 && a!=z-4) {
						break;
					}
				 }
				 if ((int)p[a]==1) {
					 x = x + 1;
				}
				 if ((int)p[a]==3) {
					 y=y+1;
				 }
				 if ((int)p[a]==5) {
					 x=x-1;
				 }
				 if ((int)p[a]==7) {
					 y=y-1;
				 } 
				
				 
				 k[0]=(int)p[a];
				 int tempscore = score;
				 for (int i=0;i<board.getS();i++) {
					 if(board.getSupplies()[i].getsupplyTileId() == x*board.getN()+y) {
						 score+=1;
						 board.getSupplies()[i].set(-10);
						 board.getSupplies()[i].setx(-10);
						 board.getSupplies()[i].sety(-10);
					 }
				 }
				 if(score - tempscore == 1) {
					 k[1]=1;
				 }
				 else 
				 k[1]= 0;
				
				 
				 
		 }
		 int l=10;
		 int n=-1;
		 int m=x*board.getN()+y;
		 
		 if (minotaurtileid-m==1) {
			 if(board.getTiles()[m].getRight()==false) {
				 n=1;
			 }
		 }
		 
		 else if (minotaurtileid-m==board.getN()) {
			 if(board.getTiles()[m].getUp()==false) {
				 n=1;
			 }
		 }
		 
		 else if (minotaurtileid-m==-1) {
			 if(board.getTiles()[m].getLeft()==false) {
				 n=1;
			 }
		 }
		 else if (minotaurtileid-m==-board.getN()) {
			 if(board.getTiles()[m].getDown()==false) {
				 n=1;
			 }
		 }
		 
		 else if (minotaurtileid-m==2) {
			 if(board.getTiles()[m].getRight()==false) {
				 if(board.getTiles()[m+1].getRight()==false) {
					 n=2;
				 }
			 }
		 }
		 
		 else if (minotaurtileid-m==2*board.getN()) {
			 if(board.getTiles()[m].getUp()==false) {
				 if(board.getTiles()[m+board.getN()].getUp()==false) {
					 n=2;				 }
			 }
		 }
		 
		 else if (minotaurtileid-m==-2) {
			 if(board.getTiles()[m].getLeft()==false) {
				 if(board.getTiles()[m-1].getLeft()==false) {
					 n=2;
				 }
			 }
		 }
		 
		 else if (minotaurtileid-m==-2*board.getN()) {
			 if(board.getTiles()[m].getDown()==false) {
				 if(board.getTiles()[m-board.getN()].getDown()==false) {
					 n=2;
				 }
			 }
		 }
		 else if (minotaurtileid-m==3) {
			 if(board.getTiles()[m].getRight()==false) {
				 if(board.getTiles()[m+1].getRight()==false) {
					 if(board.getTiles()[m+2].getRight()==false) {
						 n=3;
					 }
				 }
			 }
		 }
		 
		 else if (minotaurtileid-m==3*board.getN()) {
			 if(board.getTiles()[m].getUp()==false) {
				 if(board.getTiles()[m+board.getN()].getUp()==false) {
					 if(board.getTiles()[m+2*board.getN()].getUp()==false) {
						 n=3;
					 }
				 }
			 }
		 }
		 
		 else if (minotaurtileid-m==-3) {
			 if(board.getTiles()[m].getLeft()==false) {
				 if(board.getTiles()[m-1].getLeft()==false) {
					 if(board.getTiles()[m-2].getLeft()==false) {
						 n=3;
					 }
				 }
			 }
		 }
		 else if (minotaurtileid-m==-3*board.getN()) {
			 if(board.getTiles()[m].getDown()==false) {
				 if(board.getTiles()[m-board.getN()].getDown()==false) {
					 if(board.getTiles()[m-2*board.getN()].getDown()==false) {
						 n=3;
					 }
				 }
			 }
		 }
		 k[3]=n;
		 
		 
		 for(int i=0; i<board.getS();i++) {
			 
			 if (board.getSupplies()[i].getsupplyTileId()-m==1) {
				 if(board.getTiles()[m].getRight()==false) {
					 l=1;
					 break;
				 }
			 }
			 
			 else if (board.getSupplies()[i].getsupplyTileId()-m==board.getN()) {
				 if(board.getTiles()[m].getUp()==false) {
					 l=1;
					 break;
				 }
			 }
			 
			 else if (board.getSupplies()[i].getsupplyTileId()-m==-1) {
				 if(board.getTiles()[m].getLeft()==false) {
					 l=1;
					 break;
				 }
			 }
			 else if (board.getSupplies()[i].getsupplyTileId()-m==-board.getN()) {
				 if(board.getTiles()[m].getDown()==false) {
					 l=1;
					 break;
				 }
			 }
			 
			 else if (board.getSupplies()[i].getsupplyTileId()-m==2 && l>2) {
				 if(board.getTiles()[m].getRight()==false) {
					 if(board.getTiles()[m+1].getRight()==false) {
						 l=2;
					 }
				 }
			 }
			 
			 else if (board.getSupplies()[i].getsupplyTileId()-m==2*board.getN() && l>2) {
				 if(board.getTiles()[m].getUp()==false) {
					 if(board.getTiles()[m+board.getN()].getUp()==false) {
						 l=2;				 }
				 }
			 }
			 
			 else if (board.getSupplies()[i].getsupplyTileId()-m==-2 && l>2) {
				 if(board.getTiles()[m].getLeft()==false) {
					 if(board.getTiles()[m-1].getLeft()==false) {
						 l=2;
					 }
				 }
			 }
			 
			 else if (board.getSupplies()[i].getsupplyTileId()-m==-2*board.getN() && l>2) {
				 if(board.getTiles()[m].getDown()==false) {
					 if(board.getTiles()[m-board.getN()].getDown()==false) {
						 l=2;
					 }
				 }
			 }
			 
			 else if (board.getSupplies()[i].getsupplyTileId()-m==3 && l>3) {
				 if(board.getTiles()[m].getRight()==false) {
					 if(board.getTiles()[m+1].getRight()==false) {
						 if(board.getTiles()[m+2].getRight()==false) {
							 l=3;
						 }
					 }
				 }
			 }
			 
			 else if (board.getSupplies()[i].getsupplyTileId()-m==3*board.getN() && l>3) {
				 if(board.getTiles()[m].getUp()==false) {
					 if(board.getTiles()[m+board.getN()].getUp()==false) {
						 if(board.getTiles()[m+2*board.getN()].getUp()==false) {
							 l=3;
						 }
					 }
				 }
			 }
			 
			 else if (board.getSupplies()[i].getsupplyTileId()-m==-3 && l>3) {
				 if(board.getTiles()[m].getLeft()==false) {
					 if(board.getTiles()[m-1].getLeft()==false) {
						 if(board.getTiles()[m-2].getLeft()==false) {
							 l=3;
						 }
					 }
				 }
			 }
			 else if (board.getSupplies()[i].getsupplyTileId()-m==-3*board.getN()&&l>3) {
				 if(board.getTiles()[m].getDown()==false) {
					 if(board.getTiles()[m-board.getN()].getDown()==false) {
						 if(board.getTiles()[m-2*board.getN()].getDown()==false) {
							 l=3;
						 }
					 }
				 }
			 }
			 	 
		 }
		 
		 if(l==10) {
			 l=-1;
		 }
		 k[2]=l;
		 
		 path.add(k);
		 return (m);
	}
	//in this method we print all the informations about the last move of our player (it's an extra method)
	public void stat() {
		int a=path.size();		
			System.out.println("Theseus set the dice "+path.get(a-1)[0]+" in round "+a+".");
			System.out.println("Theseus have "+score +" supplies.");
			if (path.get(a-1)[2]!=-1) {
				System.out.println("He is "+ path.get(a-1)[2]+" tiles away from a supply.");	
			}
			else 
				System.out.println("There isn't any supply near");
			if (path.get(a-1)[3]!=-1) {
				System.out.println("He is "+ path.get(a-1)[3]+" tiles away from minotaur.");
			}
			else 
				System.out.println("There isn't minotaur near");	
	}
	//in this method we print informations about player's move for every round and statistics about his moves in the whole game   
	public void statistics() {
		int a=path.size();
		int u=0,d=0,r=0,l=0;
		for (int i=0;i<a;i++) {
			
			System.out.println("Round "+(i+1));
			System.out.println("Theseus set the dice "+path.get(i)[0]+" in round "+i+".");
			System.out.println("Theseus have "+score +" supplies.");
			if (path.get(i)[2]!=-1) {
				System.out.println("He is "+ path.get(i)[2]+" tiles away from a supply.");	
			}
			else 
				System.out.println("There isn't any supply near");
			if (path.get(i)[3]!=-1) {
				System.out.println("He is "+ path.get(i)[3]+" tiles away from minotaur.");
			}
			else 
				System.out.println("There isn't minotaur near");
			System.out.println(" ");
			
			if (path.get(i)[0]==1) {
				u++;
			}
			if (path.get(i)[0]==3) {
				r++;
			}
			if (path.get(i)[0]==5) {
				d++;
			}
			if (path.get(i)[0]==7) {
				l++;
			}
			
		}
		System.out.println("Theseus mooved up "+ u + " times.");
		System.out.println("Theseus mooved right "+ r + " times.");
		System.out.println("Theseus mooved down "+ d + " times.");
		System.out.println("Theseus mooved left "+ l + " times.");
		System.out.println("Theseus took "+ score +" supplies.");
		System.out.println(" ");
	}

		
	
	
	
}
