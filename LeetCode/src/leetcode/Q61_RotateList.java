package leetcode;

class ListNode {
	int val;
	ListNode next;
	ListNode(int x) { val = x; }
}

public class Q61_RotateList {
	public static ListNode rotateRight(ListNode head, int k) {
		if (head == null) return null; //可能出现head是null的情况
		ListNode end = head; //用来寻找输入list的结尾
		int count = 1; //用来计算list一共有多少个node
		while (end.next != null){ //end依次遍历
			count++; //count加1
			end = end.next;
		}
		end.next = head; //使listnode形成一个环
		k = k % count; //k值有可能比count大
		int kk = count - k; //计算从head算起走多少个node
		while (--kk>0){ //比kk少走一个node，所以是--kk 而不是kk--
			head = head.next; //头结点往后走
		}
		ListNode ans = head.next; //head.next要断环，所以返回ans
		head.next = null; //断环
		return ans;
    }
	public static void main(String[] args) {
		ListNode l1 = new ListNode(1);
		l1.next = new ListNode(2);
		l1.next.next = new ListNode(3);
		l1.next.next.next = new ListNode(4);
		l1.next.next.next.next = new ListNode(5);
		l1 = rotateRight(l1,2);
		while(l1 !=null){
			System.out.print(l1.val+"_");
			l1 = l1.next;
		}
	}

}
