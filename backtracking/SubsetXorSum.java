class Solution {
    public int subsetXORSum(int[] nums) {
        return print(0,nums,0);
    }
    public static int print(int index,int[] A,int xor) {
         if(index==A.length) return xor;
         xor = xor^A[index];
         int xor1 = print(index+1,A,xor);
         int xor2 = print(index+1,A,A[index]^xor);
         return xor1+xor2;
    }
}
