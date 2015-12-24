package leetcode;

public class Q138_CopyListWithRandomPointer {
	static class RandomListNode {
		int label;
		RandomListNode next, random;
		RandomListNode(int x) {	 this.label = x; }
	}
	public static RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) return null;
        //第一遍循环，组成重复的列表
        for(RandomListNode cur = head; cur!=null; cur=cur.next.next){
        		RandomListNode node = new RandomListNode(cur.label);
        		node.next = cur.next; //复制原来的点
        		cur.next = node; //把新建的点加入到原来点的后面
        }
        
        System.out.println(head.label);
        //System.out.println(head.next.label);
        //System.out.println(head.next.next.label);
        //System.out.println(head.next.next.next.label);
        
        //第二遍循环，处理random
        for(RandomListNode cur = head; cur!=null; cur=cur.next.next){
        		if(cur.random!=null)//旧节点的random
        			cur.next.random = cur.random.next;//新节点的random=旧节点random的next
        }
        //第三遍，拆链表。
        RandomListNode ans = head.next;
        for(RandomListNode cur=head; cur!=null; cur=cur.next){
        		RandomListNode temp = cur.next.next; //第三个节点
        		cur.next.next = temp!=null ? temp.next : null;
        		cur.next = temp;
        }
        return ans;
    }
	public static void main(String[] args) {
		RandomListNode head = new RandomListNode(-1);
		head.next = new RandomListNode(1);
		RandomListNode ans = copyRandomList(head);
		System.out.println(ans.label);
		System.out.println(ans.next.label);
	}

}
