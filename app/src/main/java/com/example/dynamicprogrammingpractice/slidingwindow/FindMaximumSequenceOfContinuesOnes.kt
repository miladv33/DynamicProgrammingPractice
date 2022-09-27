package com.example.dynamicprogrammingpractice.slidingwindow

fun main() {
    val intArray = intArrayOf(0, 0, 1, 0, 1, 1, 1, 0, 1, 1)
    print(findMaximumSequenceOfContinuesOnes(intArray))
}

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