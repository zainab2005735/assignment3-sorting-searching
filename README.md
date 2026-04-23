Project Overview

This project implements and compares sorting and searching algorithms in Java.
The goal is to experimentally analyze algorithm performance using execution time and compare the results with theoretical Big-O complexity.

Selected algorithms:

Basic Sorting: Insertion Sort
Advanced Sorting: Merge Sort
Searching: Binary Search

The program generates arrays of different sizes and measures execution time using System.nanoTime().

Insertion Sort

Insertion Sort builds a sorted array one element at a time by inserting each element into its correct position.

Time Complexity:

Best case: O(n)
Average case: O(n²)
Worst case: O(n²)

It performs well on small or already sorted datasets but becomes slow for large datasets.

Merge Sort

Merge Sort uses the divide-and-conquer technique.
The array is divided into halves, sorted recursively, and merged together.

Time Complexity:

Best: O(n log n)
Average: O(n log n)
Worst: O(n log n)

It is efficient and consistent for large datasets but requires extra memory.

Binary Search

Binary Search finds an element in a sorted array by repeatedly dividing the search space in half.

Time Complexity:

Best: O(1)
Worst: O(log n)

Binary Search is extremely fast but requires a sorted array.


| Size | Insertion Sort | Merge Sort |
| ---- | -------------- | ---------- |
| 10   | 5000 ns        | 7900 ns    |
| 100  | 51700 ns       | 40500 ns   |
| 1000 | 1710800 ns     | 142600 ns  |

| Size | Insertion Sort | Merge Sort |
| ---- | -------------- | ---------- |
| 10   | 1300 ns        | 5000 ns    |
| 100  | 3200 ns        | 47700 ns   |
| 1000 | 2900 ns        | 79100 ns   |


| Size | Time    |
| ---- | ------- |
| 10   | 2000 ns |
| 100  | 1300 ns |
| 1000 | 800 ns  |


Which sorting algorithm performed faster? Why?

Merge Sort was significantly faster for large datasets.
For array size 1000:

Insertion Sort: 1,710,800 ns
Merge Sort: 142,600 ns

This matches theory because:

Insertion Sort → O(n²)
Merge Sort → O(n log n)

As the dataset grows, Merge Sort scales much better.

How does performance change with input size?

Execution time increases as array size grows.

Insertion Sort increased dramatically:

From 5,000 ns → 1,710,800 ns

Merge Sort increased slowly:

From 7,900 ns → 142,600 ns

This demonstrates the impact of Big-O complexity.

How does sort vs unsorted data affect performance?

Insertion Sort became extremely fast on sorted arrays:

1000 elements random: 1,710,800 ns
1000 elements sorted: 2,900 ns

This happens because its best case is O(n).

Merge Sort performance stayed similar because it always runs in O(n log n).

Do results match Big-O expectations?

Yes.
Experimental results strongly match theoretical complexities.

Which searching algorithm is more efficient? Why?

Binary Search is very efficient because it reduces the search space by half each step.
Even for 1000 elements, it took only 800 ns.

This demonstrates O(log n) complexity.

Why does Binary Search require a sorted array?

Binary Search decides whether to search the left or right half of the array.
This is only possible if the array is sorted.
Without sorting, the algorithm cannot eliminate half of the elements.

Reflection

This project helped me understand how theoretical algorithm complexity translates into real performance.
I learned that algorithm choice becomes extremely important as data size grows.

The biggest challenge was implementing Merge Sort and ensuring fair performance testing by copying arrays before sorting.
This project improved my understanding of object-oriented design, performance measurement, and algorithm efficiency.