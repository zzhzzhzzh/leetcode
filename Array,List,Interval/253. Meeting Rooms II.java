/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
//swip line
class Solution {
    public int minMeetingRooms(Interval[] intervals) {
        if (intervals == null || intervals.length == 0) return 0;
        int max = Integer.MIN_VALUE;
        Map<Integer, Integer> map = new HashMap<>();
        for (Interval interval: intervals) {
            map.put(interval.start, map.getOrDefault(interval.start, 0) + 1);
            map.put(interval.end, map.getOrDefault(interval.end, 0) - 1);
            max = Math.max(max, interval.end);
        }
        int res = 0;
        int room = 0;
        for (int i = 0; i <= max; i++) {
            if (!map.containsKey(i)) continue;
            room += map.get(i);
            res = Math.max(res, room);
        }
        return res;
        
    }
}

// pq + sort
class Solution {
    public int minMeetingRooms(Interval[] intervals) {
        if (intervals == null || intervals.length == 0) return 0;
        int max = Integer.MIN_VALUE;
        Map<Integer, Integer> map = new HashMap<>();
        for (Interval interval: intervals) {
            map.put(interval.start, map.getOrDefault(interval.start, 0) + 1);
            map.put(interval.end, map.getOrDefault(interval.end, 0) - 1);
            max = Math.max(max, interval.end);
        }
        int res = 0;
        int room = 0;
        for (int i = 0; i <= max; i++) {
            if (!map.containsKey(i)) continue;
            room += map.get(i);
            res = Math.max(res, room);
        }
        return res;
        
    }
}
