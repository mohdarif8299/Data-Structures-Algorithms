class Solution {
    public int bulbSwitch(int n) {
        int pSquares = 0;
        for(int i=1;i*i<=n;i++) pSquares++;
        return pSquares;
    }
}