public class Solution {
	public ArrayList<ArrayList<String>> partition(String a) {
	    ArrayList<ArrayList<String>> ans = partition(0,a,new ArrayList<>(),new ArrayList<>());
	    return ans;
	}
	public static ArrayList<ArrayList<String>> partition(int start,String s,ArrayList<String> temp,ArrayList<ArrayList<String>> ans) {
        if(start==s.length()) {
            ans.add(temp);
            return ans;
        }
        for(int end = start;end<s.length();end++) {
            if(isPalindrome(s,start,end)) {
                temp.add(s.substring(start,end+1));
                partition(end+1,s,new ArrayList<>(temp),ans);
                temp.remove(temp.size()-1);
            }
        }
        return ans;
    }
    public static boolean isPalindrome(String s,int start,int end) {
        int p1=start;
        int p2=end;
        while(p1<p2) {
            if(s.charAt(p1)!=s.charAt(p2)) return false;
            p1++;
            p2--;
        }
        return true;
    }
}
