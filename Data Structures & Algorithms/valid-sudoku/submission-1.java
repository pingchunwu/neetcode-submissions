class Solution {
    public boolean isValidSudoku(char[][] board) {
        Map<Integer, Set<Character>> rows = new HashMap();
        Map<Integer, Set<Character>> cols = new HashMap();
        Map<String, Set<Character>> squares = new HashMap();
        for (int r = 0 ; r < 9; r ++) {
            for (int c = 0 ; c < 9; c ++) {
                char character = board[r][c];
                if (character == '.') {
                    continue;
                }
                String key = r/3 + " " + c/3;
                if (rows.computeIfAbsent(r, k -> new HashSet()).contains(character) ||
                    cols.computeIfAbsent(c, k -> new HashSet()).contains(character) ||
                    squares.computeIfAbsent(key, k -> new HashSet()).contains(character)) {
                    return false;
                }
                rows.get(r).add(character);
                cols.get(c).add(character);
                squares.get(key).add(character);
            }
        }
        return true;
    }
}
