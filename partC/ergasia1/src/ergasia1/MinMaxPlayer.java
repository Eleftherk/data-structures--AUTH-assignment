package ergasia1;

import java.util.ArrayList;
/*this class have methods we need to create the three and choose the best move 
and create an max-min tree and contains an array list with some informations about the game 
*/
public class MinMaxPlayer extends Player{
	ArrayList<Integer[]> path;
	
	public MinMaxPlayer() {
		super();
		path=new ArrayList<Integer[]>();
	}

	public MinMaxPlayer(int playerId, String name, Board board, int score, int x, int y) {
		super(playerId, name, board, score, x, y);
		path=new ArrayList<Integer[]>();
	}
	/*
		in this method we evaluate a potential move so if it is good or not to play
		
	 */
	public double evaluate(int currentPos, int dice,int minotaurtileid, Board board, int idPlayer) {
		double points;
		double m=0, s=0;
		if(dice == 1) {
			if(board.getTiles()[currentPos].getUp() == false ) {
				if (minotaurtileid - currentPos == board.getN()) {
					m = -1;
				}
				if (idPlayer==1) {
					for(int i=0; i<board.getS();i++) {
						if(board.getSupplies()[i].getsupplyTileId() - currentPos == board.getN()) {
							s+=1;
							break;
						}
					}
				}
				if (board.getTiles()[currentPos + board.getN()].getUp() == false ) {
					if(minotaurtileid - currentPos == 2*board.getN()) {
						m = -0.5;
					}
					if (idPlayer==1) {
						for(int i=0; i<board.getS();i++) {
							if(board.getSupplies()[i].getsupplyTileId() - currentPos == 2*board.getN()) {
								s+=0.5;
								break;
							}
						}
					}
					if(board.getTiles()[currentPos + 2*board.getN()].getUp() == false) {
						if (minotaurtileid - currentPos == 3*board.getN()) {
							m = -0.3;
						}
						if (idPlayer==1) {
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
		}
		else if(dice == 3) {
			if(board.getTiles()[currentPos].getRight() == false ) {
				if (minotaurtileid - currentPos == 1) {
					m = -1;
				}
				if (idPlayer==1) {
					for(int i=0; i<board.getS();i++) {
						if(board.getSupplies()[i].getsupplyTileId() - currentPos == 1) {
							s+=1;
							break;
						}
					}
				}
				if (board.getTiles()[currentPos + 1].getRight() == false ) {
					if(minotaurtileid - currentPos == 2) {
						m = -0.5;
					}
					if (idPlayer==1) {
						for(int i=0; i<board.getS();i++) {
							if(board.getSupplies()[i].getsupplyTileId() - currentPos == 2) {
								s+=0.5;
								break;
							}
						}
					}
					if(board.getTiles()[currentPos + 2].getRight() == false) {
						if (minotaurtileid - currentPos == 3) {
							m = -0.3;
						}
						if (idPlayer==1) {
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
			
		}
		else if(dice == 5) {
			if(board.getTiles()[currentPos].getDown() == false ) {
				if (minotaurtileid - currentPos == -board.getN()) {
					m = -1;
				}
				if (idPlayer==1) {
					for(int i=0; i<board.getS();i++) {
						if(board.getSupplies()[i].getsupplyTileId() - currentPos == -board.getN()) {
							s+=1;
							break;
						}
					}
				}
				if (board.getTiles()[currentPos - board.getN()].getDown() == false ) {
					if(minotaurtileid - currentPos == -2*board.getN()) {
						m = -0.5;
					}
					if (idPlayer==1) {
						for(int i=0; i<board.getS();i++) {
							if(board.getSupplies()[i].getsupplyTileId() - currentPos == -2*board.getN()) {
								s+=0.5;
								break;
							}
						} 
					}
					if(board.getTiles()[currentPos - 2*board.getN()].getDown() == false) {
						if (minotaurtileid - currentPos == -3*board.getN()) {
							m = -0.3;
						}
						if (idPlayer==1) {
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
			
		}
		else if(dice == 7) {
			if(board.getTiles()[currentPos].getLeft() == false ) {
				if (minotaurtileid - currentPos == -1) {
					m = -1;
				}
				if (idPlayer==1) {
					for(int i=0; i<board.getS();i++) {
						if(board.getSupplies()[i].getsupplyTileId() - currentPos == -1) {
							s+=1;
							break;
						}
					}
				}
				if (board.getTiles()[currentPos - 1].getLeft() == false ) {
					if(minotaurtileid - currentPos == -2) {
						m = -0.5;
					}
					if (idPlayer==1) {
						for(int i=0; i<board.getS();i++) {
							if(board.getSupplies()[i].getsupplyTileId() - currentPos == -2) {
								s+=0.5;
								break;
							}
						}
					}
					if(board.getTiles()[currentPos - 2].getLeft() == false) {
						if (minotaurtileid - currentPos == -3) {
							m = -0.3;
						}
						if (idPlayer==1) {
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
	
	/*
		in this method we get the better move using a min-max tree 
		which contains all the available moves and for opponent or
		supply neat to the new position and add information in path
	 */
	int[] getNextMove (int currentPos, int opponentCurrentPos) {
		Node root = new Node(); 
		root.setNodeBoard(board);
		createMySubtree(currentPos, opponentCurrentPos, root, 1);
		int d = chooseMinMaxMove(root);
		int move[];
		move = moven(currentPos, opponentCurrentPos, d);
		Integer k[]= new Integer [4];
		k[0]=d;
		int l=10;
		 int n=-1;
		 int m=x*board.getN()+y;
		 
		 if (opponentCurrentPos-m==1) {
			 if(board.getTiles()[m].getRight()==false) {
				 n=1;
			 }
		 }
		 
		 else if (opponentCurrentPos-m==board.getN()) {
			 if(board.getTiles()[m].getUp()==false) {
				 n=1;
			 }
		 }
		 
		 else if (opponentCurrentPos-m==-1) {
			 if(board.getTiles()[m].getLeft()==false) {
				 n=1;
			 }
		 }
		 
		 else if (opponentCurrentPos-m==-board.getN()) {
			 if(board.getTiles()[m].getDown()==false) {
				 n=1;
			 }
		 }
		 
		 else if (opponentCurrentPos-m==2) {
			 if(board.getTiles()[m].getRight()==false) {
				 if(board.getTiles()[m+1].getRight()==false) {
					 n=2;
				 }
			 }
		 }
		 
		 else if (opponentCurrentPos-m==2*board.getN()) {
			 if(board.getTiles()[m].getUp()==false) {
				 if(board.getTiles()[m+board.getN()].getUp()==false) {
					 n=2;				 }
			 }
		 }
		 
		 else if (opponentCurrentPos-m==-2) {
			 if(board.getTiles()[m].getLeft()==false) {
				 if(board.getTiles()[m-1].getLeft()==false) {
					 n=2;
				 }
			 }
		 }
		 
		 else if (opponentCurrentPos-m==-2*board.getN()) {
			 if(board.getTiles()[m].getDown()==false) {
				 if(board.getTiles()[m-board.getN()].getDown()==false) {
					 n=2;
				 }
			 }
		 }
		 else if (opponentCurrentPos-m==3) {
			 if(board.getTiles()[m].getRight()==false) {
				 if(board.getTiles()[m+1].getRight()==false) {
					 if(board.getTiles()[m+2].getRight()==false) {
						 n=3;
					 }
				 }
			 }
		 }
		 
		 else if (opponentCurrentPos-m==3*board.getN()) {
			 if(board.getTiles()[m].getUp()==false) {
				 if(board.getTiles()[m+board.getN()].getUp()==false) {
					 if(board.getTiles()[m+2*board.getN()].getUp()==false) {
						 n=3;
					 }
				 }
			 }
		 }
		 
		 else if (opponentCurrentPos-m==-3) {
			 if(board.getTiles()[m].getLeft()==false) {
				 if(board.getTiles()[m-1].getLeft()==false) {
					 if(board.getTiles()[m-2].getLeft()==false) {
						 n=3;
					 }
				 }
			 }
		 }
		 
		 else if (opponentCurrentPos-m==-3*board.getN()) {
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
		 k[1]=0;
		 for (int i=0;i<board.getS();i++) {
			 if(move[3] == i) {
				 k[1]=1;
			 }
		 }
		 
		 
		 path.add(k);
		 return move;
	}
	
	/*
	 	in this method we create the tree with moves of player and opponent
	 	
	 */
	void createMySubtree(int currentPos, int opponentCurrentPos, Node root, int depth) {
		int numofmoves = 0;
		if(board.getTiles()[currentPos].getUp()==false) {
			numofmoves+=1;
			int moveu[]= new int [3];
			
			moveu[0] = opponentCurrentPos/board.getN();
			moveu[1] = currentPos% board.getN();
			moveu[2] = 1;
			Board b = root.getNodeBoard(); 
			ArrayList<Node> child = new ArrayList<Node>();
			Node childu = new Node(root,child ,depth, moveu, b, evaluate(currentPos,1, opponentCurrentPos, b ,1) );
			root.getChildren().add(childu);
			createOpponentSubtree(opponentCurrentPos,currentPos+board.getN(),childu,depth+1,evaluate(currentPos,1, opponentCurrentPos, b ,1));
		}
		if(board.getTiles()[currentPos].getDown()==false) {
			numofmoves+=1;
			int moved[]= new int [3];
			moved[0] = opponentCurrentPos/board.getN();
			moved[1] = currentPos% board.getN();
			moved[2] = 5;
			Board b = root.getNodeBoard(); 
			ArrayList<Node> child = new ArrayList<Node>();
			Node childd = new Node(root,child ,depth, moved, b, evaluate(currentPos,5, opponentCurrentPos, b ,1) );
			root.getChildren().add(childd);
			createOpponentSubtree(opponentCurrentPos,currentPos-board.getN(),childd,depth+1,evaluate(currentPos,5, opponentCurrentPos, b ,1));
		}
		if(board.getTiles()[currentPos].getLeft()==false) {
			numofmoves+=1;
			int moved[]= new int [3];
			moved[0] = opponentCurrentPos/board.getN();
			moved[1] = currentPos% board.getN();
			moved[2] = 7;
			Board b = root.getNodeBoard(); 
			ArrayList<Node> child = new ArrayList<Node>();
			Node childl = new Node(root,child ,depth, moved, b, evaluate(currentPos,7, opponentCurrentPos, b ,1) );
			root.getChildren().add(childl);
			createOpponentSubtree(opponentCurrentPos,currentPos-1,childl,depth+1,evaluate(currentPos,7, opponentCurrentPos, b ,1));
		}
		if(board.getTiles()[currentPos].getRight()==false) {
			numofmoves+=1;
			int moved[]= new int [3];
			moved[0] = opponentCurrentPos/board.getN();
			moved[1] = currentPos% board.getN();
			moved[2] = 3;
			ArrayList<Node> child = new ArrayList<Node>();
			Board b = root.getNodeBoard(); 
			Node childr = new Node(root,child ,depth, moved, b, evaluate(currentPos,3, opponentCurrentPos, b ,1) );
			root.getChildren().add(childr);
			createOpponentSubtree(opponentCurrentPos,currentPos+1,childr,depth+1,evaluate(currentPos,3, opponentCurrentPos, b ,1));
			
		}
		
		
	}
	//in this method we create the part of the tree with opponent's moves
	void createOpponentSubtree(int currentPos, int opponentCurrentPos, Node parent, int depth, double parentEval) {
		
			int numofmoves = 0;
			if(board.getTiles()[currentPos].getUp()==false) {
				numofmoves+=1;
				int moveu[]= new int [3];
				
				moveu[0] = opponentCurrentPos/board.getN();
				moveu[1] = currentPos% board.getN();
				moveu[2] = 1;
				Board b = parent.getNodeBoard(); 
				ArrayList<Node> child = new ArrayList<Node>();
				Node childu = new Node(parent,child ,depth, moveu, b, parentEval+evaluate(currentPos,1, opponentCurrentPos, b ,2) );
				parent.getChildren().add(childu);
				
			}
			if(board.getTiles()[currentPos].getDown()==false) {
				numofmoves+=1;
				int moved[]= new int [3];
				moved[0] = opponentCurrentPos/board.getN();
				moved[1] = currentPos% board.getN();
				moved[2] = 5;
				Board b = parent.getNodeBoard(); 
				ArrayList<Node> child = new ArrayList<Node>();
				Node childd = new Node(parent,child ,depth, moved, b, parentEval+evaluate(currentPos,5, opponentCurrentPos, b ,2) );
				parent.getChildren().add(childd);
				
			}
			if(board.getTiles()[currentPos].getLeft()==false) {
				numofmoves+=1;
				int moved[]= new int [3];
				moved[0] = opponentCurrentPos/board.getN();
				moved[1] = currentPos% board.getN();
				moved[2] = 7;
				Board b = parent.getNodeBoard(); 
				ArrayList<Node> child = new ArrayList<Node>();
				Node childl = new Node(parent,child ,depth, moved, b, parentEval+evaluate(currentPos,7, opponentCurrentPos, b ,2) );
				parent.getChildren().add(childl);
				
			}
			if(board.getTiles()[currentPos].getRight()==false) {
				numofmoves+=1;
				int moved[]= new int [3];
				moved[0] = opponentCurrentPos/board.getN();
				moved[1] = currentPos% board.getN();
				moved[2] = 3;
				ArrayList<Node> child = new ArrayList<Node>();
				Board b = parent.getNodeBoard(); 
				Node childr = new Node(parent,child ,depth, moved, b, parentEval+evaluate(currentPos,3, opponentCurrentPos, b ,2) );
				parent.getChildren().add(childr);
				
			}
	}
	// here we chose the best move according to min-max tree  
	int chooseMinMaxMove(Node root) {
        
        for(int j=0; j<root.getChildren().size(); j++) {
            double minimum= root.getChildren().get(j).getChildren().get(0).getNodeEvaluation();
            for(int i=1; i< root.getChildren().get(j).getChildren().size(); i++) {
                double w =root.getChildren().get(j).getChildren().get(i).getNodeEvaluation();
            	if(w<minimum) {
            		minimum=w;
                }
                if(w==minimum) {
                    if(Math.random()<0.5) {
                    	minimum=w;

                    }
                }
            }
            root.getChildren().get(j).setNodeEvaluation(minimum);
        }

        double maximum = root.getChildren().get(0).getNodeEvaluation();
        int i = 0;
        for(int j = 1; j < root.getChildren().size(); j++) {
        	double k = root.getChildren().get(j).getNodeEvaluation();
           if(k > maximum) {
               maximum = k;
               i = j;
           }
           if(k == maximum) {
               if(Math.random() < 0.5) {
            	   maximum = k;
               i = j;
               }
           }
        }
        return  root.getChildren().get(i).getNodeMove()[2];
     }
	//here we print info about the player's current move
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
	 //here we have statistics of player's moves and print them (we use in the end of the game)
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
