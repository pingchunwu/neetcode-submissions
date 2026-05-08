class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int f = 0;
        int b = numbers.length -1;
        while (f < b) {
            if (numbers[f] + numbers[b] > target) {
                b --;
            } else if (numbers[f] + numbers[b] < target) {
                f ++;
            } else {
                return new int[]{f + 1, b + 1};
            }
        }
        return new int[2];
        // Map<Integer, Integer> map = new HashMap();
        // for (int i  = 0 ; i < numbers.length; i++) {
        //     map.put(numbers[i], i);
        // }

        // for (int i  = 0 ; i < numbers.length; i++) {
        //     Integer left = map.get(target - numbers[i]);
        //     if (left != null) {
        //         return new int[]{i + 1, left + 1};
        //     }
        // }
        // return new int[2];
    }
}
