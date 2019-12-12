package cc.ArraysAndStrings;

import java.util.Stack;

//71. Simplify Path
public class SimplifyPath {
    public String simplifyPath(String path) {
        if(path == ""){
            return path;
        }
        Stack<String> stack = new Stack<>();
        String[] paths = path.split("/");
        for(String s: paths){
            if(s.equals(".") || s.equals("")){
                continue;
            }
            if(s.equals("..")){
                if(!stack.isEmpty()){
                    stack.pop();
                }
            }else{
                stack.push(s);
            }
        }

        StringBuffer sb = new StringBuffer();
        if(stack.isEmpty()){
            sb.insert(0, "/");
        }
        while(!stack.isEmpty()){
            sb.insert(0, stack.pop());
            sb.insert(0, "/");
        }
        return sb.toString();
    }
}
