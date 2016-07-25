package leetcode;

import java.util.Stack;

public class Q230_KthSmallestElementInABST {
	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
    public static int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        int count = 0;
        
        TreeNode p = root; //当前要遍历的值，如果p为空，则从栈里遍历
        while(!stack.empty() || p!=null){ //两者有一个非空 证明还没遍历完
        		while(p != null){
        			stack.push(p); //存起来一会遍历
        			p = p.left; //先遍历这个点
        		}
        		TreeNode min = stack.pop(); //找出当前最小值
        		count++; //计数，这是第几小了
        		if(count == k) return min.val; //如果是kth 则返回
        		if(min.right != null) p = min.right; //如果当前节点的右子树不为空 入栈。
        }
        return 0;
    }
    public static int kthSmallest2(TreeNode root, int k){
    		int left = findNum(root.left); //左儿子个数
    		if(left + 1 == k){ //如果是根
    			return root.val;
    		}else if(left + 1 < k){ //如果在右边
    			return kthSmallest2(root.right, k - left - 1);
    		}else{
    			return kthSmallest2(root.left, k); //如果在左边
    		}
    }
    private static int findNum(TreeNode root){ //计算节点个数
    		if(root == null) return 0;
    		return findNum(root.left) + findNum(root.right) + 1;
    }
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.right = new TreeNode(2);
		System.out.println(kthSmallest(root,2));

	}

}
