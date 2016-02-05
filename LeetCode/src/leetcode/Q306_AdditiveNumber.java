package leetcode;

public class Q306_AdditiveNumber {
	public static boolean isAdditiveNumber(String num) {
		int n = num.length(); //整个字符串的长度
		for(int i=1; i<=n/2; i++){ //枚举第一个数的切割点
			if(num.charAt(0)=='0' && i>1) break; //不是数
			for(int j=1; i+j<n; j++){ //枚举第二个数的切割点
				if(num.charAt(i)=='0' && j>1) break; //不是数
				Long x1 = Long.parseLong(num.substring(0,i)); //切割出来的第一个数
				Long x2 = Long.parseLong(num.substring(i,i+j)); //切割出来的第二个数
				int k=0; //能够匹配到的最远距离
				for(k=i+j; k<num.length(); k+=x2.toString().length()){
					x2 = x1 + x2; //x2后移
					x1 = x2 - x1; //x1后移
					if(!num.startsWith(x2.toString(), k)) break; //不符合条件，枚举下一个切割
				}
				if(k==num.length()) return true; //跑通了一次就返回
			}
		}
		return false; //从来没有跑通过
    }
	public static void main(String[] args) {
		System.out.println(isAdditiveNumber("1123582"));

	}

}
