class Solution {
    Map<Integer, Integer> map = new HashMap<>();
    public int coinChange(int[] coins, int amount) {
        int min = dfs(coins, amount);
        return min == Integer.MAX_VALUE? -1: min;
    }

    private int dfs(int[] coins, int amount) {
        if (amount <= 0) {
            return 0;
        }
        if (map.containsKey(amount)) {
            return map.get(amount);
        }

        int result = Integer.MAX_VALUE;
        for (int i = 0 ; i < coins.length; i++) {
            if (amount - coins[i] >= 0) {
                int res = dfs(coins, amount - coins[i]);
                if (res != Integer.MAX_VALUE) {
                    result = Math.min(result, res + 1);
                }
            }
        }
        map.put(amount, result);
        return result;
    }

}

// class Solution {
//     Map<Integer, Integer> map = new HashMap<>();
//     public int coinChange(int[] coins, int amount) {
//         int min = dfs(coins, amount);
//         return min == Integer.MAX_VALUE? -1: min;
//     }

//     private int dfs(int[] coins, int amount) {
//         if (amount == 0) {
//             return 0;
//         }
//         if (map.containsKey(amount)) {
//             return map.get(amount);
//         }

//         int res = Integer.MAX_VALUE;
//         for (int i = 0 ; i < coins.length; i++) {
//             if (amount - coins[i] >= 0) {
//                 int result = dfs(coins, amount - coins[i]);
//                 if (result != Integer.MAX_VALUE) {
//                     res = Math.min(result + 1, res);
//                 }
//             }

//         }

//         map.put(amount, res);
//         return res;
//     }
// }
