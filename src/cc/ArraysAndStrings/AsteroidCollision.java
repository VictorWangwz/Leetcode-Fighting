package cc.ArraysAndStrings;

import java.util.Stack;

//735. Asteroid Collision
public class AsteroidCollision {

    public int[] asteroidCollision(int[] asteroids) {
        if(asteroids == null || asteroids.length <= 1){
            return asteroids;
        }
        Stack<Integer> s = new Stack<>();
        s.push(asteroids[0]);
        loop: for(int i = 1; i < asteroids.length; i++){
            int cur = asteroids[i];
            if(s.empty()){
                s.push(cur);
                continue ;
            }
            if(cur > 0 ){
                s.push(cur);
                continue;
            }
            if(cur + s.peek() == 0){
                s.pop();
                continue;
            }
            if(cur + s.peek() > 0){
                continue;
            }
            while(!s.isEmpty() && cur <0 && s.peek() > 0 ){
                if (cur + s.peek() > 0){
                    cur = s.pop();
                } else if(cur + s.peek() == 0){
                    s.pop();
                   continue loop;
                }  else{
                    s.pop();
                }
            }
            s.push(cur);
        }
        int[] rst = new int[s.size()];
        int i = s.size() - 1;
        while(!s.isEmpty()){
            rst[i--] = s.pop();
        }
        return rst;
    }

    public static void main(String[] args) {
        Integer intObj=Integer.valueOf(args[args.length-1]);
        int i = intObj.intValue();
        if(args.length > 1)
            System.out.println(i);
        if(args.length > 0)
            System.out.println(i - 1);
        else
            System.out.println(i - 2);
        AsteroidCollision asteroidCollision = new AsteroidCollision();
        int[] asteroids = {-4,-1,10,2,-1,8,-9,-6,5,2};
        int[] rst =  asteroidCollision.asteroidCollision(asteroids);
        System.out.println(rst);
    }
}
