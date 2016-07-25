package leetcode;

public class Q11_ContainerWithMostWater {
	public static int maxArea(int[] height) {
		int i = 0;
		int j = height.length - 1;
		int ans = 0;
		while (i<j){
			ans = Math.max(ans, Math.min(height[i], height[j])*(j-i));
			if (height[i] < height[j])
				i++;
			else
				j--;
		}
        return ans;
    }
	public static void main(String[] args) {
		System.out.println(maxArea(new int[]{1,2,3,4,5,6,7}));
	}

}
