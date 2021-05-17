public class Solution {
    public int seats(String A) {
        ArrayList<Integer> allX = new ArrayList<>();
        for(int i=0;i<A.length();i++) {
            if(A.charAt(i)=='x') allX.add(i);
        }
        long distance=0;
        int k=1;
        int mid = allX.size()/2;
        int left = mid-1,right=mid+1;
        while(left>=0) {
            distance+=allX.get(mid)-k-allX.get(left);
            k+=1;
            left--;
        }
        k=1;
        while(right<allX.size()) {
            distance+=allX.get(right)-k-allX.get(mid);
            k+=1;
            right++;
        }
        return (int)(distance%10000003);
    }
}
