package leetcode2.list;

public class Q109_ConvertSortedListToBinarySearchTree {
	static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}
	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	private static ListNode last = null;
	public static TreeNode sortedListToBST(int l, int r){
		if(l>=r) return null;
		int m = l + ((r-l) >> 1);
		TreeNode root = new TreeNode(0);
		root.left = sortedListToBST(l,m);
		root.val = last.val;
		last = last.next;
		root.right = sortedListToBST(m+1,r);
		return root;
	}
	public static TreeNode sortedListToBST(ListNode head){
		ListNode t = head;
		int len = 0;
		while(t!=null){
			len++;
			t = t.next;
		}
		last = head;
		return sortedListToBST(0,len);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
