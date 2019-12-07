package cc.ArraysAndStrings;

import java.util.ArrayList;
import java.util.List;

//388. Longest Absolute File Path
public class LongestAbsoluteFilePath {

    private int countT(String s){
        int count = s.lastIndexOf("\t") + 1;
        return count;
    }

    private void findPath(String[] inputs, int idx , StringBuffer path){
        int count = countT(inputs[idx]);
        if(count < 0){
            return;
        }
        for(int i = idx - 1; i >= 0; i--){
            if(countT(inputs[i]) == count  - 1){
                path.insert(0, createPath(inputs[i]));
                findPath(inputs, i, path);
                return;
            }
        }

    }

    private String createPath(String s){
        return "/" + s.substring(s.lastIndexOf("\t") + 1);
    }

    public int lengthLongestPath(String input) {
        String[] inputs = input.split("\\n");
        List<String> allPaths = new ArrayList<>();
        for(int i = 0; i < inputs.length; i++){
            if(inputs[i].contains(".")){
                String file = inputs[i];
                StringBuffer path = new StringBuffer();
                path.append(createPath(file));
                findPath(inputs, i, path);
                allPaths.add(path.toString());
            }
        }
        int max = Integer.MIN_VALUE;
        if(allPaths.size() == 0){
            return 0;
        }
        for(String s: allPaths){
            if(s.length() > max){
                max = s.length();
            }
        }
        return max - 1;
    }

    public static void main(String[] args) {
        String input = "dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext";
        LongestAbsoluteFilePath longestAbsoluteFilePath = new LongestAbsoluteFilePath();
        int rst = longestAbsoluteFilePath.lengthLongestPath(input);
        System.out.println(rst);
    }
}
