package leetcode;

public class Q215_KthLargestElementInAnArray {//快速选择，两个方法
	//选择首元素作为监督哨
    public static int findKthLargest(int[] nums, int k) {
    	k--;
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
        	if(x == k)
        		return nums[k];
        	else if(x > k)
        		r = x - 1;
        	else
        		l = x + 1;
        }
        return nums[k];
    }
    //选择中间元素作为监督哨
    public static int findKthLargest1(int[] nums, int k){
    	k--;
    	int l=0, r= nums.length - 1;
    	while(l<r){
    		int i=l, j= r;
    		int x = nums[(i+j)>>1];
    		while(i<j){
    			while(nums[i]>x) i++;
    			while(x>nums[j]) j--;
    			if(i<=j){
    				int t=nums[i]; nums[i] = nums[j]; nums[j] = t;
    				i++;
    				j--;
    			}
    		}
    		if((l<j)&&(k<=j)) r = j;
    		else if((i<r)&&(i<=k)) l = i;
    		else return nums[k];
    	}
    	return nums[k];
    }
    
    public static int findKthLargest2(int[] nums, int k){ //递归版快速选择
    	return findKthLargest20(nums, k-1, 0, nums.length-1);
    }
    private static int findKthLargest20(int[] nums, int k, int l, int r){
    	int i=l, j=r;
    	int x=nums[(i+j)>>1];
    	while(i<j){
    		while(nums[i]>x) i++;
    		while(x>nums[j]) j--;
    		if(i<=j){
    			int t = nums[i]; nums[i]=nums[j]; nums[j]=t;
    			i++;
    			j--;
    		}
    	}
    	if((l<j)&&(k<=j)) return findKthLargest20(nums,k,l,j);
    	else if ((i<r)&&(i<=k)) return findKthLargest20(nums,k,i,r);
    	else return nums[k];
    }
    
	public static void main(String[] args) {
		System.out.println(findKthLargest2(new int[]{-1,2,0},2));
	}

}
