package leetcode;

public class Q147_InsertionSortList {
	static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}
    public static ListNode insertionSortList(ListNode head) {
    	ListNode ans = new ListNode(-1);
        while(head != null){
        		ListNode p = ans;
        		for(p=ans;
        			p.next != null && p.next.val < head.val;
        			p = p.next);
        		ListNode t = head.next;
        		head.next = p.next;
        		p.next = head;
        		head = t;
        }
        return ans.next;
    }
	public static void main(String[] args) {
		ListNode head = new ListNode(2);
//		head.next = new ListNode(4);
//		head.next.next = new ListNode(1);
		ListNode ans = insertionSortList(head);
		while(ans!=null){
			System.out.println(ans.val);
			ans = ans.next;
		}
	}

}
