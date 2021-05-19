public class Solution {
    public static int T[];
    public int[] solve(int[] A, int[][] B) {
         ArrayList<Integer> aList = new ArrayList<>();
         T = new int[4*A.length-1];
          T = build(0,0,A.length-1,A,T);
          for(int i=0;i<B.length;i++) {
               int check = B[i][0];
               if(check==1) {
                   aList.add(query(0,0,A.length-1,B[i][1]-1,B[i][2]-1,T));
               } else {
                   update(0,0,A.length-1,B[i][1]-1,B[i][2],T);
               }
          }
          int ans[] = new int[aList.size()];
          for(int i=0;i<aList.size();i++) ans[i] = aList.get(i);
          return ans;
    }
    public static int[] build(int i,int left,int right,int A[],int T[]) {
        if(left==right) {
            T[i] = A[left];
            return T;
        }
        int mid = (left+right)/2;
        build(2*i+1,left,mid,A,T);
        build(2*i+2,mid+1,right,A,T);
        T[i] = Math.min(T[2*i+1],T[2*i+2]);
        return T;
    }
    public static int query(int i,int left,int right,int qLeft,int qRight,int T[]) {
        if(right<qLeft || left>qRight) return Integer.MAX_VALUE;
        else if(left>=qLeft && right<=qRight) return T[i];
        else {
            int mid = (left+right)/2;
            int leftSum = query(2*i+1,left,mid,qLeft,qRight,T);
            int rightSum = query(2*i+2,mid+1,right,qLeft,qRight,T);
            return Math.min(leftSum,rightSum);
        }
    }
    public static void update(int i,int left,int right,int index,int val,int T[]) {
        if(index>right || index<left) return ;
        if(index==left && index==right){ 
            T[i]=val; 
            return;
        }
        int mid = (left+right)/2;
        update(2*i+1,left,mid,index,val,T);
        update(2*i+2,mid+1,right,index,val,T);
        T[i] = Math.min(T[2*i+1],T[2*i+2]);
    }
}
