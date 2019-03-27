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
    public boolean canAttendMeetings(Interval[] intervals) {
        if (intervals == null || intervals.length == 0) return true;
        Arrays.sort(intervals, new Comparator<Interval>(){
            public int compare(Interval a, Interval b) {
                return a.start - b.start;
            }
        });
        int last = Integer.MIN_VALUE;
        for (Interval interval: intervals) {
            if (last <= interval.start) {
                last = interval.end;
            } else {
                return false;
            }
        }
        return true;
    }
}

//一个新的事件是否与其他事件重合
class Event{
    int start, end;
    Event(int satrt, int end) {
        this.start = start;
        this.end = end;
    }
}
public boolean isOverlapping(List<Event> events, Event e) {
    if (events == null || events.size() == 0) return false;
    for (Event event: events) {
        if (helper(event, e)) {
            return true;
        }
    }
    return false;
}
public boolean helper(Event a, Event b) {
    if (a. end <= b.start || a.start >= b.end) {
        return false;
    } else {
        return true;
    }
}
