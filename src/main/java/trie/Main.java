package trie;

public class Main {
	public static void main(String args[]) {
		Trie trie = new Trie();
		trie.insert(10022);
		trie.insert(123123);
		trie.insert(123121);
		trie.insert(123222);

		trie.print();
		

		System.out.println(trie.contains(1002));
	}
}
