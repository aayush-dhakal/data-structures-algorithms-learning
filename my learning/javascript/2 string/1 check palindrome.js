const checkPalindrome = (word) => {
  const charArry = word.split("");
  let end = charArry.length - 1;

  // for (let start = 0; start < charArry.length; start++) {
  //   if (start < end) {
  //     if (charArry[start] !== charArry[end]) {
  //       return false;
  //     }
  //     end--;
  //   }
  // }
  // return true;

  let start = 0;
  while (start < end) {
    if (start < end) {
      if (charArry[start] !== charArry[end]) {
        return false;
      }
      start++;
      end--;
    }
  }
  return true;
};

const s = "madam";
const s1 = "caac";
const s2 = "caact";
const s3 = "caas";

console.log(checkPalindrome(s));
console.log(checkPalindrome(s1));
console.log(checkPalindrome(s2));
console.log(checkPalindrome(s3));
