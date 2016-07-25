package leetcode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Q199_BinaryTreeRightSideView {
	static class TreeNode{
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	public static List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new LinkedList<Integer>(); //存放答案
        Queue<TreeNode> queue = new LinkedList<TreeNode>(); //层序遍历队列
		if (root == null) return ans; 
        queue.add(root);
        queue.add(null); //每一层之间的分隔符
        while(!queue.isEmpty()){ //终止条件
        	TreeNode temp = queue.poll(); //每次拿出队头元素
        	if (temp == null){ //如果是空的
        		if (!queue.isEmpty()) //说明还有下一层，下一层已经全部入队
        			queue.add(null); //加入下一层的间隔
        	}else{ //如果是一个非null元素
        		if (queue.peek() == null) //如果是每一层的最后一个元素
        			ans.add(temp.val); //则加入到ans中
        		if (temp.left != null) //如果左儿子存在，则左儿子入队
        			queue.add(temp.left);
        		if (temp.right != null) //如果右儿子存在，则右儿子入队
        			queue.add(temp.right);
        	}
        }
        return ans;
    }
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.left.right = new TreeNode(5);
		root.right = new TreeNode(3);
		root.right.right = new TreeNode(4);
		List<Integer> ans = rightSideView(null);
		for(Integer i:ans){
			System.out.println(i);
		}
	}

}
