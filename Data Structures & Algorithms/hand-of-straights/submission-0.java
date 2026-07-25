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
                System.out.println(" out pointer used " + pointer);
                pointer ++;
                continue;
            }
            System.out.println("pointer " + pointer);
            while (pointer < hand.length) {
                System.out.println(" pointer " + pointer + " cur " + cur);
                if (isUsed[pointer]) {
                    System.out.println(" in pointer used " + pointer);
                    pointer ++;
                    continue;
                }
                System.out.println("space " + space);
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
                    System.out.println("space == 0");
                    for (int h: hand) {
                        System.out.print(" " + h);
                    }
                    System.out.println(" ");
                    for (boolean b: isUsed) {
                        System.out.print(" " + b);
                    }
                    System.out.println(" ");
                    break;
                }
                pointer ++;
            }
            if (space != 0) {
                System.out.println("space != 0");
                return false;
            }
            
        }
        
        return left == 0;
    }
}
