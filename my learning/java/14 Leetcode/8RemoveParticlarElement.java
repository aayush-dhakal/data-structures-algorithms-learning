// Q. Given an integer array nums and an integer val, remove all occurrences of
// val in nums in-place. The order of the elements may be changed. Then return
// the number of elements in nums that are not equal to val.

// Input: nums = [3,2,2,3], val = 3
// Output: 2, nums = [2,2,_,_] // means starting two elements doesn't have value 3

// Input: nums = [0,1,2,2,3,0,4,2], val = 2
// Output: 5, nums = [0,1,4,0,3,_,_,_]  // means starting 5 elements doesn't have value 5

import java.util.Arrays;

class RemoveElement {

  public static int removeElement(int[] nums, int val) {
    int i = 0; // Variable to track the count of elements not equal to val. slow pointer used
               // to keep the value

    for (int j = 0; j < nums.length; j++) {
      // j is fast pointer to check whether the element is equal to val. if is equal
      // to val then swap palces with i th position
      if (nums[j] != val) {
        nums[i] = nums[j];
        i++;
      }
    }

    return i;
  }

  public static void main(String[] args) {
    int[] nums1 = { 3, 2, 2, 3 };
    int val1 = 3;

    int result1 = removeElement(nums1, val1);
    System.out.println("Output: " + result1 + ", nums = " + Arrays.toString(nums1));

    int[] nums2 = { 0, 1, 2, 2, 3, 0, 4, 2 };
    int val2 = 2;

    int result2 = removeElement(nums2, val2);
    System.out.println("Output: " + result2 + ", nums = " + Arrays.toString(nums2));
  }
}
