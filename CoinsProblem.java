public class Solution {
    public int solve(int A) {
      ArrayList<Long> coins = new ArrayList<>();
      coins.add(1L);
      int totalCoins=0;
      long num=1;
      int i=1;
      while(num<=Integer.MAX_VALUE) {
          num = coins.get(i-1)*5L;
          coins.add(num);
          i++;
      }
      long temp=A;
      while(temp!=0) {
          temp = temp-binarySearch(coins,temp);
          totalCoins++;
      }
      return totalCoins;
    }
    public static long binarySearch(ArrayList<Long> coins,long num) {
      int low=0,high=coins.size()-1;
      long upper = 1;
      while(low<=high) {
          int mid = (low+high)/2;
          if(coins.get(mid)<=num) {
              upper = coins.get(mid);
              low = mid+1;
          } else {
              high = mid-1;
          }
      }
      return upper;
    }
}
