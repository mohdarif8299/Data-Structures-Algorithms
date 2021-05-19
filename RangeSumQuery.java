class NumArray {

    public static int T[];
    public static int A[];
    public NumArray(int[] A) {
        this.A = A; 
        this.T = build(0,0,A.length-1,A,new int[4*A.length-1]);
    }
    public static int[] build(int i,int left,int right,int A[],int T[]) {
        if(left==right) {
            T[i] = A[left];
            return T;
        }
        int mid = (left+right)/2;
        build(2*i+1,left,mid,A,T);
        build(2*i+2,mid+1,right,A,T);
        T[i] = T[2*i+1]+T[2*i+2];
        return T;
    }
    public void update(int index, int val) {
        update(0,0,A.length-1,index,val,T);
    }
    public static int query(int i,int left,int right,int qLeft,int qRight,int T[]) {
        if(right<qLeft || left>qRight) return 0;
        else if(left>=qLeft && right<=qRight) return T[i];
        else {
            int mid = (left+right)/2;
            int leftSum = query(2*i+1,left,mid,qLeft,qRight,T);
            int rightSum = query(2*i+2,mid+1,right,qLeft,qRight,T);
            return leftSum+rightSum;
        }
    }
    public int sumRange(int left, int right) {
        return query(0,0,A.length-1,left,right,T);
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
        T[i] = T[2*i+1]+T[2*i+2];
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */
