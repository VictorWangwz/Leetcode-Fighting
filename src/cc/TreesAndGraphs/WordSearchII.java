package cc.TreesAndGraphs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//212. Word Search II
public class WordSearchII {

    //time limited exceeded
    private boolean helper(char[][] board, String word, int r, int c, int cur, Set<List<Integer>> visited){
        List<Integer> curPix = new ArrayList<>();
        curPix.add(r);
        curPix.add(c);
        if(r < 0 || r >= board.length || c < 0 || c >= board[0].length|| visited.contains(curPix)){
            return false;
        }

        if(board[r][c] != word.charAt(cur)){
            return false;
        }
        if(cur == (word.length() -1) ){
            return true;
        }
        cur++;
        Set<List<Integer>> tmpVisited = new HashSet<>();
        tmpVisited.addAll(visited);
        tmpVisited.add(curPix);
        return helper(board, word, r, c+1, cur, tmpVisited) || helper(board, word, r, c-1, cur, tmpVisited) || helper(board, word, r+1, c, cur, tmpVisited) || helper(board, word, r-1, c, cur, tmpVisited) ;
    }


    public List<String> findWords(char[][] board, String[] words) {
        List<String> rst = new ArrayList<>();
        if(words == null || words.length == 0){
            return rst;
        }
        next: for(String word: words){
            for(int i = 0; i < board.length; i++){
                for(int j = 0; j < board[0].length; j++){
                    if(board[i][j] == word.charAt(0)){
                        Set<List<Integer>> visited = new HashSet<>();
                        if(helper(board, word, i, j, 0, visited)){
                            rst.add(word);
                            continue next;
                        }
                    }
                }
            }

        }
        return rst;
    }

    public static void main(String[] args) {
        char[][] board = {
                {'a','b','c'},
                {'a','e','d'},
                {'a','f','g'}
        };
        String[] words = {"abcdefg","gfedcbaaa","eaabcdgfa","befa","dgc","ade"};
        WordSearchII wordSearchII = new WordSearchII();
        List<String> rst = wordSearchII.findWords(board, words);
        System.out.println(rst);
    }
}
