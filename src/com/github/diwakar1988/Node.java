package com.github.diwakar1988;

import java.util.HashMap;
import java.util.Map;

public class Node {

	private Map<Character, Node> childs=new HashMap<>();
	private boolean endOfWord;
	
	public Node setChilds(char ch) {
		Node n = new Node();
		this.childs.put(ch, n);
		return n;
	}
	public Node setChilds(char ch,boolean endOfWord) {
		Node n = setChilds(ch);
		if (endOfWord) {			
			n.markEndOfWord();
		}
		return n;
	}
	public boolean isEndOfWord() {
		return endOfWord;
	}
	public void markEndOfWord() {
		this.endOfWord = true;
	}

}
