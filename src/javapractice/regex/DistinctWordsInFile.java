package javapractice.regex;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DistinctWordsInFile {
    public List<String> readDistrintWordsFromFile(String path) throws IOException {
        //read file
        BufferedReader reader = new BufferedReader(new FileReader(path));

        Set<String> distinctWordSet = new HashSet<>();

        String line = reader.readLine();

        //read line by line
        while( line != null){
            //transfer line to word array
            if(line.length() != 0){
                String[] words = line.split("[\\W]+");
                for(String word: words){

                    // use set to make it unique
                    distinctWordSet.add(word);
                }

            }
            line = reader.readLine();


        }
        reader.close();

        //transfer to word list as the result
        List<String> distinctWordList = new ArrayList<>();
        distinctWordList.addAll(distinctWordSet);


        return distinctWordList;
    }

    public static void main(String[] args)throws IOException{
        String path = "/Users/zhenwang/Desktop/java/leetcode/src/javapractice/regex/text.txt";
        DistinctWordsInFile distinctWordsInFile = new DistinctWordsInFile();
        List<String> words = distinctWordsInFile.readDistrintWordsFromFile(path);
    }




}
