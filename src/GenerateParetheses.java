import java.util.ArrayList;
import java.util.List;

//g(f(i)) + f(n-i-1)
public class GenerateParetheses {
    public List<String> generateParenthesis(int n) {
        List <String> l = new ArrayList<>();
        if(n == 0){
            l.add("");
            return l;
        }
        for(int i = 0; i<=n - 1; i++){
            for(String s1: generateParenthesis(i)){
                for(String s2 : generateParenthesis(n - i - 1)){
                    String s = "(".concat(s1).concat(")").concat(s2);
                    l.add(s);
                }
            }
        }
        return l;
    }

    public static void main(String[] args) {
        GenerateParetheses g = new GenerateParetheses();
        int n = 10;
        System.out.print(g.generateParenthesis(n));
    }

}

