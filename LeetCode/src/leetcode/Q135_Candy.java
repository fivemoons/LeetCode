package leetcode;

public class Q135_Candy {
    public static int candy(int[] ratings) {
        int[] candy = new int[ratings.length];
        candy[0] = 1;
        for(int i=1; i<ratings.length; i++){
        		if(ratings[i] > ratings[i-1])
        			candy[i] = candy[i-1] + 1;
        		else
        			candy[i] = 1;
        }
        for(int i=ratings.length-2; i>=0; i--){
        		if((ratings[i] > ratings[i+1])&&(candy[i] < candy[i+1] + 1))
        			candy[i] = candy[i+1] + 1;
        	}
        	int ans = 0;
        	for(int i=0; i<ratings.length; i++){
        		ans += candy[i];
        }
        	return ans;
    }
	public static void main(String[] args) {
		System.out.println(candy(new int[]{1,2,2}));

	}

}
