package com.implementation;

/**
 * 
 * @author Chandra Mohan Singh
 *
 */
public class TrieMain {

	public static void main(String[] args) {
		Trie t  =new Trie();
		
		//CASE-1
		t.insert("abcd");
		t.insert("abkl");
		t.delete("abcd");
		t.search("abcd");
		t.search("abkl");
		
		
		//CASE-2
		t.insert("abcd");
		t.insert("abcdef");
		t.delete("abcd");
		t.search("abcd");
		t.search("abcdef");
		
		
		//CASE-3
		t.insert("abcd");
		t.insert("ab");
		t.delete("abcd");
		t.search("abcd");
		t.search("abcd");
		t.search("ab");
		t.search("a");
		
		
		//CASE-4
		t.insert("abcd");
		t.delete("abcd");
		t.search("abcd");
		
	}

}