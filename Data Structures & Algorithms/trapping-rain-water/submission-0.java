class Solution {
    public int trap(int[] height) {
        int res = 0;
        int curLeft = 0;
        int maxLeft = 0;
        int curRight = 0;
        int maxRight = 0;
        int[] left = new int[height.length];
        int[] right = new int[height.length];
        for (int i = 0 ; i < height.length; i++) {
            int rightIndex=height.length -i-1;
            if (i == 0) {
                left[i] = curLeft;
                right[rightIndex] = curRight; 
                continue;
            } 
            curLeft = height[i-1];
            maxLeft = Math.max(curLeft, maxLeft);
            left[i] = maxLeft;
            
            curRight = height[rightIndex+1];
            maxRight = Math.max(curRight, maxRight);
            right[rightIndex] = maxRight;
        }
        for (int i = 0 ; i < height.length; i ++) {
            int minPosition = Math.min(left[i], right[i]);
            int h = height[i];
            int water = minPosition - h;
            if (water > 0) {
                res += water;
            }
        }




        return res;
        
    }
}
