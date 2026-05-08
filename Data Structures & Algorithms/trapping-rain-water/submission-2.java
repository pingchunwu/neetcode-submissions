class Solution {
    public int trap(int[] height) {
        int res = 0;
        int l = 0;
        int r = height.length - 1;
        int maxLeft = 0;
        int maxRight = 0;
        while (r > l) {
            int leftH = height[l];
            int rightH = height[r];
            maxLeft = Math.max(leftH, maxLeft);
            maxRight = Math.max(rightH, maxRight);
            int minLR = Math.min(maxRight, maxLeft);
            if (rightH < leftH) {
                int water = minLR - rightH;
                if (water > 0) {
                    res += water;
                }
                r --;
            } else {
                int water = minLR - leftH;
                if (water > 0) {
                    res += water;
                }
                l ++;
            }
        }

        // int curLeft = 0;
        // int maxLeft = 0;
        // int curRight = 0;
        // int maxRight = 0;
        // int[] left = new int[height.length];
        // int[] right = new int[height.length];
        // for (int i = 0 ; i < height.length; i++) {
        //     int rightIndex=height.length -i-1;
        //     if (i == 0) {
        //         left[i] = curLeft;
        //         right[rightIndex] = curRight; 
        //         continue;
        //     } 
        //     curLeft = height[i-1];
        //     maxLeft = Math.max(curLeft, maxLeft);
        //     left[i] = maxLeft;
            
        //     curRight = height[rightIndex+1];
        //     maxRight = Math.max(curRight, maxRight);
        //     right[rightIndex] = maxRight;
        // }
        // for (int i = 0 ; i < height.length; i ++) {
        //     int minPosition = Math.min(left[i], right[i]);
        //     int h = height[i];
        //     int water = minPosition - h;
        //     if (water > 0) {
        //         res += water;
        //     }
        // }




        return res;
        
    }
}
