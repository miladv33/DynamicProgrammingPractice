package com.example.dynamicprogrammingpractice.slidingwindow

fun main() {
    val intArray = intArrayOf(0, 0, 1, 0, 1, 1, 1, 0, 1, 1)
    print(findMaximumSequenceOfContinuesOnes(intArray))
}

/**
 * It takes an array of integers, and returns the index of the last zero in the array
 *
 * @param intArray The array of integers that we want to find the maximum sequence of continues ones
 * in.
 * @return The index of the last zero in the array.
 */
fun findMaximumSequenceOfContinuesOnes(intArray: IntArray): Int {
    var subArray = intArrayOf()
    var zeroCountIntList = 0
    var indexOfZero = -1
    for (i in intArray.indices) {
        subArray += intArray[i]
        if (intArray[i] == 0) {
            zeroCountIntList++
            indexOfZero = i
        }
        if (zeroCountIntList > 1) {
            subArray = subArray.drop(1).toIntArray()
            zeroCountIntList--
        }
    }
    return indexOfZero
}