package leetcode;

public class Q222_CountCompleteTreeNodes {
	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
    public static int countNodes(TreeNode root) {
        int l = getleft(root); //左儿子的深度
        int r = getright(root); //右儿子的深度
        if(l==r){
        	return (1<<l) - 1;
        }else{
        	return countNodes(root.left) + countNodes(root.right) + 1;
        }
    }
    private static int getleft(TreeNode root){
    	if (root == null)
    		return 0;
    	else
    		return getleft(root.left) + 1;
    }
    private static int getright(TreeNode root){
    	if (root == null)
    		return 0;
    	else
    		return getright(root.right) + 1;
    }
	public static void main(String[] args) {
		TreeNode tree = new TreeNode(1);
		tree.left = new TreeNode(2);
		tree.right = new TreeNode(3);
		tree.left.left = new TreeNode(4);
		tree.left.right = new TreeNode(5);
		System.out.println(countNodes(tree));
	}

}
