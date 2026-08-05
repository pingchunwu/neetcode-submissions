class Solution {
    public int numIslands(char[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int res = 0;

        for (int r = 0 ; r < row; r ++) {
            for (int c = 0; c < col ; c++) {
                if (grid[r][c] == '1') {
                    res++;
                    dfs(grid, r, c);
                }
            }
        }
        return res;
    }

    private void dfs(char[][] grid, int r, int c) {
        int[][] dir = {{0,1}, {1,0}, {0,-1}, {-1,0}};
        
        if (r < 0 || c < 0 || r > grid.length -1 || c > grid[0].length -1 ||
            grid[r][c] == '0') {
            return;
        }
        grid[r][c] = '0';
        for (int[] d: dir) {
            dfs(grid, r + d[0], c + d[1]);
        }
    }
}
