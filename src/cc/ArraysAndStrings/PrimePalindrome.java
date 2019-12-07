package cc.ArraysAndStrings;

import java.util.ArrayList;
import java.util.List;

//866. Prime Palindrome
public class PrimePalindrome {
    //time limited exceed
    private boolean checkPal(int num){
        int newNum = 0;
        int oldNum = num;
        while(num != 0){
            newNum = newNum * 10 + num  % 10;
            num = num / 10;
        }
        return newNum == oldNum;
    }

    public int primePalindrome(int N) {
        if(N <= 2){
            return 2;
        }
        List<Integer> primes = new ArrayList<>();
        for(int i = 2; i < N; i++){
            boolean isPrime = true;
            for(Integer prime: primes){
                if(i % prime == 0 ){
                    isPrime = false;
                }
            }
            if(isPrime){
                primes.add(i);
            }
        }
        while(true){
            if(checkPal(N)){
                boolean isPrime = true;
                for(Integer prime: primes){
                    if(N % prime == 0 ){
                        isPrime = false;
                    }
                }
                if(isPrime){
                    primes.add(N);
                    return N;

                }
                N++;
            }
            if (10_000_000 < N && N < 100_000_000)
                N = 100_000_000;

        }
    }

    private boolean checkPrime(int N){
        int n = (int)Math.sqrt(N);
        boolean isPrime = true;
        for(int i = 2; i <= n ; i++){
            if(N % i == 0){
                isPrime = false;
                break;
            }
        }
        return isPrime;
    }

    public int primePalindrome0(int N) {
        while(true){
            if(checkPal(N) && checkPrime(N) ){
                return N;
            }
            N ++;
            if (10_000_000 < N && N < 100_000_000)
                N = 100_000_000;
        }

    }

    public static void main(String[] args) {
        int num = 1;
        PrimePalindrome primePalindrome = new PrimePalindrome();
        int rst = primePalindrome.primePalindrome(num);
        System.out.println(rst);
    }
}
