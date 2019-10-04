package string;

import java.util.HashMap;
import java.util.Map;

//6. ZigZag Conversion
public class ZigZagConversion {
    public String convert(String s, int numRows) {
        if(numRows == 1){
            return s;
        }
        int iter = numRows * 2 -2;
        Map<Integer, StringBuffer> map = new HashMap<>();
        for(int i = 0; i < numRows; i++){
            map.put(i, new StringBuffer());
        }
        for( int i = 0; i < s.length(); i++){
            StringBuffer sb = map.get(numRows - 1 - Math.abs(numRows - 1 - i%iter) );
            sb.append(""+s.charAt(i));
        }
        StringBuffer rst = new StringBuffer();
        for( int i = 0; i < numRows; i++){
            rst.append(map.get(i));
        }
        return rst.toString();


    }
}
