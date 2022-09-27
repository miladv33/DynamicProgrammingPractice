package com.example.dynamicprogrammingpractice.slidingwindow

fun main() {
//    val string = "findlongestsubstring"
    val string = "aaaaaabbbbbbabcdefgh"
    println(findLongestDistinctSubstring(string))
}

/**
 * We iterate through the string, adding each character to a substring. If the substring is distinct,
 * we check if it's longer than the longest substring we've found so far. If it's not distinct, we drop
 * the first character of the substring and continue
 *
 * @param string The string to find the longest distinct substring in.
 * @return The longest substring of the string that is distinct.
 */
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