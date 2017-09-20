package com.github.diwakar1988;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class Trie {

	private class Node {
		private char data;
		private Map<Character, Node> childs=new HashMap<>();
		private boolean endOfWord;
		public Node(char data) {
			this.data=data;
		}
		public Node setChild(char ch) {
			Node n = new Node(ch);
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
		root = new Node(Character.MIN_VALUE);
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
	public List<String> search(String prefix) {
		List<String> list = new ArrayList<>();
		Node current=root;
		for(int i=0;i<prefix.length();i++){
			char ch = prefix.charAt(i);
			Node child = current.getChild(ch);
			if (child==null) {
				//prefix not found here
				return list;
			}
			current=child;
		}
		addChars(prefix,current,list,new StringBuilder(prefix));
		return list;
	}
	private void addChars(String prefix, Node current, List<String> list,StringBuilder sb) {
		sb.append(current.data);
		if (current.endOfWord) {
			list.add(sb.toString());
			sb.setLength(0);
			sb.append(prefix);
			return;
		}
		Iterator<Character> chars = current.childs.keySet().iterator();
		while (chars.hasNext()) {
			char ch = (char) chars.next();
			Node leaf = current.getChild(ch);
			addChars(prefix, leaf, list,sb);
		}
		
	}
	public boolean searchPrefix(String prefix) {
		Node current=root;
		for(int i=0;i<prefix.length();i++){
			char ch = prefix.charAt(i);
			Node child = current.getChild(ch);
			if (child==null) {
				return false;
			}
			current=child;
		}
		return true;
	}
	public boolean searchWord(String word) {
		Node current=root;
		for(int i=0;i<word.length();i++){
			char ch = word.charAt(i);
			Node child = current.getChild(ch);
			if (child==null) {
				return false;
			}
			current=child;
		}
		return current.endOfWord;
	}
	

}
