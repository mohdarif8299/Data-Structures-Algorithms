class Solution {
    int remove_duplicate(int A[],int N){
        int x=A[0];
        int p=0;
        int size=1;
        for(int i=1;i<N;i++) {
            if(x==A[i]) {
                continue;
            } else {
                size++;
                p++;
                x = A[i];
                // swapping
                int temp = A[i];
                A[i] = A[p];
                A[p] = temp;
            }
        }
        return size;
    }
}
