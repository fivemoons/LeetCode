package leetcode;

public class Q5_LongestPalindromicSubstring {
	
	public static String change(String s){
		String ss = s.substring(0, 1);
		for (int i =1; i<s.length(); i++)
			ss +="*"+s.charAt(i);
		//System.out.println(ss); //a*b*c*b*c*b*e
		ss = longestPalindrome1(ss);
		//System.out.println(ss); //*b*c*b*c*b*
		String sss = new String("");
		for (int i=0;i<ss.length(); i++){
			if (ss.charAt(i)!='*')
				sss += ss.charAt(i);
		}
		return sss;	
	}
	
	//枚举中心节点往两边扩展。n2 超时
	public static String longestPalindrome1(String s) {
		int anscount = 0; //最长长度的一半。
		int ansi = 0; //最长长度中心点
		for(int i=0; i<s.length(); i++){
			int j=1;//包括自己
			while ((i-j>=0)&&(i+j<s.length())&&(s.charAt(i-j)==s.charAt(i+j))) j++;
			if (anscount < j){
				anscount = j;
				ansi = i;
			}
		}
		return s.substring(ansi-anscount+1, ansi+anscount); //带*回文串
	}
	
	//动态规划：（P[i][j]=0如果ij不是回文串）
	//P[i+1][j-1]=1且a[i]=a[j]则P[i][j]=P[i+1][j-1]+1
	//时间复杂度O(N^2),空间复杂度O(N^2)
	public static String longestPalindrome2(String s) {
		
		boolean[][] p = new boolean[s.length()][s.length()];//动归的数组
		int anscount = 1;//最长长度
		int ansstart = 0;//最长长度开始坐标
		
		//len1
		for(int i=0; i<s.length(); i++)
			p[i][i] = true;
		
		//len2
		for(int i=0; i<s.length()-1; i++)
			if (s.charAt(i) == s.charAt(i + 1)){
				p[i][i+1] = true;
				anscount = 2;
				ansstart = i;
			}
		
		//len3
		for(int l = 3; l<=s.length(); l++)//回文长度
			for(int i = 0; i<s.length(); i++){//起始点
				int j = i + l -1;//结尾点
				if ((s.charAt(i) == s.charAt(j)) && (p[i+1][j-1])){
					p[i][j] = true;//设为子串
					if (anscount < l){
						anscount = l;
						ansstart = i;
					}					
				}
			}
		return s.substring(ansstart, ansstart + anscount);
	}

	//Manchester法 复杂度O(N)
	//仍以中心扩展法为主，加入了Manchester思想，每次扩展之前看是否能利用之前存的子串长度
	public static String longestPalindrome3(String s) {
		
		//预处理a*b*a*b*a
		String ss = "*";
		for (int i =0; i<s.length(); i++)
			ss +=s.charAt(i)+"*";
		//a*b*a*b*a
		s = ss;
		//System.out.println(s);
		
		int[] p = new int[s.length()];//以i为中心的回文半径，包括自己
		int max = 0;//当前以id为中心，延伸到最右的坐标。
		int id = 0;//能够延伸到最右的坐标的中心点
		int ansid = 0;//答案最长的中心点。
		for(int i= 0; i<s.length(); i++){
			//1.如果在max里面可以对称计算。
			if(max > i)
				p[i] = Math.min(p[2*id-i], max-i);
			else
				p[i] = 1;
			//2.继续中心拓展
			while ((i-p[i]>=0)&&(i+p[i]<s.length())//下两个点比较
					&&(s.charAt(i-p[i])==s.charAt(i+p[i])))
				p[i]++;
			if (max < i+p[i]-1){
				id = i;
				max = p[i] + i -1;
			}
			if (p[ansid] < p[i])
				ansid = i;
		}
		s = s.substring(ansid - p[ansid] + 1, ansid + p[ansid]);
		//System.out.println(s);
		
		//去掉*
		ss = "";
		for(int i = 0; i*2+1<s.length(); i++){
			ss += s.charAt(i*2+1);
		}
		return ss;
	}

	public static void main(String[] args) {
		String s = new String("abb");
		System.out.println(s);
		System.out.println(longestPalindrome3(s));
	}
}
