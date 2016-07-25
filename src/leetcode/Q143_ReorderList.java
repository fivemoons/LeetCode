package leetcode;

public class Q143_ReorderList {
	static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}
	private static ListNode reverse(ListNode head){ //把list反向
		if (head == null) return null;
		ListNode q0 = null;
		ListNode q1 = head;
		ListNode q2 = head.next;
		while(q2 != null){ //说明还有点未反向
			q1.next = q0;
			q0 = q1;
			q1 = q2;
			q2 = q2.next;
		}
		q1.next = q0;
		return q1;
	}
	public static void reorderList(ListNode head) {
		if (head == null) return;
        //查找一共有多少个num
		int count = 0;
        ListNode cur = head; 
        while(cur!=null){
        		count++;
        		cur =cur.next;
        }
        //把指针移向mid
        int midIndex = count - ((count - 1) >> 1);
        ListNode mid = head;
        while(--midIndex>0){
        		mid = mid.next;
        }
        ListNode head2 = reverse(mid.next); //mid之后的点反向
        mid.next = null;
        
        //合并两个list
        ListNode head1 = head;
        while (head2 != null){
        		ListNode t1 = head1;
        		head1 = head1.next;
        		t1.next = head2;
        		ListNode t2 = head2;
        		head2 = head2.next;
        		t2.next = head1;
        }
    }
	public static void main(String[] args) {
		ListNode ans = new ListNode(0);
		ans.next = new ListNode(1);
		ans.next.next = new ListNode(2);
		ans.next.next.next = new ListNode(3);
		ans.next.next.next.next = new ListNode(4);
		reorderList(ans);
		while(ans!=null){
			System.out.print(ans.val);
			ans = ans.next;
		}
	}

}
