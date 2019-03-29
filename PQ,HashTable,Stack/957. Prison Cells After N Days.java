//这种方法超时
class Solution {
    public int[] prisonAfterNDays(int[] cells, int N) {
        int[] res = new int[cells.length];
        while (N > 0) {
            N--;
            res = new int[cells.length];
            for (int i = 1; i < cells.length - 1; i++) {
                res[i] = cells[i-1] == cells[i + 1]? 1: 0;
            }
            cells = res;
        }
        res[0] = 0;
        res[cells.length - 1] = 0;
        return res;
        
    }
}

//hashmap
class Solution {
    public int[] prisonAfterNDays(int[] cells, int N) {
        Map<String, Integer> map = new HashMap<>();
        while (N > 0) {
            int[] cells2 = new int[8];
            map.put(Arrays.toString(cells), N--);
            for (int i = 1; i < 7; i++) {
                cells2[i] = cells[i - 1] == cells[i + 1] ? 1 : 0;
            }
            cells = cells2;
            if (map.containsKey(Arrays.toString(cells))) {
                N %= map.get(Arrays.toString(cells)) - N;
            }
        }
        return cells;
        
    }
}
