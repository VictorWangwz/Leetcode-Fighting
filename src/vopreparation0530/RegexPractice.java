package vopreparation0530;

import java.util.regex.Pattern;

public class RegexPractice {
    public static void main(String[] args) {
        String contractName = "contract-";
        String contractNamePattern = "contract-";
        Pattern pattern = Pattern.compile(contractNamePattern);
        boolean isMatched = pattern.matcher(contractName).matches();
        System.out.println(isMatched);
    }
}
