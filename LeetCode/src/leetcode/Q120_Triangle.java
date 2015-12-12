package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q120_Triangle {
    public static int minimumTotal(List<List<Integer>> triangle) {
        int[] ans = new int[triangle.size()];
        Arrays.fill(ans, Integer.MAX_VALUE);
        if (triangle.size() == 0)
        		return 0;
        ans[0] = 0;
        for(int i=0; i<triangle.size(); i++){
        		for(int j=i; j>0; j--){
        			ans[j] = triangle.get(i).get(j) + Math.min(ans[j-1],ans[j]);
        		}
        		ans[0] = ans[0] + triangle.get(i).get(0);
        }
        int min = Integer.MAX_VALUE;
        for(int i=0; i<triangle.size(); i++){
        		if (min>ans[i])
        			min = ans[i];
        }
        return min;
    }
	public static void main(String[] args) {
		List<List<Integer>> tri = new ArrayList<List<Integer>>();
		List<Integer> t0 = Arrays.asList(new Integer[]{-1});
		List<Integer> t1 = Arrays.asList(new Integer[]{-2,-3});
		//List<Integer> t2 = Arrays.asList(new Integer[]{6,5,7});
		//List<Integer> t3 = Arrays.asList(new Integer[]{4,1,8,3});
		tri.add(t0);
		tri.add(t1);
		//tri.add(t2);
		//tri.add(t3);
		System.out.println(minimumTotal(tri));
	}

}
