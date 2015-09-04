package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class Q18_4Sum {
	public static List<List<Integer>> fourSum(int[] nums, int target) {
		List<List<Integer>> ans = new ArrayList<List<Integer>>(); //最后的答案
		Arrays.sort(nums);//首先进行排序
        Map<Integer,List<Integer[]>> map = new HashMap<>(); //用来缓存两个数的和，key：和 value两个下标的list
        
        for(int i=0; i<nums.length - 1; i++){//这是特殊情况。当答案的四个数的后两个相同的时候，加入map
        	if ((nums[i] == nums[i+1])&& //n3 = n4
        			((i+2==nums.length) || (i+2<nums.length)&&(nums[i]!=nums[i+2]))){//a==b!=c
        		List<Integer[]> tmp = new ArrayList<Integer[]>();
        		tmp.add(new Integer[]{i,i+1});
        		map.put(new Integer(nums[i] + nums[i+1]), tmp);
        	}
        }
        for(int i=0; i<nums.length; i++){
        	if ((i!=nums.length-1)&&(nums[i]==nums[i+1])) continue;//保证n3是相同的数里面的最后一个，为了去重
        	for(int j=i+1; j<nums.length; j++){
        		if ((j!=nums.length-1)&&(nums[j]==nums[j+1])) continue;//保证n4是相同的数里面的最后一个，为了去重
        		List<Integer[]> l = map.get(nums[i] + nums[j]); //在map中找到和为 n3 + n4 的list
        		if (l==null){ //如果为空
        			l = new ArrayList<Integer[]>(); //创建新list
        			l.add(new Integer[]{i,j}); //添加n3 n4下标进入
        			map.put(new Integer(nums[i] + nums[j]), l); //缓存在map中
        		}else{
        			l.add(new Integer[]{i,j}); //不为空，说明已经存在一组和为 n3+n4，直接在list后面追加
        		}
        	}
        }
        //为了输出map
        /*
        Set<Entry<Integer,List<Integer[]>>> set =  map.entrySet(); //entrySet函数返回map的每一个entry生成一个set，此外还有keyset和valueset
        for(Entry<Integer,List<Integer[]>> entry : set){//增强for循环
        	System.out.print(entry.getKey() + ":");
        	for(Integer[] l1 : entry.getValue()){
        		System.out.print(l1[0] + "" + l1[1]+"|");
        	}
        	System.out.println();
        }
        */
        //两个2sum
        
        
        for(int n1=0; n1 < nums.length; n1++){//枚举n1（循环变量为下标）
        	if ((n1!=0)&&(nums[n1-1]==nums[n1])) continue;//保证n1不重复（循环变量为下标）
        	for(int n2=n1 + 1; n2 < nums.length; n2++){//枚举n2
        		if ((n2!=n1 + 1)&&(nums[n2-1]==nums[n2])) continue;//保证n2不重复
        		List<Integer[]> ln3n4 = map.get(target - nums[n1] - nums[n2]);//从map中找出target-前两个值
        		if (ln3n4!=null)//如果找到了
        			for (Integer[] n3n4:ln3n4) {//枚举list中的每一组n3 n4
        				if (n2<n3n4[0]){//保证n1 n2 n3 n4下标 不降
        					//System.out.println(n1 +" and " + n2 + " and " + find2[0] + " and " + find2[1]);
        			        ans.add(Arrays.asList(new Integer[]{nums[n1],nums[n2],nums[n3n4[0]],nums[n3n4[1]]}));//将结果存到ans中
        				}
        			}
        	}
        }
        return ans;
    }
	public static void main(String[] args) {
		List<List<Integer>> l1 = fourSum(new int[]{0,0,0,0},0);
		for (List<Integer> l2:l1){
			for (Integer l3:l2){
				System.out.print(l3+"__");
			}
			System.out.println();
		}
	}

}
