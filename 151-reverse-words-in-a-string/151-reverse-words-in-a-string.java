class Solution {
    public String reverseWords(String s) {
        s = s.trim().replaceAll("\\s+", " ");
        char ch[] = s.toCharArray();
        int start = 0;
        for(int i=0;i<ch.length;i++) {
            if(ch[i] == ' ') {
                reverse(start, i-1, ch);
                start = i+1;
            }
        }
        reverse(start, ch.length-1,ch);
        reverse(0, ch.length-1, ch);
        return new String(ch);
    }
    public void reverse(int start , int end, char ch[]) {
        while(start <= end) {
            char temp = ch[start];
            ch[start] = ch[end];
            ch[end] = temp;
            start++;
            end--;
        }
    }
}