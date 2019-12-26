package quoraoa;
//541. Reverse String II
public class ReverseStringII {
    public String reverse(String s){
        StringBuffer sb = new StringBuffer();
        sb.append(s);
        return sb.reverse().toString();
    }
    public String reverseStr(String s, int k) {
        if(s.length() < k){
            return reverse(s);
        }
        if(s.length() >= k && s.length() < 2 * k){
            return reverse(s.substring(0, k)) + s.substring(k);
        }

        return reverse(s.substring(0, k)) + s.substring(k, 2* k) + reverseStr(s.substring(2*k),k);


    }
}
