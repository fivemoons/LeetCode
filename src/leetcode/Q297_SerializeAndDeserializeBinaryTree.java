package leetcode;

public class Q297_SerializeAndDeserializeBinaryTree {
	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}

    // Encodes a tree to a single string.
	private static void dfs(TreeNode root, StringBuilder cur){
		if(root == null)
			cur.append(",null");
		else{
			cur.append(',' + new Integer(root.val).toString());
			dfs(root.left,cur);
			dfs(root.right,cur);
		}
	}
    public static String serialize(TreeNode root) {
        StringBuilder ans = new StringBuilder();
        dfs(root,ans);
        ans.deleteCharAt(0);
        return ans.toString();
    }

    // Decodes your encoded data to tree.
    private static TreeNode dfs2(TreeNode root, StringBuilder cur){//这道题的重点在这里，传引用
    		if (cur.length() == 0) return null;
    		int count = cur.indexOf(",");//找出逗号位置
    		String num = cur.substring(0, count); //当前数
    		cur.delete(0, count+1);//剩下的cur
    		
    		if(num.equals("null"))
    			root = null;
    		else{
    			root = new TreeNode(Integer.valueOf(num));
    			root.left = dfs2(root.left,cur);
    			root.right = dfs2(root.right,cur);
    		}
    		return root;
    }
    public static TreeNode deserialize(String data) {
        TreeNode root = dfs2(null, new StringBuilder(data+','));
        return root;
    }
	public static void main(String[] args) {
		// Your Codec object will be instantiated and called as such:
		// Codec codec = new Codec();
		// codec.deserialize(codec.serialize(root));
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.right.right = new TreeNode(4);
		System.out.println(serialize(root));
		System.out.println(serialize(deserialize(serialize(root))));
	}

}
