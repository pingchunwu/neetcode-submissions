class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        for (int i = 0 ; i < matrix.length; i++) {
            int lastIndex = matrix[i].length - 1;
            if (target > matrix[i][lastIndex]) {
                continue;
            } else {
                for (int j = 0 ; j <= lastIndex; j++) {
                    if (matrix[i][j] == target) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
