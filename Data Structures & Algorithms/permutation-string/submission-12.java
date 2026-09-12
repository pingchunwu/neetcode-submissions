class Solution {
    public boolean checkInclusion(String s1, String s2) {
        Map<Character,Integer> map = new HashMap<>();
        for (char c: s1.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int l = 0;
        for (int r = s1.length() - 1 ; r < s2.length(); r++) {
            while ( r >= l && map.containsKey(s2.charAt(l)) && map.get(s2.charAt(l)) != 0) {
                map.put(s2.charAt(l), map.get(s2.charAt(l)) - 1);
                l++;
            }
            if (check(map)) {
                return true;
            } else {
                while (l != (r - s1.length() + 1)) {
                    l --;
                    if (map.containsKey(s2.charAt(l))) {
                        map.put(s2.charAt(l), map.get(s2.charAt(l)) + 1);
                    }
                }
            }
            l++;
        }

        return false;
    }

    private boolean check(Map<Character, Integer> map) {
        for (Map.Entry<Character, Integer> e: map.entrySet()) {
            if(e.getValue() != 0) {
                return false;
            }
        }
        return true;
    }
}
