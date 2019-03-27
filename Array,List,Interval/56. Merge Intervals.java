/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
class Solution {
    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> res = new ArrayList<>();
        if (intervals == null) return res;
        Interval last = null;
        Collections.sort(intervals, new Comparator<Interval>(){
            public int compare(Interval a, Interval b) {
                return a.start - b.start;
            }
        });
        for (Interval interval: intervals) {
            if (last == null) {
                res.add(interval);
                last = interval;
                continue;
            }
            if (last.end >= interval.start) { // 发生了一次merge
                last.end = Math.max(last.end, interval.end);

            } else {
                last = interval;
                res.add(last);
            }
            
        }
        return res;
    }
}
//变形版本，由最多interval merge成的interval是由几个interval 组成的, 也可以用扫描线求
// class Solution {
//     public List<Interval> merge(List<Interval> intervals) {
//         List<Interval> res = new ArrayList<>();
//         if (intervals == null) return res;
//         Interval last = null;
//         int max = 1;
//         int temp = 0;
//         Collections.sort(intervals, new Comparator<Interval>(){
//             public int compare(Interval a, Interval b) {
//                 return a.start - b.start;
//             }
//         });
//         for (Interval interval: intervals) {
//             if (last == null) {
//                 res.add(interval);
//                 last = interval;
//                 continue;
//             }
//             if (last.end >= interval.start) { // 发生了一次merge
//                 last.end = Math.max(last.end, interval.end);
//                 temp++;
//                 max = Math.max(max, temp);
//             } else {
//                 last = interval;
//                 res.add(last);
//                 temp = 0;
//             }
            
//         }
//         return res;
//     }
// }
