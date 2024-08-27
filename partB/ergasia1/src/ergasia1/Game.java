package ergasia1;

 //class "game" contains the round of the game and "main" of the project
 
public class Game {
	
	int round;
	
	public Game() {
		round = 0;
	}
	
	public Game(int round) {
		this.round = round;
	}

	public int getRound() {
		return round;
	}

	public void setRound(int round) {
		this.round = round;
	}
	//main
	/*
	 in "main" we create a new game with a board (of dimensions n x n)and s supplies,with two players(Theseus and
	 Minotaur)
	 in "main" we print our board on every round , we count the rounds and the game continues until we have a winner or
	 the max number of rounds (100) is reached.
	 w helps us know who wins
	 */
	public static void main(String[] args) {
		int w = 0;//who wins 
		int n=15;//dimension
		int s=4;//number of supplies
		int r=(((n * n * 3 + 1) / 2)-4*n);
		int q=(int)(Math.random()*r)+4*n;
		Game g = new Game();
		Board p = new Board(n, s, q ) ;
		p.createBoard();
		HeuristicPlayer player1 = new HeuristicPlayer(1 ,"Theseus" ,p ,0, 0, 0);	
		Player player2 = new Player(2 ,"Minotaur" ,p ,0, (n-1)/2, (n-1)/2);	
		for (int k=2*n;k>-1;k--) {
			for(int j=0;j<n;j++) {
				System.out.print(p.getStringRepresentation(player1.getX()*n + player1.getY(), player2.getX()*n + player2.getY())[k][j]);
			}
			System.out.print("\n");
			
		}
		p.getTiles()[0].setDown(true);
		for (int i=0; i<100;i++) {
			g.setRound(i+1);;
			System.out.println("Round: "+g.getRound());
			int p1=player1.getX()*n + player1.getY();
			int p2=player2.getX()*n + player2.getY();
			player1.getNextMove(player1.getX()*n + player1.getY(),player2.getX()*n + player2.getY());
			if(p1==player1.getX()*n + player1.getY()-n) {
				System.out.println("Theseus go up ("+player1.getY()+","+player1.getX()+").");
			}
			if(p1==player1.getX()*n + player1.getY()-1) {
				System.out.println("Theseus go right ("+player1.getY()+","+player1.getX()+").");
			}
			if(p1==player1.getX()*n + player1.getY()+n) {
				System.out.println("Theseus go down ("+player1.getY()+","+player1.getX()+").");
			}
			if(p1==player1.getX()*n + player1.getY()+1) {
				System.out.println("Theseus go left ("+player1.getY()+","+player1.getX()+").");
			}
			player1.stat();
			if (player1.getScore()==s) {
				w = 1;//player1 wins
				break;
			}
			if (player1.getX()*n + player1.getY() == player2.getX()*n + player2.getY()) {
				w =2; //player2 wins
				break;
			}
			
		
			player2.move(player2.getX()*n + player2.getY());
			if(p2==player2.getX()*n + player2.getY()-n) {
				System.out.println("Minotaur go up ("+player2.getY()+","+player2.getX()+").");
			}
			if(p2==player2.getX()*n + player2.getY()-1) {
				System.out.println("Minotaur go right ("+player2.getY()+","+player2.getX()+").");
			}
			if(p2==player2.getX()*n + player2.getY()+n) {
				System.out.println("Minotaur go down ("+player2.getY()+","+player2.getX()+").");
			}
			if(p2==player2.getX()*n + player2.getY()+1) {
				System.out.println("Minotaur go left ("+player2.getY()+","+player2.getX()+").");
			}
			
			if (player1.getX()*n + player1.getY() == player2.getX()*n + player2.getY()) {
				w=2; //player2 wins
				break;
			}		
			for (int k=2*n;k>-1;k--) {
				for(int j=0;j<n;j++) {
					System.out.print(p.getStringRepresentation(player1.getX()*n + player1.getY(), player2.getX()*n + player2.getY())[k][j]);
				}
				System.out.print("\n");
				
			}
			
			
		}
		if(w==1) {
			for (int k=2*n;k>-1;k--) {
				for(int j=0;j<n;j++) {
					System.out.print(p.getStringRepresentation(player1.getX()*n + player1.getY(), -10)[k][j]);
				}
				System.out.print("\n");
				
			}
			player1.statistics();
			System.out.println("The winner is Theseus.");
			
		}
		else if(w==2) {
			for (int k=2*n;k>-1;k--) {
				for(int j=0;j<n;j++) {
					System.out.print(p.getStringRepresentation(-10, player2.getX()*n + player2.getY())[k][j]);
				}
				System.out.print("\n");
				
			}
			player1.statistics();
			System.out.println("The winner is Minotaur.");
		}
		else {
			player1.statistics();
			System.out.println("There is no winner.");
		}
	
	}
	

}
