package leetcode;

public class Q2_AddTwoNumbers {
	public class ListNode{
		int val;
		ListNode next;
		ListNode(int x) {val = x;}
	}
	public ListNode addTwoNumbers(ListNode l1, ListNode l2){
		ListNode l3 = new ListNode(0);
		ListNode ans = l3;
		
		while (l1!=null && l2!=null){
			l3.val += l1.val + l2.val;
			l3.next = new ListNode(l3.val / 10);
			if (l3.val>=10) l3.val -= 10;
			l1 = l1.next;
			l2 = l2.next;
			if (l1==null && l2==null && l3.next.val == 0) l3.next = null;
			l3 = l3.next;
		}
		ListNode rest;
		if (l1 == null)
			rest = l2;
		else 
			rest = l1;
		
		while (rest!=null){
			l3.val += rest.val;
			l3.next = new ListNode(l3.val /10);
			if (l3.val>=10) l3.val -= 10;
			rest = rest.next;
			if (rest==null && l3.next.val == 0) l3.next = null;
			l3 = l3.next;
		}
		return ans;
	}
}
