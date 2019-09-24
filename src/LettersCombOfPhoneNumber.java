//17
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LettersCombOfPhoneNumber {
    static List<String> rst = new ArrayList<>();

    public static void backTrace(Map<String, String> m, String digits, String s){
        if(digits.length() == 0){
            rst.add(s);
        }else{
            String number = digits.substring(0, 1);
            String letter = m.get(number);
            for(int i = 0; i < letter.length(); i++){
                backTrace(m, digits.substring(1),s + letter.substring(i , i + 1));
            }
        }
    }

    public static List<String> letterCombinations(String digits) {
        Map<String, String> m = new HashMap<>();
        m.put("2", "abc");
        m.put("3", "def");
        m.put("4", "ghi");
        m.put("5", "jkl");
        m.put("6", "mno");
        m.put("7", "pqrs");
        m.put("8", "tuv");
        m.put("9", "wxyz");
        if(digits.length() != 0){
            backTrace(m, digits, "");
        }
        return rst;
    }

    public static void main(String[] args) {
        letterCombinations("23");
        System.out.println(rst);
    }
}
