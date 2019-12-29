package cc.ArraysAndStrings;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//93. Restore IP Addresses
public class RestoreIPAddresses {

    Set<String> set = new HashSet<>();

    private void restoreIpAddresses(StringBuffer sb, String s, int count){
        if(count == 0 && s.length() == 0){
            set.add(sb.toString());
            return;
        }

        for(int i = 0; i < 3 && i < s.length(); i++){
            int val = Integer.valueOf(s.substring(0, i + 1));
            if(checkVal(s.substring(0, i + 1)) ){
                StringBuffer newSb = new StringBuffer(sb);

                if(newSb.length() != 0){
                    newSb.append(".");
                }
                newSb.append(val);
                restoreIpAddresses(newSb, s.substring(i + 1), count - 1);
            }

        }
    }

    private boolean checkVal(String s){
        if(s.length() > 1 && s.charAt(0) == '0'){
            return false;
        }
        int val = Integer.valueOf(s);
        if( val >= 0 && val <= 255){
            return true;
        }
        return false;
    }

    public List<String> restoreIpAddresses(String s) {
        if(s.length() <= 16){
            restoreIpAddresses(new StringBuffer(), s, 4);
        }
        List<String> rst = new ArrayList<>();
        rst.addAll(set);
        return rst;
    }

    public static void main(String[] args) {
        String s = "010010";
        RestoreIPAddresses restoreIPAddresses = new RestoreIPAddresses();
        List<String> rst = restoreIPAddresses.restoreIpAddresses(s);
        System.out.println(rst);
    }
}
