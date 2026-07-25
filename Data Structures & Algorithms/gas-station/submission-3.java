class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        if (gas.length == 1) {
            return gas[0] - cost[0] >= 0 ? 0 : -1;
        }
        int totalCost = 0;
        int[] balance = new int[gas.length];

        for (int i = 0 ; i < gas.length; i++) {
            balance[i] = gas[i] - cost[i];
            totalCost += balance[i];
        }

        if (totalCost < 0) {
            return -1;
        }

        for (int i = 0 ; i < gas.length; i++) {
            if (balance[i] > 0) {
                int cur = balance[i];
                int index = i + 1;
                int path = 1;
                while (path < gas.length) {
                    if (index == gas.length) {
                        index = 0;
                    }
                    cur += gas[index] - cost[index];

                    if (cur < 0) {
                        break;
                    }

                    path++;
                    index++;
                }

                if (path == gas.length) {
                    return i;
                }
            }

        }
        return -1;
    }
}
