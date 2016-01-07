package leetcode;

public class Q169_MajorityElement {
	public static int majorityElement(int[] nums) {//o(n) 时间空间  hash方法 o(1)时间 o(n)空间 排序方法 o(nlogn)
        int ans = nums[0];
        int count = 1;
        for(int i=1; i<nums.length; i++){
        		if (count == 0){
        			ans = nums[i];
        			count = 1;
        		}else{
        			if (ans == nums[i]){
        				count++;
        			}else{
        				count--;
        			}
        		}
        }
        return ans;
    }
	public static void main(String[] args) {
		System.out.println(majorityElement(new int[]{1,1,1,1,2,2,2,2,2,2,2,2,2,}));

	}

}
