package com.github.conradoqg.studydsa.hackerrank.challenges.ctci;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Contacts {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		
		ContactsTree contacts = new ContactsTree();
		
		for (int a0 = 0; a0 < n; a0++) {
			String op = in.next();
			String contact = in.next();
			
			if (op.equals("add")) contacts.add(contact); 
			else if (op.equals("find")) System.out.println(contacts.find(contact));
		}
		
		in.close();
	}
	
	public static class ContactsTree {
		CharNode rootCharNode = new CharNode();
		
		public ContactsTree() {}
	
		public void add(String word) {
			CharNode currentCharNode = rootCharNode;
			for (char c : word.toCharArray()) {				
				currentCharNode.putChildrenCharIfAbsent(c);
				currentCharNode = currentCharNode.getChildrenCharNode(c);
				currentCharNode.wordsUsingThis++;
			}
		}
		
		public int find(String word) {
			CharNode currentCharNode = rootCharNode;
			for (char c : word.toCharArray()) {
				currentCharNode = currentCharNode.getChildrenCharNode(c);
				if (currentCharNode == null) return 0;
			}
			
			return currentCharNode.wordsUsingThis;
		}
	}
	
	static class CharNode {
		Map<Character, CharNode> childrenCharNodes = new HashMap<Character, CharNode>();
		int wordsUsingThis = 0;
		
		CharNode putChildrenCharIfAbsent(char ch) {
			return childrenCharNodes.putIfAbsent(ch, new CharNode());
		}
		
		CharNode getChildrenCharNode(char ch) {
			return childrenCharNodes.get(ch);
		}
	}
}
