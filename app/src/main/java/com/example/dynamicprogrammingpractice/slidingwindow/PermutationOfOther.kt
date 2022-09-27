package com.example.dynamicprogrammingpractice.slidingwindow

fun main() {
//    println(permutationOfOther("xyyzxzyzxxyz", "xyz"))
    println(permutationOfOther("ab", "eidbaooo"))
}

/**
 * It takes a string and a pattern, and returns true if the string contains a substring that is a
 * permutation of the pattern
 *
 * @param string "oidbcaf"
 * @param pattern "abbc"
 * @return a list of indices where the pattern is found in the string.
 */
fun permutationOfOther(string: String, pattern: String):Boolean {
    val result = arrayListOf<Int>()
    var substring = ""
    for (i in string.indices) {
        substring += string[i]
        if (substring.length == pattern.length) {
            if (substring.toCharArray().sorted() == pattern.toCharArray().sorted()) {
                result.add(i - pattern.length + 1)
            }
            substring = substring.drop(1)
        }
    }
    return result.isNotEmpty()
}