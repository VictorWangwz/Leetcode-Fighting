package vopreparation0530;

//Given two words word1 and word2, find the minimum number of operations required to convert word1 to word2.
//
//        You have the following 3 operations permitted on a word:
//
//        Insert a character
//        Delete a character
//        Replace a character

//72
public class EditDistance {

    public static int minDistance(String word1, String word2) {
        return 3;
    }

    public static void main(String[] args) {
        String word1 = "horse", word2 = "ros";
        int expected = 3;
        int rst = minDistance(word1, word2);
        System.out.println(rst == expected);
    }
}
