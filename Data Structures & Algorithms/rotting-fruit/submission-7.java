class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<List<int[]>> queue = new LinkedList<>();
        List<int[]> list = new ArrayList<>();
        int ones = 0;
        for (int i = 0; i < grid.length; i ++) {
            for (int j = 0 ; j < grid[0].length; j++) {
                if (grid[i][j] == 2) {
                    list.add(new int[]{i, j});
                } else if (grid[i][j] == 1) {
                    ones++;
                }
            }
        }
        queue.offer(list);

        int res = 0;
        while (!queue.isEmpty()) {
            List<int[]> newList = new ArrayList<>();
            List<int[]> l = queue.poll();
            for (int[] cur: l) {
                int row = cur[0];
                int col = cur[1];
                int[][] dir = {{0,1},{1,0},{-1,0},{0,-1}};
                for (int[] d: dir) {
                    int r = cur[0] + d[0];
                    int c = cur[1] + d[1];
                    if (r < 0 || c < 0 || r >= grid.length || c >= grid[0].length) {
                        continue;
                    }
                    if (grid[r][c] == 1) {
                        newList.add(new int[]{r, c});
                        grid[r][c] = 2;
                        ones--;
                    }
                }
            }
            if (newList.size() > 0) {
                queue.offer(newList);
            }
            
            res++;
        }

        return ones == 0? (res - 1): -1;
    }
}

// class Solution {
//     public int orangesRotting(int[][] grid) {
//         Queue<int[]> queue = new LinkedList<>();
//         int fresh = 0;
//         for (int i = 0 ; i < grid.length; i ++) {
//             for (int j = 0 ; j < grid[0].length; j++) {
//                 if (grid[i][j] == 2) {
//                     queue.offer(new int[]{i, j});
//                 }
//                 if (grid[i][j] == 1) {
//                     fresh++;
//                 }
//             }
//         }
//         int min = 0;
//         int[][] dir = {{0,1},{1,0},{-1,0},{0,-1}};
//         while (fresh > 0 && !queue.isEmpty()) {
//             int len = queue.size();
//             for (int i = 0 ; i < len; i ++) {
//                 int[] q = queue.poll();
//                 int row = q[0];
//                 int col = q[1];

//                 for (int[] d: dir) {
//                     int r = row + d[0];
//                     int c = col + d[1];

//                     if (r < 0 || c < 0 || r > grid.length -1 || c > grid[0].length - 1 ||
//                         grid[r][c] == 0 || grid[r][c] == 2) {
//                         continue;
//                     }

//                     grid[r][c] = 2;
//                     queue.offer(new int[]{r,c});
//                     fresh--;
//                 }
//             }
//             min++;
//         }

//         return fresh == 0 ? min: -1;
//     }
// }
