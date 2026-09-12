class Solution {
    public boolean checkInclusion(String s1, String s2) {
        Map<Character,Integer> map = new HashMap<>();
        for (char c: s1.toCharArray()) {
            // System.out.println("c is :"+c);
            // map.computeIfAbsent(c, key -> map.getOrDefault(c, 0) + 1);
            map.put(c, map.getOrDefault(c, 0) + 1);
            // System.out.println("map has c :"+ map.get(c));
        }

        for (Map.Entry<Character, Integer> e: map.entrySet()) {
            System.out.println("check!! key:"+e.getKey()+",value:"+e.getValue());
        }

        int l = 0;
        for (int r = s1.length() - 1 ; r < s2.length(); r++) {
            while ( r >= l && map.containsKey(s2.charAt(l)) && map.get(s2.charAt(l)) != 0) {
                // System.out.println("l:"+l+",r:"+r+",char is:"+s2.charAt(l)+",left:"+map.get(s2.charAt(l)));
                map.put(s2.charAt(l), map.get(s2.charAt(l)) - 1);
                l++;
            }
            if (check(map)) {
                return true;
            } else {
                // System.out.println("not match");
                while (l != (r - s1.length() + 1)) {
                    l --;
                    if (map.containsKey(s2.charAt(l))) {
                        map.put(s2.charAt(l), map.get(s2.charAt(l)) + 1);
                        // System.out.println("add l:"+l+",char is:"+s2.charAt(l)+",now have:"+map.get(s2.charAt(l)));
                    }
                }
            }
            l++;
        }

        return false;
    }

    private boolean check(Map<Character, Integer> map) {
        for (Map.Entry<Character, Integer> e: map.entrySet()) {
            // System.out.println("key:"+e.getKey()+",value:"+e.getValue());
            if(e.getValue() != 0) {
                return false;
            }
        }
        return true;
    }
}
