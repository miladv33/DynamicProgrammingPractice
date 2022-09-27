package com.example.dynamicprogrammingpractice.slidingwindow

import java.lang.Math.max

/**
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/
 */

fun main() {
    println(lengthOfLongestSubstring("abcabcbb")) // abc 3
    println(lengthOfLongestSubstring("bbbbb")) // b 1
    println(lengthOfLongestSubstring("pwwkew")) // pwke 3
}

/**
 * We iterate through the string, adding each character to a substring. If the substring contains only
 * unique characters, we check if the length of the substring is greater than the current max substring
 * length. If the substring contains duplicate characters, we remove the first character from the
 * substring
 *
 * @param string The string to find the longest substring of.
 * @return The length of the longest substring without repeating characters.
 */
fun lengthOfLongestSubstring(string: String): Int {
    var subString = ""
    var maxsubStringSize = 0
    for (i in string.indices) {
        subString += string[i]
        if (subString.toCharArray().distinct().size == subString.length) {
            maxsubStringSize = Math.max(subString.length, maxsubStringSize)
        } else {
            subString = subString.drop(1)
        }
    }
    return maxsubStringSize
}