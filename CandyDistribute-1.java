import java.util.*;
public class MyClass {
    public static class Pair {
        int rating;
        int index;
        Pair(int rating,int index) {
            this.rating = rating;
            this.index = index;
        }
    } 
    public static void main(String args[]) {
      int A[] = {1,5,2,1};
      Pair[] p = new Pair[A.length];
      int ans[] = new int[A.length];
      int totalCandy=0;
      for(int i=0;i<A.length;i++) p[i] = new Pair(A[i],i);
      Arrays.sort(p,(p1,p2)->p1.rating-p2.rating);
      for(int i=0;i<A.length;i++) {
          //0-index case
          if(p[i].index==0) {
              if(A[p[i].index+1]>A[p[i].index]) {
                  ans[p[i].index]+=1;
              }   else {
                  ans[p[i].index] = ans[p[i].index+1]+1;
              }
          } 
          // last element case
          else if(p[i].index==A.length-1) {
              if(A[p[i].index-1]>A[p[i].index]) {
                  ans[p[i].index]+=1;
              } else {
                  ans[p[i].index] =ans[p[i].index-1]+1;
              }
              
          } else {
              if(A[p[i].index+1]>A[p[i].index] && A[p[i].index-1]>A[p[i].index]) {
                  ans[p[i].index]+=1;
              }  else if(A[p[i].index+1]>A[p[i].index] && A[p[i].index-1]<A[p[i].index]) {
                  ans[p[i].index]=ans[p[i].index-1]+1;
              } else if(A[p[i].index-1]>A[p[i].index] && A[p[i].index+1]<A[p[i].index]) {
                  ans[p[i].index] = ans[p[i].index+1]+1;
              } else {
                  ans[p[i].index] = Math.max(A[p[i].index-1],A[p[i].index+1])+1;
              }
          }
      }
      for(int i=0;i<ans.length;i++) totalCandy+=ans[i];
      System.out.println(totalCandy);
    }
}
