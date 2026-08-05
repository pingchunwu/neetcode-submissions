class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int max = 0;

        for (int r = 0; r < row; r++) {
            for (int c = 0 ; c < col; c++) {
                if (grid[r][c] == 1) {
                    max = Math.max(max, dfs(grid, r, c, 0));
                }
            }
        }
        return max;
    }
    String indent = " ";
    private int dfs(int[][] grid, int row, int col, int acc) {
        int[][] dir = {{0,1}, {1,0}, {0,-1}, {-1,0}};

        if (row < 0 || row > grid.length -1 || 
            col < 0 || col > grid[0].length -1 || 
            grid[row][col] == 0) {
                return acc;
        }

        if (grid[row][col] == 1) {
            acc++;
        }

        grid[row][col] = 0;
        for (int[] d: dir) {
            if (row + d[0] < 0 || row + d[0] > grid.length - 1 ||
                col + d[1] < 0 || col + d[1] > grid[0].length - 1) {
                    continue;
            }
            if (grid[row + d[0]][col + d[1]] == 1) {
                
                acc = dfs(grid, row + d[0], col + d[1], acc);
            }
        }
        return acc;
    }
}
