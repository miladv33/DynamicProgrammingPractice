package com.example.dynamicprogrammingpractice.slidingwindow

fun main() {
    val arrayList = arrayListOf(5, 7, 1, 4, 3, 6, 2, 9, 2)
    println(slidingWindow(arrayList))
}


/**
 * We start with the sum of the first 5 elements, then we subtract the first element and add the 6th
 * element, and we keep doing this until we reach the end of the array.
 *
 * @param arrayList The arrayList of integers to be evaluated
 * @return The largest sum of 5 consecutive elements in the array.
 */
fun slidingWindow(arrayList: ArrayList<Int>): Int {
    if (arrayList.size < 5) return -1
    var currSum = arrayList.subList(0, 4).sum()
    var largestSum = currSum
    for (i in 1..arrayList.size - 5) {
        currSum -= arrayList[i - 1]
        currSum += arrayList[i + 4]
        largestSum = currSum.coerceAtLeast(largestSum)
    }
    return largestSum
}

fun test(arrayList: ArrayList<Int>): Int {
    if (arrayList.size == 5) {
        return arrayList.sum()
    } else {
        var sum = 0
        var newSum = 0
        for (i in 0..arrayList.size) {
            if (i <= 5) {
                sum += arrayList[i]
            } else {
                newSum = sum - arrayList[i - 5] + arrayList[i]
                if (newSum > sum) {
                    sum = newSum
                }
            }
        }
        return sum
    }
}