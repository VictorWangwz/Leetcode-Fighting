package binarySearch;

 public class SVNRepo {
     private int indexOfBad;
     public SVNRepo(int n){
          indexOfBad = n;
     }

     public  boolean isBadVersion(int k){
         return k < indexOfBad ? false: true;
     }
 }
