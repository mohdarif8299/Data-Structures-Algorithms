class Solution {
    public String multiply(String num1, String num2) {
        if(num1.equals("0") || num2.equals("0")) return "0";
        if(num1.equals("1")) return num2;
        if(num2.equals("1")) return num1;
        
        int m = num1.length();
        int n = num2.length();
        int ans[] = new int[m + n];
        for(int i=m-1;i>=0;i--) {
            for(int j=n-1;j>=0 ;j--) {
                int mul =  (num1.charAt(i) - '0' ) * (num2.charAt(j) - '0');
                
                mul += ans[i+j+1];
                ans[i+j+1] = mul%10;
                ans[i+j] += mul/10;
            }
        }
        StringBuilder sb = new StringBuilder("");
        for(int i=0;i<ans.length;i++) {
            if(sb.length() ==0 && ans[i] == 0) continue;
            sb.append(ans[i]);
        }
        return sb.toString();
    }
}