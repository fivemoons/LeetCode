package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Q212_WordSearchII {
	static class TrieNode{
		char c;
		boolean leaf;
		Map<Character, TrieNode> children = new HashMap<Character, TrieNode>();
		
		public TrieNode(char c){
			this.c = c;
		}
		public TrieNode(){};
	}
	static class Trie{
		private TrieNode root;
		public Trie(){
			root = new TrieNode();
		}
		public void insert(String word){
			Map<Character, TrieNode> map = root.children;
			for(int i=0; i<word.length(); i++){
				char c = word.charAt(i);
				TrieNode t;
				if(map.containsKey(c)){
					t = map.get(c);
				}else{
					t = new TrieNode(c);
					map.put(c, t);
				}
				map = t.children;
				if (i==word.length() -1) t.leaf = true;
			}
		}
		public boolean search(String word){
			TrieNode t = searchNode(word);
			return t!=null && t.leaf;
		}
		public boolean startsWith(String prefix){
			TrieNode t = searchNode(prefix);
			return t!=null;
		}
		private TrieNode searchNode(String word){
			Map<Character, TrieNode> map = root.children;
			TrieNode t = null;
			for(int i=0; i<word.length(); i++){
				char c = word.charAt(i);
				if(!map.containsKey(c)) return null;
				t = map.get(c);
				map = t.children;
			}
			return t;
		}
	}
    public static List<String> findWords(char[][] board, String[] words) { //思路：先将words加入到Trie中，然后遍历数组中的每一个节点展开
        Set<String> ans = new HashSet<String>();
        if((board==null) || (board.length == 0)) return new ArrayList<String>();
        if((words==null) || (words.length == 0)) return new ArrayList<String>();
        boolean[][] visited = new boolean[board.length][board[0].length];
        
        Trie trie = new Trie(); //新建一个Trie树
        for(String word : words){
        	trie.insert(word); //存放的是单词列表
        }
        
        for(int i=0; i<board.length; i++){
        	for(int j=0; j<board[0].length; j++){
        		dfs(board, visited, trie, i, j, new StringBuffer(), ans); //搜索每个开始的地方
        	}
        }
        
        return new ArrayList<String>(ans);
    }
    
    private static void dfs(char[][] board, boolean[][] visited, Trie trie, int i, int j, StringBuffer sb, Set<String> ans){
    	if(i<0 || i>=board.length) return;
    	if(j<0 || j>=board[0].length) return;
    	if(visited[i][j]) return;
    	sb.append(board[i][j]);
    	String s = sb.toString();
    	visited[i][j] = true;
    	if(trie.startsWith(s)){ //这个单词是前缀  还可以
    		if(trie.search(s)) ans.add(s); //确实是单词
    		dfs(board, visited, trie, i-1, j, sb, ans);
    		dfs(board, visited, trie, i+1, j, sb, ans);
    		dfs(board, visited, trie, i, j-1, sb, ans);
    		dfs(board, visited, trie, i, j+1, sb, ans);
    	}
    	sb.deleteCharAt(sb.length() - 1);
    	visited[i][j] = false;
    }
	public static void main(String[] args) {
		List<String> ans = findWords(new char[][]{{'a','a','a','a'},{'a','a','a','a'},{'a','a','a','a'}},
			new String[]{"aaaaaaaaaaaa","aaaaaaaaaaaaa","aaaaaaaaaaab"});
		for(String s:ans){
			System.out.println(s);
		}
	}

}
