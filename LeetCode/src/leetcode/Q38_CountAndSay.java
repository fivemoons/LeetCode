package leetcode;

public class Q38_CountAndSay {
	public static String countAndSay(int n) {
		if (n==0) return ""; //0的情况 空串
        String ans = new String("1"); //1的情况
        String ans2; //用来滚动的字符串
        for(int i=2; i<=n; i++){//依次做叠加
        		ans2 = "";
        		int k = 0;//扫描ans字符串下标
        		while(k<ans.length()){
        			char c = ans.charAt(k);//当前字符
        			Integer count = 1;//当前字符个数
        			while ((k<ans.length()-1)&&(ans.charAt(k + 1)==c)){//扫描当前字符总个数
        				k++;//坐标+1
        				count++;//字符计数+1
        			}
        			ans2+=count.toString()+c; //拼装成新的字符串
        			k++;//坐标+1
        		}
        		ans = ans2;//字符串滚动
        }
        return ans;
    }
	public static void main(String[] args) {
		for(int i=0;i<8;i++){
			System.out.println(countAndSay(i));
		}
	}

}
