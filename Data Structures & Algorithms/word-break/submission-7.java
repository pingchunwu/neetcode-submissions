class Solution {
    Map<Integer,Boolean> map = new HashMap<>();
    public boolean wordBreak(String s, List<String> wordDict) {
        return dfs(s, wordDict, 0);
    }

    int indent = 0;
    private boolean dfs(String s, List<String> wordDict, int start) {
        indent++;
        if (s.length() == start) {
            System.out.println(" ".repeat(indent) + "finish ");
            indent--;
            return true;
        }

        if (map.containsKey(start)) {
            System.out.println(" ".repeat(indent) + "contains " + s + " is " + map.get(start));
            indent--;
            return map.get(start);
        }

        for (String dic: wordDict) {
            String res = "";
            if (s.startsWith(dic, start)) {
                if (dfs(s, wordDict, start + dic.length())) {
                    map.put(start, true);
                    return true;
                }
            }
        }

        map.put(start, false);
        indent--;
        return false;
    }
}
