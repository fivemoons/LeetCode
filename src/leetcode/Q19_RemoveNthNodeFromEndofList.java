package leetcode;

public class Q19_RemoveNthNodeFromEndofList {
	public static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
		}
	}
	
	public static ListNode removeNthFromEnd(ListNode head, int n) {
		ListNode ans = new ListNode(0); //申请一个假节点。
		ans.next = head; //next指向head
		ListNode end = ans; //遍历到末尾
		ListNode del = ans; //要删除的点的前一个节点
		for(int i=0; i<n; i++) //end后移n位
			end = end.next;
		while (end.next!=null){//end del一起后移直到末尾
			end = end.next;
			del = del.next;
		}
		del.next = del.next.next; //删除del.next
        return ans.next;
    }

	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		head = removeNthFromEnd(head,5);
		while (head!=null){
			System.out.print(head.val+"_");
			head = head.next;
		}
	}

}
