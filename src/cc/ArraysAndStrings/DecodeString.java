package cc.ArraysAndStrings;

//394. Decode String
public class DecodeString {
    //todo
//    public String decodeString(String s) {
//        Stack<Integer> countS = new Stack<>();
//        Stack<Integer> idxS = new Stack<>();
//        StringBuffer sb = new StringBuffer();
//        for(int i = 0; i < s.length(); i++){
//            char c = s.charAt(i);
//            sb.append(String.valueOf(c));
//            if(c == '['){
//                idxS.push(i + 1);
//                countS.push(s.charAt(i - 1) - '0');
//            }
//            else if(c == ']'){
//                int start = idxS.pop();
//                int count = countS.pop();
//                StringBuffer tmp = new StringBuffer();
//                for(int j = start; j < i; j++){
//                    tmp.append(s.charAt(j));
//                }
//                sb.replace(start -2, sb.length(), tmp.toString());
//                for(int j = 1; j < count; j++){
//                    sb.append(tmp);
//                }
//            }
//        }
//        return sb.toString();
//
//    }


    private int helper(StringBuffer sb, int idx, String s){
        StringBuffer rst = new StringBuffer();
        int num;
        for(int i = idx; i < s.length(); ) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                int k = i;
                while (s.charAt(k) != '[') {
                    k++;
                }
                num = Integer.valueOf(s.substring(i, k));
                StringBuffer tmp = new StringBuffer();
                i = helper(tmp, k + 1, s);
                rst.append(tmp);
                for (int j = 0; j < num; j++) {
                    sb.append(rst);
                }
                i++;
                return i;
            }
            else if(c ==']'){
                sb.append(rst);
                return i;
            }

            else {
                rst.append(c);
                i++;
            }

        }
        sb.append(rst);
        return s.length();

    }


    public String decodeString(String s) {
        StringBuffer newS = new StringBuffer(s);
        newS.insert(0,"1[");
        newS.append("]");
        StringBuffer sb = new StringBuffer();
        helper(sb, 0, newS.toString());
        return sb.toString();
    }

    public static void main(String[] args) {
        String s = "3[a]2[bc]";
        DecodeString decodeString = new DecodeString();
        String rst = decodeString.decodeString(s);
        System.out.println(rst);
    }
}
