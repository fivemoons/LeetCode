package leetcode;
import java.util.HashMap;
import java.util.Map;

class WordTrieNode {
    boolean isWord;
    int index;
    Map<Character, WordTrieNode> nexts;
    public WordTrieNode() {
        nexts = new HashMap<Character, WordTrieNode>();
    } 
}

public class Q211_AddAndSearchWord_DataStructureDesign {
	private WordTrieNode root = new WordTrieNode();

	// 增加一个单词进入Trie树
	public void addWord(String word) {
		WordTrieNode p = root;
		int i = 0, len = word.length(); //i是当前深度。len是最大深度
		while (i < len) { //这层循环走存在的路径
			char c = word.charAt(i);
			if (p.nexts.containsKey(c)) {
				p = p.nexts.get(c);
				i++;
			} else {
				break;
			}
		}
		while (i < len) { //这层循环走新建的路径
			WordTrieNode newNode = new WordTrieNode(); //新建一个分支
			newNode.index = i; //当前节点的层数
			p.nexts.put(word.charAt(i), newNode);
			p = newNode;
			i++;
		}
		p.isWord = true; //标识单词节点
	}

	// Returns if the word is in the data structure. A word could
	// contain the dot character '.' to represent any one letter.
	public boolean search(String word) {
		if (word == null || word.length() == 0) {
			return false;
		}
		WordTrieNode p = root;
		return dfs(word, 0, p);
	}

	private boolean dfs(String word, int index, WordTrieNode p) { //单词，层数，节点
		if (index == word.length() - 1) { //最后一层，防止陷入递归栈中
			if (word.charAt(index) == '.') {
				for (WordTrieNode node : p.nexts.values()) { //枚举每一个
					if (node.isWord) { //判断是否是叶子
						return true;
					}
				}
				return false;
			} else {
				WordTrieNode endNode = p.nexts.get(word.charAt(index)); //判断是否是单词节点
				return endNode != null && endNode.isWord;
			}
		}

		if (word.charAt(index) == '.') { //.的情况
			boolean res = false;
			for (WordTrieNode node : p.nexts.values()) {
				res |= dfs(word, index + 1, node); //递归看是否可以
			}
			return res;
		} else {
			if (p.nexts.containsKey(word.charAt(index))) { //包含当前节点
				return dfs(word, index + 1, p.nexts.get(word.charAt(index)));
			} else { //不包含
				return false; 
			}
		}
	}
}
// Your WordDictionary object will be instantiated and called as such:
// WordDictionary wordDictionary = new WordDictionary();
// wordDictionary.addWord("word");
// wordDictionary.search("pattern");