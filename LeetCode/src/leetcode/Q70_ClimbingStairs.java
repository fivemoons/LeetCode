package leetcode;

public class Q70_ClimbingStairs {//上楼梯，菲波那切数列
	public static int climbStairs(int n) { //f[n] = f[n-2] + f[n-1]
		int laststep = 1;
        int step = 1;
        for(int i=2; i<=n; i++){
        		int temp = step;
        		step = laststep + step;
        		laststep = temp;
        }
        return step;
    }
	public static int climbStairs2(int n) {
		n++;
		double sqrt5 = Math.sqrt(5);
		return (int) Math.round((Math.pow(((1 + sqrt5)/2),n) - Math.pow(((1 - sqrt5)/2),n))/sqrt5);
    }

	public static void main(String[] args) {
		System.out.println(climbStairs(2));
		System.out.println(climbStairs2(2));
	}

}
