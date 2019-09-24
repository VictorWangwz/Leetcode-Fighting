package vopreparation0530;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class WordBreak {

    //139. Word Break
//    Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, determine if s can be segmented into a space-separated sequence of one or more dictionary words.
//
//    Note:
//
//    The same word in the dictionary may be reused multiple times in the segmentation.
//    You may assume the dictionary does not contain duplicate words.
    public static boolean wordBreak1(String s, List<String> wordDict) {
        return true;
    }


//    140. Word Break II
//    Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, add spaces in s to construct a sentence where each word is a valid dictionary word. Return all such possible sentences.
//
//            Note:
//
//    The same word in the dictionary may be reused multiple times in the segmentation.
//    You may assume the dictionary does not contain duplicate words.
    public static List<String> wordBreak2(String s, List<String> wordDict) {
        List<String> rst = new ArrayList<>();
        return rst;
    }

    public static void main(String[] args) {
        String s1 = "leetcode";
        String[] words1 = {"leet", "code"};
        List<String> wordDict1 = Arrays.asList(words1);
        boolean expected1 = true;
        boolean rst1 = wordBreak1(s1, wordDict1);
        System.out.print(expected1 == rst1);
        String s2 = "catsanddog";
        String[] words2 = {"cat", "cats", "and", "sand", "dog"};
        List<String> wordDict2 = Arrays.asList(words2);
        String[] expectedS = {"cats and dog", "cat sand dog"};
        List<String> expected2 = Arrays.asList(expectedS);
        List<String> rst2 = wordBreak2(s2, wordDict2);
        System.out.print(expected2.equals(rst2));
    }
}
