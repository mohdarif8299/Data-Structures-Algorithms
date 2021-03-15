public class FoodDistribution {
    public static void main(String[] args) {
        int A[] = {1,1,1};
        int B = 4;
        System.out.println(solve(A,B));
    }
    public static int solve(int A[],int B) {
        long sum = 0;
        int minElement = A[0];
        for(int i=0;i<A.length;i++) {
            sum+=A[i];
            minElement = Math.min(minElement,A[i]);
        }
        if(B>sum) return 0;
        int ans = 0;
        int low =1,high = minElement;
        while(low<=high) {
            int mid = (low+high)/2;
            if(checkPopulation(A,mid,B)) {
                ans = mid;
                low = mid+1;
            }
            else {
                high = mid-1;
            }

        }
        return ans;
    }
    public static boolean checkPopulation(int A[],int mid,int B)  {
        long totalOffices  = 0;
        for(int i=0;i<A.length;i++) {
            totalOffices+=(A[i]/mid);
        }
        return totalOffices>=B?true:false;
    }
}