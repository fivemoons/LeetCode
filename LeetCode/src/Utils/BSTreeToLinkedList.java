package Utils;

public class BSTreeToLinkedList {
	class Node{
		public int data;
		public Node left;
		public Node right;
	}
	private Node last;
	private Node head;
	public void toLinkedList(Node root){
		if (root != null){
			toLinkedList(root.left);
		}
		if(last != null){
			last.right = root;
			root.left = last;
		}else{
			head = root;
		}
		last = root;
		toLinkedList(root.right);
	}
	public void print(){
		for(Node temp = head; temp!=null; temp = temp.right)
			System.out.print(temp.data+"_");
	}
}
