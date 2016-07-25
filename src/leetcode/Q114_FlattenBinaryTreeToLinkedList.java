package leetcode;

import java.util.Stack;

public class Q114_FlattenBinaryTreeToLinkedList {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
    public void flatten(TreeNode root) { //把左子树放在根和右子树之间
    		if (root == null) return; //空节点返回
    		flatten(root.left); //左子树已经拍扁
    		flatten(root.right); //右子树也已经拍扁
    		if (root.left != null){ //有左子树
    			TreeNode p = root.left;
    			while(p.right!=null) p = p.right; //找到左子树的最右一个点
    			p.right = root.right; //最后一个点的右子树设为根结点的右子树
    			root.right = root.left; //根结点的右子树设为左子树
    			root.left = null; //左子树设为null
    		}
    }
    private TreeNode flatten(TreeNode root, TreeNode tail){//对于每一个点，返回拍扁后的点，把tail放在后面
    		if (root == null) return tail; //如果是null 返回后面的节点
    		root.right = flatten(root.left, flatten(root.right, tail));//右子树是左子树拍扁，接在拍扁的右子树上，右子树接上tail
    		root.left = null; //左子树设为null
    		return root;
    }
    public void flatten2(TreeNode root){
    		flatten(root, null);
    }
    public void flatten3(TreeNode root){
    		if (root ==null) return;
    		Stack<TreeNode> s = new Stack<TreeNode>();
    		s.push(root);//根结点
    		while(!s.empty()){ //非空
    			TreeNode p = s.pop();//得到首节点
    			if(p.right!=null) s.push(p.right); //右子树进栈
    			if(p.left!=null) s.push(p.left); //左子树进栈
    			p.left = null;//左子树置空
    			if (!s.empty()) p.right = s.peek();//右子树设栈顶
    		}
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
