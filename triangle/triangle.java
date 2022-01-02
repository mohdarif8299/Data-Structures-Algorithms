class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int dp[][] = new int[triangle.size() + 1][];
        for(int i = 0; i<=triangle.size();i++) {
            dp[i] = new int[i+1];
            for(int j = 0; j<=i;j++) {
                dp[i][j] = -1;
            }
        }
        return minimumTri(0, 0, triangle, dp);
    }
    public static int minimumTri(int row, int index, List<List<Integer>> triangle, int dp[][]) {
        if(row>=triangle.size()) return 0;
        if(dp[row][index] == -1) {
            dp[row][index] = triangle.get(row).get(index) +  Math.min(minimumTri(row+1, index+1, triangle, dp), minimumTri(row+1, index, triangle, dp));
        }
        return dp[row][index];
    }
}