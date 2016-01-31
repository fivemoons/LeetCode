package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Q229_MajorityElementII {
    public static List<Integer> majorityElement(int[] nums) { //使用多数投票方法
        List<Integer> ans = new ArrayList<>(); //存放答案的list
        if(nums == null || nums.length == 0) return ans; //返回空
        if(nums.length == 1){ ans.add(nums[0]); return ans;} //返回第一个元素
        
        int m1 = nums[0]; //初始是第一个元素
        int m2 = 0;
        
        int c1 = 1; //初始个数为1
        int c2 = 0;
        
        for(int i=1; i<nums.length; i++){
        		int x = nums[i]; //x是当前元素
        		if(x == m1) c1++; //对应的m1或m2个数加1
        		else if(x==m2) c2++;
        		else if(c1 == 0){ //如果都不相同 并且有0  替换
        			m1 = x;
        			c1 = 1;
        		}else if(c2 == 0){
        			m2 = x;
        			c2 = 1;
        		}else{ //否则都减一
        			c1--;
        			c2--;
        		}
        }
        c1 = 0; c2 = 0;
        for(int i=0; i<nums.length; i++){ //如果答案存在 必在m1 m2中
    			if(m1 == nums[i]) c1++;
    			else if(m2 == nums[i]) c2++;
        }
        if(c1>nums.length/3) ans.add(m1);
        if(c2>nums.length/3) ans.add(m2);
        return ans;
    }
	public static void main(String[] args) {
		List<Integer> ans = majorityElement(new int[]{1,1,1,2,2,2,2,2,2,3,3,3,3,3,3});
		for(int i:ans){
			System.out.println(i);
		}
	}

}
