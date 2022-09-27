package com.example.dynamicprogrammingpractice.slidingwindow

import kotlin.math.min

/**
 * https://leetcode.com/problems/minimum-size-subarray-sum/
 */

fun main() {
    val intArray2 = intArrayOf(2, 3, 1, 2, 4, 3)
    println(solutionForMinSubArrayLen(7, intArray2)) // 2
    println(solutionForMinSubArrayLen(11, intArrayOf(1, 1, 1, 1, 1, 1, 1, 1))) // 0
    println(solutionForMinSubArrayLen(15, intArrayOf(1, 2, 3, 4, 5))) // 5
}

/**
 * We start with an empty subarray, and add elements to it until the sum of the subarray is greater
 * than or equal to the target. Then we drop elements from the subarray until the sum is less than the
 * target. We keep track of the minimum length of the subarray that satisfies the condition
 *
 * @param target the target sum
 * @param nums [2,3,1,2,4,3]
 * @return The minimum length of the subarray that sums to the target.
 */
fun minSubArrayLen(target: Int, nums: IntArray): Int {
    var subArray = intArrayOf()
    var minLengthOfSum = nums.sum() + 1
    var numberOfDrop = 0
    for (i in nums.indices) {
        subArray += nums[i]
        var tempSize = subArray.sum()
        if (tempSize >= target) {
            while (subArray.sum() >= target) {
                if (minLengthOfSum >= subArray.size) {
                    minLengthOfSum = subArray.size
                }
                numberOfDrop++
                subArray = subArray.drop(1).toIntArray()
            }
        }
    }
    return if (minLengthOfSum > nums.size) 0 else minLengthOfSum
}


/**
 * We use a sliding window, with left and right pointers. We add elements from the right pointer and
 * subtract elements from the left pointer to get the sum within the window. If the sum is greater than
 * the target, we remove elements from the left pointer to decrease the sum. We keep doing this until
 * the sum is less than the target
 *
 * @param target the target value we're looking for
 * @param nums the array of integers
 * @return The minimum length of a contiguous subarray of which the sum ≥ s. If there isn't one, return
 * 0 instead.
 */
fun solutionForMinSubArrayLen(target: Int, nums: IntArray): Int {
    var minesLengthOfSubArray = Int.MAX_VALUE
    var left = 0
    var sum = 0
    for (i in nums.indices) {
        sum += nums[i]
        while (sum >= target) {
            minesLengthOfSubArray = min(minesLengthOfSubArray, i + 1 - left)
            sum -= nums[left++]
        }
    }
    return if (minesLengthOfSubArray != Int.MAX_VALUE) minesLengthOfSubArray else 0
}