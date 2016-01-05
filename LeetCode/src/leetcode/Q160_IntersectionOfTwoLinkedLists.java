package leetcode;

public class Q160_IntersectionOfTwoLinkedLists {
	static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
			next = null;
		}
	}
	
	public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		//计算两者长度
        ListNode p1 = headA;
        ListNode p2 = headB;
        int len1 = 0;
        int len2 = 0;
        while(p1!=null){
        		p1 = p1.next;
        		len1++;
        }
        while(p2!=null){
        		p2 = p2.next;
    			len2++;
        }
        //挪动两者差值
        p1 = headA;
        p2 = headB;
        if (len1 > len2){
        		for(int i=0; i<len1-len2; i++, p1 = p1.next);
        }else{
        		for(int i=0; i<len2-len1; i++, p2 = p2.next);
        }
        //移动到相同节点
        for(; p1!=p2; p1 = p1.next, p2 = p2.next);
        return p1;
    }

	public static void main(String[] args) {
		ListNode headA = new ListNode(1);
		headA.next = new ListNode(2);
		headA.next.next = new ListNode(3);
		headA.next.next.next = new ListNode(4);
		
		ListNode headB = new ListNode(5);
		headB.next = new ListNode(6);
		headB.next.next = headA.next.next;
		System.out.println(getIntersectionNode(headA,headB).val);
	}

}
