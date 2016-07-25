package leetcode;

public class Q24_SwapNodesInPairs {
	public static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
		}
	}

	public static ListNode swapPairs(ListNode head) {//交换临近两个
		if (head==null) //有0个点
			return null;
		if (head.next==null) //有1个点
			return head;
		ListNode ans = head.next; //第二个点作为返回值
		head.next = swapPairs(ans.next); //第一个点的next设为递归后面的部分。
		ans.next = head; //第二个点next设为第一个点
		return ans;
	}

	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head = swapPairs(head);
		while (head != null){
			System.out.println(head.val);
			head = head.next;
		}
	}

}
