package cc.ArraysAndStrings;

//394. Decode String
public class DecodeString {

    private int helper(StringBuffer sb, int idx, int count, String s){
        StringBuffer rst = new StringBuffer();
        int num;
        for(int i = idx; i < s.length(); ) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
               i++;
               continue;
            }
            else if(c == '['){
                int k = i;
                while (k - 1 >= 0 && Character.isDigit(s.charAt(k - 1))) {
                    k--;
                }
                num = Integer.valueOf(s.substring(k, i));
                StringBuffer tmp = new StringBuffer();
                i = helper(tmp, i + 1, num, s);
                rst.append(tmp);

                i++;
            }
            else if(c ==']'){
                for (int j = 0; j < count; j++) {
                    sb.append(rst);
                }
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
        helper(sb, 0, 1,  newS.toString());
        return sb.toString();
    }

    public static void main(String[] args) {
        String s = "3[a]2[bc]";
        DecodeString decodeString = new DecodeString();
        String rst = decodeString.decodeString(s);
        System.out.println(rst);
    }
}
