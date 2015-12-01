package leetcode;

public class Q92_ReverseLinkedListII {
	public static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}
	/* .........|.............|...........
	 * 			m             n
	 *        p0       p1 head
	 *        	 p4            p3
	 */
    public static ListNode reverseBetween(ListNode head, int m, int n) {
    		if (n==m) return head; //如果n==m  只一个点交换，直接返回
    		ListNode ans = null; //存放最后返回串的起点
    		ListNode p0 = null; //用于寻找最左段的最后一个元素
        int mm = m;
        int nn = n - m;
        if (m > 1){
        		ans = head;
        		while(mm-->2){
        			head = head.next;
        		}
        		p0 = head; //需要换next的节点
        		head = head.next;
        }
        ListNode p1 = head; //移动指针时的首节点
        ListNode p4 = head; //中间段的首节点
        ListNode p3 = null; //移动指针时的尾节点
        while(nn-->0){
        		head = (p3 == null ? head.next : p3);
        		p3 = head.next;
        		head.next = p1;
        		p1 = head;
        }
        
        p4.next = p3; //中间段的首节点的next设为最后段的头，nn = 0 时为null
        if(m > 1){
        		p0.next = head;
        }else{
        		ans = head;
        }
        return ans;
    } //1  2   3   4  5
	public static void main(String[] args) {
		ListNode ans = new ListNode(1);
		ans.next = new ListNode(2);
		ans.next.next = new ListNode(3);
		ans.next.next.next = new ListNode(4);
		ans.next.next.next.next = new ListNode(5);
		ans = reverseBetween(ans, 1, 4);
		while(ans!=null){
			System.out.print(ans.val);
			ans = ans.next;
		}
	}

}
