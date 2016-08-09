package leetcode2.tree;

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { val = x; }
}

class ListNode {
	int val;
	ListNode next;
	ListNode(int x) { val = x;}
}

public class Q109_ConvertSortedListToBinarySearchTree {
	private ListNode prehead = new ListNode(0);
    public TreeNode sortedListToBST(ListNode head) {
        int len = 0;
        ListNode p = head;
        while (p!=null){
            p = p.next;
            len ++;
        }
        prehead = head;
        return sortedListToBST2(0, len-1);
    }
    private TreeNode sortedListToBST2(int st, int ed){
        if (st > ed) return null;
        int md = st + (ed - st) / 2;
        TreeNode p = new TreeNode(0);
        p.left = sortedListToBST2(st, md-1);
        p.val = prehead.val;
        prehead = prehead.next;
        p.right = sortedListToBST2(md+1, ed);
        return p;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
