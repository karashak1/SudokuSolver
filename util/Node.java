package util;

public class Node {
	
	private Node left;
	private Node right;
	private Node top;
	private Node bottom;
	private Object data;
	
	public Node(){
		left = right = null;
		data = null;
	}
	
	public Node(Object data ){
		this.data = data;
	}
	
	public Node(Node right, Object data){
		this.right = right;
		this.data = data;
	}
	
	public Node(Node left, Node right, Object data){
		this.left = left;
		this.right = right;
		this.data = data;
	}

	public Node getLeft() {
		return left;
	}

	public void setLeft(Node left) {
		this.left = left;
	}

	public Node getRight() {
		return right;
	}

	public void setRight(Node right) {
		this.right = right;
	}

	public Object getData() {
		return data;
	}
	
	public Node getTop() {
		return top;
	}

	public void setTop(Node top) {
		this.top = top;
	}

	public Node getBottom() {
		return bottom;
	}

	public void setBottom(Node bottom) {
		this.bottom = bottom;
	}

	public void setData(Object data) {
		this.data = data;
	}
	
	

}
