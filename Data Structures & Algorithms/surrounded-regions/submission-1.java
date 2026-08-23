class Solution {
    public void solve(char[][] board) {
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0 ; i < board.length; i ++) {
            for (int j = 0 ; j < board[0].length; j++) {
                if (board[i][j] == 'O' && 
                    (i == 0 || i == board.length - 1 || j == 0  || j == board[0].length - 1)) {
                    queue.offer(new int[]{i,j});
                }
            }
        }

        int[][] dir = {{1,0},{0,1},{-1,0},{0,-1}};
        boolean[][] visited = new boolean[board.length][board[0].length];
        while (!queue.isEmpty()) {
            int[] q = queue.poll();
            int row = q[0];
            int col = q[1];
            if (visited[row][col]) {
                continue;
            }
            visited[row][col] = true;

            // if (row != 0 && col != 0 && row != board.length -1 && col != board[0].length -1) {
            //     board[row][col] = 'X';
            // }

            for (int[] d: dir) {
                int r = row + d[0];
                int c = col + d[1];

                if (r < 0|| c <0 || r >= board.length -1 || c >= board[0].length -1 ||
                    board[r][c] == 'X') {
                        continue;
                }
                queue.offer(new int[]{r,c});
            }
        }

        for (int i = 0 ; i < board.length; i ++) {
            for (int j = 0 ; j < board[0].length; j++) {
                if (visited[i][j] ) {
                    board[i][j] = 'O';
                } else {
                    board[i][j] = 'X';
                }
            }
        }
    }
}
