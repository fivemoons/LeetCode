package leetcode;

public class Q307_RangeSumQueryMutable {
	private class SegmentTreeNode{   //线段树的节点
		int start;
		int end;
		int sum; //求和
		SegmentTreeNode left; //左根
		SegmentTreeNode right; //右根
		SegmentTreeNode(int start,int end){ //构造方法
			this.start = start;
			this.end = end;
			this.sum = 0;
		}
	}
	private SegmentTreeNode root; //线段树的根结点
	public Q307_RangeSumQueryMutable(int[] nums){ //类的构造方法
		this.root = buildTree(nums,0,nums.length-1); //使用nums数组的0~nums.length-1构造线段树
	}
	private SegmentTreeNode buildTree(int[] nums, int start, int end){ //递归构造线段树
		if(start > end){ //如果范围不对
			return null;
		}else{ //如果范围对
			SegmentTreeNode node = new SegmentTreeNode(start,end); //新建一个节点
			if(start == end){ //如果根结点
				node.sum = nums[start]; //计算sum信息
			}else{ //start<end
				int mid = start + (end - start) / 2;
				node.left = buildTree(nums,start,mid); //mid属于左节点
				node.right = buildTree(nums,mid+1,end);
				node.sum = node.left.sum + node.right.sum; //计算每个点的sum
			}
			return node;
		}
	}
	public void update(int i, int val){ //更新新节点 i位置更新为val
		update(root, i, val);
	}
	private void update(SegmentTreeNode node, int i, int val){
		if(node.start == i && node.end == i){ //如果是根结点的，start == end == i
			node.sum = val; //更新求和
			return;
		}else{
			int mid = node.start + (node.end - node.start) / 2;
			if(i <= mid){ //mid属于左节点
				update(node.left, i, val); //左节点更新
			}else{
				update(node.right, i, val); //右结点更新
			}
			node.sum = node.left.sum + node.right.sum; //重新计算当前范围的sum
		}
	}
	public int sumRange(int i, int j){
		return sumRange(root, i, j); //求i j返回的和
	}
	private int sumRange(SegmentTreeNode node, int start, int end){
		if(node.start == start && node.end == end){ //范围是对的
			return node.sum; //返回sum
		}else{ //节点的范围太大了
			int mid = node.start + (node.end - node.start) / 2;
			if(end <= mid){ //mid属于左，所以end<=mid的时候都要递归左节点
				return sumRange(node.left, start, end);
			}else if(mid < start){ //mid不属于右，所以mid<start才递归
				return sumRange(node.right, start, end);
			}else{
				return sumRange(node.left,start,mid) + sumRange(node.right,mid+1,end); //分开，mid在左
			}
		}
	}
	public static void main(String[] args) {
		
	}

}
