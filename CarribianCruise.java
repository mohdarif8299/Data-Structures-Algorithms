import java.util.*;
public class CarribianCruise {
    public static void main(String[] args) {
        int B[] = { 1,2,3,1,2,3,6 };
        int A = 2;
        System.out.println(solve(A,B));
    }
    public static int solve(int A,int B[]) {
        SortedMap<Integer,Integer> map = new  TreeMap<>();
        for(int i=0;i<B.length;i++) {
            if(map.containsKey(B[i])) {
                map.put(B[i],map.get(B[i])+1);
            }
            else {
                map.put(B[i],1);
            }
        }
        ArrayList<Integer> aList = new ArrayList<>(map.values());
        Collections.sort(aList,Collections.reverseOrder());
        int low=1,high = B.length;
        int totalLunchBox =1;
        while(low<=high) {
            int mid = (low+high)/2;
            if(binarySearch(aList,mid)>=A) {
              totalLunchBox = mid;
              low = mid+1;
            }
            else {
                high = mid-1;
            }
        }
        return totalLunchBox;
    }
    public static int binarySearch(ArrayList<Integer> list,int mid) {
      int lunchBox = 0;
        for(Integer i:list) {
            lunchBox+=i/mid;
      }
      return lunchBox;
    }
}