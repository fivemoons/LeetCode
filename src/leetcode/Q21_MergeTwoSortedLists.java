package leetcode;

public class Q21_MergeTwoSortedLists {
	public static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}
	public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		if (l1==null) return l2; //防止出现空指针的情况
		if (l2==null) return l1;
        ListNode ans = l1.val<l2.val?l1:l2;//返回答案的头 两者中较小值
        ListNode p = new ListNode(0); //新建一个首节点
        while ((l1!=null)&&(l2!=null)){ //双指针扫描
        		if (l1.val < l2.val){ //这里和ans的判断一样。相同情况选择l2
        			p.next = l1;
        			p = p.next;
        			l1 = l1.next;
        		}else{
        			p.next = l2;
        			p = p.next;
        			l2 = l2.next;
        		}
        }
        if (l1==null) p.next = l2; //处理l2未扫描完情况。
        if (l2==null) p.next = l1; //处理l1未扫描完情况。
        return ans;
    }
	public static void main(String[] args) {
		ListNode l1 = new ListNode(1);
		//l1.next = new ListNode(2);
		//l1.next.next = new ListNode(5);
		//l1.next.next.next = new ListNode(6);
		ListNode l2 = new ListNode(1);
		//l2.next = new ListNode(3);
		//l2.next.next = new ListNode(4);
		ListNode l3 = mergeTwoLists(l1,l2);
		while (l3!=null){
			System.out.println(l3.val);
			l3 = l3.next;
		}
	}

}
