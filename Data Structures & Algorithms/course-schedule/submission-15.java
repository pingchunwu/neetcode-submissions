class Solution {
    Set<Integer> set = new HashSet<>();
    Set<Integer> valid = new HashSet<>();
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int[] pre: prerequisites) {
            map.computeIfAbsent(pre[0], k -> new ArrayList<>()).add(pre[1]);
        }
        boolean allClear = true;
        for (Map.Entry<Integer, List<Integer>> m: map.entrySet()) {
            int course = m.getKey();
            List<Integer> pre = m.getValue();
            boolean clear = true;
            for (Integer p: pre) {
                clear &= dfs(map, p);
            }
            allClear &= clear;
        }
        return allClear;
    }

    private boolean dfs(Map<Integer, List<Integer>> map, int course) {
        if (set.contains(course)) {
            return false;
        }
        if (valid.contains(course)) {
            return true;
        }
        set.add(course);
        List<Integer> pres = map.getOrDefault(course, new ArrayList<>());
        for (int pre: pres) {
            if (!dfs(map, pre)) {
                return false;
            }
        }
        valid.add(course);
        set.remove(course);
        return true;
    }
}
