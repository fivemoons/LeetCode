package leetcode;

public class Q52_NQueenII {//位运算优化版本，只计算答案数
	private static int ans = 0; //用来计算答案数

	private static void dfs(int all, int col, int ld, int rd) { //依次为n位全是1，列数，右上左下对角线，左上右下对角线被占情况
		if (col != all) { //如果当前列还没有被占满，说明还没有放慢皇后。
			int pos = all & ~(col | ld | rd); //col|ld|rd 得到当前行哪些位置被占了，取反后得到可以放皇后的地方，&all则是为了把高位的1补齐。pos：可以放皇后的位为1
			while (pos != 0) { //如果得到的pos不是0 说明还有位置可以放皇后
				int p = pos & (~pos + 1); //这段代码是保留pos的最后一个1 例：100100 取反011011 取反+1：011100 &本身：000100
				pos -= p; //减去最后一个1的位置。表名已经放置皇后
				dfs(all, col + p, (ld + p) << 1, (rd + p) >> 1); //递归，all不变，col加上当前放置皇后的列，对角线加上当前之后注意左移和右移
			}
		} else {
			ans++; //全部占满，答案+1
		}
	}

	public static int totalNQueens(int n) {
		dfs((1 << n) - 1, 0, 0, 0);
		return ans;
	}

	public static void main(String[] args) {
		System.out.println(totalNQueens(8));
	}

}
