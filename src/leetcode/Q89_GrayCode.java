package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Q89_GrayCode {
	private static int gray(int i){ //公式1二进制转换为gary码
		return i^(i>>1);
	}
	@SuppressWarnings("unused")
	private static int gray_to_bin(int i){ //公式2gary码转换为二进制
        for(int mask = i>>1; mask != 0; mask >>= 1){
        		i = i^mask;
        }
        return i;
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
    public static List<Integer> grayCode2(int n){ //使用镜像
        List<Integer> ans = new ArrayList<Integer>();
        ans.add(0);
        for(int i=0; i<n; i++){//镜像次数为n   n=1 镜像1次 0|1   n=2 镜像2次 0|1  00 01 | 11 10
        		int height_bit = 1 << i;
        		for(int j = ans.size() - 1; j>=0; j--){
        			ans.add(height_bit | ans.get(j));
        		}
        }
        return ans;
    }
	public static void main(String[] args) {
		List<Integer> ans = grayCode2(2);
		for(Integer i:ans){
			System.out.print(i);
		}

	}

}
