class PrefixTree {
    Node root;

    public PrefixTree() {
        root = new Node();
    }

    public void insert(String word) {
        String[] sArr = word.split("");
        Node tem = root;
        for(int i = 0 ; i < sArr.length; i++) {
            String s = sArr[i];
            // System.out.println("insert " + s);
            if (tem.kids.keySet().contains(s)) {
                // System.out.println("if " + s);
                tem = tem.kids.get(s);
            } else {
                while(i < sArr.length) {
                    s = sArr[i];
                    // System.out.println("while " + s);
                    tem.kids.put(s, new Node());
                    tem = tem.kids.get(s);
                    i++;
                }
            }
        }
        tem.isEnd = true;
    }

    public boolean search(String word) {
        String[] sArr = word.split("");
        Node tem = root;
        for(String s: sArr) {
            // System.out.println("search " + s);
            if (tem.kids.keySet().contains(s)) {
                // System.out.println("contains " + s);
                tem = tem.kids.get(s);
            } else {
                // System.out.println("!contains " + s);
                return false;
            }
        }
        // System.out.println("tem.isEnd " + tem.isEnd);
        return tem.isEnd;
    }

    public boolean startsWith(String prefix) {
        String[] sArr = prefix.split("");
        Node tem = root;
        for(String s: sArr) {
            // System.out.println("search " + s);
            if (tem.kids.keySet().contains(s)) {
                // System.out.println("contains " + s);
                tem = tem.kids.get(s);
            } else {
                // System.out.println("!contains " + s);
                return false;
            }
        }
        // System.out.println("tem.isEnd " + tem.isEnd);
        return true;
    }
}

class Node {
    Map<String, Node> kids;
    boolean isEnd;
    public Node() {
        this.kids = new HashMap();
    }
}
