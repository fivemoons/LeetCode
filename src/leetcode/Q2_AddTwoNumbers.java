package leetcode;

public class Q2_AddTwoNumbers {
	static class ListNode{
		int val;
		ListNode next;
		ListNode(int x) {val = x;}
	}
	public ListNode addTwoNumbers(ListNode l1, ListNode l2){
		ListNode l3 = new ListNode(0);
		ListNode ans = l3;
		
		while(l1!=null && l2!=null){
			l3.next = new ListNode(l1.val + l2.val);
			l1 = l1.next;
			l2 = l2.next;
			l3 = l3.next;
		}
		while(l1!=null){
			l3.next = new ListNode(l1.val);
			l1 = l1.next;
			l3 = l3.next;
		}
		while(l2!=null){
			l3.next = new ListNode(l2.val);
			l2 = l2.next;
			l3 = l3.next;
		}
		l3 = ans.next;
		while(l3!=null){
			if(l3.val>=10){
				if(l3.next == null) l3.next = new ListNode(0);
				l3.next.val += l3.val / 10;
				l3.val = l3.val % 10;
			}
			l3 = l3.next;
		}
		return ans.next;
	}
}
