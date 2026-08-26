class Solution {
    public int maxArea(int[] heights) {
        int max = 0;
        int l = 0 ; 
        int r = heights.length -1;

        while (r > l) {
            max = Math.max(Math.min(heights[l], heights[r]) * (r - l), max);
            if (heights[l] > heights[r]) {
                r--;
            } else {
                l++;
            }
        }
        return max;
    }
}
