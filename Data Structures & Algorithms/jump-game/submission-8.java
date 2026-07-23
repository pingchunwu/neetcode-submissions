// class Solution {
//     Map<Integer, Boolean> map = new HashMap();
//     public boolean canJump(int[] nums) {
//         return jump(nums, 0);
//     }

//     private boolean jump(int[] nums, int idx) {
//         if (nums[idx] + idx >= nums.length -1) {
//             return true;
//         }
//         int end = Math.min(nums[idx] + idx, nums.length -1);
//         for (int i = idx + 1 ; i <= end; i ++) {
//             if (jump(nums, i)){
//                 return true;
//             }
//         }
//         return false;
//     }
// }
class Solution { // from video
    public boolean canJump(int[] nums) {
        int goal = nums.length - 1;
        for (int i = nums.length - 1 ; i >= 0 ; i --) {
            if (i + nums[i] >= goal) {
                goal = i;
            }
        }
        return goal == 0;
    }
}
// class Solution {
//     public boolean canJump(int[] nums) {
//         int jump = nums[0];
//         return jump(nums, 0, jump);
//     }

//     private boolean jump(int[] nums, int l, int r) {
//         if (r >= nums.length - 1) {
//             return true;
//         }
//         for (int i = l+1; i <= r; i ++) {
//             int jump = nums[i];
//             if (i + jump >= nums.length - 1) {
//                 return true;
//             }
//             if (jump == 0) {
//                 continue;
//             }
//             if(jump(nums, i, i + jump)) {
//                 return true;
//             }
//         }
//         return false;
//     }
// }
