package leetcode2.math;

public class Q258_AddDigits {
	public int addDigits(int num) {
        if (num == 0){
            return 0;
        }
        return (num % 9 == 0) ? 9 : num % 9;
    }
}
