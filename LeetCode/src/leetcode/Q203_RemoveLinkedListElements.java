package leetcode;

public class Q203_RemoveLinkedListElements {
	static class ListNode{
		int val;
		ListNode next;
		ListNode(int x){ val = x; }
	}
    public static ListNode removeElements(ListNode head, int val) {
    	if (head == null) return null; //空
        while((head!=null)&&(head.val == val)) head = head.next; //前导val
        ListNode t = head; //遍历指针
        while((t!=null)&&(t.next!=null)){ //枚举
        	if (t.next.val == val)
        		t.next = t.next.next; //越过val
        	else
        		t = t.next;
        }
        return head;
    }
	public static void main(String[] args) {
		ListNode ans = new ListNode(1);
		ans.next = new ListNode(2);
		ans.next.next = new ListNode(6);
		ans.next.next.next = new ListNode(3);
		ans.next.next.next.next = new ListNode(4);
		ans.next.next.next.next.next = new ListNode(5);
		ans.next.next.next.next.next.next = new ListNode(6);
		ans = removeElements(ans, 1);
		while(ans != null){
			System.out.print(ans.val);
			ans = ans.next;
		}
	}

}
