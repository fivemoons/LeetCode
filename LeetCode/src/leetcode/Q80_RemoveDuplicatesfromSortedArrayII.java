package leetcode;

public class Q80_RemoveDuplicatesfromSortedArrayII {
    public static int removeDuplicates(int[] nums) {
    	boolean[] bool = new boolean[nums.length]; //是否是要返回的数
        for(int i=0; i<nums.length; i++){
        	if ((i<=1) || ((i>1) && (nums[i] != nums[i-2]))) bool[i] = true; //判断条件
        }
        int ans = 0; //计数
        for(int i=0; i<nums.length; i++){
        	if (bool[i]){
        		nums[ans] = nums[i]; //移动到前ans个
        		ans++;
        	}
        }
        return ans;
    }
	public static void main(String[] args) {
		System.out.println(removeDuplicates(new int[]{1,1,1,2,2,3}));
	}

}
