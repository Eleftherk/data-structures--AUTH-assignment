package ergasia1;

import java.util.ArrayList;
//class node contains all the methods and all the characteristics to create a node
public class Node {
	Node parent;
	ArrayList<Node> children;
	int nodeDepth;
	int[] nodeMove;
	Board nodeBoard;
	double nodeEvaluation;
	
	public Node (){
		parent = null;
		children = new ArrayList<Node>(0);
		nodeDepth = 0;
		nodeMove = new int [3];
		nodeBoard = new Board();
		nodeEvaluation = 0;
	}
	
	public Node (Node parent, ArrayList<Node> children, int nodeDepth, int[] nodeMove, Board nodeBoard, double nodeEvaluation){
		this.parent = parent;
		this.children = children;
		this.nodeDepth = nodeDepth;
		this.nodeMove = nodeMove;
		this.nodeBoard = nodeBoard;
		this.nodeEvaluation = nodeEvaluation;
	}

	public Node getParent() {
		return parent;
	}

	public void setParent(Node parent) {
		this.parent = parent;
	}

	public ArrayList<Node> getChildren() {
		return children;
	}

	public void setChildren(ArrayList<Node> children) {
		this.children = children;
	}

	public int getNodeDepth() {
		return nodeDepth;
	}

	public void setNodeDepth(int nodeDepth) {
		this.nodeDepth = nodeDepth;
	}

	public int[] getNodeMove() {
		return nodeMove;
	}

	public void setNodeMove(int[] nodeMove) {
		this.nodeMove = nodeMove;
	}

	public Board getNodeBoard() {
		return nodeBoard;
	}

	public void setNodeBoard(Board nodeBoard) {
		this.nodeBoard = nodeBoard;
	}

	public double getNodeEvaluation() {
		return nodeEvaluation;
	}

	public void setNodeEvaluation(double nodeEvaluation) {
		this.nodeEvaluation = nodeEvaluation;
	}
}