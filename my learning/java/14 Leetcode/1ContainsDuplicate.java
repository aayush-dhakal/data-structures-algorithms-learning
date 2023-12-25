// Q. Given an integer array nums, return true if any value appears at least
// twice in the array, and return false if every element is distinct.
// => [1,2,3,1] - true
// => [1,2,3,7] - false

import java.util.HashSet;
import java.util.Set;

class ContainsDuplicate {
  public static boolean containsDuplicate(int[] nums) {
    // HashSet<Integer> set = new HashSet<>();

    // you can use Set<Integer> set = new HashSet<>(); instead of HashSet<Integer>
    // set = new HashSet<>(); in your code. This is an example of using the
    // interface Set as the type for the variable set and creating an instance of
    // HashSet to implement that interface.
    // In Java, it's often recommended to use the interface type (Set in this case)
    // instead of the concrete class (HashSet) when declaring variables. This
    // provides more flexibility in case you decide to switch to a different
    // implementation of the Set interface later on (for example, if you want to use
    // a TreeSet or another Set implementation). Using the interface type also
    // adheres to the programming principle of "coding to the interface."
    Set<Integer> set = new HashSet<>();

    // for (int i = 0; i < nums.length; i++) {
    // if (set.contains(nums[i])) {
    // return true; // Duplicate found
    // } else {
    // set.add(nums[i]);
    // }
    // }

    // using enhanced for loop/foreach loop
    for (int num : nums) {
      if (set.contains(num)) {
        return true; // Duplicate found
      } else {
        set.add(num);
      }
    }

    return false; // No duplicates found
  }

  public static void main(String[] args) {
    int[] arr1 = { 1, 2, 3, 1 };
    int[] arr2 = { 1, 2, 3, 7 };

    System.out.println(containsDuplicate(arr1)); // true
    System.out.println(containsDuplicate(arr2)); // false
  }
}
