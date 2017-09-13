package com.github.diwakar1988;

import java.util.HashMap;
import java.util.Map;

public class Trie {

	private class Node {

		private Map<Character, Node> childs=new HashMap<>();
		private boolean endOfWord;
		
		public Node setChild(char ch) {
			Node n = new Node();
			this.childs.put(ch, n);
			return n;
		}
		public Node setChild(char ch,boolean endOfWord) {
			Node n = setChild(ch);
			if (endOfWord) {			
				n.markEndOfWord();
			}
			return n;
		}
		public Node getChild(char ch) {
			return childs.get(ch);
		}
		public boolean isEndOfWord() {
			return endOfWord;
		}
		public void markEndOfWord() {
			this.endOfWord = true;
		}

	}
	private Node root;
	
	public Trie() {
		root = new Node();
	}
	public void insert(String str) {
		Node current=root;
		for(int i=0;i<str.length();i++){
			char ch = str.charAt(i);
			Node child = current.getChild(ch);
			if (child==null) {
				child = current.setChild(ch);
			}
			current=child;
		}
		current.markEndOfWord();
	}
	public void remove(String str) {
		
	}
	public boolean search(String prefix) {
		return false;
	}

}
