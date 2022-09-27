package com.example.dynamicprogrammingpractice.slidingwindow

fun main() {
    var intArray = intArrayOf(1, 1, 0, 1, 1, 0, 1, 1, 1, 1, 0, 0)
    println(findMaximumSequenceOfContinuesOnesReplacingKZero(intArray, 0) == 4)
    println(findMaximumSequenceOfContinuesOnesReplacingKZero(intArray, 1) == 7)
    println(findMaximumSequenceOfContinuesOnesReplacingKZero(intArray, 2) == 10)
    println(findMaximumSequenceOfContinuesOnesReplacingKZero(intArray, 3) == 11)
}

/**
 * We keep a running subarray of the input array, and keep track of the first zero index in the
 * subarray. When the number of zeros in the subarray is equal to k, we calculate the sum of the
 * subarray and compare it to the maximum sum we've seen so far. When the number of zeros in the
 * subarray is equal to k + 1, we remove the first zero from the subarray and update the first zero
 * index
 *
 * @param nums an array of integers
 * @param k number of zeros to be replaced
 * @return The maximum sum of a subarray of size k
 */
/**
 * We keep a running subarray of the input array, and keep track of the first zero index in the
 * subarray. When the number of zeros in the subarray is equal to k, we calculate the sum of the
 * subarray and compare it to the maximum sum we've seen so far. When the number of zeros in the
 * subarray is equal to k + 1, we remove the first zero from the subarray and update the first zero
 * index
 *
 * @param nums an array of integers
 * @param k the number of zeros you can replace
 * @return The maximum sum of a subarray of size k
 */
fun findMaximumSequenceOfContinuesOnesReplacingKZero(nums: IntArray, k: Int): Int {
    var subArray = intArrayOf()
    var maxSubArray = 0
    var zeroCount = 0
    var firstZeroIndex = -1
    for (i in nums.indices) {
        subArray += nums[i]
        if (nums[i] == 0)
            zeroCount++
        if (zeroCount == k - 1) {
            firstZeroIndex = i
        }
        if (k== 0)
            firstZeroIndex = i
        if (zeroCount == k + 1) {
            maxSubArray = Math.max(subArray.sum() + k, maxSubArray)
            zeroCount--
            subArray = subArray.drop(firstZeroIndex + 1).toIntArray()
        }
    }
    return maxSubArray
}