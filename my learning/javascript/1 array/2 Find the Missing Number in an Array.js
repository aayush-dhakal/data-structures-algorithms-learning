// Q. Given an array of n-1 distinct numbers in the range of 1 to n. Find the missing number in it.
// if an array has 5 elements then the n will be 6 as one element will be missing.
// example: input: [2, 4, 1, 3, 6] and output is 5. (here n is 6 ie array_length + 1)

const findMissing2 = (arr) => {
  const len = arr.length;
  for (let i = 0; i < len; i++) {
    if (!arr.includes(i + 1)) {
      return i + 1;
    }
  }
};

const findMissing = (arr) => {
  const n = arr.length + 1; // total number of numbers that should have been in the array
  let sum_of_first_n_natural_number = (n * (n + 1)) / 2;
  let totalSum = sum_of_first_n_natural_number;

  for (let i = 0; i < arr.length; i++) {
    totalSum -= arr[i];
  }
  return totalSum;
};

const a = [2, 4, 1, 3, 6]; // output: 5
const a1 = [2, 4, 1, 3, 6, 8, 5]; // output: 7
const a2 = [2, 4, 3, 6, 8, 5, 7];

console.log(findMissing(a));
console.log(findMissing(a1));
console.log(findMissing(a2));
