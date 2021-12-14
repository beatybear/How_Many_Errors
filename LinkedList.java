package beaty;

public class LinkedList {
	//data members
	private Node head;
	private Node tail;
	
	//constructor
	public LinkedList(){
		head = null;
		tail = null;
	}
	
	//add a node method
	public void addNode(int n) {
		//task 1: create a temporary node
		Node temp = new Node(n);
		//task 2: add the node to the back of the list
		//senerio 1: the list is empty
		if(head==null) {
			head = temp;
			tail = temp;
		}
		//senario 2: the list is not empty
		else {
			tail.setNext(temp); //assign value using setter
			temp.prev = tail; //assign value with a direct reference to variable
			tail = temp;
		}
	}
	
	//construct a string for nodes in reverse
	public String toStringOrdered() { //my solution
		Node temp = head;
		String order = head.getN() + " "; //starts with the first node
		while(temp.hasNext()) { //if there is another node, it adds it
			temp = temp.next;
			order += temp.getN() + " ";	
		}
		return order;
	}
	
	//construct a string for nodes in order
	public String toStringReversed() { //Trish's solution
		Node travPtr = tail;
		String collection = "";
		while (travPtr != null) {
			collection += travPtr.getN() + " "; //can only do travPtr.n.toString() if n is an Integer rather then an int
			travPtr = travPtr.prev;
		}
		return collection;
	}
	
	//pop(): pop a node from the front
	//if a node is on its own, nuconnected to anything, Eclipse (the garbage collector) will throw it away
	public int pop(){
		//task 1: grab the item at the front
		int headValue = -1;
		if(head != null)
			headValue = head.n;
		//senario 1" the list is empty or has one node
		if(tail == head) {
			tail = null;
			head = null;
		}
		//senario 2: the list has multiple items
		else {
			head.next.prev = null; //removes the link the next node has to the head
			head = head.next;
		}
		
		return headValue; //usually popping a node out means it is returned
	}
}
