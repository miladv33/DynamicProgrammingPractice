package com.example.dynamicprogrammingpractice.slidingwindow

fun main() {
//    println(permutationOfOther("xyyzxzyzxxyz", "xyz"))
    println(permutationOfOther("ab", "eidbaooo"))
}

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