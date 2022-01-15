package trie;


import java.util.LinkedList;
import java.util.Queue;
import java.util.SortedMap;

public class Trie {
	TrieNode root;
	Trie() { 
		root = new TrieNode();
	} 
	

	public void insert(int num) {
		String str = String.valueOf(num);
		TrieNode current = root;

		if(str.length() == 0) {
			root.setEndOfWord();
			return;}

		int i = 0;
		while(i<str.length()) {
			char c= str.charAt(i);
			if(current.contains(c)) {
				current = current.get(c);
			}else {
				TrieNode temp = new TrieNode();
				temp.parent = current;
				current.childrenSize++;
				current.put(c, temp);
				current = temp;
			}
			i++;
		}
		current.endOfWord=true;
	}
	public boolean contains(int num) { 
		String str = String.valueOf(num);
		TrieNode current = root;

		int i = 0;
		while(i<str.length()) {
			char c= str.charAt(i);
			if(current.contains(c)) {
				current = current.get(c);
			}else {
				return false;
			}
			i++;
		}
		return current.endOfWord;
	}

	public void delete(int num) {
		String word = String.valueOf(num);
		delete(root, word, 0);
	}

	private boolean delete(TrieNode current, String word, int index) {
		if (index == word.length()) {
			//when end of word is reached only delete if currrent.endOfWord is true.
			if (!current.endOfWord) {
				return false;
			}
			current.endOfWord = false;
			//if current has no other mapping then return true
			return current.childrenSize == 0;
		}
		char ch = word.charAt(index);
		TrieNode node = current.children.get(ch);
		if (node == null) {
			return false;
		}
		boolean shouldDeleteCurrentNode = delete(node, word, index + 1);

		//if true is returned then delete the mapping of character and trienode reference from map.
		if (shouldDeleteCurrentNode) {
			current.children.remove(ch);
			//return true if no mappings are left in the map.
			return current.children.size() == 0;
		}
		return false;
	}

	public void print() {
		Queue<TrieNode> currentQueue = new LinkedList<TrieNode>();
		Queue<TrieNode> nextLevelQueue = new LinkedList<TrieNode>();
		currentQueue.add(root);

		while(!currentQueue.isEmpty()) {
			TrieNode node = currentQueue.poll();
			for(Character c: node.children.keySet()) {
				System.out.print(c+" ");
				nextLevelQueue.add(node.get(c));
			}
			if(currentQueue.isEmpty()) {
				currentQueue = nextLevelQueue;
				nextLevelQueue = new LinkedList<TrieNode>();
				System.out.println();
			}
		}
	}
}
