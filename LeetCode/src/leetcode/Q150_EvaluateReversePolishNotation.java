package leetcode;

import java.util.Stack;

public class Q150_EvaluateReversePolishNotation {
	/*
	 * 超时了

	private static boolean isNum(String s){
		try {
			Integer.parseInt(s);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	private static boolean isOp(String s){
		if(s.equals("+")) return true;
		if(s.equals("-")) return true;
		if(s.equals("*")) return true;
		if(s.equals("/")) return true;
		return false;
	}
    public static int evalRPN(String[] tokens) {
        List<String> l = new LinkedList<String>(Arrays.asList(tokens));
        while(l.size() >=3){
        		int i=0;
        		for(i=0; !(isNum(l.get(i))
        				&& isNum(l.get(i+1))
        				&& isOp(l.get(i+2))); i++);
        		int num1 = Integer.parseInt(l.get(i));
        		int num2 = Integer.parseInt(l.get(i+1));
        		int num3 = 0;
        		switch (l.get(i+2)) {
				case "+":	num3 = num1 + num2;	break;
				case "-":	num3 = num1 - num2;	break;
				case "*":	num3 = num1 * num2;	break;
				case "/":	num3 = num1 / num2;	break;
				default:	break;
        		}
        		l.remove(i+2);
        		l.remove(i+1);
        		l.remove(i);
        		l.add(i, Integer.toString(num3));
        }
        return Integer.parseInt(l.get(0));
    }
    	 */
	public static int evalRPN(String[] tokens) {
		String op = "+-*/";
		Stack<String> s = new Stack<String>();
		for(String ss: tokens){
			if(!op.contains(ss)){
				s.push(ss);
			}else{
				int num2 = Integer.valueOf(s.pop());
				int num1 = Integer.valueOf(s.pop());
				switch (ss) {
					case "+": s.push(Integer.toString(num1 + num2)); break;
					case "-": s.push(Integer.toString(num1 - num2)); break;
					case "*": s.push(Integer.toString(num1 * num2)); break;
					case "/": s.push(Integer.toString(num1 / num2)); break;
					default:
						break;
				}
			}
		}
		return Integer.valueOf(s.pop());
	}
	public static void main(String[] args) {
		System.out.println(evalRPN(new String[]{"2", "1", "+", "3", "*"}));

	}

}
