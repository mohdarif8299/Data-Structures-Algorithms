public class Solution {
    static int[] T;
    static int[] L;
    public int solve(int N, ArrayList<ArrayList<Integer>> B) {
        int A[] = new int[N];
        T = new int[4*N-1];
        L = new int[4*N-1];
        long sum=0;
        build(0,0,N-1,A);
        for(int i=0;i<B.size();i++) {
            if(B.get(i).get(0)==0) {
                update(0,0,N-1,B.get(i).get(1),B.get(i).get(2));
            } else {
                sum+=query(0,0,N-1,B.get(i).get(1),B.get(i).get(2));
            }
        }
        return (int)(sum%1000000007);
    }
    public static void build(int i,int left,int right,int A[]) {
        if(left==right) {
            T[i] = A[left];
            return;
        }
        int mid = (left+right)/2;
        build(2*i+1,left,mid,A);
        build(2*i+2,mid+1,right,A);
        T[i] = T[2*i+1]+T[2*i+2];
    }
    public static void update(int i,int left,int right,int qLeft,int qRight) {
        
         if(L[i]!=0) {
              T[i] = (right-left+1)-T[i];
             if(left!=right) {
                 L[2*i+1]^=1;
                 L[2*i+2]^=1;
             }
             L[i]=0;
         }
        
        //No Overlap
        if(left>qRight || right<qLeft) return;
        //Complete Overlap
        if(left>=qLeft && right<=qRight) {
            T[i] = (right-left+1)-T[i];
             if(left!=right) {
                 L[2*i+1]^=1;
                 L[2*i+2]^=1;
             }
             return;
         }
        int mid = (left+right)/2;
        update(2*i+1,left,mid,qLeft,qRight);
        update(2*i+2,mid+1,right,qLeft,qRight);
        T[i] = T[2*i+1]+T[2*i+2];
    }
    public static int query(int i,int left,int right,int qLeft,int qRight) {
        if(L[i]!=0) {
              T[i] = (right-left+1)-T[i];
             if(left!=right) {
                 L[2*i+1]^=1;
                 L[2*i+2]^=1;
             }
             
             L[i]=0;
         }
         //No Overlap
        if(left>qRight || right<qLeft) return 0;
        //Complete Overlap
        if(left>=qLeft && right<=qRight) {
            return T[i];
        }
        int mid = (left+right)/2;
        int l = query(2*i+1,left,mid,qLeft,qRight);
        int r = query(2*i+2,mid+1,right,qLeft,qRight);
        return l+r;
    }
}
