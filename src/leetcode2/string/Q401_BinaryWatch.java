package leetcode2.string;

import java.util.ArrayList;
import java.util.List;

public class Q401_BinaryWatch {
	public List<String> readBinaryWatch(int num) {
        List<String> ans = new ArrayList<String>();
        for(int h=0; h<12; h++){
            for(int m=0; m<60; m++){
                if (Integer.bitCount(h) + Integer.bitCount(m) == num){
                    ans.add(String.format("%d:%02d", h, m));
                }
            }
        }
        return ans;
    }
}
