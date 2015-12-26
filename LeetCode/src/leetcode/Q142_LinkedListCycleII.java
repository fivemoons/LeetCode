package leetcode;

public class Q142_LinkedListCycleII {
	private static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
			next = null;
		}
	}
	public static ListNode detectCycle(ListNode head) {
    	if ((head == null) || (head.next == null)) return null;
    	ListNode fast = head, slow = head;
    	do {
			slow = slow.next;  //一倍速度走
			fast = fast.next.next; //两倍速度走
		} while ( fast!=slow && fast!=null && fast.next != null );
        if (fast != slow)
        	return null;
        else{
        	ListNode ans;
        	for(ans = head; ans != slow; ans=ans.next, slow=slow.next);
        	return ans;
        }
    }
	public static void main(String[] args) {
		ListNode ans = new ListNode(1);
		ans.next = new ListNode(2);
		ans.next.next = new ListNode(3);
		ans.next.next.next = ans.next;
		System.out.println(detectCycle(ans).val);
	}

}
