// example, the input array is [1, 2, 3, 4, 5, 6, 7, 8, 9]and the length of the subarray we want to find is 3. The function returns the maximum sum of any subarray of length 3, which is 24 in this case which is sum of 3 sub array elements [7,8,9].

// we will use sliding window technique
function maxSubarraySum(arr, num) {
  if (num > arr.length) {
    return null;
  }

  let maxSum = 0;
  let tempSum = 0;

  // initialize the window
  for (let i = 0; i < num; i++) {
    maxSum += arr[i];
  }

  tempSum = maxSum;

  // slide the window over the array
  for (let i = num; i < arr.length; i++) {
    tempSum = tempSum - arr[i - num] + arr[i];
    maxSum = Math.max(maxSum, tempSum);
  }

  return maxSum;
}

// example usage
const arr = [1, 2, 3, 4, 5, 6, 7, 8, 9];
const num = 3;
const maxSum = maxSubarraySum(arr, num);
console.log(maxSum); // output: 24
