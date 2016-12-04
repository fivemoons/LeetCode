package leetcode2.list;

public class Q21_MergeTwoSortedLists {
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        ListNode ans = l1.val < l2.val ? l1 : l2;
        ListNode l3 = new ListNode(0);
        while((l1!=null)&&(l2!=null)){
	        if(l1.val < l2.val){
	            l3.next = l1;
	            l3 = l3.next;
	            l1 = l1.next;
            }else{
	            l3.next = l2;
	            l3 = l3.next;
	            l2 = l2.next;
            }
        }
        if(l1!=null) l3.next = l1;
        if(l2!=null) l3.next = l2;
	    return ans;
    }
}
