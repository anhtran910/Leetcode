package trie;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;


public class WordDictionary {
	
	class TrieNodeD{
		Map<Character, TrieNodeD> children=new HashMap();
		boolean word=false;
		public TrieNodeD() {}
	}
	
	 /** Initialize your data structure here. */
	TrieNodeD dictionary;
    public WordDictionary() {
    	dictionary=new TrieNodeD();
    }
    
    public void addWord(String word) {
    	TrieNodeD dic=dictionary;
        for (char ch:word.toCharArray()) {
        	if(!dic.children.containsKey(ch)) {
        		dic.children.put(ch, new TrieNodeD());
        	
        	}
        	dic=dic.children.get(ch);	
        }
        dic.word=true;
    }
    
    public boolean searchInNode (String word, TrieNodeD dic) {
    	
    	for (int i=0; i<word.length();i++) {
    		char ch=word.charAt(i);
    		if (!dic.children.containsKey(ch)) {
    			if(ch=='.') {
    				for (char x:dic.children.keySet()) {
    					TrieNodeD child=dic.children.get(x);
    					if(searchInNode(word.substring(i+1),child)) {
    						return true;
    					}
    					
    				}
    			}
    			 // if no nodes lead to answer
                // or the current character != '.'
    			return false;
    		} else {
    			// if the character is found
                // go down to the next level in trie
    			dic=dic.children.get(ch);
    		}
    		
    	}
    	return dic.word;
    }
    

/** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
    	TrieNodeD dic=dictionary;
    	return searchInNode(word,dictionary);
    }


/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WordDictionary test=new WordDictionary();
		test.addWord("hello");
		test.addWord("goodbye");
		test.addWord("hallo");
		System.out.println(test.search("goodbye"));
		System.out.println(test.search("halo"));
	}

}
