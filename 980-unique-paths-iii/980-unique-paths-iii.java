class Solution {
   
    public int uniquePathsIII(int[][] grid) {
        int startI = 0;
        int startJ = 0;
        int zero = 0;
        for(int i=0;i<grid.length;i++) {
            for(int j=0;j<grid[i].length;j++) {
                if(grid[i][j] == 1) {
                    startI = i;
                    startJ = j;
                } else if(grid[i][j] == 0) zero++;
            }
        }
        
        return uniquePathsIII(startI, startJ, grid, zero);
    }
    public int uniquePathsIII(int i, int j, int grid[][], int zero) {
        if( i<0 || i>=grid.length || j<0 || j>=grid[i].length || grid[i][j] == -1) return 0;
        if(grid[i][j] == 2) {
            if(zero == 0)
            return 1;
            return 0;
        }
        
        if(grid[i][j] == 0) zero--;
        grid[i][j] = -1;
        int count = 0; 
        count += uniquePathsIII(i,j+1, grid, zero);
        count += uniquePathsIII(i-1,j, grid, zero);
        count += uniquePathsIII(i+1,j, grid, zero);
        count += uniquePathsIII(i,j-1, grid, zero);
        grid[i][j] = 0;
      
        return count;
    }
}