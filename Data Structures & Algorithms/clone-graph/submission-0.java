/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    Map<Node, Node> map = new HashMap();

    public Node cloneGraph(Node node) {
        return newNode(node);
    }

    private Node newNode(Node node) {
        if (map.containsKey(node)) {
            return map.get(node);
        }
        if (node == null) {
            return null;
        }
        Node newNode = new Node(node.val);
        map.put(node, newNode);

        for (Node n: node.neighbors) {
            newNode.neighbors.add(newNode(n));
        }
        return newNode;
    }
}

// class Solution {
//     public Node cloneGraph(Node node) {
//         if (node == null) {
//             return null;
//         }
//         return dfs(node);
//     }

//     Map<Node, Node> map = new HashMap();

//     private Node dfs(Node node) {
//         if (map.containsKey(node)) {
//             return map.get(node);
//         }

//         Node newNode = new Node(node.val);
//         map.put(node, newNode);

//         for (Node n: node.neighbors) {
//             newNode.neighbors.add(dfs(n));
//         }

//         return newNode;
//     }
// }