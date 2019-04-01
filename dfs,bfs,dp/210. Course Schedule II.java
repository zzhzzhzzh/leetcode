class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] res = new int[numCourses];
        if (numCourses == 0 ) return res;
        Map<Integer, Integer> map = new HashMap<>();
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < numCourses; i++) {
            graph.put(i, new ArrayList<Integer>());
        }
        for (int[] prerequisite: prerequisites) {
            int num = prerequisite[0]; // 后续课程
            map.put(num, map.getOrDefault(num, 0) + 1);
            graph.get(prerequisite[1]).add(num);
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0;  i < numCourses; i++) {
            if (!map.containsKey(i)) {
                queue.offer(i);
                //System.out.println(i);
            }
        }
        int index = 0;
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            res[index++] = cur;
            for (Integer course: graph.get(cur)) {
                map.put(course, map.get(course) - 1);
                if (map.get(course) == 0) {
                    queue.offer(course);
                }
            }
        }
        if (index == numCourses) {
            return res;
        }
        return new int[0];
        
    }
}
