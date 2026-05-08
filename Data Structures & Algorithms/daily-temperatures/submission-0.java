class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int [] res = new int[temperatures.length];
        for (int i = 0 ; i < temperatures.length; i++){
            int next = i + 1;
            while (next < temperatures.length) {
                if (temperatures[next] > temperatures[i]) {
                    res[i] = next - i;
                    break;
                }
                next ++;
            }
        }
        return res;
    }
}
