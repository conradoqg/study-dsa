package com.github.conradoqg.studydsa.hackerrank.challenges.ctci;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class BalancedBrackets {
	public static boolean isBalanced(String expression) {
		Deque<Character> bracketsStack = new LinkedList<Character>();

		for (char c : expression.toCharArray()) {
			if (c == '{') bracketsStack.push('}');
			else if (c=='[') bracketsStack.push(']');
			else if (c=='(') bracketsStack.push(')');
			else {
				if (bracketsStack.contains(c)) bracketsStack.pop();
				else return false;
			}
		}

		if (!bracketsStack.isEmpty())
			return false;
		
		return true;
	}

	public static void main(String[] args) {		
		try (Scanner in = new Scanner(System.in)) {
			int t = in.nextInt();
			for (int a0 = 0; a0 < t; a0++) {
				String expression = in.next();
				System.out.println((isBalanced(expression)) ? "YES" : "NO");
			}
		}
	}
}
