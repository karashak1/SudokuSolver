package util;

public class LinkedList {
	
	private Node head;
	private Node tail;
	
	public LinkedList(){
		head = tail = null;
	}
	
	public LinkedList(Object data){
		head = tail = new Node(data);
	}
	
	public void addLink(Object data){
		if(head == null){
			head = tail = new Node(data);
		}
	}

}
