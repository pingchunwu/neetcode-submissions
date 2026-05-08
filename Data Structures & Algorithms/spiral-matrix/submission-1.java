class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int l = 0 ; 
        int r = matrix[0].length - 1;
        int t = 0;
        int b = matrix.length - 1;
        List<Integer> res = new ArrayList();
        int total = matrix[0].length * matrix.length;
        int direction = 0;
        int x = 0;
        int y = 0;

        while (res.size() != total) {
            res.add(matrix[y][x]);
            switch(direction) {
                case 0:  // right
                    if (x + 1 <= r) {
                        x++;
                    } else {
                        direction = 1;
                        y ++;
                        t++;
                    }
                    break;
                case 1: // down
                    if (y+1 <= b) {
                        y++;
                    } else {
                        direction = 2;
                        x--;
                        r--;
                    }
                    break;
                case 2: // left
                    if (x-1 >= l) {
                        x --;
                    } else {
                        direction = 3;
                        y--;
                        b--;
                    }
                    break;
                case 3: // up
                    if (y-1 >= t) {
                        y--;
                    } else {
                        direction = 0;
                        x++;
                        l++;
                    }
                    break;
            }
            

        }
        return res;
    }
}
