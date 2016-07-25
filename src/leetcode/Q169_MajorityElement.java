package leetcode;

public class Q169_MajorityElement {
	public static int majorityElement(int[] nums) {
		int ans = 0;
		int count = 0;
		for(int x:nums){
            if(x==ans){
                count++;
            }else if(count ==0){
                ans = x;
                count = 1;
            }else{
                count--;
            }
        }
		return ans;
	}

	public static void main(String[] args) {
		System.out.println(majorityElement(new int[] { 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, }));

	}

}
