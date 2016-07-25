package leetcode;

import java.util.LinkedList;
import java.util.List;

public class Q241_DifferentWaysToAddParentheses {
    public static List<Integer> diffWaysToCompute(String input) {//分治，递归
        List<Integer> ans = new LinkedList<Integer>();
        for(int i=0; i<input.length(); i++){
        		char c = input.charAt(i);
        		if(c == '*' || c == '+' || c=='-'){ //劈开了才能递归
        			List<Integer> l = diffWaysToCompute(input.substring(0, i)); //左边答案
        			List<Integer> r = diffWaysToCompute(input.substring(i+1)); //右边答案
        			for(Integer x:l){ //依次枚举左边答案
        				for(Integer y:r){ //依次枚举右边答案
        					if(c == '*')
        						ans.add(x*y);
        					else if(c == '+')
        						ans.add(x+y);
        					else if(c == '-')
        						ans.add(x-y);
        				}
        			}
        		}
        }
        if(ans.isEmpty()){ //如果没有劈开过，说明是一个数字，则返回该数字
        		ans.add(Integer.valueOf(input));
        }
        return ans;
    }
	public static void main(String[] args) {
		List<Integer> ans = diffWaysToCompute("2*3-4*5");
		for(Integer i:ans){
			System.out.println(i);
		}
	}

}
