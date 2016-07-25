package leetcode;

import java.util.LinkedList;
import java.util.List;

public class Q68_TextJustification {
    public static List<String> fullJustify(String[] words, int maxWidth) {
        List<StringBuffer> sblist = new LinkedList<StringBuffer>(); //存放中间结果的字符串
        List<String> ans = new LinkedList<String>(); //存放答案字符串
        if (words.length == 0){ //返回0情况
        		return new LinkedList<String>();
        }
        StringBuffer sb = new StringBuffer(); //生成每一行的单词
        for(String s:words){
        		if (sb.length() + (sb.length() == 0 ? 0 : 1) + s.length() > maxWidth){ //是否还可以追加单词
        			sblist.add(sb); //sb加入到list中
        			sb = new StringBuffer(s); //存放新的单词
        		}else if(sb.length() == 0){ //第一行的第一个单词加入其中
        			sb.append(s);
        		}else{
        			sb.append(" " + s);//追加单词
        		}
        }
        sblist.add(sb); //最后一行没有超过限制，也加入到list中

        for(int i=0; i<sblist.size() - 1; i++){//除了最后一行，依次补全空格
        		sb = sblist.get(i); //拿到当前的StringBuffer
        		int j=0; //循环变量
        		while(sb.length() < maxWidth){ //判断是否补全
        			if (sb.indexOf(" ") == -1){ //如果是一个单词的情况
        				while (sb.length() < maxWidth){ //末尾补空格
        					sb.append(' ');
        				}
        			}else{//如果是多个单词的情况
        				j = (j + 1) % sb.length(); //依次循环
        				if (sb.charAt(j) == ' '){ //如果是空格
        					while(sb.charAt(++j) == ' '){};//直到找到最后一个空格，j留在空格之后
        					sb.insert(j, ' '); //j在原地+1
        				}
        			}
        		}
        		ans.add(sb.toString());//补全空格后加入到最终答案中
        }
        sb = sblist.get(sblist.size() - 1); //获得最后一行sb
        while (sb.length() < maxWidth){ //末尾补全空格
        		sb.append(' ');
        }
        ans.add(sb.toString()); //最后一行加入答案中
        return ans;
    }
	public static void main(String[] args) {
		List<String> ans = fullJustify(
				new String[]{"This", "is", "an", "example", 
						"of", "text", "justification."},16);
		ans = fullJustify(
				new String[]{"a"},1);
				
		ans = fullJustify(
				new String[]{""},2);
		for(String s:ans){
			System.out.println(s);
		}
	}

}
