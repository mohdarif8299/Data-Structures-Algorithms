import java.util.*;
public class MyClass {
    static int[] T;
    static int[] L;
    public static void main(String args[]) {
      int A[] = {2,4,3,-4,5,1,-2,0};
      T = new int[4*A.length-1];
      L = new int[4*A.length-1];
      build(0,0,A.length-1,A);
      System.out.println(Arrays.toString(T));
      updateRange(0,0,A.length-1,2,3,1);
      System.out.println(Arrays.toString(T));
    }
    public static void build(int i,int left,int right,int A[]){
         if(left==right) {
             T[i] = A[left];
             return;
         }
         int mid = (left+right)/2;
         build(2*i+1,left,mid,A);
         build(2*i+2,mid+1,right,A);
         T[i] = Math.min(T[2*i+1],T[2*i+2]);
    }
    public static int queryRange(int i,int left,int right,int qLeft,int qRight) {
        // Check Lazy Tree
        if(L[i]!=0) {
            T[i]+=L[i];
            if(left!=right) {
               L[2*i+1]+=L[i];
               L[2*i+2]+=L[i];
            }
            L[i]=0;
           }
        // No Overlap
        if(left>qRight || right<qLeft) return Integer.MAX_VALUE;
        // Complete Overlap
        if(left<=qLeft && right<=qRight) return T[i];
       // Partial overlap
       int mid = (left+right)/2;
       int left = queryRange(2*i+1,left,mid,qLeft,qRight);
       int right = queryRange(2*i+2,mid+1,right,qLeft,qRight);
       return Math.min(left,right);
    }
    public static void updateRange(int i,int left,int right,int qLeft,int qRight,int val) {
      
        if(L[i]!=0) {
            T[i]+=L[i];
            if(left!=right) {
               L[2*i+1]+=L[i];
               L[2*i+2]+=L[i];
            }
            L[i]=0;
           }
      
       // No overlap
       if(left>qRight || right<qLeft) { return;
       } 
       if(left<=qLeft && right<=qRight) {
           T[i]= T[i]+val;
             if(left!=right) {
                L[i*2+1]+= L[i];
                L[i*2+2]+= L[i];
             }
             return;
       }
       
       int mid = (left+right)/2;
       updateRange(2*i+1,left,mid,qLeft,qRight,val);
       updateRange(2*i+2,mid+1,right,qLeft,qRight,val);
       T[i] = Math.min(T[2*i+1],T[2*i+2]);
       // Complete Overlap
       // Partial Overlap 
       
    }
}
