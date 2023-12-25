/*
 * Q. Given a list of non-overlapping intervals sorted by their start time,
 * insert a given interval at the valid position, merge all the overlapping
 * intervals and return a list of mutually exclusive intervals.
 * 
 * Example:
 * Input: intervals = [{1,3},{5,7},{8,10}] and newInterval = [{4,9}]
 * Output = [{1,3},{4,10}]
 * Input: intervals = [{0,1},{3,5},{6,7},{9,10}] and newInterval = [{2,7}]
 * Output = [{0,1},{2,7},{9,10}]
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class InsertAndMergeIntervals {
  static class Interval {
    int start;
    int end;

    public Interval(int start, int end) {
      this.start = start;
      this.end = end;
    }
  }

  public static List<Interval> insertAndMerge(List<Interval> intervals, Interval newInterval) {
    if (intervals == null || intervals.isEmpty()) {
      return Arrays.asList(newInterval);
    }

    List<Interval> mergedIntervals = new ArrayList<>();
    int i = 0;

    // Add intervals before the new interval that do not overlap
    while (i < intervals.size() && intervals.get(i).end < newInterval.start) {
      mergedIntervals.add(intervals.get(i));
      i++;
    }

    // Merge overlapping intervals with the new interval
    while (i < intervals.size() && intervals.get(i).start <= newInterval.end) {
      newInterval.start = Math.min(newInterval.start, intervals.get(i).start);
      newInterval.end = Math.max(newInterval.end, intervals.get(i).end);
      i++;
    }

    // Add the merged interval to the result
    mergedIntervals.add(newInterval);

    // Add intervals after the new interval that do not overlap
    while (i < intervals.size()) {
      mergedIntervals.add(intervals.get(i));
      i++;
    }

    return mergedIntervals;
  }

  public static void main(String[] args) {
    List<Interval> intervals1 = Arrays.asList(
        new Interval(1, 3),
        new Interval(5, 7),
        new Interval(8, 10));
    Interval newInterval1 = new Interval(4, 9);

    List<Interval> result1 = insertAndMerge(intervals1, newInterval1);

    System.out.println("Output 1:");
    for (Interval interval : result1) {
      System.out.println("[" + interval.start + ", " + interval.end + "]");
    }

    List<Interval> intervals2 = Arrays.asList(
        new Interval(0, 1),
        new Interval(3, 5),
        new Interval(6, 7),
        new Interval(9, 10));
    Interval newInterval2 = new Interval(2, 7);

    List<Interval> result2 = insertAndMerge(intervals2, newInterval2);

    System.out.println("Output 2:");
    for (Interval interval : result2) {
      System.out.println("[" + interval.start + ", " + interval.end + "]");
    }
  }
}
