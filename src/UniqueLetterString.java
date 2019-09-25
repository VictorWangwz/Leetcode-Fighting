import java.util.HashSet;
import java.util.Set;

//828. Unique Letter String
public class UniqueLetterString {
    public static int uniqueNum(String s){
        Set<Character> set = new HashSet<>();
        for(char c: s.toCharArray()){
            set.add(c);
        }
        return set.size();
    }
    public static int uniqueLetterString(String S) {
        if(S == null || S.length() == 0){
            return 0;
        }
        Set<String> set = new HashSet<>();
        int num = 0;
        for( int i = 0; i < S.length(); i ++){
            for( int j = i; j < S.length(); j++){
                set.add(S.substring(i, j+1));
                num += j - i + 1;
            }
        }
        return num;

    }

    public static void main(String[] args) {
        String S = "ABA";
        int rst = uniqueLetterString(S);
        System.out.println(rst);
    }
}
