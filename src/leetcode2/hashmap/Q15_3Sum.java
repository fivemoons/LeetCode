package leetcode2.hashmap;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Q15_3Sum {
	public static List<List<Integer>> threeSum(int[] nums) { //n2 枚举两个 hashmap找第三个
		Arrays.sort(nums);
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			map.put(nums[i], i);
		}
		List<List<Integer>> ans = new LinkedList<>();
		for (int b = 0; b < nums.length; b++) {
			if ((b != 0) && (nums[b] == nums[b - 1]))
				continue;
			for (int m = b + 1; m < nums.length; m++) {
				if ((m != b + 1) && (nums[m] == nums[m - 1]))
					continue;
				int e = 0 - nums[b] - nums[m];
				if (map.get(e) != null && map.get(e) > m) {
					ans.add(Arrays.asList(new Integer[] { nums[b], nums[m], e }));
				}
			}
		}
		return ans;
	}

	public List<List<Integer>> threeSum2(int[] nums) { //n2 枚举第一个 首尾指针找后两个
        Arrays.sort(nums);
        List<List<Integer>> ans = new LinkedList<List<Integer>>();
        for(int i=0; i<nums.length; i++){
            if((i>0) && (nums[i-1] == nums[i])){
                continue;
            }
            int l = i+1, r = nums.length - 1, sum = 0 - nums[i];
            while(l < r){
                if(nums[l] + nums[r] == sum){
                    ans.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    l++;
                    while((l < r) && (nums[l] == nums[l-1])) l++;
                    r--;
                    while((l < r) && (nums[r] == nums[r+1])) r--;
                }else if(nums[l] + nums[r] < sum){
                    l++;
                    while((l < r) && (nums[l] == nums[l-1])) l++;
                }else{
                    r--;
                    while((l < r) && (nums[r] == nums[r+1])) r--;
                }
            }
        }
        return ans;
    }
	
	public static void main(String[] args) {
		// -4_-1_-1_0_1_2_
		//System.out.println(threeSum(new int[] {-4,-1,-1,0,1,2}));
		//System.out.println(threeSum2(new int[] {-4,-1,-1,0,1,2}));
		System.out.println(threeSum(new int[] { 7, -1, 14, -12, -8, 7, 2, -15, 8, 8, -8, -14, -4, -5, 7, 9, 11, -4,
				-15, -6, 1, -14, 4, 3, 10, -5, 2, 1, 6, 11, 2, -2, -5, -7, -6, 2, -15, 11, -6, 8, -4, 2, 1, -1, 4, -6,
				-15, 1, 5, -15, 10, 14, 9, -8, -6, 4, -6, 11, 12, -15, 7, -1, -9, 9, -1, 0, -4, -1, -12, -2, 14, -9, 7,
				0, -3, -4, 1, -2, 12, 14, -10, 0, 5, 14, -1, 14, 3, 8, 10, -8, 8, -5, -2, 6, -11, 12, 13, -7, -12, 8, 6,
				-13, 14, -2, -5, -11, 1, 3, -6 }));
		System.out.println(threeSum(new int[] { 7, -1, 14, -12, -8, 7, 2, -15, 8, 8, -8, -14, -4, -5, 7, 9, 11, -4,
				-15, -6, 1, -14, 4, 3, 10, -5, 2, 1, 6, 11, 2, -2, -5, -7, -6, 2, -15, 11, -6, 8, -4, 2, 1, -1, 4, -6,
				-15, 1, 5, -15, 10, 14, 9, -8, -6, 4, -6, 11, 12, -15, 7, -1, -9, 9, -1, 0, -4, -1, -12, -2, 14, -9, 7,
				0, -3, -4, 1, -2, 12, 14, -10, 0, 5, 14, -1, 14, 3, 8, 10, -8, 8, -5, -2, 6, -11, 12, 13, -7, -12, 8, 6,
				-13, 14, -2, -5, -11, 1, 3, -6 }));
	}

}
