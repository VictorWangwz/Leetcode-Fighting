package cc.ArraysAndStrings;

import java.util.Stack;

//394. Decode String
public class DecodeString {
    //todo
    public String decodeString(String s) {
        Stack<Integer> countS = new Stack<>();
        Stack<Integer> idxS = new Stack<>();
        StringBuffer sb = new StringBuffer();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            sb.append(String.valueOf(c));
            if(c == '['){
                idxS.push(i + 1);
                countS.push(s.charAt(i - 1) - '0');
            }
            else if(c == ']'){
                int start = idxS.pop();
                int count = countS.pop();
                StringBuffer tmp = new StringBuffer();
                for(int j = start; j < i; j++){
                    tmp.append(s.charAt(j));
                }
                sb.replace(start -2, sb.length(), tmp.toString());
                for(int j = 1; j < count; j++){
                    sb.append(tmp);
                }
            }
        }
        return sb.toString();

    }

    public static void main(String[] args) {
        String s = "3[a]2[bc]";
        DecodeString decodeString = new DecodeString();
        String rst = decodeString.decodeString(s);
        System.out.println(rst);
    }
}
