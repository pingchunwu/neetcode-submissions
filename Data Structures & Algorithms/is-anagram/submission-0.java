class Solution {
    public boolean isAnagram(String s, String t) {
        String[] sArr = s.split("");
        String[] tArr = t.split("");
        if (sArr.length != tArr.length) {
            return false;
        }

        Map<String, Integer> map = new HashMap();
        for (int i = 0 ; i < sArr.length ; i ++) {
            if (map.get(sArr[i]) != null) {
                map.put(sArr[i], map.get(sArr[i]) + 1);
            } else {
                map.put(sArr[i], 1);
            }
        }
        for (int i = 0 ; i < tArr.length ; i ++) {
            if (map.get(tArr[i]) == null) {
                return false;
            }
            if (map.get(tArr[i]) > 0) {
                map.put(tArr[i], map.get(tArr[i]) - 1);
            } else {
                return false;
            }
        }

        return true;
    }
}
