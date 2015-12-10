package leetcode;

public class Q116_PopulatingNextRightPointersInEachNode {
	public class TreeLinkNode {
		int val;
		 TreeLinkNode left, right, next;
		 TreeLinkNode(int x) { val = x; }
	}
    public void connect(TreeLinkNode root) {
    		TreeLinkNode p = root;
        while(p!=null){
        		TreeLinkNode nextLevel = null; //存放下一层节点的首节点，每一层都要设为空，让第一个遍历的点传进来
        		TreeLinkNode prevChild = null; //存放当前之前的那个节点，每一层都要舍为空，让上一次最后一个没有指向下来
        		for(;p!=null;p=p.next){ //这个循环走每一层
        			if(p.left!=null){//存在左子树
        				if(nextLevel==null) nextLevel=p.left;//如果p的left是该层最左边的一个点,也就是nextLevel还没有值
        				if(prevChild!=null) prevChild.next=p.left;//如果p不是该层最左边的一个点，也就是之前有个点的右子树缓存在prevChild点，则设next
        				prevChild=p.left;//依次替换前一个点的引用
        			}
        			if(p.right!=null){//存在右子树
        				if(nextLevel==null) nextLevel=p.right;//如果p的right是该层最左边的一个点
        				if(prevChild!=null) prevChild.next=p.right;//如果p不是该层第一个点，则设next
        				prevChild=p.right;//依次替换前一个点的引用
        			}
        		}
        		p=nextLevel; //跳转到下一层
        }
    }
	public static void main(String[] args) {
	}

}
