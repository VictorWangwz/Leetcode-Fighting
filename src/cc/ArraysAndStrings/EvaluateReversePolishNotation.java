package cc.ArraysAndStrings;

import java.util.Stack;

//150. Evaluate Reverse Polish Notation
public class EvaluateReversePolishNotation {
    public int evalRPN(String[] tokens) {
        Stack<Integer> valS = new Stack<>();
        for(int i = 0; i < tokens.length; i++){
            String s = tokens[i];
            if(!(s.length() == 1 && s.charAt(0) < '0')){
                valS.push(Integer.valueOf(s));
            }
            else{
                int val2 = valS.pop();
                int val1 = valS.pop();
                if(s.equals("-"))
                    val1 -= val2;
                else if(s.equals("+"))
                    val1 += val2;
                else if(s.equals("*"))
                    val1 *= val2;
                else if(s.equals("/"))
                    val1 /= val2;

                valS.push(val1);
            }
        }
        return valS.pop();
    }

    public static void main(String[] args) {
        String[] tokens = {"4", "13", "5", "/", "+"};
        EvaluateReversePolishNotation evaluateReversePolishNotation = new EvaluateReversePolishNotation();
        int rst = evaluateReversePolishNotation.evalRPN(tokens);
        System.out.println(rst);
    }
}
