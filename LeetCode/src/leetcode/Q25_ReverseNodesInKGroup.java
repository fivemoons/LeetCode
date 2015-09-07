package leetcode;

public class Q25_ReverseNodesInKGroup {
	public static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public static ListNode reverseKGroup(ListNode head, int k) {
		if (head == null) return null; //当前0个节点
		int sub = k - 1; //需要移动的长度
		ListNode tail = head; //尾指针
		while (sub-->0){ //找到最后一个点
			if (tail.next==null) //不足k个点 ，不移动返回head
				return head;
			else
				tail = tail.next;//后移一位
		}
		ListNode t0 = null;//前一个点
		ListNode t1 = head;//当前点
		ListNode t2 = head.next;//后一个点，最后一个点的时候可能为空
		while (t1!=tail){ //判断当前点是否为尾指针
			t1.next = t0; //当前点的next指向前一个点
			t0 = t1; //前一个点指针后移
			t1 = t2; //当前点指针后移
			t2 = t2.next;//后一个点指针后移
		}
		t1.next = t0;//尾指针指向前一个点
		head.next = reverseKGroup(t2,k); //原来的头指针的next改成t2之后的点的递归
		return tail;
	}

	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		head = reverseKGroup(head, 3);
		while (head != null) {
			System.out.println(head.val);
			head = head.next;
		}
	}

}
