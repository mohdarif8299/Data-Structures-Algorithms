class Solution
{
 
    // arr: input array
    // n: size of array
    //Function to rearrange an array so that arr[i] becomes arr[arr[i]]
    //with O(1) extra space.
    static void arrange(long A[], int n)
    {
        for(int i=0;i<n;i++) {
            A[i]+=(A[(int)A[i]]%n)*n;
        }
        for(int i=0;i<n;i++) A[i] = A[i]/n;
        // your code here
    }
}
