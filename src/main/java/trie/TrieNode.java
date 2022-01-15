package trie;
import java.util.SortedMap;
import java.util.TreeMap;

public class TrieNode {
	SortedMap<Character, TrieNode> children;
	boolean endOfWord;
	TrieNode parent;
	int childrenSize=0;
	TrieNode() {
		children = new TreeMap<Character, TrieNode>();
		endOfWord = false;
	}
	
	boolean contains(Character c) {
		return children.containsKey(c);
	}
	TrieNode get(Character c) {
		return children.get(c);
	}
	void put(Character c, TrieNode temp) {
		children.put(c, temp);
	}
	void setEndOfWord() {
		endOfWord =true;
	}
}
