package com.greatlearning.stackproblem;

import java.util.Stack;

public class BalancingBrackets {

	public static void main(String[] args) {
		String input = "([[{[}]])]";
		boolean result = areBracketsBalanced(input);
		if (result) {
			System.out.println("The entered String has Balanced Brackets");
		} else
			System.out.println("The entered Strings do not contain Balanced Brackets");
	}

	// function to check if brackets are balanced
	static boolean areBracketsBalanced(String expr) {
		// Using ArrayDeque is faster than using Stack class
		Stack<Character> stack = new Stack<Character>();

		// Traversing the Expression
		for (int i = 0; i < expr.length(); i++) {
			char x = expr.charAt(i);

			//pushing into the stack
			if (x == '(' || x == '[' || x == '{') {
				// Push the element in the stack
				stack.push(x);
				continue;
			}

			// If current character is not opening
			// bracket, then it must be closing. So stack
			// cannot be empty at this point.
			if (stack.isEmpty())
				return false;
			char check;
			
			//popping out of the stack and matching it with check
			switch (x) {
			case ')':
				check = stack.pop();
				if (check == '{' || check == '[')
					return false;
				break;

			case '}':
				check = stack.pop();
				if (check == '(' || check == '[')
					return false;
				break;

			case ']':
				check = stack.pop();
				if (check == '(' || check == '{')
					return false;
				break;
			}
		}

		// Check Empty Stack
		return (stack.isEmpty());
	}
}
