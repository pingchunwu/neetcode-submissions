class Solution {
    public void setZeroes(int[][] matrix) {
        Set<int[]> set = new HashSet();
        for (int i = 0 ; i < matrix.length; i ++) {
            for (int j = 0 ; j < matrix[i].length; j ++) {
                if (matrix[i][j] == 0) {
                    set.add(new int[]{i, j});
                }
                
            }
        }
        for (int[] arr: set) {
            int i = arr[0];
            int j = arr[1];
            
            for (int k = 0 ; k < matrix.length; k ++) {
                matrix[k][j] = 0;
            }

            for (int k = 0 ; k < matrix[i].length; k ++) {
                matrix[i][k] = 0;
            }
        }
        
    }
}
