package leetcode2.array;

public class Q26_RemoveDuplicatesFromSortedArray {
	public int removeDuplicates(int[] nums) {
        if (nums== null || nums.length == 0) return 0;
        int ans = 1;
        for(int i=1; i<nums.length; i++){
            if (nums[i] != nums[i-1]){
                nums[ans++] = nums[i];
            }
        }
        return ans;
    }
}
