package cc.ArraysAndStrings;

import java.util.HashMap;
import java.util.Map;

//273. Integer to English Words
public class IntegertoEnglishWords {
    private Map<Integer, String> tenDic = new HashMap<>();
    private Map<Integer, String> oneDic = new HashMap<>();

    private void init(){
        String[] dic1 = {"", "One", "Two", "Three", "Four","Five","Six","Seven","Eight","Nine", "Ten", "Eleven", "Twelve", "Thirteen","Fourteen","Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
        for(int i = 0; i < dic1.length; i++){
            oneDic.put(i, dic1[i]);
        }

        String[] dic2 = {"Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
        for(int i = 2; i <= 9; i++){
            tenDic.put(i, dic2[i - 2]);
        }

    }

    private String transferToString(int num, String postFix){
        StringBuffer sb = new StringBuffer();
        if(num == 0){
            return "";
        }
        if(num / 100 != 0 ){
            sb.append(oneDic.get(num / 100));
            sb.append(" Hundred");
        }
        num %= 100;
        if(num  == 0){

        }
        else if(num < 20){
            if(sb.length() != 0){
                sb.append(" ");
            }
            sb.append(oneDic.get(num));
        }
        else{
            if(sb.length() != 0){
                sb.append(" ");
            }

            sb.append(tenDic.get(num /10));
            if(num % 10 != 0){
                sb.append(" ");
                sb.append(oneDic.get(num % 10));
            }

        }
        if(!postFix.equals("")){
            sb.append(postFix);
        }
        return sb.toString();
    }

    public String numberToWords(int num) {
        if(num == 0){
            return "Zero";
        }
        Map<Integer, String> map = new HashMap<>();
        map.put(0, "");
        map.put(1, " Thousand");
        map.put(2, " Million");
        map.put(3, " Billion");

        init();

        StringBuffer sb = new StringBuffer();


        int i = 0;
        while(num != 0){
            String tmp = transferToString(num % 1000, map.get(i));
            if(tmp.length() != 0){
                sb.insert(0, " ");
            }
            sb.insert(0, tmp);
            num /= 1000;
            i++;
        }

        return sb.toString().substring(0, sb.length() - 1);

    }

    public static void main(String[] args) {
        int num = 100;
        IntegertoEnglishWords integertoEnglishWords = new IntegertoEnglishWords();
        String rst = integertoEnglishWords.numberToWords(num);
        System.out.println(rst);
    }
}
