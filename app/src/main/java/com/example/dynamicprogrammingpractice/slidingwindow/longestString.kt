package com.example.dynamicprogrammingpractice.slidingwindow

import androidx.compose.runtime.currentComposer

fun main() {
    var string1 = "aabacbebebe"
    var string2 = "aabbcc"
    var string3 = "abcabcbb"
    var string4 = "abcdss"
    println(longestDistinctSubstring(string1, 2)) // bebebe
    println(longestDistinctSubstring(string2, 2)) //
    println(longestDistinctSubstring(string3, 2)) //
    println(longestDistinctSubstring(string4, 2)) //
    println("-------------")
    println(betterLongestDistinctSubstring(string1, 2)) // bcbb
    println(betterLongestDistinctSubstring(string2, 2)) // bcbb
    println(betterLongestDistinctSubstring(string3, 2)) // bcbb
    println(betterLongestDistinctSubstring(string4, 2)) // bcbb
}


/**
 * It iterates through the string, adding each character to a substring, and if the substring has more
 * than k distinct characters, it drops the first character of the substring
 *
 * @param string The string to search for the longest substring in.
 * @param k the number of distinct characters in the substring
 * @return The longest substring of the input string that contains no more than k distinct characters.
 */
fun longestDistinctSubstring(string: String, k: Int): String {
    var substring = ""
    for (i in string.indices) {
        substring += string[i]
        if (substring.toCharArray().distinct().size > k) {
            substring = substring.drop(1)
        }
    }
    return substring
}

/**
 * If the substring from the pointer to the current index has more than k distinct characters,
 * increment the pointer.
 *
 * @param string The string to find the longest substring of.
 * @param k the number of distinct characters allowed in the substring
 * @return The longest substring of the string that has at most k distinct characters.
 */
fun betterLongestDistinctSubstring(string: String, k: Int): String {
    var pointer = 0
    for (i in string.indices) {
        if (string.substring(pointer, i+1).toCharArray().distinct().size > k) {
            pointer++
        }
    }
    return string.substring(pointer)
}

