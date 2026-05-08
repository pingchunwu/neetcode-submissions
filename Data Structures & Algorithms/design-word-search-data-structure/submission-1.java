class WordDictionary {
    // Node root = new Node();
    Set<String> set = new HashSet();

    public WordDictionary() {

    }

    public void addWord(String word) {
        set.add(word);
    }

    public boolean search(String word) {
        for (String s: set) {
            boolean isMatch = true;
            if (word.length() != s.length()){
                continue;
            }
            for (int i = 0 ; i < s.length(); i ++) {
                char c = s.charAt(i);
                char w = word.charAt(i);
                if (w == '.' || w == c) {
                    continue;
                } else {
                    isMatch = false;
                    break;
                }
            }
            if (isMatch) {
                return true;
            }
        }
        return false;
    }


    // class Node {
    //     Map<Character, Node> kids = new HashMap();
    //     boolean isEnd;
    // }
}
