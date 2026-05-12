class Solution {
    int ROW;
    int COL;
    Set<Pair<Integer, Integer>> path;
    public boolean exist(char[][] board, String word) {
        ROW = board.length;
        COL = board[0].length;
        path = new HashSet();
        for (int r = 0 ; r < ROW; r++) {
            for (int c = 0 ; c < COL; c++) {
                if (bfs(board, word, r, c, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean bfs(char[][] board, String word, int r, int c, int i) {
        if (r < 0 || r >= ROW || c < 0 || c >= COL || 
            path.contains(new Pair(r, c)) || board[r][c] != word.charAt(i)) {
            return false;
        }

        if (word.length() == i + 1) {
            return true;
        }

        path.add(new Pair(r, c));
        boolean res = bfs(board, word, r+1, c, i + 1) ||
                        bfs(board, word, r-1, c, i + 1) ||
                        bfs(board, word, r, c+1, i + 1) ||
                        bfs(board, word, r, c-1, i + 1);
        path.remove(new Pair(r, c));
        return res;
    }
}
