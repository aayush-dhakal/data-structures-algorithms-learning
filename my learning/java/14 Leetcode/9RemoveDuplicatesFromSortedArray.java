// Given an integer array nums sorted in non-decreasing order, remove the
// duplicates in-place such that each unique element appears only once. The
// relative order of the elements should be kept the same. Then return the
// number of unique elements in nums.

// Input: nums = [1,1,2]
// Output: 2, nums = [1,2,_]

// Input: nums = [0,0,1,1,1,2,2,3,3,4]
// Output: 5, nums = [0,1,2,3,4,_,_,_,_,_]

import java.util.Arrays;

class RemoveDuplicates {

  public static int removeDuplicates(int[] nums) {
    if (nums.length == 0) {
      return 0; // Empty array, no duplicates to remove
    }

    int i = 1; // At least one unique element (the first one) is in first position ie nums[0]
               // so we start to compare from 2nd position of array

    for (int j = 1; j < nums.length; j++) {
      if (nums[j] != nums[j - 1]) {
        nums[i] = nums[j];
        i++;
      }
    }

    return i;
  }

  public static void main(String[] args) {
    int[] nums1 = { 1, 1, 2 };
    int result1 = removeDuplicates(nums1);
    System.out.println("Output: " + result1 + ", nums = " + Arrays.toString(Arrays.copyOf(nums1, result1)));

    int[] nums2 = { 0, 0, 1, 1, 1, 2, 2, 3, 3, 4 };
    int result2 = removeDuplicates(nums2);
    System.out.println("Output: " + result2 + ", nums = " + Arrays.toString(Arrays.copyOf(nums2, result2)));
  }
}
