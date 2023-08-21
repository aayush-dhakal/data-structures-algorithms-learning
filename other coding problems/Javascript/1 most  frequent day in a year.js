// What is your favorite day of the week? Check if it's the most frequent day of the week in the year.

// You are given a year as an integer (e.g. 2001). You should return the most frequent day(s) of the week in that year.

// Input: Year as an int.

// Output: The list of most frequent days in the Gregorian calendar year.

// Examples:
// most_frequent_days(2427) == ['Friday']
// most_frequent_days(2185) == ['Saturday']
// most_frequent_days(2860) == ['Thursday', 'Friday']

// Tests:
// most_frequent_days(1770)
// most_frequent_days(1785)
// most_frequent_days(1984)
// most_frequent_days(2000)

const mostFrequentDays = (year) => {
  const dayValues = [
    "Sunday",
    "Monday",
    "Tuesday",
    "Wednesday",
    "Thursday",
    "Friday",
    "Saturday",
  ];

  let days = [];

  days.push(dayValues[new Date("01-01-" + year).getDay()]); // since this is representational date format so here both month and day starts with 1.
  // or
  // days.push(dayValues[new Date(year, 0, 1).getDay()]); // sequence is (year, month, date). Note, month starts with 0 and date starts with 1 in this format

  // check if it's a leap year. For leap year there will be two most frequent days.
  // 2021 and 2022 both are non leap years so if jan 1 of 2021 is Friday then December 31 will also be Friday and Jan 1 of 2022 will start from Saturday so most frequent day of 2021 non leap year will be Friday
  // 2024 is leap year so if Jan 1 for 2024 is Monday then December 31 will be Tuesday(there will be one extra day in leap year) so now there will be two most frequent days Monday and Tuesday and Jan 1 of 2025 will start from Wednesday
  if (year % 4 === 0) days.push(dayValues[new Date("01-02-" + year).getDay()]);
  // or
  // if (year % 4 === 0) days.push(dayValues[new Date(year, 0, 2).getDay()]);

  return days;
};

console.log(mostFrequentDays(2427)); // [ 'Friday' ]
console.log(mostFrequentDays(2860)); // [ 'Thursday', 'Friday' ]
console.log(mostFrequentDays(2021));
console.log(mostFrequentDays(2024));

function mostFrequentDays2(year) {
  const daysOfWeek = [
    "Sunday",
    "Monday",
    "Tuesday",
    "Wednesday",
    "Thursday",
    "Friday",
    "Saturday",
  ];
  const daysCount = [0, 0, 0, 0, 0, 0, 0];

  // Calculate the day of the week for January 1st of the given year
  const firstDayOfYear = new Date(year, 0, 1).getDay();

  // Count the occurrences of each day of the week in the year
  for (let month = 0; month < 12; month++) {
    const daysInMonth = new Date(year, month + 1, 0).getDate();
    for (let day = 1; day <= daysInMonth; day++) {
      const dayOfWeek = new Date(year, month, day).getDay();
      daysCount[dayOfWeek]++;
    }
  }

  // Find the maximum count and get the corresponding day(s) of the week
  const maxCount = Math.max(...daysCount);
  const mostFrequentDays2 = [];
  for (let i = 0; i < daysCount.length; i++) {
    if (daysCount[i] === maxCount) {
      mostFrequentDays2.push(daysOfWeek[i]);
    }
  }

  return mostFrequentDays2;
}

// console.log(mostFrequentDays2(2427)); // Output: ['Friday']
// console.log(mostFrequentDays2(2185)); // Output: ['Saturday']
// console.log(mostFrequentDays2(2860)); // Output: ['Thursday', 'Friday']
// console.log(mostFrequentDays2(1770)); // Test
// console.log(mostFrequentDays2(1785)); // Test
// console.log(mostFrequentDays2(1984)); // Test
// console.log(mostFrequentDays2(2000)); // Test
