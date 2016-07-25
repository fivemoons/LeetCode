package leetcode;

import java.util.Stack;

class TreeNode{
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x){ val = x; }
}

public class Q173_BinarySearchTreeIterator {
	Stack<TreeNode> stack;
	
	public Q173_BinarySearchTreeIterator(TreeNode root){ //构造函数，用root输出化一个stack
		stack = new Stack<TreeNode>();
		while(root != null){ //将最小的数入栈。
			stack.push(root);
			root = root.left; //栈顶是最小数
		}
	}
	
	public boolean hasNext(){
		return !stack.empty();
	}
	
	public int next(){
		TreeNode node = stack.pop(); //栈顶是最小数
		int ans = node.val; //返回答案
		if (node.right != null){ //出栈的点有没有右分支，比父节点小，比该节点大
			node = node.right; //移动到右儿子
			while(node != null){
				stack.push(node); //找右儿子的最左节点
				node = node.left; //依次挪到左节点
			}
		}
		return ans;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
