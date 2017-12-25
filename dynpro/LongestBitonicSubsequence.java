Find Longest Increasing Subsequence from left. Store in an Array.
Find Longest increading Subsequence from right. Store in an Array.

You can calculate the Bitonic now by  Max(Left LIS[i] + Right LIS[i] - 1).
Why this works ?

At an index i: Left LIS gives increasing sequence till i & Right LIS gives decreasing 
sequence from i. (Need to reduce the value by 1 after summation as we are double counting
i th element).

