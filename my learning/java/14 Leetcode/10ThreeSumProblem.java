// Q. Given an array of distinct integers, print all such triplets such that
// they add up to a specific target. The triplet should be ordered in ascending
// order.
// Example -
// Given array of integers - {2,4,3,7,1,8,9,0}, target = 6
// Solution -
// Print - {0, 2, 4}, {1, 2, 3}

import java.util.Arrays;

class ThreeSum {

  public static void findTriplets(int[] nums, int target) {
    Arrays.sort(nums);

    for (int i = 0; i < nums.length - 2; i++) {
      // we have given i max index to num.lenght - 2 coz to give last two position to
      // left and right index as max index boundary for left will be nums.length - 1
      // and for right it will be nums.length
      int left = i + 1;
      int right = nums.length - 1;

      while (left < right) {
        int currentSum = nums[i] + nums[left] + nums[right];

        if (currentSum == target) {
          System.out.println("{" + nums[i] + ", " + nums[left] + ", " + nums[right] + "}");
          left++;
          right--;
        } else if (currentSum < target) {
          left++;
        } else {
          right--;
        }
      }
    }
  }

  public static void main(String[] args) {
    int[] nums = { 2, 4, 3, 7, 1, 8, 9, 0 };
    int target = 6;

    System.out.println("Triplets that add up to " + target + ":");
    findTriplets(nums, target);
  }
}
