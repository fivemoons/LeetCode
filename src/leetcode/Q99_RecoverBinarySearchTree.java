package leetcode;

public class Q99_RecoverBinarySearchTree {
	/*
	 * 寻找中序遍历的逆序对，交换逆序对
	 * 正常中序遍历 o(n) 空间复杂度
	 * Morris中序遍历 o(1) 空间复杂度，遍历坐子树的时候让其最后一个点的右子树设为根
	 */
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	
    public static void recoverTree(TreeNode root) {
    		//#是本题需要
    		TreeNode sw1 = null; //#
    		TreeNode sw2 = null; //#要交换的两个指针
    		TreeNode p0 = null; //#前一个指针
    		TreeNode p1 = root; //当前指针
    		while(p1!=null){
    			if (p1.left!=null){ //左儿子存在
    				TreeNode lrrr = p1.left; //寻找lrrr
    				while((lrrr.right != null)&&(lrrr.right != p1)) lrrr = lrrr.right; //寻找lrrr，不能循环
    				if(lrrr.right == null){ //第一次到这里，找到了lrrr
    					lrrr.right = p1; //设为根
    					p1 = p1.left; //遍历左节点
    				}else{ //第二次到这里，lrrr找到了但是指向了自己，说明已经遍历完左子树
    					lrrr.right = null; //lrrr右子树恢复原状
    					if ((p0!=null) && (p0.val > p1.val)){ //#找到了一个突出值，和第二个凹陷值之间
        					if (sw1 == null) sw1 = p0; //#突出值
        					sw2 = p1; //#一直更新 知道那个需要交换的节点
        				}
    					p0 = p1; //#前一个点设为p1
    					p1 = p1.right; //遍历右子树
    				}
    			}else{ //左儿子不存在
    				if ((p0!=null) && (p0.val > p1.val)){ //#找到了一个突出值，和第二个凹陷值之间
    					if (sw1 == null) sw1 = p0; //#突出值
    					sw2 = p1; //#一直更新 知道那个需要交换的节点
    				}
    				p0 = p1; //#把前一个节点设为当前节点
    				p1 = p1.right; //当前节点寻找下一个
    			}
    		}
    		int temp = sw1.val; //#交换
    		sw1.val = sw2.val; //#
    		sw2.val = temp; //#
    }
	public static void main(String[] args) {
		TreeNode ans = new TreeNode(0);
		ans.left = new TreeNode(1);
		recoverTree(ans);
		System.out.println(ans.val);
		System.out.println(ans.left.val);
	}

}
