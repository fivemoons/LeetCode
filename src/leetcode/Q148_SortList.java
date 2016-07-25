package leetcode;

public class Q148_SortList {
	static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}
	private static ListNode merge(ListNode l, ListNode r){
		ListNode ans = new ListNode(-1);
		ListNode p = ans;
		while(l!=null || r!=null){
			if( ((l!=null) && (r!=null) && (l.val <= r.val)) || (r==null)){
				p.next = l;
				l = l.next;
			}else{
				p.next = r;
				r = r.next;
			}
			p = p.next;
		}
		p.next = null;//注意3：要把合并后的list尾节点设为null
		return ans.next;
	}
    public static ListNode sortList(ListNode head) {
    		if ((head == null)||(head.next == null)) return head; //注意1：0个1个节点的特殊情况
        //1 找出r
    		ListNode fast = head; //fast
    		ListNode slow = head; //slow
    		ListNode r = null; //将来的r的前一个点
    		for(;fast != null && fast.next != null ; slow = slow.next, fast = fast.next.next){
    			r = slow;
    		}
    		//2 分成两部分
    		r.next = null; //注意2：要把第一部分和第二部分拆开
    		r = slow;
    		//3 分别递归
    		ListNode l = sortList(head);
    		r = sortList(r);
    		//4 merge
    		return merge(l,r);
    }
	public static void main(String[] args) {
		ListNode ans = new ListNode(4);
		ans.next = new ListNode(3);
		ans.next.next = new ListNode(2);
		ans.next.next.next = new ListNode(1);
		ans = sortList(ans);
		while(ans!=null){
			System.out.println(ans.val);
			ans = ans.next;
		}
	}

}
