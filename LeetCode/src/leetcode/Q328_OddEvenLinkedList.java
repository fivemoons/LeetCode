package leetcode;

public class Q328_OddEvenLinkedList {
	static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}
	public static ListNode oddEvenList(ListNode head) {
		/*
		 *  1 2 3 4 5 6 7 8
		 *  1 3 5 7 2 4 6 8
		 */
		if (head == null || head.next == null) return head;
		ListNode odd = head;
		ListNode even = head.next;
		ListNode ans2 = even;
		while(even.next!=null && even.next.next!=null){
			odd.next = even.next;
			odd = odd.next;
			even.next = odd.next;
			even = even.next;
		}
		if(even.next==null){
			odd.next = ans2;
		}else if(even.next.next==null){
			odd.next = even.next;
			odd = odd.next;
			even.next = null;
			odd.next = ans2;
		}
		return head;
    }
	public static void main(String[] args) {
		ListNode ans = new ListNode(1);
		//ans.next = new ListNode(2);
		//ans.next.next = new ListNode(3);
		//ans.next.next.next = new ListNode(4);
		//ans.next.next.next.next  = new ListNode(5);
		ans = oddEvenList(ans);
		while(ans != null){
			System.out.println(ans.val);
			ans = ans.next;
		}
	}

}
