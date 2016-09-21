package leetcode2.list;

public class Q237_DeleteNodeInALinkedList {
	public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
