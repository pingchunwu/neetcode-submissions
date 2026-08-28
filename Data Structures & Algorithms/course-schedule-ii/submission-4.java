class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int[] pre : prerequisites) {
            map.computeIfAbsent(pre[0], key -> new ArrayList<>()).add(pre[1]);
        }

        int[] visited = new int[numCourses];
        int[] res = new int[numCourses];
        for (int i = 0 ; i < numCourses; i ++) {
            if (!dfs(map, i, visited, res)) {
                return new int[0];
            }
        }

        if (count <= numCourses) {
            for (int i = count ; i < numCourses; i ++) {
                res[i] = i;
            }
        }

        return count > 0 ? res : new int[0];
    }
    int count = 0;
    private boolean dfs(Map<Integer, List<Integer>> map, int course, int[] visited, int[] res) {
        if (visited[course] == 1) {
            // System.out.println("visited " + course);
            return false; // visited
        } else if (visited[course] == 2) {
            // System.out.println("validated " + course);
            return true; // validated
        }
        visited[course] = 1;

        for (int pre: map.getOrDefault(course, new ArrayList<>())) {
            if (!dfs(map, pre, visited, res)){
                return false;
            }
        }

        visited[course] = 2;
        res[count++] = course;
        // System.out.println("pass " + course);
        return true;
    }
}
