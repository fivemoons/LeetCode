package leetcode;

public class Q331_VerifyPreorderSerializationOfABinaryTree {
	public static boolean isValidSerialization(String preorder) {
        String[] nodes = preorder.split(",");
        int diff = 1; //现在有几个坑可以放节点
        for(String s:nodes){
        		diff--; //每一个节点占用一个坑
        		if(diff<0) return false; //是不是符合条件
        		if(!s.equals("#")) diff+=2; //如果是非叶子节点，补偿了两个坑
        }
        return diff==0; //最后把坑全都填满了
    }
	public static void main(String[] args) {
		System.out.println(isValidSerialization("9,3,4,#,#,1,#,#,2,#,6,#,#"));
	}

}
