package vopreparation0530;

//
//第一题是给一个sentence分别print出每一个单词
//        -joezie：应该问的是除重。用stringstream来分割字符串，用一个hashset来存。
//        -follow-up：列出所有corner case
//
//        -follow-up*2：如果单词里有typo（输入错误）怎么办？用什么数据结构识别？
//        -joezie：用一个hashset来存储“字典”，对于读入的每个单词，用O(1)时间就能判断是否存在hashset之中。
//
//        -follow-up*3：如果有标点符号怎么办
//        -joezie：如果是单词只由字母组成的话，那么除了空格，所有的非字母字符也应该看作是分隔符。需要先遍历一遍sentence，把非字母的字符变为空格，然后再用以上方法解决。


import java.util.ArrayList;
import java.util.List;

public class SentencePrint {

    public List<String> print(String sentence){
        return new ArrayList<>();
    }
}
