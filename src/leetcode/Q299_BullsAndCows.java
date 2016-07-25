package leetcode;

public class Q299_BullsAndCows {
	public static String getHint(String secret, String guess) {
        StringBuilder s = new StringBuilder(secret);
        StringBuilder g = new StringBuilder(guess);
        int A = 0;
        for(int i=s.length()-1; i>=0; i--){
        		if (s.charAt(i) == g.charAt(i)){
        			s.deleteCharAt(i);
        			g.deleteCharAt(i);
        			A++;
        		}
        }
        int B = 0;
        for(int i=s.length()-1; i>=0; i--){
        		String c = s.substring(i, i+1);
        		int j = g.indexOf(c);
        		if (j != -1){
        			s.deleteCharAt(i);
        			g.deleteCharAt(j);
        			B++;
        		}
        }
        return Integer.toString(A)+"A"+Integer.toString(B)+"B";
    }
	public static void main(String[] args) {
		System.out.println(getHint("1807","7810"));

	}

}
