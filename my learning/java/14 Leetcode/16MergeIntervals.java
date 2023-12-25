/*
 * Q. Given a list of intervals, merge all the overlapping intervals and return
 * a list of non-overlapping intervals.
 * Example:
 * Input: intervals = [{2,6},{1,3},{8,10}]
 * Output: [{1,6},{8,10}]
 * Input: intervals = [{0,1},{1,3},{8,10}]
 * Output: [{0,3},{8,10}]
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

class MergeIntervals {
  static class Interval {
    int start;
    int end;

    public Interval(int start, int end) {
      this.start = start;
      this.end = end;
    }
  }

  public static List<Interval> mergeIntervals(List<Interval> intervals) {
    if (intervals == null || intervals.isEmpty()) {
      return new LinkedList<>();
    }

    // Sort intervals based on their start times
    intervals.sort((a, b) -> Integer.compare(a.start, b.start));

    List<Interval> result = new LinkedList<>();
    Interval first = intervals.get(0);
    int start = first.start;
    int end = first.end;

    for (int i = 1; i < intervals.size(); i++) {
      Interval current = intervals.get(i);

      // Check for overlap
      if (current.start <= end) {
        // Merge the intervals
        end = Math.max(current.end, end);
      } else {
        // Add the non-overlapping interval to the result
        result.add(new Interval(start, end));
        start = current.start;
        end = current.end;
      }
    }

    // Add the last interval
    result.add(new Interval(start, end));

    return result;
  }

  public static List<Interval> mergeIntervals2(List<Interval> intervals) {
    if (intervals == null || intervals.isEmpty()) {
      return new ArrayList<>();
    }

    // Sort intervals based on their start times
    intervals.sort((a, b) -> Integer.compare(a.start, b.start));

    List<Interval> mergedIntervals = new ArrayList<>();
    Interval currentInterval = intervals.get(0);

    for (int i = 1; i < intervals.size(); i++) {
      Interval nextInterval = intervals.get(i);

      // Check for overlap
      if (currentInterval.end >= nextInterval.start) {
        // Merge the intervals
        currentInterval.end = Math.max(currentInterval.end, nextInterval.end);
      } else {
        // Add the non-overlapping interval to the result
        mergedIntervals.add(currentInterval);
        currentInterval = nextInterval;
      }
    }

    // Add the last interval
    mergedIntervals.add(currentInterval);

    return mergedIntervals;
  }

  public static void main(String[] args) {
    List<Interval> intervals = Arrays.asList(
        new Interval(2, 6),
        new Interval(1, 3),
        new Interval(8, 10));

    List<Interval> mergedIntervals = mergeIntervals(intervals);
    List<Interval> mergedIntervals2 = mergeIntervals2(intervals);

    // Print the merged intervals
    for (Interval interval : mergedIntervals) {
      System.out.println("[" + interval.start + ", " + interval.end + "]");
    }

    // Print the merged intervals 2
    for (Interval interval : mergedIntervals2) {
      System.out.println("[" + interval.start + ", " + interval.end + "]");
    }
  }
}
