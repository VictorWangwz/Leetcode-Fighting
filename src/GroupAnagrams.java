import java.util.*;

public class GroupAnagrams {
//    Stupid method
//    public boolean CheckAnagram(String ss, String s){
//        if(ss.length() != s.length()){
//            return false;
//        }
//        char[] ssl = ss.toCharArray();
//        char[] sl = s.toCharArray();
//        Arrays.sort(ssl);
//        Arrays.sort(sl);
//        return Arrays.equals(ssl, sl);
//    }
//
//    public int ContainAnagram(List<List<String>> res, String s){
//        for(int i = 0; i<res.size(); i++){
//            List<String> l = res.get(i);
//            String ss = l.get(0);
//            if(CheckAnagram(ss, s)){
//                return i;
//            }
//        }
//        return -1;
//    }
//
//    public List<List<String>> groupAnagrams(String[] strs) {
//        List<List<String>> res = new ArrayList<>();
//
//        for(int i = 0; i<strs.length; i++){
//            List<String> l;
//            int idx = ContainAnagram(res, strs[i]);
//            if( idx != -1){
//                l = res.get(idx);
//                l.add(strs[i]);
//                res.set(idx, l);
//            }
//            else{
//                l = new ArrayList<>();
//                l.add(strs[i]);
//                res.add(l);
//            }
//        }
//        return res;
//    }

//    Hash map

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> m = new HashMap<>();
        for(String str: strs){
            char[] sl = str.toCharArray();
            Arrays.sort(sl);
            String key = String.valueOf(sl);
            if(m.containsKey(key)){
                m.get(key).add(str);
            }
            else{
                List<String> l = new ArrayList<>();
                l.add(str);
                m.put(key, l);
            }
        }
        return new ArrayList<>(m.values());
    }


    public static void main(String[] args) {
        GroupAnagrams g = new GroupAnagrams();
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(g.groupAnagrams(strs));
    }
}
