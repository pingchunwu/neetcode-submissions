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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        List<ListNode> list = new ArrayList();
        ListNode res = head;
        while (head != null) {
            list.add(head);
            head = head.next;
        }
        if (list.size() == 1) {
            return null;
        }
        if (n == list.size()) {
            return res.next;
        }
        
        ListNode targetPrev = list.get(list.size()-n - 1);
        if (n == 1) {
            targetPrev.next = null;
            return res;
        }
        targetPrev.next = list.get(list.size()-n +1);
        return res;
    }
}
