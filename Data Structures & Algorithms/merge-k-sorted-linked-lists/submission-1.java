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
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0 || lists == null) {
            return null;
        }
        List<ListNode> arrayList = new ArrayList();
        for (ListNode list: lists) {
            while(list != null) {
                arrayList.add(list);
                list = list.next;
            }
        }
        arrayList.sort(Comparator.comparingInt(node -> node.val));
        ListNode node = new ListNode(0);
        ListNode res = node;
        for (ListNode n: arrayList) {
            node.next = n;
            node = node.next;
        }
        node.next = null;
        return res.next;
    }
}
