package trie;

import java.util.Arrays;
import java.util.List;

//648. Replace Words
public class ReplaceWords {
    public static String replaceWords(List<String> dict, String sentence) {
        WordTrie2 trie = new WordTrie2();
        for(String str: dict){
            trie.insert(str);
        }
        StringBuffer sb = new StringBuffer();
        for(String word: sentence.split("\\s+")){
           int prefixIndx = trie.searchPrefix(word);
           if(prefixIndx == -1){
               sb.append(word);
               sb.append(" ");
           }
           else{
               sb.append(word.substring(0, prefixIndx + 1));
               sb.append(" ");
           }
        }
        String rst = sb.toString();
        return rst.substring(0, rst.length()  - 1);

    }

    public static void main(String[] args) {
        String[] dictArray  = {"cat", "bat", "rat"};
        List<String> dict = Arrays.asList(dictArray);
        String sentence = "the cattle was rattled by the battery";
        String rst = replaceWords(dict, sentence);
        System.out.println(rst);
    }
}
