import java.util.Stack;
//227
public class BasicCalculator {
    public static int calculate(String s) {
        int rst = 0;
        Stack<Integer> sVal = new Stack<>();
        Stack<Character> sOpt = new Stack<>();
        Stack<Integer> sHelp = new Stack<>();
        for(int i = 0; i < s.length(); i++){
            switch(s.charAt(i)){
                case ' ': continue;
                case '*':
                case '/':
                case '+':
                case '-':{
                    if(!sHelp.isEmpty()){
                        int temp = 0;
                        int p = 0;
                        while(!sHelp.isEmpty()){
                            temp += sHelp.pop() *  Math.pow(10, p);
                            p++;
                        }
                        sVal.push(temp);
                    }
                    sOpt.push(s.charAt(i));
                    continue;
                }
                default:{
                    StringBuffer tmpVal = new StringBuffer();
                    while(i < s.length() &&s.charAt(i) != ' ' && s.charAt(i) != '*' && s.charAt(i) != '/' && s.charAt(i) != '+' && s.charAt(i) != '-'){
                        tmpVal.append(s.charAt(i));
                        i++;
                    }
                    i--;

                    if(sOpt.isEmpty()){
                        sHelp.push(Integer.valueOf(tmpVal.toString()));
                        continue;
                    }
                    if(sOpt.peek() == '*')
                    {
                        sOpt.pop();
                        int val = (sVal.pop()) * (Integer.valueOf(tmpVal.toString()));
                        sVal.push(val);
                    }
                    else if(sOpt.peek() == '/')
                    {
                        sOpt.pop();
                        int val = (sVal.pop()) / (Integer.valueOf(tmpVal.toString()));
                        sVal.push(val);
                    }
                    else{
                        sHelp.push(Integer.valueOf(tmpVal.toString()));
                        continue;
                    }
                }
            }
        }
        if(!sHelp.isEmpty()){
            int temp = 0;
            int p = 0;
            while(!sHelp.isEmpty()){
                temp += sHelp.pop() * Math.pow(10, p);
                p++;
            }
            sVal.push(temp);
        }

        while(!sOpt.isEmpty()){
            char operator = sOpt.pop().charValue();
            int val = sVal.pop().intValue();
            if(operator == '-'){
                rst -= val;
            }
            else{
                rst += val;
            }
        }

        rst += sVal.pop().intValue();
        return rst;

    }

    public static void main(String[] args) {
        String s = "1*2-3/4+5*6-7*8+9/10";
        int rst = calculate(s);
        System.out.println(rst);
    }
}
