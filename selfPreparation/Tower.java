package selfPreparation;

import java.util.Stack;

public class Tower {

	private Stack<Integer> stack;
	
	public Tower(){
		stack = new Stack<Integer>();
	}
	
	public void add(int val){
		if(!stack.isEmpty() && stack.peek() <= val){
			System.out.println("Error inserting: "+ val);
		}
		else {
			stack.push(val);
		}
	}
	
	public void moveTopTo(Tower t){
		if(!stack.isEmpty()){
			t.add(stack.pop());
		}
	}
	
	public int pop(){
		return stack.pop();
	}
	
	public boolean isEmpty(){
		return stack.isEmpty();
	}
}
