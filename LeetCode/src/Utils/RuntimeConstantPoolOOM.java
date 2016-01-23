package Utils;

public class RuntimeConstantPoolOOM {
	/* JDK1.6 false false
	 * JDK1.7 true false
	 * 
	 */
	public static void main(String[] args) {
		String str1 = new StringBuilder("计算机").append("软件").toString();
		System.out.println(str1.intern() == str1);
		
		String str2 = new StringBuilder("ma").append("in").toString();
		System.out.println(str2.intern() == str2);
	}
}
