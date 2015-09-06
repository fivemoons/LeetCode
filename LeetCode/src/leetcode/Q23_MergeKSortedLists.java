package leetcode;

import java.util.Arrays;

public class Q23_MergeKSortedLists { //这道题要有很好的归并排序的思维
	public static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
		}
	}
	
	public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {//这是mergeTwoLists的程序
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
	
	public static ListNode mergeKLists(ListNode[] lists) { //参照归并排序的程序
        if (lists.length==0) return null; //0 返回null
        if (lists.length==1) return lists[0]; //一个返回本列表
        if (lists.length==2) return mergeTwoLists(lists[0],lists[1]); //返回两个的合并
        return mergeTwoLists( //分治解决
        		mergeKLists(Arrays.copyOfRange(lists, 0, lists.length/2)),//前一部分 用Arrays.copyofRangef复制一部分
        		mergeKLists(Arrays.copyOfRange(lists, lists.length/2, lists.length)));//后一部分
    }
	public static void main(String[] args) {
		ListNode l1 = new ListNode(1);
		l1.next = new ListNode(2);
		l1.next.next = new ListNode(5);
		l1.next.next.next = new ListNode(6);
		ListNode l2 = new ListNode(1);
		l2.next = new ListNode(3);
		l2.next.next = new ListNode(4);
		ListNode l3 = new ListNode(7);
		ListNode l4 = new ListNode(8);
		ListNode l5 = new ListNode(9);
		ListNode l6 = new ListNode(10);

		ListNode ans = mergeKLists(new ListNode[] {l1,l2,l3,l4,l5,l6});
		while (ans!=null){
			System.out.println(ans.val);
			ans = ans.next;
		}
	}

}
