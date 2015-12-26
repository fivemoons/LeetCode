package leetcode;

public class Q141_LinkedListCycle {
	private static class ListNode {
		int val;
		 ListNode next;
		 ListNode(int x) {
			val = x;
		 	next = null;
		 }
	}
    public static boolean hasCycle(ListNode head) {
    		if ((head == null) || (head.next == null)) return false;
        ListNode t = head.next;
        while((t!=null) && (t!=head)){
        		t = t.next;
        }
        return t == head;
    }
	public static void main(String[] args) {
		ListNode ans = new ListNode(1);
		ans.next = new ListNode(2);
		ans.next.next = new ListNode(3);
		ans.next.next.next = ans;
		System.out.println(hasCycle(ans));
	}

}
