package selfPreparation;

public class MyStack {

	private int size;
	Node top;
	
	public MyStack(){
		size = 0;
		top = null;
	}
	
	public void push(int val){
		size++;
		if(top == null) {
			top = new Node(val);
		}
		else {// elements already present
			Node temp = new Node(val);
			temp.next = top;
			top = temp;
		}
	}
	
	public int pop(){
		if(size == 0)
			return -1;
		size--;
		Node temp = top;
		top = top.next;
		return temp.val;
	}
	
	public int size(){
		return size;
	}
	
	public boolean isEmpty(){
		return top == null ;
	}
	
	public int top(){
		if(size == 0)
			return -1;
		return top.val;
	}
}
