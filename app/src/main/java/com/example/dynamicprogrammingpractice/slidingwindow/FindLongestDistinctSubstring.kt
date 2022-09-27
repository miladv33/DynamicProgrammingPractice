package com.example.dynamicprogrammingpractice.slidingwindow

fun main() {
//    val string = "findlongestsubstring"
    val string = "aaaaaabbbbbbabcdefgh"
    println(findLongestDistinctSubstring(string))
}

fun findLongestDistinctSubstring(string: String): String {
    var substring = ""
    var longestSubstring = ""
    for (i in string.indices) {
        substring += string[i]
        if (substring.toCharArray().distinct().size == substring.length) { // if the substring is distinct
            if (longestSubstring.length <= substring.length) {
                longestSubstring = substring
            }
        } else {
            substring = substring.drop(1)
        }
    }
    return longestSubstring
}