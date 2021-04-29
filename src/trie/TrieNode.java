package trie;

import binarySearchTree.BinarySearch;

public class TrieNode {
	public TrieNode[] children;
	public String word;
	public boolean leafNode;
	
	public TrieNode() {
		children=new TrieNode[26];
		//word=false;
		leafNode=false;
	}
}


