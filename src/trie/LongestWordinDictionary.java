package trie;
//720. Longest Word in Dictionary
public class LongestWordinDictionary {
    public static String longestWord(String[] words) {
        WordTrie trie = new WordTrie();
        for(String word: words){
            trie.insert(word);
        }

        int max = Integer.MIN_VALUE;
        String rst = "";
        for(String word: words){
            int temp = trie.searchWord(word);
            if(temp != -1 && temp == max){
                rst = rst.compareTo(word) < 0? rst: word;
            }
            if(temp > max){
                max = temp;
                rst = word;
            }
        }
        return rst;
    }

    public static void main(String[] args) {
        String[] words = {"a", "banana", "app", "appl", "ap", "apply", "apple"};
        String rst = longestWord(words);
        System.out.println(rst);
    }


}
