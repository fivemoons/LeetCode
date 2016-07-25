package leetcode;

public class Q83_RemoveDuplicatesFromSortedList {
	public static class ListNode{
		int val;
		ListNode next;
		ListNode(int x) {val = x;}
	}
	
	public static ListNode deleteDuplicates(ListNode head) { //注意：空间复杂度
		ListNode t = head; //保护head节点，使用t迭代
		while (t!=null){ //当t不为空的时候
			while ((t.next != null) && (t.next.val == t.val)){ //判断当前点 和 next 是否是重复的节点
				t.next = t.next.next; //如果当前点是重复节点，则把第一个点移除list
			}
			t = t.next; //当前位置的重复节点全部都移除后，把t后移一位。
		}
		return head;
	}
	public static void main(String[] args) {
		ListNode ans = new ListNode(1);
		ans.next = new ListNode(1);
		ans.next.next = new ListNode(2);
		ans.next.next.next = new ListNode(3);
		ans.next.next.next.next = new ListNode(4);
		ans.next.next.next.next.next = new ListNode(4);
		ans.next.next.next.next.next.next = new ListNode(5);
		ans = deleteDuplicates(ans);
		while(ans!=null){
			System.out.print(ans.val);
			ans = ans.next;
		}
	}

}
