class Solution {
    public boolean isAnagram(String s, String t) {
        String[] sArr = s.split("");
        String[] tArr = t.split("");
        if (sArr.length != tArr.length) {
            return false;
        }

        Map<String, Integer> mapS = getMap(sArr);
        Map<String, Integer> mapT = getMap(tArr);

        for (var entry: mapS.entrySet()) {
            if (mapT.get(entry.getKey()) == null ||
                mapT.get(entry.getKey()).intValue() != entry.getValue().intValue()) {
                    System.out.println(entry.getKey() + " " + mapT.get(entry.getKey()) + " != " + entry.getValue());
                return false;
            }
        }

        return true;
    }

    private Map<String, Integer> getMap(String[] arr) {
        Map<String, Integer> map = new HashMap();
        for (int i = 0 ; i < arr.length ; i ++) {
            if (map.get(arr[i]) != null) {
                map.put(arr[i], map.get(arr[i]) + 1);
            } else {
                map.put(arr[i], 1);
            }
        }
        return map;
    }
}
