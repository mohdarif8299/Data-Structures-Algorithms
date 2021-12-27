class Solution {
    public int findComplement(int num) {
     StringBuilder sb = new StringBuilder("");
     StringBuilder binaryString = new StringBuilder("");
     while(num > 0) {
         int binary = num%2;
         sb.append(binary);
         num /=2;
     }
        sb.reverse();
     for(int i=0;i<sb.length();i++) {
         int toggled = toggle(sb.charAt(i));
         binaryString.append(toggled);
     }
     return Integer.parseInt(binaryString.toString(), 2);
    }
    public static int toggle(char ch) {
        return 1 - Integer.parseInt(ch+"");
    } 
}