package leetcode2.list;

public class Q2_AddTwoNumbers {
	static class ListNode{
		int val;
		ListNode next;
		ListNode(int x) {val = x;}
	}
	public ListNode addTwoNumbers(ListNode l1, ListNode l2){
		ListNode p = new ListNode(0);
        ListNode ans = p;
        while(l1!=null && l2!=null){
            p.next = new ListNode(l1.val + l2.val + p.val / 10);
            p.val = p.val % 10;
            p = p.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        while(l1!=null){
            p.next = new ListNode(l1.val + p.val / 10);
            p.val = p.val % 10;
            p = p.next;
            l1 = l1.next;
        }
        while(l2!=null){
            p.next = new ListNode(l2.val + p.val / 10);
            p.val = p.val % 10;
            p = p.next;
            l2 = l2.next;
        }
        if (p.val / 10 > 0){
            p.next = new ListNode(p.val / 10);
            p.val = p.val % 10;
            p = p.next;
        }
        return ans.next;
	}
}
