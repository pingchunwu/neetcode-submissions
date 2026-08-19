class Solution {
    public void islandsAndTreasure(int[][] grid) {
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0 ; i < grid.length; i ++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0) {
                    queue.offer(new int[]{i,j});
                }
            }
        }

        int[][] dir = {{1,0},{0,1},{-1,0},{0,-1}};

        while (!queue.isEmpty()) {
            int[] q = queue.poll();
            int row = q[0];
            int col = q[1];

            for (int[] d : dir) {
                int r = row + d[0];
                int c = col + d[1];
                if (r < 0 || c < 0 || r > grid.length -1 || c > grid[0].length - 1 || 
                    grid[r][c] != Integer.MAX_VALUE) {
                    continue;
                }
                grid[r][c] = grid[row][col] + 1;
                queue.offer(new int[]{r,c});
            }
        }

    }
}
