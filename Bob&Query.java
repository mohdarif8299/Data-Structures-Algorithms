public class Solution {
    private static int T[];
    public int[] solve(int N, int[][] B) {
       int A[] = new int[N];
       T = new int[4*N-1];
       ArrayList<Integer> list = new ArrayList<>();
       build(0,0,N-1,A);
       for(int i=0;i<B.length;i++) {
           if(B[i][0]==3) {
                list.add(query(0,0,N-1,B[i][1]-1,B[i][2]-1));
               
           }  else {
              update(0,0,N-1,B[i][1]-1,B[i][0]);
           }
       }
       int arr[] = new int[list.size()];
       for(int i=0;i<list.size();i++) arr[i] = list.get(i);
       return arr;
    }
     public static void build(int i,int left,int right,int A[]) {
        if(left==right) { T[i]=A[left]; return; }
        int mid = (left+right)/2;
        build(2*i+1,left,mid,A);
        build(2*i+2,mid+1,right,A);
        T[i] = T[2*i+1]+T[2*i+2];
    }
    public static int query(int i,int left,int right,int qLeft,int qRight) {
        if(right<qLeft || left>qRight) return 0;
        if(left>=qLeft && right<=qRight) return T[i];
        int mid = (left+right)/2;
        int leftSum = query(2*i+1,left,mid,qLeft,qRight);
        int rightSum = query(2*i+2,mid+1,right,qLeft,qRight);
        return leftSum+rightSum;
    }
    public static void update(int i,int left,int right,int index,int type) {
        if(left==right) {
            if(type==1) {
                T[i]+=1;
            } else {
                if(T[i]==0) return;
                T[i]-=1;
            }
            return;
        }
        int mid = (left+right)/2;
        if(index<=mid) {
            update(2*i+1,left,mid,index,type);
        } else {
            update(2*i+2,mid+1,right,index,type);
        }
        T[i] = T[2*i+1]+T[2*i+2];
    }
}
