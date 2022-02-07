class Solution {
    public int numIslands(char[][] grid) {
        int islands = 0;
        for(int i=0;i<grid.length;i++) {
            for(int j=0;j<grid[i].length;j++) {
                if(grid[i][j] == '1')  {
                    bfs(i, j, grid);
                    islands++;
                }
            }
        } 
        return islands;
    }
    public void bfs(int i, int j, char grid[][]) {
        if(i < 0 ||  i >= grid.length || j >= grid[i].length || j<0 || grid[i][j] != '1') return;
        grid[i][j] = 'x';
        bfs(i, j+1, grid);
        bfs(i+1, j, grid);
        bfs(i,j-1, grid);
        bfs(i-1, j, grid);
    }
}