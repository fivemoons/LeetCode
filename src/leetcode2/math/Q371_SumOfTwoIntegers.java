package leetcode2.math;

public class Q371_SumOfTwoIntegers {
	public int getSum(int a, int b) {
        int c = a ^ b;
        int d = (a & b) << 1; //前提：java的int会越界 python需要判断
        return d == 0 ? c : getSum(c, d);
    }
}
