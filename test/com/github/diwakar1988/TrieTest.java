package com.github.diwakar1988;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class TrieTest {

	private Trie trie;
	@Before
	public void setup(){
		trie = new Trie();
		trie.insert("diwakar");
		trie.insert("dinesh");
		trie.insert("dinkar");
		trie.insert("dipankar");
		trie.insert("devesh");
		trie.insert("danish");
		trie.insert("rani");
		
	}
	@Test
	public void testSearchPrefix() {
		assertTrue(trie.searchPrefix("di"));
		assertTrue(trie.searchPrefix("din"));
		assertTrue(trie.searchPrefix("ran"));
		assertTrue(trie.searchPrefix("da"));
		assertTrue(trie.searchPrefix("de"));
		assertFalse(trie.searchPrefix("dw"));
		assertFalse(trie.searchPrefix("in"));
	}
	@Test
	public void testSearchWord() {
		assertTrue(trie.searchWord("diwakar"));
		assertFalse(trie.searchWord("din"));
		assertTrue(trie.searchWord("dinkar"));
		assertFalse(trie.searchWord("dev"));
		assertTrue(trie.searchWord("rani"));
	}
	@Test
	public void testSearch() {
		List<String> list = trie.search("di");
		System.out.println(list);
	}

}
