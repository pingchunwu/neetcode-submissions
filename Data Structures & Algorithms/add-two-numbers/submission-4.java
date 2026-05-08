/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode n1 = l1;
        ListNode n2 = l2;
        ListNode res = new ListNode(0);
        ListNode cur = res;
        int total1 = 0;
        int total2 = 0;
        
        int mult = 1;
        while(l1 != null) {
            total1 += l1.val * mult;
            l1 = l1.next;
            mult *= 10;
        }
        mult = 1;
         while(l2 != null) {
            total2 += l2.val * mult;
            l2 = l2.next;
            mult *= 10;
        }
        int total = total1+ total2;

        while (total > 9) {
            int divide = total % 10;
            cur.next = new ListNode(divide);
            cur = cur.next;
            total /= 10;
        }
        cur.next = new ListNode(total);

        return res.next;
    }
}
