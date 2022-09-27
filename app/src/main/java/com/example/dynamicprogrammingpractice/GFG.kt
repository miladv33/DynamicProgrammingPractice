package com.example.dynamicprogrammingpractice

import kotlin.jvm.JvmStatic
import com.example.dynamicprogrammingpractice.GFG

// Java code O(n*k) solution for finding maximum sum of
// a subarray of size k
internal object GFG {
    // Returns maximum sum in
    // a subarray of size k.
    fun maxSum(arr: IntArray, n: Int, k: Int): Int {
        // Initialize result
        var max_sum = Int.MIN_VALUE

        // Consider all blocks starting with i.
        for (i in 0 until n - k + 1) {
            var current_sum = 0
            for (j in 0 until k) current_sum += arr[i + j]

            // Update result if required.
            max_sum = Math.max(current_sum, max_sum)
        }
        return max_sum
    }

    // Driver code
    @JvmStatic
    fun main(args: Array<String>) {
        val arr = intArrayOf(1, 4, 2, 10, 2, 3, 1, 0, 20)
        val k = 4
        val n = arr.size
        println(maxSum(arr, n, k))
    }
}