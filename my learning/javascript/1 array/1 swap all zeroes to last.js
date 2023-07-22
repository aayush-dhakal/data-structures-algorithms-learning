const swap = (arr) => {
  let j = 0;
  for (let i = 0; i < arr.length; i++) {
    if (arr[i] != 0 && arr[j] == 0) {
      let temp = arr[i];
      arr[i] = arr[j];
      arr[j] = temp;
    }
    if (arr[j] != 0) {
      j++;
    }
  }
  console.log(arr);
};

const arr = [1, 0, 7, 0, 9, 7];
const arr2 = [0, 0, 1, 0, 7, 0, 9, 7];
const arr3 = [0, 0, 7, 0, 9, 7, 0, 0];
const arr4 = [1, 0, 7, 0, 9, 7, 0, 0];
swap(arr);
swap(arr2);
swap(arr3);
swap(arr4);
