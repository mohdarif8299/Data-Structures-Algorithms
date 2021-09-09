class Solution{
    static long minTime(int[] arr,int n,int k){
        long totalSum = 0;
        long maxElement = arr[0];
        for(int i=0;i<n;i++) {
            totalSum+=arr[i];
            maxElement = Math.max(maxElement,arr[i]);
        }
        return minimumTime(arr,maxElement,totalSum,k);
    }
    public static long minimumTime(int arr[],long low,long high,int painters) {
        long ans = low;
        while(low<=high) {
            long mid = (low+high)/2;
            if(checkPaintingTime(arr,mid,painters)) {
                ans = mid;
                high = mid-1;
            } else {
                low = mid+1;
            }
        }
        return ans;
    }
    public static boolean checkPaintingTime(int arr[],long mid,int painter) {
        int painter_intitial = 1;
        int recently_painted = arr[0];
        for(int i=1;i<arr.length;i++) {
            recently_painted += arr[i];
            if(recently_painted>mid) {
                painter_intitial++;
                recently_painted = arr[i];
            }
        }
        return painter_intitial<=painter;
    }
}
