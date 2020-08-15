package amzoapreperationwinter;

import java.util.*;

public class CellTower {

//    public int minimumDate(int rows, int colums, List<List<Integer>> grid){
//
//    }
//    public int minimumDate(int[][] grid){
//        if(grid == null || grid.length == 0 || grid[0].length == 0){
//            return 0;
//        }
//
//
//    }
    private static List<String> topNBuzzwords(int numToys, int topToys, String[] toys, int numQuotes, String[] quotes) {
        List<String> res = new ArrayList<>();
        Set<String> setToys = new HashSet<>();
        Map<String, WordStats> mapWords = new HashMap<>();

        for (int i = 0; i < numToys; i++)
            setToys.add(toys[i]);

        for (int i = 0; i < numQuotes; i++)
        {
            String q = quotes[i];
            q = q.replaceAll("[\\!?,;.]", "").toLowerCase();
            String[] words = q.split(" ");

            for (int w = 0; w < words.length; w++)
            {
                String word = words[w];
                if (setToys.contains(word))
                {
                    WordStats stats;
                    if (mapWords.containsKey(word))
                        stats = mapWords.get(word);
                    else
                        stats = new WordStats(word, 0);
                    stats.countTimes++;
                    stats.quotesIds.add(i);
                    mapWords.put(word, stats);
                }
            }
        }

        PriorityQueue<WordStats> pq = new PriorityQueue<WordStats>(new Comparator<WordStats>() {
            @Override
            public int compare(WordStats o1, WordStats o2) {
                if (o1.countTimes != o2.countTimes)
                    return Integer.compare(o2.countTimes, o1.countTimes);
                else if (o1.quotesIds.size() != o2.quotesIds.size())
                    return Integer.compare(o2.quotesIds.size(), o1.quotesIds.size());
                else
                    return o1.word.compareTo(o2.word);
            }
        });
        pq.addAll(mapWords.values());

        if (topToys > pq.size())
            for (int i = 0; i < numToys && !pq.isEmpty(); i++)
                res.add(pq.poll().word);
        else
            for (int i = 0; i < pq.size(); i++)
                res.add(pq.poll().word);

        return res;
    }

    private static class WordStats {
        String word;
        int countTimes;
        Set<Integer> quotesIds;
        public WordStats(String word, int countTimes) {
            this.word = word;
            this.countTimes = countTimes;
            this.quotesIds = new HashSet<>();
        }
    }


//    private static List<String> topNBuzzwords1(int numToys, int topToys, String[] toys, int numQuotes, String[] quotes) {
//        List<String> results = new ArrayList<>();
//        Set<String> comSet = new HashSet<>();
//        for(String com: toys){
//            comSet.add(com.toLowerCase());
//        }
//
//        Map<String, Integer> hashMap = new HashMap<>();
//
//        for(String review: quotes){
//            review = review.replaceAll("[\\!,;.]]", "").toLowerCase();
//            String[] words = review.split(" ");
//
//            Set<String> used = new HashSet<>();
//            for(String word: words){
//                String tmp = word.toLowerCase();
//                if(!comSet.contains(tmp)){
//                    continue;
//                }
//
//            }
//        }
//    }


    public static void main(String[] args) {
//        int[][] gridArr = {
//                {0,1,1,0,1},
//                {0,1,0,1,0},
//                {0,0,0,0,1},
//                {0,1,0,0,0}
//        };
        int num = 6, topN = 2, numReview = 6;
        String[] competitors = {
                "newshop",
                "shopnow",
                "afshion",
                "fashionbeats",
                "mymarket",
                "tcellular"
        };
        String[] reviews = {
                "newshop is providing good services in the city, everyone should use newshop",
                "best services by newshop",
                "fashionbeats has great services in the city",
                "I am proud to have fashionbeats",
                "mymarket has awesome services",
                "Thanks Newshop for the quick delivery"
        };
        List<String> rst = topNBuzzwords(num, topN,competitors, numReview, reviews);
        System.out.print(rst);

        String s1 = "a", s2 = "b";
        System.out.print(s1.compareTo(s2));


    }
}
