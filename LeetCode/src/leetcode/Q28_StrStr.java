package leetcode;

public class Q28_StrStr {//找子串 最普通的方法。。。
	public static int strStr(String haystack, String needle) {
        return haystack.indexOf(needle);
    }
	public static int[] getNext(String p){
		int[] next = new int[p.length()];
		next[0] = -1; //初始值为-1
		int k = -1; //k是当前的最长真后缀
		int j = 0; //循环用
		while (j < p.length() - 1){   //遍历第一个点到倒数第二个点
			if ((k == -1)||(p.charAt(j) == p.charAt(k))){ //匹配到的情况
				j++; //下标加1
				k++; //真后缀加1
				next[j] =  k; //当前j的next设为k
			}
			else
				k = next[k]; //没有匹配到，k退回到前一个真后缀，然后
		}
		return next;
	}
	
	public static int[] getNext2(String p){
		int[] next = new int[p.length()];
		next[0] = -1;
		int k = -1;
		int j = 0;
		while (j < p.length() - 1){
			if ((k == -1)||(p.charAt(j) == p.charAt(k))){
				j++;
				k++;
				if (p.charAt(j)!=p.charAt(k))
					next[j] =  k;
				else
					next[j] =next[k];
			}
			else{
				k = next[k];
			}
		}
		return next;
	}
	
	
	public static int KMP(String haystack, String needle){
		if ("".equals(needle)) return 0;
		int[] next = getNext(needle);
		int i = 0;
		int j = 0;
		while ((i<haystack.length())&&(j < needle.length())){
			if ((j == -1)||(haystack.charAt(i) == needle.charAt(j))){//如果已经无路可退或者匹配上了
				i++;
				j++;
			}
			else{
				j = next[j]; //j往后退一个
			}
		}
		if (j == needle.length())
			return i - j;
		else
			return -1;
	}
	public static void main(String[] args) {
		System.out.println(KMP("",""));
	}

}
