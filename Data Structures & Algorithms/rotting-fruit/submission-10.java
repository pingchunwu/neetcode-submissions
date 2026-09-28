class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> queue = new LinkedList<>();
        int fresh = 0;
        for (int i = 0 ; i < grid.length; i ++) {
            for (int j = 0 ; j < grid[0].length; j++) {
                if (grid[i][j] == 2) {
                    queue.offer(new int[]{i, j});
                }
                if (grid[i][j] == 1) {
                    fresh++;
                }
            }
        }
        int min = 0;
        int[][] dir = {{0,1},{1,0},{-1,0},{0,-1}};
        while (fresh > 0 && !queue.isEmpty()) {
            int len = queue.size();
            for (int i = 0 ; i < len; i ++) {
                int[] q = queue.poll();
                int row = q[0];
                int col = q[1];

                for (int[] d: dir) {
                    int r = row + d[0];
                    int c = col + d[1];

                    if (r < 0 || c < 0 || r > grid.length -1 || c > grid[0].length - 1 ||
                        grid[r][c] == 0 || grid[r][c] == 2) {
                        continue;
                    }

                    grid[r][c] = 2;
                    queue.offer(new int[]{r,c});
                    fresh--;
                }
            }
            min++;
        }

        return fresh == 0 ? min: -1;
    }
}
