class Solution {
    public void rotate(int[][] matrix) {
        for (int i = 0 ; i < matrix.length/2; i ++) {
            for (int col = i ;col < matrix.length-1-i; col ++) {
                int tem1 = matrix[i][col];
                matrix[i][col] = matrix[matrix.length -1 - col][i];
                int tem2 = matrix[col][matrix[0].length-1-i];
                matrix[col][matrix[0].length-1-i] = tem1;
                tem1 = matrix[matrix[0].length-1 -i][matrix[0].length-1-col];
                matrix[matrix[0].length-1 -i][matrix[0].length-1-col] = tem2;
                matrix[matrix.length -1 - col][i] = tem1;
            }
        }
    }
}
