import java.util.Stack;

//161 One Edit Distance
public class OneEditDistance {

    public static boolean isOneEditDistance(String s, String t) {
        if(s == null || t == null || Math.abs(s.length() - t.length()) >= 2){
            return false;
        }

        if(s.length() > t.length()){
            return isOneEditDistance(t, s);
        }

        int dis = 1;
        Stack<Character> ss = new Stack<>();
        for(char c: s.toCharArray()){
            ss.push(c);
        }

        int pt = t.length() - 1;
        while(!ss.isEmpty()){
            if(ss.peek().equals(t.charAt(pt))){
                ss.pop();
                pt--;
                continue;
            }
            dis--;
            if( dis < 0){
                return false;
            }
            if(ss.size() == pt + 1){
                pt--;
                ss.pop();
            }else if(ss.size() > pt + 1){
                ss.pop();
            }
            else{
                pt--;
            }
        }


        return dis == 0 || pt == 0;
    }

    public static boolean isOneEditDistance1(String s, String t) {
        if(s.length() > t.length()){
            return isOneEditDistance1(t, s);
        }

        if(t.length() - s.length() > 1)
            return false;

        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) != t.charAt(i)){
                if(s.length() == t.length()){
                    return s.substring(i + 1).equals(t.substring(i + 1));
                }
                else{
                    return s.substring(i).equals(t.substring(i + 1));
                }
            }
        }
        return s.length() + 1 == t.length();
    }

    public static void main(String[] args) {
        String s = "a", t = "A";
        boolean rst = isOneEditDistance1(s, t);
        System.out.println(rst);
    }
}
