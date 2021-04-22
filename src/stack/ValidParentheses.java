package stack;

import java.util.HashMap;
import java.util.Stack;

public class ValidParentheses {
	
	public boolean isValid(String s) {
		//Create a hashmap that keys are the open characters, and values are the matching close characters
		HashMap<Character,Character> mappingP=new HashMap<>();
		mappingP.put('(', ')');
		mappingP.put('{', '}');
		mappingP.put('[', ']');
		//System.out.println(mappingP.get('#'));
		
		//create a new stack to store the open parentheses characters when going through the input string
		Stack<Character> stack=new Stack<>();
		//loop through the string character by character,
		//compare if it is open parentheses add into the starch, if not compare if it is matching with the latest open parentheses
		
		for (int i=0;i<s.length();i++) {
			Character cha=s.charAt(i);
			System.out.print(cha);
		}
		
		for (int i=0;i<s.length();i++) {
			Character cha=s.charAt(i);
			if (mappingP.containsKey(cha)) {
				
				stack.push(cha);
			}
			else if(stack.isEmpty() ||mappingP.get(stack.pop())!=cha){
				
				//case having extra close parentheses
				
					 return false;
			} 
				
		}
		
		return stack.isEmpty();
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s="[](){}";
		ValidParentheses test=new ValidParentheses();
		System.out.println(test.isValid(s));
	}

}
