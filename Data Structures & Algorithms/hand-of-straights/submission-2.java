class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if (hand.length % groupSize != 0) {
            return false;
        }

        Arrays.sort(hand);
        boolean[] isUsed = new boolean[hand.length];
        int left = hand.length;
        for (int i = 0 ; i < hand.length ; i++) {
            int pointer = i;
            int space = groupSize;
            int cur = -1;
            if (isUsed[pointer]) {
                pointer ++;
                continue;
            }
            while (pointer < hand.length) {
                if (isUsed[pointer]) {
                    pointer ++;
                    continue;
                }
                if (space == groupSize) {
                    isUsed[pointer] = true;
                    cur = hand[pointer];
                    space--;
                    left--;
                } else {
                    if (cur + 1 == hand[pointer]) {
                        isUsed[pointer] = true;
                        cur = hand[pointer];
                        space--;
                        left--;
                    }
                }
                if (space == 0) {
                    break;
                }
                pointer ++;
            }
            if (space != 0) {
                return false;
            }
            
        }
        
        return left == 0;
    }
}
