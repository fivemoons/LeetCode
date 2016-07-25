package leetcode;

public class Q206_ReverseLinkedList {
	static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}
    public static ListNode reverseList(ListNode head) { //递归版
        if (head == null || head.next == null) return head;
        
        ListNode l1 = head.next; //head的next
        ListNode ans = reverseList(l1); //head的next转换
        head.next = null; //head的next设为null
        l1.next = head; //head的next转换后的next设为head
        return ans;
    }
    public static ListNode reverselList2(ListNode head){ //非递归版
    	if (head == null || head.next == null) return head;
        
        ListNode t0 = null; //虚拟节点
        ListNode t1 = head;
        ListNode t2 = head.next;
        while(t1 != null){ //中间结点不为空
        		t2 = t1.next; //t2是next
        		t1.next = t0; //指针前移
        		t0 = t1; //t0后移
        		t1 = t2; //t1后移
        }
        return t0;
    }
	public static void main(String[] args) {
		ListNode ans = new ListNode(1);
		ans.next = new ListNode(2);
		ans = reverselList2(ans);
		while(ans != null){
			System.out.print(ans.val);
			ans = ans.next;
		}

	}

}
