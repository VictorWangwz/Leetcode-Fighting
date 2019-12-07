package cc.ArraysAndStrings;
//953. Verifying an Alien Dictionary
public class VerifyinganAlienDictionary {

    private boolean check(String w1, String w2, String order){
        int i = 0, j = 0;
        while( i < w1.length() && j < w2.length()){
            if(w1.charAt(i) == w2.charAt(j)){
                i++;
                j++;
                continue;
            }
            else{
                if(order.indexOf(w1.charAt(i)) > order.indexOf(w2.charAt(i))){
                    return false;
                }
                else{
                    return true;
                }
            }
        }
        if(i != w1.length()){
            return false;
        }
        return true;

    }

    public boolean isAlienSorted(String[] words, String order) {
        if(words == null || words.length <= 1){
            return true;
        }
        for(int i = 1; i < words.length; i++){
            if(!check(words[i - 1], words[i], order)){
                return false;
            }
        }
        return true;

    }
}
