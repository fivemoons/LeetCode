package leetcode;

public class Q86_PartitionList {
	public static class ListNode {
	     int val;
	     ListNode next;
	     ListNode(int x) { val = x; }
	}
	public static ListNode partition(ListNode head, int x) {
		ListNode before = new ListNode(-1); //创造小区的上帝节点
		ListNode after = new ListNode(-1); //创造大区的上帝节点
		ListNode t1 = before; //用来遍历小区
		ListNode t2 = after; //用来遍历大区
        while(head!=null){ //直接用head来遍历原list
        		if (head.val < x){ //分段
        			t1.next = head; //加入到小区
        			t1 = t1.next; //小区后移
        		}else{
        			t2.next = head; //加入到大区
        			t2 = t2.next; //大区后移
        		}
        		head = head.next; //原list后移
        }
        t1.next = after.next; //使小区末尾指向大区开头
        t2.next = null; //使大区末尾指向空
        return before.next; //返回小区的开头，即为上帝节点的next
    }
	public static void main(String[] args) {
		ListNode ans = new ListNode(5);
		ans.next = new ListNode(4);
		ans.next.next = new ListNode(3);
		ans.next.next.next = new ListNode(3);
		ans.next.next.next.next = new ListNode(2);
		ans.next.next.next.next.next = new ListNode(1);
		ans.next.next.next.next.next.next = new ListNode(2);
		ans = partition(ans,3);
		while(ans!=null){
			System.out.print(ans.val);
			ans = ans.next;
		}
	}

}
