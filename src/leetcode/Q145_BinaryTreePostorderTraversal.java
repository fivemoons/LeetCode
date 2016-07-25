package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

public class Q145_BinaryTreePostorderTraversal {
	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	public static List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<Integer>(); //存放遍历次序
        if(root == null) return ans;
        Stack<TreeNode> stack = new Stack<TreeNode>(); //存放还没有遍历的点
        Set<TreeNode> set = new HashSet<TreeNode>(); //存放已经遍历的点
        
        //在stack中但不在set中说明第一遍遍历过 在，但是没有加入到ans中
        //在stack中并且在
        stack.push(root); //入栈
        while(!stack.empty()){
        		if(!set.contains(stack.peek())){ //如果是第一遍遍历
            		TreeNode cur = stack.peek(); //拿出栈顶元素，但是不出栈。
        			set.add(cur); //增加set，等待第二次遍历
        			if(cur.right !=null) stack.push(cur.right); //右儿子入栈,让左儿子压着右儿子。左儿子先遍历
        			if(cur.left!=null) stack.push(cur.left); //左儿子入栈
        		}else{ //如果是第二遍遍历
        			ans.add(stack.pop().val); //第二遍说明左右儿子都遍历过了，可以加入到ans中
        		}
        }
        return ans;
    }
	public static void main(String[] args) {
		TreeNode t = new TreeNode(3);
		t.left = new TreeNode(1);
		t.right = new TreeNode(2);
		List<Integer> ans = postorderTraversal(t);
		for(Integer i:ans){
			System.out.println(i);
		}
	}

}
