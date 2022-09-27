package com.example.dynamicprogrammingpractice.slidingwindow

import kotlin.math.min

/**
 * https://leetcode.com/problems/minimum-size-subarray-sum/
 */

fun main() {
    val intArray2 = intArrayOf(2, 3, 1, 2, 4, 3)
    println(minSubArrayLen(7, intArray2)) // 2
    println(minSubArrayLen(11, intArrayOf(1, 1, 1, 1, 1, 1, 1, 1))) // 0
    println(minSubArrayLen(15, intArrayOf(1, 2, 3, 4, 5))) // 5
}

fun minSubArrayLen(target: Int, nums: IntArray): Int {
    var subArray = intArrayOf()
    var minLengthOfSum = nums.sum() + 1
    for (i in nums.indices) {
        subArray += nums[i]
        while (subArray.sum() >= target) {
            if (minLengthOfSum >= subArray.size) {
                minLengthOfSum = subArray.size
            }
            subArray = subArray.drop(1).toIntArray()
        }
    }
    return if (minLengthOfSum > nums.size) 0 else minLengthOfSum
}