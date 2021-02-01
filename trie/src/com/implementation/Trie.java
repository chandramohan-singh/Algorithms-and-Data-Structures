package com.implementation;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author Chandra Mohan Singh
 *
 */
public class Trie {

	private class TrieNode {
		Map<Character, TrieNode> characterMap;
		boolean endOfWord;

		// Constructor
		public TrieNode() {
			characterMap = new HashMap<>();
			endOfWord = false;
		}
	}

	private final TrieNode root;

	
	public Trie() {
		root = new TrieNode();
	}

	
	// Insert word into Trie
	public void insert(String word) {
		TrieNode current = root;
		for (int i = 0; i < word.length(); i++) {
			char ch = word.charAt(i);
			TrieNode node = current.characterMap.get(ch);
			if (node == null) {
				node = new TrieNode();
				current.characterMap.put(ch, node);
			}
			current = node;
		}
		current.endOfWord = true;
		System.out.println("Successfully inserted " + word + " in Trie.");
	}

	
	// Search for a word in Trie
	public boolean search(String word) {
		TrieNode currentNode = root;
		for (int i = 0; i < word.length(); i++) {
			char ch = word.charAt(i);
			TrieNode node = currentNode.characterMap.get(ch); 
			if (node == null) {
				System.out.println("Word : " + word + " does not exists in Trie.");
				return false;
			}
			currentNode = node;
		}
		if(currentNode.endOfWord == true) {
			System.out.println("Word : " + word + " exists in The Trie.");
		}else { //Current word is a prefix of another word. But this word does not exists
			System.out.println("Word : " + word + " does not exists in the Trie, But this is a Prefix of another Word.");
		}
		return currentNode.endOfWord;
	}

	
	// Delete word from the Trie
	public void delete(String word) {
		if (search(word) == true) {
			delete(root, word, 0);
		}
	}

	// Returns true if parent should delete the mapping
	private boolean delete(TrieNode parentNode, String word, int index) {
		
		char charactor = word.charAt(index);
		TrieNode currentNode = parentNode.characterMap.get(charactor);
		boolean canThisNodeBeDeleted;

		// CASE-1 -- Some other word's prefix is same as Prefix of this word (ABCD, ABKL)
		if (currentNode.characterMap.size() > 1) {
			delete(currentNode, word, index + 1);
			return false;
		}

		// CASE-2 -- We are at last character of this word and This word is a Prefix of some other word (ABCD, ABCDEF)
		if (index == word.length() - 1) {
			if (currentNode.characterMap.size() >= 1) {
				//updating endOfWord will signify that this word is not there in the Trie
				currentNode.endOfWord = false;
				return false;
			} else {
				// If this word is not a prefix of some other word, and since this is last character, we should return true, indicating we are ok to delete this node
				System.out.println("Character " + charactor + " has no dependency, hence deleting it from last.");
				parentNode.characterMap.remove(charactor);
				return true;
			}
		}
		
		// CASE-3 -- Some other word is a Prefix of this word (ABCD, AB)
		if (currentNode.endOfWord == true) {
			System.out.println("Entering Case#3");
			delete(currentNode, word, index + 1); 
			return false;
		}
		
		// CASE-4 -- No one is dependent on this Word (BCDE, BCDE)
		canThisNodeBeDeleted = delete(currentNode, word, index + 1);
		if (canThisNodeBeDeleted == true) {
			System.out.println("Character " + charactor + " has no dependency, hence deleting it");
			parentNode.characterMap.remove(charactor);
			return true; // Current node can also be deleted
		} else {
			return false; // Someone is dependent on this node, hence dont delete it
		}
	}
}