package string;

public class AddBinary {
    public static String addBinary(String a, String b) {
        int ia = a.length() - 1, ib = b.length() - 1;
        if(ia > ib){
            return addBinary(b, a);
        }
        int lenDiff = ib - ia;
        StringBuffer strDiff = new StringBuffer();
        for(int i = 0; i < lenDiff; i++){
            strDiff.append("0");
        }
        a = strDiff.toString() + a;
        StringBuffer sb = new StringBuffer();
        int rest = 0;
        while( ib >=0 ){
            int sum = rest;
            if(a.charAt(ib) == '1') sum++;
            if(b.charAt(ib) == '1') sum++;
            String tmp = String.valueOf(sum % 2);
            sb.append( tmp);
            rest = sum /2;
            ib--;
        }
        if(rest != 0){
            sb.append(rest);
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        String a = "1010", b = "1011";
        String rst = addBinary(a, b);
        System.out.println(rst);
    }
}
