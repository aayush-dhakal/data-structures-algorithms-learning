// Q. Given an array of integers, return pair of numbers such that
// they add up to a specific target.
// Example:
// array - {2,11,5,10.7,8}, target = 9
// since aar[0]+arr[4]=2+7=9, return {2,7} indices

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class TwoSum {

  // HashMap Approach (Unsorted Array):
  // Time Complexity: O(n) - The loop through the array takes linear time, and
  // each lookup/insertion in the HashMap is constant time on average.
  // Space Complexity: O(n) - In the worst case, all elements of the array are
  // distinct and need to be stored in the HashMap.
  public static int[] findTwoSum(int[] nums, int target) {
    Map<Integer, Integer> map = new HashMap<>();

    for (int i = 0; i < nums.length; i++) {
      int complement = target - nums[i];

      // we will first check if map contains the number for target - current array
      // element
      if (map.containsKey(complement)) {
        // if the complement is present then we will return the current array value for
        // which it matched and also the value of its matched complement by using
        // map.get (map.get(2) will retun the value for key 2 which is 0)
        return new int[] { nums[map.get(complement)], nums[i] };
        // return new int[] { complement, nums[i] };
      }

      // we will add the number as key and its index as value in hashmap if there is
      // no match for target - current array element is found
      map.put(nums[i], i);
    }

    // No solution found
    return null;
  }

  // Two-Pointer Approach (Sorted Array):
  // Time Complexity: O(n log n) - The sorting step takes O(n log n) time, and
  // then the two-pointer traversal takes linear time.
  // Space Complexity: O(1) - The sorting is done in-place, and there is no
  // additional space complexity related to the input size.
  public static int[] findTwoSum2(int[] nums, int target) {
    // Assuming nums is already sorted
    Arrays.sort(nums);

    int left = 0;
    int right = nums.length - 1;

    while (left < right) {
      int sum = nums[left] + nums[right];

      if (sum == target) {
        return new int[] { nums[left], nums[right] };
      } else if (sum < target) {
        left++;
      } else {
        right--;
      }
    }

    // No solution found
    return null;
  }

  public static void main(String[] args) {
    int[] nums = { 2, 11, 5, 10, 7, 8 };
    int target = 9;

    int[] result = findTwoSum(nums, target);
    int[] result2 = findTwoSum2(nums, target);

    if (result != null) {
      System.out.println("Result1 Indices: [" + result[0] + ", " + result[1] + "]");
    } else {
      System.out.println("No solution found.");
    }

    if (result != null) {
      System.out.println("Result2 Indices: [" + result2[0] + ", " + result2[1] + "]");
    } else {
      System.out.println("No solution found.");
    }
  }
}
