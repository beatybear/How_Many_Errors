package beaty;

public class Node {
	/**
	 * "don't leave a child node unattended because they are trash" - Trish, the garbage collector will come thake them
	 */
	
	//data members
	public int n;
	public Node next;
	public Node prev; 
	
	//constructor
	public Node(int n) {
		this.n = n; //this.n refers to the global variable while n is the local variable, the parameter
		next = null;
		prev = null;
	}
	
	public Boolean hasNext() {
		if(next != null)
			return true; //if there is not a next node, if returns true
		return false; //if there is a next node, if returns false
	}

	//setters and getters
	public int getN() {
		return n;
	}

	public void setN(int n) {
		this.n = n;
	}

	public Node getNext() {
		return next;
	}

	public void setNext(Node next) {
		this.next = next;
	}
	
	public Node getPrev() {
		return prev;
	}

	public void setPrev(Node prev) {
		this.prev = prev;
	}
}
