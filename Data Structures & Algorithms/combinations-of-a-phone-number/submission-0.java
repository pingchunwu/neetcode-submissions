class Solution {
    Map<Integer, List<String>> map = new HashMap();
    List<String> res = new ArrayList();
    StringBuilder s = new StringBuilder();
    int digitNumber;
    public List<String> letterCombinations(String digits) {
        if (digits.equals("")) {
            return List.of();
        }
        digitNumber = digits.length();
        map.put(2, List.of("a", "b", "c"));
        map.put(3, List.of("d", "e", "f"));
        map.put(4, List.of("g", "h", "i"));
        map.put(5, List.of("j", "k", "l"));
        map.put(6, List.of("m", "o", "n"));
        map.put(7, List.of("p", "q", "r", "s"));
        map.put(8, List.of("t", "u", "v"));
        map.put(9, List.of("w", "x", "y", "z"));

        List<List<String>> lists = new ArrayList();
        for (String s: digits.split("")) {
            lists.add(map.get(Integer.valueOf(s)));
        }

        dfs(lists, 0);
        return res;
    }

    private void dfs(List<List<String>> lists, int i) {
        if (s.length() == digitNumber) {
            res.add(s.toString());
            return;
        }

        for (String str: lists.get(i)) {
            s.append(str);
            dfs(lists, i + 1);
            s.deleteCharAt(s.length() - 1);
        }

    }
}
