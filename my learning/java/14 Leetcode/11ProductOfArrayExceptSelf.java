// Q. Given an array of integers arr[], return an array result[] such that
// result[i] is equal to the product of all the elements of arr except arr[i].
// The product fits in 32-bit integer. The algorithm should run in O(n) time and
// without using division operator.
// Example -
// Input: arr = {1, 2, 3, 4}
// Output: result = {24, 12, 8, 6}
// result[0]=result[1]*result[2]*result[3]=2*3*4=24
// result[1]=result[0]*result[2]*result[3]=1*3*4=12

// Input: arr = {-1, 1, 0, -3, 3}
// Output: result = {0, 0, 9, 0, 0}

import java.util.Arrays;

class ProductArrayExceptSelf {

  public static int[] productExceptSelf(int[] arr) {
    int temp = 1; // intitally storing product as 1
    int[] result = new int[arr.length];

    // store product from left side of array
    for (int i = 0; i < arr.length; i++) {
      result[i] = temp;
      temp = temp * arr[i];
    }

    // store product from right side of array
    temp = 1;
    for (int i = arr.length - 1; i >= 0; i--) {
      result[i] = result[i] * temp;
      temp = temp * arr[i];
    }
    return result;
  }

  // making seperate left and right array for first approach
  public static int[] productExceptSelf2(int[] arr) {
    // leftProducts array stores the product of all elements to the left of each
    // element.
    // rightProducts array stores the product of all elements to the right of each
    // element.
    // The final result array is calculated by multiplying the corresponding
    // elements of leftProducts and rightProducts.

    int n = arr.length;

    // Arrays to store products to the left and right of each element
    int[] leftProducts = new int[n];
    int[] rightProducts = new int[n];

    // Initialize leftProducts and rightProducts arrays
    leftProducts[0] = 1;
    for (int i = 1; i < n; i++) {
      leftProducts[i] = leftProducts[i - 1] * arr[i - 1]; // at last it will be [1,1,2,6] for [1,2,3,4] input
    }

    rightProducts[n - 1] = 1;
    for (int i = n - 2; i >= 0; i--) {
      rightProducts[i] = rightProducts[i + 1] * arr[i + 1]; // at last it will be [24,12,8,6] for [1,2,3,4] input
    }

    // Calculate the result array using leftProducts and rightProducts
    int[] result = new int[n];
    for (int i = 0; i < n; i++) {
      result[i] = leftProducts[i] * rightProducts[i]; // this will be [24, 12, 8, 6] for [1,2,3,4] input
    }

    return result;
  }

  public static void main(String[] args) {
    int[] arr1 = { 1, 2, 3, 4 };

    int[] result = productExceptSelf2(arr1);
    System.out.println("Output: " + Arrays.toString(result));

    int[] result2 = productExceptSelf2(arr1);
    System.out.println("Output2: " + Arrays.toString(result2));

    int[] arr2 = { -1, 1, 0, -3, 3 };

    int[] result3 = productExceptSelf2(arr2);
    System.out.println("Output3: " + Arrays.toString(result3));

    int[] result4 = productExceptSelf2(arr2);
    System.out.println("Output4: " + Arrays.toString(result4));

  }
}
