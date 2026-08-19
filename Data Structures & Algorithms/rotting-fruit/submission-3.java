class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0 ; i < grid.length; i ++) {
            for (int j = 0 ; j < grid[0].length; j++) {
                if (grid[i][j] == 2) {
                    queue.offer(new int[]{i, j});
                }
            }
        }
        int min = 0;
        int[][] dir = {{0,1},{1,0},{-1,0},{0,-1}};
        // Set<int[]> set = new HashSet();
        while (!queue.isEmpty()) {
            int[] q = queue.poll();
            int row = q[0];
            int col = q[1];

            for (int[] d: dir) {
                int r = row + d[0];
                int c = col + d[1];

                if (r < 0 || c < 0 || r > grid.length -1 || c > grid[0].length - 1 ||
                    grid[r][c] == 0 || grid[r][c] >= 2) {
                    continue;
                }

                grid[r][c] = grid[row][col] + 1;
                min = grid[r][c];
                queue.offer(new int[]{r,c});
                // set.add(new int[]{r,c});
            }
        }
        int zero = 0;
        for (int i = 0 ; i < grid.length; i ++) {
            for (int j = 0 ; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    return -1;
                }
                if (grid[i][j] == 2 && min == 0) {
                    return 0;
                }
                if (grid[i][j] == 0) {
                    zero++;
                }
            }
        }

        if (zero == grid.length * grid[0].length) {
            return 0;
        }

        return min == 0 ? -1 : min-2;
    }
}
