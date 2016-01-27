package leetcode;

public class Q223_RectangleArea {
    public static int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        long cgae =( (long) Math.min(C, G) - (long) Math.max(A, E)); //计算重叠部分的面积，注意int范围不够
        long dhbf =( (long) Math.min(D, H) - (long) Math.max(B, F));
        long area = 0L;
        if ((cgae>0) && (dhbf>0)) //判断是否真的有重叠
        	area = cgae * dhbf;
        return (int) ((C - A) * (D - B) - area + (G - E) * (H - F));
    }
	public static void main(String[] args) {
		System.out.println(computeArea(-1500000001,0,-1500000000,1,1500000000,0,1500000001,1));
	}

}
