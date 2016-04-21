package leetcode;

public class Q28_StrStr {//找子串 最普通的方法。。。
	public static int strStr2(String haystack, String needle) {
        return haystack.indexOf(needle);
    }
	public static int[] getNext(String p){
        int[] next = new int[p.length()+1];
        next[0] = -1; //注意初始化为-1
        
        int k = -1; //注意初始化为-1
        int i = 0;
        while(i<p.length()){
            if(k==-1 || p.charAt(k) == p.charAt(i)){
                k++;
                i++;
                next[i] = k;
            }else{
                k = next[k];
            }
        }
        return next;
    }
	public static int strStr(String haystack, String needle){
	    String s = haystack;
	    String p = needle;
	    if (p.equals("")) return 0;
		int[] next = getNext(p);
		
		int k = 0; //注意初始化为0
		int i = 0;
		while(i<s.length() && k<p.length()){
            if(k==-1 || s.charAt(i) == p.charAt(k)){
                k++;
                i++;
            }else{
                k = next[k];
            }
		}
		
		if(k == p.length()){
		    return i-k;
		}else{
		    return -1;
		}
	}
	public static void main(String[] args) {
		System.out.println(strStr2("a","a"));
	}

}
