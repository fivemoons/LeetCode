package leetcode;

public class Q41_FirstMissingPositive {
	public static void swap(int[] nums,int a,int b){ //swap函数 注意因为a,b是简单类型，不是传引用，是传值，所以要带入nums
		int temp = nums[a];
		nums[a] = nums[b];
		nums[b] = temp;
	}
	public static int firstMissingPositive(int[] nums) {
        for(int i=0; i<nums.length; i++) //从左到右依次扫描
        	while (nums[i]!= i+1){ //当找到一个不属于这个位置的值，这下标从0开始 所以这个位置的值应该 ！= 下标+1
        		if( (0 <= nums[i] - 1) && (nums[i] -1 < nums.length) && //要和nums[i]交换的值的下标满足条件
        			(nums[i]!=nums[nums[i] - 1])){ //当前数，和这个数应该在的位置的那个数，比如当前数是4 应该和下标3所在的数交换
        			swap(nums,i,nums[i] - 1); //交换
        		}else
        			break; //如果能够交换  则继续拿交换后的数对比，否则跳出while 继续下一个i
        	}
        for (int i=0; i<nums.length; i++){ //寻找第一个没有的正整数
        	if (nums[i] != i+1) //和下标+1作比较  比如第一个数1 和 下标0 对应
        		return i+1; //返回下标+1
        }
        return nums.length + 1;  //这是nums的数全部满足条件，返回整个数组的下一个元素。包含数组为空，返回1.
    }
	public static void main(String[] args) {
		System.out.println(firstMissingPositive(new int[]{1,2,3}));
	}

}
