public class Solution {
    /**
     * @param str: the string
     * @return: the number of substrings 
     */
    public int stringCount(String str) {
       int count=0;
       int ans = 0;
       for(int i=0;i<str.length();i++) {
          // if(str.charAt(i)=='0') {
               while(i<str.length() && str.charAt(i)=='0') {
                   // System.out.println("Foun...");
                   i++;
                   count++;
               }
           //}
           ans= ans+ ((count*(count+1))/2);
           count=0;
       }
       return ans;
    }
}
