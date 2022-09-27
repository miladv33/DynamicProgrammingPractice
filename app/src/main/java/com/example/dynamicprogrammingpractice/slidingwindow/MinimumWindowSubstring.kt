package com.example.dynamicprogrammingpractice.slidingwindow

import java.util.Collections.min

//https://leetcode.com/problems/minimum-window-substring/

fun main() {
//    println(minWindow("ADOBECODEBANC", "ABC") == "BANC")
//    println(minWindow("a", "a") == "a")
//    println(minWindow("a", "") == "")
    minWindow("AGNBCABNMOBQANC", "ABC")
}

fun minWindow(string: String, target: String): String {
    var minSizeOfList = Int.MAX_VALUE
    var lastWordFound = '.'
    val foundSizeMap = mutableMapOf<Char, Int>()
    val lastIndexOfWordMap = mutableMapOf<Char, Int>()
    val wordCountMap = mutableMapOf<Char, Int>()
    var subString = ""
    var shortestSubstring = ""
    for (c in target) {
        wordCountMap[c] = target.count { it == c }
    }
    for (i in wordCountMap) {
        foundSizeMap[i.key] = 0
    }
    for (i in string.indices) {
        subString = string
        subString = subString.drop(lastIndexOfWordMap[lastWordFound] ?: 0)
        if (target.contains(string[i])) {
            lastIndexOfWordMap[string[i]] = i
            foundSizeMap[string[i]] = foundSizeMap[string[i]]?.plus(1) ?: 0
            lastWordFound = string[i]
            if (subString.toSet().containsAll(target.toSet())) {
                if (subString.length < minSizeOfList) {
                    minSizeOfList = subString.length
                    shortestSubstring = subString
                }
            }
        }
    }
    return shortestSubstring
}