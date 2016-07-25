package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Q113_PathSumII {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	private static void dfs(List<List<Integer>> ans, List<Integer> now, TreeNode root, int sum){
		if (root == null) return; //真有空树
		now.add(root.val); //增加根结点
		if ((root.left == null)&&(root.right == null)&&(sum == root.val)) //找到答案
			ans.add(new ArrayList<Integer>(now));
		else{
			if (root.left != null)
				dfs(ans,now,root.left,sum - root.val); //递归左子树
			if (root.right != null)
				dfs(ans,now,root.right,sum - root.val); //递归右子树
		}
		now.remove(now.size()-1);
	}
    public static List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> ans = new LinkedList<List<Integer>>();
        dfs(ans,new ArrayList<Integer>(),root,sum);
        return ans;
    }
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		List<List<Integer>> ans = pathSum(root,3);
		for(List<Integer> list : ans)
			for(Integer i: list)
				System.out.println(i);
	}

}
