package leetcode;

import java.util.LinkedList;
import java.util.List;

public class Q229_MajorityElementII {
	public static List<Integer> majorityElement(int[] nums) {
        int num1 = 0;
        int num2 = 0;
        int c1 = 0;
        int c2 = 0;
        for(int x:nums){
            if(num1==x){
                c1++;
            }else if(num2==x){
                c2++;
            }else if(c1==0){
                num1 = x;
                c1 = 1;
            }else if(c2==0){
                num2 = x;
                c2 = 1;
            }else{
                c1--;
                c2--;
            }
        }
        c1 = 0;
        c2 = 0;
        for(int x:nums){
            if(x==num1){
                c1++;
            }else if(x==num2){
                c2++;
            }
        }
        List<Integer> ans = new LinkedList<Integer>();
        if(c1>nums.length/3) ans.add(num1);
        if(c2>nums.length/3) ans.add(num2);
        return ans;
    }
        
	public static void main(String[] args) {
		List<Integer> ans = majorityElement(new int[]{1,1,1,2,2,2,2,2,2,3,3,3,3,3,3});
		for(int i:ans){
			System.out.println(i);
		}
	}

}
