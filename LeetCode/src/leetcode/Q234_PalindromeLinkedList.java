package leetcode;

public class Q234_PalindromeLinkedList {
	static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}
    public static boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null) return true;
        ListNode slow = head;
        ListNode fast = head;
        //寻找中点
        while(fast.next!=null && fast.next.next!=null){
        		fast = fast.next.next;
        		slow = slow.next;
        }
        ListNode mid = slow.next;
        slow.next = null;
        //1 2 3 2 1
        //      m
        //1 2 3 3 2 1
        //      m
        //转换后半
        ListNode t0 = null;
        ListNode t1 = mid;
        ListNode t2 = mid.next;
        while(t2 != null){
        		t1.next = t0;
        		t0 = t1;
        		t1 = t2;
        		t2 = t2.next;
        }
        t1.next = t0;
        mid = t1;
        
        //mid是后半部分
        while(head != null && mid != null){
        		if(head.val != mid.val) return false;
        		head = head.next;
        		mid = mid.next;
        }
        return true;
    }
	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(1);
		head.next.next = new ListNode(2);
		head.next.next.next = new ListNode(1);
		System.out.println(isPalindrome(head));
	}

}
