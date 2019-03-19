import java.util.Stack;

public class ValidParent {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(int i=0; i<s.length(); i++){
            char temp = s.charAt(i);
            switch (temp){
                case '{':
                case '[':
                case '(':
                {
                    stack.push(temp);
                    continue;
                }
                case ')':
                {
                    if(stack.isEmpty()) return false;
                    char top = stack.pop();
                    if(top != '(') return false;
                    continue;
                }
                case '}':
                {
                    if(stack.isEmpty()) return false;
                    char top = stack.pop();
                    if(top != '{') return false;
                    continue;
                }
                case ']':
                {
                    if(stack.isEmpty()) return false;
                    char top = stack.pop();
                    if(top != '[') return false;
                    continue;
                }

            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        ValidParent v = new ValidParent();
        String s = "}";
        System.out.println(v.isValid(s));
    }
}
