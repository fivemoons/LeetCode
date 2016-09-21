package leetcode2.list;

public class Q206_ReverseLinkedList {
	static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}
	public ListNode reverseList(ListNode head) {
        if(head == null) return null;
        if(head.next == null) return head;
        ListNode l1 = head.next;
        ListNode ans = reverseList(l1);
        l1.next = head;
        head.next = null;
        return ans;
    }
	public ListNode reverseList2(ListNode head){
		ListNode t0 = null;
        ListNode t1 = head;
        ListNode t2 = null;
        while(t1 != null){
            t2 = t1.next;
            t1.next = t0;
            t0 = t1;
            t1 = t2;
        }
        return t0;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
