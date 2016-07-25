package leetcode;

public class Q82_RemoveDuplicatesFromSortedListII {
	public static class ListNode{
		int val;
		ListNode next;
		ListNode(int x) {val = x;}
	}
	
	public static ListNode deleteDuplicates(ListNode head) { //注意：空间复杂度
		ListNode t1 = new ListNode(-1);//制造上帝节点。。
		t1.next = head; //增加第一个点
		ListNode t2 = head; //增加第二个点
		head = t1; //头指针前移
		while(t2 != null){ //t2用来依次遍历原list
			boolean dup = false; //默认t2点是不重复的
			while((t2.next != null) && (t2.next.val == t2.val)){ //判断点重复的条件
				t2 = t2.next; //再往后走
				dup =true; //该点是重复点
			}
			if(!dup){ //如果不是重复点，则把t2现在的点加入答案中
				t1.next = t2; //t2加入答案中
				t1 = t1.next; //t1后移
			}
			t2 = t2.next; //不管t2点是不是重复点，都需要t2后移
		}
		t1.next = null; //最后要把t1的next设为null 以免最后答案是重复点的时候t1.next没有越过最后的重复点。而最后是非重复点则无所谓，因为t1已经指向最后一个点。
		return head.next;
	}
	public static void main(String[] args) {
		ListNode ans = new ListNode(1);
		ans.next = new ListNode(1);
		ans.next.next = new ListNode(2);
		/*ans.next.next.next = new ListNode(3);
		ans.next.next.next.next = new ListNode(4);
		ans.next.next.next.next.next = new ListNode(4);
		ans.next.next.next.next.next.next = new ListNode(5);*/
		ans = deleteDuplicates(ans);
		while(ans!=null){
			System.out.print(ans.val);
			ans = ans.next;
		}
	}

}
