public class Solution {
    private static int[] T;
      private static int prime[] = new int[1000001];
    public int[] solve(int[] A, String[] B, int[] C, int[] D) {
       ArrayList<Integer> list = new ArrayList<>();
       sieve();
       T = new int[4*A.length];
       for(int i=0;i<A.length;i++) {
           if(prime[A[i]]==1) A[i]=1; else A[i]=0;
       }
       build(0,0,A.length-1,A);
       for(int i=0;i<B.length;i++) {
           if(B[i].equals("A")) {
               list.add(query(0,0,A.length-1,C[i]-1,D[i]-1));
           } else {
               update(0,0,A.length-1,C[i]-1,prime[D[i]]);
           }
       }
       int ans[] = new int[list.size()];
       for(int i=0;i<ans.length;i++) ans[i] = list.get(i);
       return ans;
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
    public static int query(int i,int left,int right,int qLeft,int qRight) {
        if(right<qLeft || left>qRight) return 0;
        else if(left>=qLeft && right<=qRight) return T[i];
        else {
            int mid = (left+right)/2;
            int leftSum = query(2*i+1,left,mid,qLeft,qRight);
            int rightSum = query(2*i+2,mid+1,right,qLeft,qRight);
            return leftSum+rightSum;
        }
    }
     public static void update(int i,int left,int right,int index,int val) {
        if(index>right || index<left) return ;
        if(index==left && index==right){ 
            T[i]=val; 
            return;
        }
        int mid = (left+right)/2;
        update(2*i+1,left,mid,index,val);
        update(2*i+2,mid+1,right,index,val);
        T[i] = T[2*i+1]+T[2*i+2];
    }
    public static void sieve() {
      
        Arrays.fill(prime,1);
        prime[0]=0;
        prime[1]=0;
        for(int i=2;i*i<prime.length;i++) {
            for(int j=i*i;j<prime.length;j+=i) {
                if(prime[j]==1) {
                    prime[j] = 0;
                }
            }
        }
    }
}
