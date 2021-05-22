public class Solution {
    public static int T[];
    public int[] solve(int N, int[][] B) {
         int A[] = new int[N];
          T = new int[4*N-1];
             Arrays.fill(A,1);
             build(0,0,N-1,A);
             ArrayList<Integer> list = new ArrayList<>();
             for(int i=0;i<B.length;i++) {
                 if(B[i][0]==1) {
                     int index = query(0,0,N-1,B[i][1]); 
                     if(index!=-1)
                     list.add(index+1);
                     else list.add(-1);
                 } else {
                     update(0,0,N-1,B[i][1]-1);
                 }
             }
             int ans[] = new int[list.size()];
             for(int i=0;i<list.size();i++) ans[i] = list.get(i);
             return ans;
    }
    public static void build(int i,int left,int right,int A[]) {
        if(left==right) { T[i]=A[left]; return; }
        int mid = (left+right)/2;
        build(2*i+1,left,mid,A);
        build(2*i+2,mid+1,right,A);
        T[i] = T[2*i+1]+T[2*i+2];
    }
    public static int query(int i,int left,int right,int k) {
       if(k>T[i]) return -1;
       if(left==right) return left;
       int leftValue = T[2*i+1];
       int mid = (left+right)/2;
       if(k<=leftValue) {
         return      query(2*i+1,left,mid,k);
       } else {
          return  query(2*i+2,mid+1,right,k-leftValue);
       }
     
    }
    public static void update(int i,int left,int right,int index) {
        if(left==right) {
            T[i] = 0;
            return;
        }
        int mid = (left+right)/2;
        if(index<=mid) {
            update(2*i+1,left,mid,index);
        } else {
            update(2*i+2,mid+1,right,index);
        }
        T[i] = T[2*i+1]+T[2*i+2];
    }
}
