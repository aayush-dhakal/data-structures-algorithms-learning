// Q. Given an array of integers, return indices of the two numbers such that
// they add up to a specific target.
// Example:
// array - {2,11,5,10.7,8}, target = 9
// since aar[0]+arr[4]=2+7=9, return {0,4} indices

import java.util.HashMap;
import java.util.Map;

class TwoSum {

  public static int[] findTwoSum(int[] nums, int target) {
    Map<Integer, Integer> map = new HashMap<>();

    for (int i = 0; i < nums.length; i++) {
      int complement = target - nums[i];

      // we will first check if map contains the number for target - current array
      // element
      if (map.containsKey(complement)) {
        // if the complement is present then we will return the current array index for
        // which it matched and also the index of its matched complement by using
        // map.get (map.get(2) will retun the value for key 2 which is 0)
        return new int[] { map.get(complement), i };
      }

      // we will add the number as key and its index as value in hashmap if there is
      // no match for target - current array element is found
      map.put(nums[i], i);
    }

    // No solution found
    return null;
  }

  public static void main(String[] args) {
    int[] nums = { 2, 11, 5, 10, 7, 8 };
    int target = 9;

    int[] result = findTwoSum(nums, target);

    if (result != null) {
      System.out.println("Indices: [" + result[0] + ", " + result[1] + "]");
    } else {
      System.out.println("No solution found.");
    }
  }
}
