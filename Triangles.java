class Solution
{
    //Function to count the number of possible triangles.
    static int findNumberOfTriangles(int arr[], int n)
    {
        int count=0;
        Arrays.sort(arr);
        for(int i=0;i<n-2;i++) {
            int k=i+2;
            for(int j=i+1;j<n-1;j++) {
                while(k<n && arr[i]+arr[j]>arr[k]) k++;
                if(k>j) count+=k-j-1;
            }
        }
        return count;
        // code here
    }
}
