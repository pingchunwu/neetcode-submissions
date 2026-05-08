class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length == 1) {
            return List.of(List.of(strs[0]));
        }
        List<Map<Character, Integer>> maps = new ArrayList();
        for (int i = 0 ; i < strs.length; i ++ ) {
            Map<Character, Integer> map = new HashMap();
            char[] charArr = strs[i].toCharArray();
            for (int j = 0 ; j < charArr.length; j ++) {
                map.put(charArr[j], map.getOrDefault(charArr[j], 0) + 1);
            }
            maps.add(map);
        }
        List<List<String>> result = new ArrayList();
        boolean[] used = new boolean[strs.length];
        for(int i = 0 ; i < strs.length; i ++) {
            if (used[i]) {
                continue;
            }
            List<String> subResult = new ArrayList();
            subResult.add(strs[i]);
            used[i] = true;
            for(int j = i + 1 ; j < strs.length; j ++) {
                if (used[j]) {
                    continue;
                }
                if (maps.get(i).equals(maps.get(j))) {
                    used[j] = true;
                    subResult.add(strs[j]);
                }
            }
            result.add(subResult);
        }
        return result;
    }
}
