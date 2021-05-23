class Solution
{
     long floorSqrt(long x)
	 {
	     long root =1;
	     long low = 1,high=x/2;
	     while(low<=high) {
	         long mid = (low+high)/2;
	         if(mid*mid<=x) {
	             root = mid;
	             low = mid+1;
	         } else {
	             high = mid-1;
	         }
	     }
	     return root;
		// Your code here
	 }
}
