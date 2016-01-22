package leetcode;

public class Q215_KthLargestElementInAnArray {
    public static int findKthLargest(int[] nums, int k) {
        int l=0, r=nums.length-1;
        while(l<r){
        	int x = l, y = r;
        	int key = nums[x];
        	while(x<y){
        		while(x < y && key > nums[y]) y--;
        		nums[x] = nums[y];
        		while(x < y && nums[x] >= key) x++;
        		nums[y] = nums[x];
        	}
        	nums[x] = key;
        	if(x == k-1)
        		return nums[k-1];
        	else if(x > k-1)
        		r = x - 1;
        	else
        		l = x + 1;
        }
        return nums[k-1];
    }
	public static void main(String[] args) {
		System.out.println(findKthLargest(new int[]{-1,2,0},2));
	}

}
