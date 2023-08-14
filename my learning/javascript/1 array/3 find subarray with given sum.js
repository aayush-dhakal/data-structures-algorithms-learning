/* A simple program to print subarray
with sum as given sum */
  
/* Returns true if the there is a subarray
of arr[] with sum equal to 'sum' otherwise
returns false. Also, prints the result */

function subArraySum( arr,  n,  sum)
{
  
    // Pick a starting point
    for (let i = 0; i < n; i++) {
        let currentSum = arr[i];
  
        if (currentSum == sum) {
            console.log("Sum found at indexes " +i);
            return;
        }
        else {
            // Try all subarrays starting with 'i'
            for (let j = i + 1; j < n; j++) {
                currentSum += arr[j];
  
                if (currentSum == sum) {
                    console.log("Sum found between indexes "
                         + i + " and " +j);
                    return;
                }
            }
        }
    }
    console.log("No subarray found");
    return;
}
  
    let arr = [15, 2, 4, 8, 9, 5, 10, 23 ];
    let n = arr.length;
    let sum = 23;
    subArraySum(arr, n, sum);
    
    
// Given an array arr[] of non-negative integers and an integer sum, find a subarray that adds to a given sum.
// Note: There may be more than one subarray with sum as the given sum, print first such subarray. 
    
// sliding window technique
function findSubarrayWithSum(arr, targetSum) {
    let windowStart = 0;
    let windowSum = 0;

    for (let windowEnd = 0; windowEnd < arr.length; windowEnd++) {
        windowSum += arr[windowEnd];

        while (windowSum > targetSum && windowStart <= windowEnd) {
            windowSum -= arr[windowStart];
            windowStart++;
        }

        if (windowSum === targetSum) {
            return arr.slice(windowStart, windowEnd + 1);
        }
    }

    return null;
}

// Example usage
const inputArray = [1, 4, 20, 3, 10, 5];
const targetSum = 33;
const subarray = findSubarrayWithSum(inputArray, targetSum);
console.log(subarray); // Output: [20, 3, 10]

