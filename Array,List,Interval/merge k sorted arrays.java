public class Solution {
    /**
     * @param arrays: k sorted integer arrays
     * @return: a sorted array
     */
    class Element {
        int x, y, val;
        Element(int x, int y, int val) {
            this.x = x;
            this.y = y;
            this.val = val;
        }
    }
    public int[] mergekSortedArrays(int[][] arrays) {
        if (arrays == null || arrays.length == 0 || arrays[0].length == 0) {
            return new int[0];
        }
        int m = arrays.length;
        PriorityQueue<Element> pq = new PriorityQueue<>(m, new Comparator<Element>(){
            public int compare(Element a, Element b) {
                return a.val - b.val;
            }
        });
        int count = 0;
        for (int i = 0; i < m; i++) {
            if (arrays[i].length > 0) {
                count += arrays[i].length;
                pq.offer(new Element(i, 0, arrays[i][0]));
            }
        }
        int[] res = new int[count];
        int index = 0;
        while (!pq.isEmpty()) {
            Element cur = pq.poll();
            res[index++] = cur.val;
            if (cur.y < arrays[cur.x].length - 1) {
                cur = new Element(cur.x, cur.y + 1, arrays[cur.x][cur.y + 1]);
                pq.offer(cur);
            }
        }
        return res;
    }
}
