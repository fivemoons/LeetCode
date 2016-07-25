package leetcode;

import java.util.LinkedList;
import java.util.List;

public class Q95_UniqueBinarySearchTreesII {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	private static List<TreeNode> gen(int l, int r){
		List<TreeNode> ans = new LinkedList<TreeNode>(); //当前区间能建立多少棵子树
		if (l>r){ //区间不对
			ans.add(null); //注意：因为后面要迭代进入，如果list.size是0则不会进入，null时会进入并将空子树设为null
			return ans; //返回含有一个null的list
		}else{
			for(int i=l; i<=r; i++){ //枚举根结点
				List<TreeNode> ansl = gen(l,i-1); //依次生成左子树的所有可能
				List<TreeNode> ansr = gen(i+1,r); //依次生成右子树的所有可能
				for(TreeNode tl : ansl){ //枚举左子树的每一种可能
					for(TreeNode tr : ansr){ //枚举右子树的每一种可能
						TreeNode m = new TreeNode(i); //新建根结点
						m.left = tl; //配置左子树
						m.right = tr; //配置右子树
						ans.add(m); //将这组答案增加到ans中
					}
				}
			}
		}
		return ans;
	}
    public static List<TreeNode> generateTrees(int n) {
    		if (n==0)
    			return new LinkedList<TreeNode>();
    		else
    			return gen(1,n);
    }
	public static void main(String[] args) {
		List<TreeNode> ans = generateTrees(4);
		System.out.println(ans.size());
	}

}
