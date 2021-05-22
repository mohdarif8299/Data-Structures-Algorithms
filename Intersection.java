class Solution{
    //Function to return the count of the number of elements in
    //the intersection of two arrays.
    public static int NumberofElementsInIntersection(int a[],int b[],int n,int m)
    {
        int count=0;
        
        HashSet<Integer> arr = new HashSet<>();
        for(int i=0;i<a.length;i++) arr.add(a[i]);
        for(int i=0;i<b.length;i++) if(arr.contains(b[i])) {
            arr.remove(b[i]);
            count+=1;
        }
        return count;
    }
};
