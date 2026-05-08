/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Map<Node, Node> map = new HashMap();
        Node cur = head;
        while(head != null) {
            Node newNode = new Node(head.val);
            map.put(head, newNode);
            head = head.next;
        }

        head = cur;
        while(head!=null) {
            Node newNode = map.get(head);
            newNode.next = map.get(head.next);
            newNode.random = map.get(head.random);
            head = head.next;
        }
        return map.get(cur);
    }
}
