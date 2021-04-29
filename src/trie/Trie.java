package trie;

import java.util.LinkedList;
import java.util.Queue;

import tree.TreeNode;

public class Trie {
	public TrieNode root;
	public Trie() {
		root=new TrieNode();
	}
	
//	public void add(String word) {
//		TrieNode node=root;
//		for (char c:word.toCharArray()) {
//			if (node.children[c-'a']==null) {
//				node.children[c-'a']=new TrieNode();
//			}
//			node=node.children[c-'a'];
//		}
//		node.leafNode=true;
//		node.word=word;
//	}
	
	
	public void add(String word) {
		TrieNode node=root;
		for (char c:word.toCharArray()) {
			if (node.children[c-'a']==null) {
				node.children[c-'a']=new TrieNode();
			}
			node=node.children[c-'a'];
			
		}
		node.word=word;
	}
	
	public boolean isExited(String word) {
		TrieNode node=root;
		for (char c:word.toCharArray()) {
			if (node.children[c-'a']==null) {
				return false;
			}
			node=node.children[c-'a'];
		}
		
		return true;
	}
	
	public void printTrieDFS(TrieNode root) {
		TrieNode curr=root;
		if (curr==null) return;
		for (TrieNode child:curr.children) {
			if (child!=null) {
				if (child.word!=null) {
					System.out.println(child.word);
				}
				printTrieDFS(child);
			}
			
		}
	}
	
	public void printTrieBFS(TrieNode root) {
		TrieNode curr=root;
		if (curr==null) return;
		Queue<TrieNode> queueT=new LinkedList<>();
		queueT.add(curr);
		while(!queueT.isEmpty()) {
			TrieNode t=queueT.poll();
			for (TrieNode child:t.children) {
				if (child!=null) {
					if (child.word!=null) {
						System.out.println(child.word);
					}
					queueT.add(child);
				}
				
			}
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Trie test=new Trie();
		TrieNode root=test.root;
		//TrieNode root=new TrieNode();
		test.add("hello");
		test.add("helloooo");
		test.add("goodbye");
		test.add("hi");
		//System.out.println(test);
		System.out.println(test.isExited("heello"));
		test.printTrieDFS(root);
		test.printTrieBFS(root);
	}
}
