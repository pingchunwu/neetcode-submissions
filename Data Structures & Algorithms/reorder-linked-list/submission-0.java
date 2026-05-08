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
    public void reorderList(ListNode head) {
        List<ListNode> list = new ArrayList();
        ListNode root = head;
        ListNode cur = root;
        while(head != null) {
            list.add(head);
            head = head.next;
        }
        while(list.size() > 1) {
            cur.next = list.remove(list.size() -1);
            System.out.println(cur.next.val);
            cur = cur.next;
            if (list.size() > 1) {
                cur.next = list.remove(1);
                System.out.println(cur.next.val);
                cur = cur.next;
            }
        }
        cur.next = null;
    }
}
