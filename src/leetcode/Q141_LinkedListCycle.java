package leetcode;

public class Q141_LinkedListCycle {
	private static class ListNode {
		@SuppressWarnings("unused")
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
			next = null;
		}
	}
    public static boolean hasCycle(ListNode head) {
    	if ((head == null) || (head.next == null)) return false;
    	ListNode fast = head, slow = head;
    	do {
			slow = slow.next;  //一倍速度走
			fast = fast.next.next; //两倍速度走
		} while ( fast!=slow && fast!=null && fast.next != null );
        return (fast == slow);
    }
	public static void main(String[] args) {
		ListNode ans = new ListNode(1);
		ans.next = new ListNode(2);
		ans.next.next = new ListNode(3);
		ans.next.next.next = ans;
		System.out.println(hasCycle(ans));
	}

}
