package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Q300_LongestIncreasingSubsequence {
	public static int lengthOfLIS(int[] nums) {
		if (nums == null || nums.length == 0) return 0;	
		List<Integer> list = new ArrayList<Integer>();
		
		for(int i=0; i<nums.length; i++){
			int x = nums[i]; //当前数字
			if(list.size() == 0 || list.get(list.size()-1) < x){//如果需要添加到队尾
				list.add(x);
			}else{ //二分查找
				int l = 0, r = list.size() - 1;
				while(l<=r){
					int m = l + (r-l)/2;
					if ((m==0 && list.get(0)>=x) ||
						(m>=1 && list.get(m-1)<x && x<=list.get(m))){
						list.set(m, x);
						break;
					}else if(list.get(m)<x){
						l = m + 1;
					}else{
						r = m - 1;
					}
				}
			}
		}
		return list.size();
    }
	public static void main(String[] args) {
		System.out.println(lengthOfLIS(new int[]{10,9,2,5,3,7,101,18}));
	}

}
