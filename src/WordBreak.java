import java.util.*;
//139

public class WordBreak {
    public static boolean wordBreak(String s, List<String> wordDict) {
        if(wordDict.contains(s)){
            return true;
        }
        for(int i = 0; i < s.length(); i++){
            String subS = s.substring(0, i);
            if(wordDict.contains(subS) && wordBreak(s.substring(i), wordDict)){
                return true;
            }
        }
        return false;
    }

//    bfs
    public static boolean wordBreak2(String s, List<String> wordDict) {
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        int[] visited = new int[s.length()];
        int start;
        while(!q.isEmpty()){
            start = q.poll();
            if(visited[start] == 0){
                for(int end  = start + 1; end <= s.length(); end ++){
                    if(wordDict.contains(s.substring(start, end))){
                        if(end == s.length()){
                            return true;
                        }
                        ((LinkedList<Integer>) q).add(end);
                    }
                }
            }
            visited[start] = 1;
        }
        return false;
    }

    public static void main(String[] args) {
        String s = "catsandog";
        List<String> wordDict = new ArrayList<>();
        String[] words = {"cats", "dog", "sand", "and", "cat"};
        for(String s1: words){
            wordDict.add(s1);
        }
        boolean rst = wordBreak2(s, wordDict);
        System.out.println(rst);
    }
}
