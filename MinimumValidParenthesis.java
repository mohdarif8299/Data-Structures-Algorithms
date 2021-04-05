class Solution {
    public int minAddToMakeValid(String S) {
    Stack<Character> stack = new Stack<>();
        for(int i=0;i<S.length();i++) {
            if(S.charAt(i)=='(') {
                stack.push(S.charAt(i));
            }
            else {
                if(!stack.isEmpty() && stack.peek()=='(') {
                    stack.pop();
                }
                else {
                    stack.push(S.charAt(i));
                }
            }
        }
        return stack.size();
    }
}
