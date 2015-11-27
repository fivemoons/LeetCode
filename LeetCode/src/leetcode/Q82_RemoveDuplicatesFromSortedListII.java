package leetcode;

public class Q82_RemoveDuplicatesFromSortedListII {
	public static class ListNode{
		int val;
		ListNode next;
		ListNode(int x) {val = x;}
	}
	
	public static ListNode deleteDuplicates(ListNode head) {
		ListNode t1 = new ListNode(-1);
		t1.next = head;
		ListNode t2 = head;
		while(t2.next != null){
			System.out.println(t1.val + "___" + t2.val);
			while((t2.next != null) && (t1.next.val == t2.val)) t2 = t2.next;
			t1.next = t2;
			while((t2.next != null) && (t2.next.val != t2.val)) t1 = t1.next;
		}
		return head;
	}
	public static void main(String[] args) {
		ListNode ans = new ListNode(1);
		ans.next = new ListNode(2);
		ans.next.next = new ListNode(3);
		ans.next.next.next = new ListNode(3);
		ans.next.next.next.next = new ListNode(4);
		ans.next.next.next.next.next = new ListNode(4);
		ans.next.next.next.next.next.next = new ListNode(5);
		ans = deleteDuplicates(ans);
		while(ans!=null){
			System.out.print(ans.val);
			ans = ans.next;
		}
	}

}
