package com.example.dynamicprogrammingpractice.slidingwindow


//https://leetcode.com/problems/maximum-average-subarray-i/

fun main() {
//    println(maxAverage(intArrayOf(1, 12, -5, -6, 50, 3), 4))
//    println(maxAverage(intArrayOf(5), 1))
//    println(maxAverage(intArrayOf(-1), 1))
    var array = intArrayOf(
        -6_662,
        5432,
        -8558,
        -8935,
        8731,
        -3083,
        4115,
        9931,
        -4006,
        -3284,
        -3024,
        1714,
        -2825,
        -2374,
        -2750,
        -959,
        6516,
        9356,
        8040,
        -2169,
        -9490,
        -3068,
        6299,
        7823,
        -9767,
        5751,
        -7897,
        6680,
        -1293,
        -3486,
        -6785,
        6337,
        -9158,
        -4183,
        6240,
        -2846,
        -2588,
        -5458,
        -9576,
        -1501,
        -908,
        -5477,
        7596,
        -8863,
        -4088,
        7922,
        8231,
        -4928,
        7636,
        -3994,
        -243,
        -1327,
        8425,
        -3468,
        -4218,
        -364,
        4257,
        5690,
        1035,
        6217,
        8880,
        4127,
        -6299,
        -1831,
        2854,
        -4498,
        -6983,
        -677,
        2216,
        -1938,
        3348,
        4099,
        3591,
        9076,
        942,
        4571,
        -4200,
        7271,
        -6920,
        -1886,
        662,
        7844,
        3658,
        -6562,
        -2106,
        -296,
        -3280,
        8909,
        -8352,
        -9413,
        3513,
        1352,
        -8825
    )
//    println(maxAverage(array, 90))
    println("---------------------------")
    println(betterMaxAverage(intArrayOf(1, 12, -5, -6, 50, 3), 4))
    println(betterMaxAverage(intArrayOf(5), 1))
    println(betterMaxAverage(intArrayOf(-1), 1))
    println(betterMaxAverage(array, 90))
    println(betterMaxAverage(intArrayOf(0, 1, 1, 3, 3), 4))
    val array2 = intArrayOf(
        9672,
        -6795,
        2696,
        -97,
        6315,
        936,
        4482,
        5863,
        5046,
        -1376,
        -4328,
        -7112,
        -7844,
        -3295,
        5268,
        5029,
        -2665,
        -8250,
        -879,
        8716,
        4184,
        -6046,
        -366,
        -1785,
        875,
        4281,
        -3168,
        2248,
        7773,
        -5652,
        2100,
        2575,
        432,
        4523,
        -9309,
        -9232,
        -59,
        -1532,
        -1493,
        -9329,
        -1850,
        7945,
        -1224,
        -2646,
        -8007,
        -6395,
        -396,
        9638,
        5254,
        -2544,
        -4907,
        3706,
        6002,
        -9347,
        6248,
        -47,
        -9564,
        4105,
        -4256,
        -1794,
        6345,
        -780,
        -3363,
        -5389,
        -8173,
        4810,
        6787,
        3589,
        -850,
        -9937,
        -6255,
        4218,
        -6299,
        -9022,
        -152,
        1063,
        -2003,
        -3677,
        9704,
        -6182,
        -9562,
        5489,
        6350,
        -1083,
        -7537,
        -3583,
        3029
    )
    println(betterMaxAverage(nums = array2, k = 31))
    val array3 = intArrayOf(
        8860,
        -853,
        6534,
        4477,
        -4589,
        8646,
        -6155,
        -5577,
        -1656,
        -5779,
        -2619,
        -8604,
        -1358,
        -8009,
        4983,
        7063,
        3104,
        -1560,
        4080,
        2763,
        5616,
        -2375,
        2848,
        1394,
        -7173,
        -5225,
        -8244,
        -809,
        8025,
        -4072,
        -4391,
        -9579,
        1407,
        6700,
        2421,
        -6685,
        5481,
        -1732,
        -8892,
        -6645,
        3077,
        3287,
        -4149,
        8701,
        -4393,
        -9070,
        -1777,
        2237,
        -3253,
        -506,
        -4931,
        -7366,
        -8132,
        5406,
        -6300,
        -275,
        -1908,
        67,
        3569,
        1433,
        -7262,
        -437,
        8303,
        4498,
        -379,
        3054,
        -6285,
        4203,
        6908,
        4433,
        3077,
        2288,
        9733,
        -8067,
        3007,
        9725,
        9669,
        1362,
        -2561,
        -4225,
        5442,
        -9006,
        -429,
        160,
        -9234,
        -4444,
        3586,
        -5711,
        -9506,
        -79,
        -4418,
        -4348,
        -5891
    )
    println(betterMaxAverage(array3, 93))


}

fun betterMaxAverage(nums: IntArray, k: Int): Double {
    if (nums.size == 1) return nums.first().toDouble()
    var max = 0.0
    var maxNegative = Double.MIN_VALUE
    var right = -1
    var left = 0
    for (i in 0 until nums.size + 1) {
        right++
        if ((right - left) == k) {
            val currSum = (nums.copyOfRange(left, right).sum()).toDouble() / k
            if (currSum > max) {
                max = currSum
            }
            var tempMaxNegative = 0.0
            if (maxNegative > currSum) {
                tempMaxNegative = currSum
            }
            if (tempMaxNegative < maxNegative) {
                maxNegative = tempMaxNegative
            }
        }
        if ((right + 1) > 1 && (right + 1) > k) {
            left++
        }
    }
    return if (max != 0.0) max else maxNegative
}

/**
 * It finds the maximum average of a subarray of size k.
 *
 * @param nums an array of integers
 * @param k the number of elements in the subarray
 * @return The maximum average of a subarray of size k
 */
fun maxAverage(nums: IntArray, k: Int): Double {
    var max = 0.0
    var subArray = intArrayOf()
    for (n in nums) {
        subArray += n
        if (subArray.size > 1 && subArray.size > k) {
            subArray = subArray.drop(1).toIntArray()
        }
        if (subArray.size == k) {
            var currSum = ((subArray.sum()).toDouble()) / k
            if (Math.abs(currSum) > max) {
                max = currSum
            }
        }
    }
    return max
}

