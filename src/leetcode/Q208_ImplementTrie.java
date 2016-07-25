package leetcode;

import java.util.HashMap;
import java.util.Map;

public class Q208_ImplementTrie {   //前缀树
	class TrieNode {  
	    // Initialize your data structure here.  
	    char c;  //该节点存放的字符
	    boolean leaf;   //该节点是否为叶子节点
	    Map<Character, TrieNode> children = new HashMap<Character, TrieNode>();   //该节点的儿子节点列表
	      
	    public TrieNode(char c) {  
	        this.c = c;  
	    }  
	          
	    public TrieNode(){};  
	}  
	
	public class Trie {
	    private TrieNode root;

	    public Trie() {
	        root = new TrieNode();
	    }

	    // Inserts a word into the trie.
	    public void insert(String word) {
	        Map<Character, TrieNode> children = root.children; //root节点不存字符
	        for(int i=0; i<word.length(); i++){ //依次循环各个节点
	        	char c = word.charAt(i); //当前字符
	        	TrieNode t = null; //当前节点
	        	if(children.containsKey(c)){ //是否包含当前字符
	        		t = children.get(c); //包含，递归
	        	}else{
	        		t = new TrieNode(c); //不包含，新建
	        		children.put(c, t); //加入到当前节点的map中
	        	}
	        	children = t.children; //递归map
	        	if(i==word.length()-1) t.leaf = true; //标识叶子节点
	        }
	    }

	    // Returns if the word is in the trie.
	    public boolean search(String word) {
	        TrieNode t = searchNode(word); //寻找节点
	        return t!=null && t.leaf; //不为空并且为叶子
	    }

	    // Returns if there is any word in the trie
	    // that starts with the given prefix.
	    public boolean startsWith(String prefix) {
	        TrieNode t = searchNode(prefix); //寻找节点
	        return t != null; //不为空即可
	    }
	    
	    private TrieNode searchNode(String word){
	    	Map<Character, TrieNode> children = root.children; //初始map
	    	TrieNode t = null; //要返回的节点。
	    	for(int i=0; i< word.length(); i++){
	    		char c = word.charAt(i);
	    		if(!children.containsKey(c)) return null; //没有找到，返回null
	    		t = children.get(c); //找到了，递归
	    		children = t.children; //递归
	    	}
	    	return t;
	    }
	}
	// Your Trie object will be instantiated and called as such:
	// Trie trie = new Trie();
	// trie.insert("somestring");
	// trie.search("key");
	
	public static void main(String[] args) {
	}

}
