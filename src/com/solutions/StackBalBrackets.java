package com.solutions;
import java.util.*;

public class StackBalBrackets {
	
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		int t = scan.nextInt();
		if(t < 1 || t > Math.pow(10, 3)) {
			scan.close();
			return;
		}
			
        for (int a0 = 0; a0 < t; a0++) {
            String expression = scan.next();
            if(expression.length() < 1 || expression.length() > Math.pow(10, 3)){
            	scan.close();
            	return;
            }
            System.out.println("expression.length()====="+expression.length());
            System.out.println( (isBalanced(expression)) ? "YES" : "NO" );
        }
        scan.close();
	}

	private static boolean isBalanced(String expression){
		char[] arr = expression.toCharArray();
		Stack<Character> stack = new Stack<>();
		for(int i = 0; i < arr.length; i++){
			if(arr[i] == '[' || arr[i] == '(' || arr[i] == '{'){
				stack.push(arr[i]);
			}else if(!stack.isEmpty() && (stack.peek() == '[' && arr[i] == ']' || stack.peek() == '(' && arr[i] == ')' || stack.peek() == '{' && arr[i] == '}')){
				stack.pop();
			}else{
				return false;
			}
		}
		
		return stack.isEmpty();
	}
}
