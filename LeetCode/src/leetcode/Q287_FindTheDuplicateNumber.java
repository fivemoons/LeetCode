package leetcode;

public class Q287_FindTheDuplicateNumber {
    public static int findDuplicate(int[] nums) {
    		int l = 1, r = nums.length;
    		while(l < r){
    			System.out.println(l + "_"+ r);
    			int m = l + (r - l) / 2;
    			int count = 0;
    			for(int i = 0; i<nums.length; i++){
    				if(nums[i] <= m)
    					count++;
    			}
    			if(count <= m)
    				l = m + 1;
    			else
    				r = m;
    		}
    		return r;
    }
	public static void main(String[] args) {
		System.out.println(findDuplicate(new int[]{2,2,2,2,2}));
		
	}

}
