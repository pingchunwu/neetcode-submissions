class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int l = 0;
        Map<Character, Integer> s1c = getMap(s1.toCharArray());
        for (int r = s1.length() ;  r <= s2.length(); r++) {
            Map<Character, Integer> s2c = getMap(s2.substring(l,r).toCharArray());
            if (s1c.equals(s2c)) {
                return true;
            }
            l++;
        }
        return false;
    }

    private Map<Character, Integer> getMap(char[] charArr) {
        Map<Character, Integer> map = new HashMap();
        for (char c: charArr) {
            map.put(c, map.getOrDefault(c, 0)+ 1);
        }
        return map;
    }
}
