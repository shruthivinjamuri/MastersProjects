package selfPreparation;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * While there are tokens to be read:
		*Read a token.
		*If the token is a number, then add it to the output queue.
		*If the token is a function token, then push it onto the stack.
		*If the token is a function argument separator (e.g., a comma):
			Until the token at the top of the stack is a left parenthesis, pop operators off the stack onto the output queue. 
			If no left parentheses are encountered, either the separator was misplaced or parentheses were mismatched.
		*If the token is an operator, o1, then:
			while there is an operator token, o2, at the top of the operator stack, and either
				o1 is left-associative and its precedence is less than or equal to that of o2, or
				o1 is right associative, and has precedence less than that of o2,
					then pop o2 off the operator stack, onto the output queue;
			push o1 onto the operator stack.
		*If the token is a left parenthesis (i.e. "("), then push it onto the stack.
		*If the token is a right parenthesis (i.e. ")"):
			Until the token at the top of the stack is a left parenthesis, pop operators off the stack onto the output queue.
			Pop the left parenthesis from the stack, but not onto the output queue.
			If the token at the top of the stack is a function token, pop it onto the output queue.
			If the stack runs out without finding a left parenthesis, then there are mismatched parentheses.
		*When there are no more tokens to read:
			While there are still operator tokens in the stack:
				If the operator token on the top of the stack is a parenthesis, then there are mismatched parentheses.
				Pop the operator onto the output queue.
  * Exit.
 **/
public class ShuntingYard {

	private static HashMap<String,Integer> precedence; 
	private static HashMap<String,String> associativity;
	
	public static void main(String[] args) {
		try {
			System.out.println(convertRPN("3+4*2/(1-5)^2^3"));
		} catch (Exception e) {
			//System.out.println(e.toString());
			e.printStackTrace();
		}

	}
	
	public static void load(){
		precedence   = new HashMap<String,Integer>();
		associativity = new HashMap<String,String>();
		//set precedence
		precedence.put("^",4);
		precedence.put("*",3);
		precedence.put("/",3);
		precedence.put("+",2);
		precedence.put("-",2);
		//set associativity
		associativity.put("^","right");
		associativity.put("*","left");
		associativity.put("/","left");
		associativity.put("+","left");
		associativity.put("-","left");
		
	}
	
	public static String convertRPN(String input) throws Exception{
		load();
		Stack<String> stack = new Stack<String>();
		Queue<String> output = new LinkedList<String>();
		String token = "";
		for (int idx = 0; idx < input.length(); idx++) {
			if (input.charAt(idx) == ' ')
				continue;
			else if (input.charAt(idx) >= '0' && input.charAt(idx) <= '9') {
				token += input.charAt(idx) + "";
				if (idx + 1 < input.length() && input.charAt(idx + 1) >= '0' && input.charAt(idx + 1) <= '9')
				{
					
				}					
				else {
					if (!token.equals(""))
						output.offer(token);
					token = "";
				}
			} else if (precedence.containsKey(input.charAt(idx)+"")) {
				String op1 = input.charAt(idx) + "";
				if (!stack.isEmpty()) {
					String op2 = stack.peek();
					if (precedence.containsKey(op2)
							&& (associativity.get(op1).equals("left") && precedence.get(op1) <= precedence.get(op2))
							|| (associativity.get(op1).equals("right") && precedence.get(op1) < precedence.get(op2))) {
						output.offer(stack.pop());
					}
				}
				stack.push(op1);
			} else if (input.charAt(idx) == '(') {
				stack.push("(");
			} else if (input.charAt(idx) == ')') {
				while (!stack.isEmpty() && !stack.peek().equals("(")) {
					output.offer(stack.pop());
				}
				if (stack.isEmpty())
					throw new Exception("Invalid input ( is missing");
				stack.pop(); // removes "("
			}
		}
		
		while(!stack.isEmpty()){
			if(stack.peek().equals("(") || stack.peek().equals(")")) throw new Exception("Invalid input of parenthesis");
			output.offer(stack.pop());
		}
		return output.toString();
	}

}
