package leetcode;

public class Q324_WiggleSortII { //实在没想到最后一个题是这个。。
	
	private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
	
    private int partition(int[] nums, int start, int end) {
        int pivot = start + (int)((end - start) * Math.random()); //这个数是start~end之间的随机数
        int pivotVal = nums[pivot]; //选择的哨兵位置
         
        swap(nums, pivot, end); //哨兵移到最后
         
        int pt = start;
        for(int i = start; i < end; i++) {
            if(nums[i] <= pivotVal) {
                swap(nums, i, pt);
                pt++;
            }
        }
         
        swap(nums, end, pt);
         
        return pt; //分隔完成
    }
    
    private int findKthElement(int[] nums, int k, int start, int end) { //返回nums从start到end的第k个数
        int partition = partition(nums, start, end);
         
        if(partition == k) //
            return nums[k];
        else if(partition < k) { //递归前半边
            return findKthElement(nums, k, partition + 1, end);
        } else { //递归后半边
            return findKthElement(nums, k, start, partition - 1);
        }
    }
    
    public void wiggleSort(int[] nums) {
        if(nums == null || nums.length <= 1) return; //特殊情况
        /*  0 1 2 3 4 5  len = 6 mid = 2
         *  0 1 2 3 4    len = 5 mid = 2
         */
        int mid = (nums.length - 1) / 2; 
        
        findKthElement(nums, mid, 0, nums.length - 1);
         
        int small = mid, large = nums.length - 1; //small最后一个 large最后一个
         
        int[] temp = new int[nums.length];
        for(int i = 0; i < nums.length; i++) {
            if(i % 2 == 0) { // find next small
                temp[i] = nums[small--];
            } else {
            		temp[i] = nums[large--];
            }
        }
         
        for(int i = 0; i < nums.length; i++) {
            nums[i] = temp[i];
        }
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
