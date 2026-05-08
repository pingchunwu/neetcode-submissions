class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int l = 0;
        char[] s1c = s1.toCharArray();
        Map<Character, Integer> map = getMap(s1c);
        for (int r = s1.length(); r < s2.length()+1; r++) {
            char[] s2c = s2.substring(l,r).toCharArray();
            Map<Character, Integer> map2 = getMap(s2c);
            if (map.equals(map2)) {
                return true;
            }
            l++;
        }
        return false;
    }

    private Map getMap(char[] cArr){
        Map<Character, Integer> map = new HashMap();
        for (char c : cArr) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        return map;
    }
}
