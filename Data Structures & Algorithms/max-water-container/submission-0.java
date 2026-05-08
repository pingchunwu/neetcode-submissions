class Solution {
    public int maxArea(int[] heights) {
        int l = 0;
        int r = heights.length -1;
        int max = 0;
        while(r>l) {
            int leftBar = heights[l];
            int rightBar = heights[r];
            int dis = r - l;
            int min = Math.min(leftBar,rightBar);
            int water = dis*min;
            max = Math.max(max, water);
            if (rightBar > leftBar) {
                l ++;
            } else {
                r --;
            }
        }
        return max;
    }
}
