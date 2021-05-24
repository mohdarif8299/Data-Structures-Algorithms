class Solution
{
    //Function to rotate an array by d elements in counter-clockwise direction. 
    static void rotateArr(int A[], int d, int n)
    {
        reverseArray(A,0,d-1);
        reverseArray(A,d,n-1);
        reverseArray(A,0,n-1);
        // add your code here
    }
    static void reverseArray(int A[],int low,int high) {
        while(low<high) {
            int temp = A[low];
            A[low] = A[high];
            A[high] = temp;
            low++;
            high--;
        }
    }
}
