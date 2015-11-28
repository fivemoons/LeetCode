package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Q89_GrayCode {
	private static int gray(int i){ //公式1二进制转换为gary码，gray码转换成二进制也是这个
		return i^(i>>1);
	}
    public static List<Integer> grayCode(int n) {
        List<Integer> ans = new ArrayList<Integer>();
        n = 1 << n;
        System.out.println(n);
        for(int i=0; i<n; i++){
        		ans.add(gray(i));
        }
        return ans;
    }
	public static void main(String[] args) {
		List<Integer> ans = grayCode(2);
		for(Integer i:ans){
			System.out.print(i);
		}

	}

}
