package com.example.dynamicprogrammingpractice.slidingwindow

import androidx.compose.runtime.currentComposer

fun main() {
//    var string = "aabacbebebe"
//    var string = "aabbcc"
    var string = "abcabcbb"
//    var string = "abcdss"
    longestDistinctSubstring(string, 2)
}

fun longestDistinctSubstring(string: String, k: Int) {
    var substring = ""
    for (i in string.indices) {
        substring += string[i]
        if (substring.toCharArray().distinct().size > k) {
            substring = substring.drop(1)
        }
    }
    println(substring.length)
    println(substring)
}

