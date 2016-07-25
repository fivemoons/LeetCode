package leetcode;

import java.util.Deque;
import java.util.LinkedList;

public class Q321_CreateMaximumNumber { //倒数第二题了，也写了好久
	private static int[] getSub(int[] nums, int k){ //返回nums数组中的k大的元素
		Deque<Integer> q = new LinkedList<Integer>(); //类似nlogn的最长不降子序列
		for(int i=0; i<nums.length; i++){ //依次拿数据
			while(q.size() > 0 && q.peek() < nums[i] && q.size() + nums.length - i > k){ //这三个条件分别是
				//队列中还有元素    栈顶元素没有新元素大   栈中有的元素+剩下的全部元素还多，防止最后元素不够
				q.poll(); //替换到队尾元素
			}
			if(q.size() < k){ //如果栈不满，加入该数
				q.push(nums[i]);
			}
		}
		//以下代码把栈中元素转为数组
		int[] ans = new int[k];
		for(int i=k-1; i>=0; i--){
			ans[i] = q.poll();
		}
		return ans;
	}
	private static boolean greater(int[] nums1, int n1, int[] nums2, int n2){//用来比较从n1开始的nums1数据是否比n2开始的nums2数组大
		for(int i=0; n1+i<nums1.length && n2+i<nums2.length; i++){ //数组比较
			if(nums1[n1+i] > nums2[n2+i]) return true; //1大
			if(nums1[n1+i] < nums2[n2+i]) return false; //1小
		}
		return nums1.length - n1 > nums2.length - n2; //1中的长度比2中的长
	}
	public static int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int[] ans = new int[k]; //存放最后答案的数组
        int from = Math.max(0, k-nums2.length);
        //nums1最少：     nums2足够   nums2还不够
        int to = Math.min(nums1.length, k);
        //nums1最多：     nums1还不够  nums1足够
        for(int i=from; i<=to; i++){ //依次分隔两个数组的数
        		int[] ans1 = getSub(nums1,i);
        		int[] ans2 = getSub(nums2,k-i);
        		int[] anst = new int[k]; //答案缓存
        		for(int p1=0,p2=0,pt=0; p1<ans1.length || p2<ans2.length; ){
        			anst[pt++] = greater(ans1,p1,ans2,p2) ? ans1[p1++] : ans2[p2++]; //不能简单的比较这一位，因为[6,7][6,0,4]需要选第一个6而不是第二个
        		}
        		if(!greater(ans,0,anst,0))
        			ans = anst;
        }
        return ans;
    }
	public static void main(String[] args) {
		int[] ans = maxNumber(new int[]{3,4,6,5},new int[]{9,1,2,5,8,3},5);
		for(int i: ans){
			System.out.print(i+"_");
		}

	}

}
