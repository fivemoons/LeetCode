package leetcode;

public class Q109_ConvertSortedListToBinarySearchTree {
	public static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	private static int len(ListNode head){ //length
		ListNode p = head;
		int len = 0;
		while(p!=null){
			p = p.next;
			len++;
		}
		return len;
	}
	private static ListNode find(ListNode head, int n){ //从0开始
		ListNode p  = head;
		while(n-->0){
			p = p.next;
		}
		return p;
	}
    private static TreeNode sortedListToBST(ListNode head, int len){
        if (len == 0) return null;
        if (len == 1) return new TreeNode(head.val);
        TreeNode root = new TreeNode(find(head,len / 2).val); //根结点
        root.left  = sortedListToBST(head, len / 2); //左树
        root.right = sortedListToBST(find(head,len / 2 + 1), len - len / 2 - 1); //右树
        return root;
    }
    public static TreeNode sortedListToBST(ListNode head){
    		return sortedListToBST(head, len(head));
    }
    //自底而上
    private static ListNode prihead;
    private static TreeNode sortedListToBST2(int start, int end){
    		if (start > end) return null; //空节点
    		int mid = start + (end - start) / 2; //中间结点
    		TreeNode root = new TreeNode(0); //新建一个点
    		root.left  = sortedListToBST2(start,mid-1); //左儿子
    		root.val = prihead.val; //根结点
    		prihead = prihead.next; //只遍历一遍
    		root.right = sortedListToBST2(mid+1,end); //右儿子
    		return root; //返回答案
    }
    public static TreeNode sortedListToBST2(ListNode head){
    		ListNode p = head;
    		int len = 0;
    		while(p!=null){
    			p = p.next;
    			len++;
    		}
    		prihead = head;
    		return sortedListToBST2(0, len - 1);
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
