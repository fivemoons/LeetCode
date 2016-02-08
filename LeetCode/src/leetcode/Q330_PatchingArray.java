package leetcode;

public class Q330_PatchingArray {
	public static int minPatches(int[] nums, int n) {
        int ans=0; //需要添加的数的个数
        long miss = 1;//第一个不行的数
        int i=0;
        while(miss <= n){ //还不满足要求
        		if(i<nums.length && nums[i] <= miss){ //nums[i]还没用呢
        			miss += nums[i]; //使用上nums[i] 让范围扩大
        			i++; //该使用下一个数了
        		}else{ //所有数都用完了，或者nums剩下的数太大了 miss还没够到
        			ans++; //没招，只能增加一个数，就是miss
        			miss = miss << 1; //增加了miss 那么 miss-1+miss都能满足，2*miss变成不行的
        		}
        }
        return ans;
    }
	public static void main(String[] args) {
		
	}

}
