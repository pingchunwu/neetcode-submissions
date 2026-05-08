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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode root = new ListNode(0);
        ListNode cur = root;
        Stack<ListNode> s = new Stack();
        int count = 0;
        
        while (head != null) {
            s.push(head);
            count++;
            head = head.next;
            if (count == k) {
                while (s.size() > 0) {
                    cur.next = s.pop();
                    System.out.println("s.pop() " + cur.next.val);
                    cur = cur.next;
                }
                count = 0;
            }
        }
        while (s.size() > 0) {
            cur.next = s.get(0);
            s.remove(0);
            System.out.println("s.get(0) " + cur.next.val);
            cur = cur.next;
        }
        cur.next = null;

        return root.next;
    }
}
