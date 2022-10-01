package com.example.dynamicprogrammingpractice.slidingwindow

import androidx.annotation.RequiresApi
import android.os.Build
import java.util.HashMap

@RequiresApi(Build.VERSION_CODES.N)
fun main() {
    val solution = Solution()
    println(solution.minWindow("AGNBCABNMOBQANC", "ABC"))
}

internal class Solution {

    /**
     * We keep expanding the window to the right until we get a desirable window i.e. a window that
     * contains all the characters of t. Then we contract (if possible) and save the smallest window
     * till now. Then, we keep expanding the window again
     *
     * @param s The string to be searched in.
     * @param t the string that contains all the characters of the desired minimum window in it.
     * @return The smallest window in s which has all the characters in t.
     */
    @RequiresApi(Build.VERSION_CODES.N)
    fun minWindow(s: String, t: String): String {
        if (s.isEmpty() || t.isEmpty()) {
            return ""
        }
        // Dictionary which keeps a count of all the unique characters in t.
        val dictT: MutableMap<Char, Int> = HashMap()
        for (i in t.indices) {
            val count = dictT.getOrDefault(t[i], 0)
            dictT[t[i]] = count + 1
        }
        // Number of unique characters in t, which need to be present in the desired window.
        val required = dictT.size

        // Left and Right pointer
        var l = 0
        var r = 0
        // formed is used to keep track of how many unique characters in t
        // are present in the current window in its desired frequency.
        // e.g. if t is "AABC" then the window must have two A's, one B and one C.
        // Thus formed would be = 3 when all these conditions are met.
        var formed = 0

        // Dictionary which keeps a count of all the unique characters in the current window.
        val windowCounts: MutableMap<Char, Int> = HashMap()

        // ans list of the form (window length, left, right)
        val ans = intArrayOf(-1, 0, 0)
        while (r < s.length) {
            // Add one character from the right to the window
            var c = s[r]
            val count = windowCounts.getOrDefault(c, 0)
            windowCounts[c] = count + 1

            // If the frequency of the current character added equals to the
            // desired count in t then increment the formed count by 1.
            if (dictT.containsKey(c) && windowCounts[c]!!.toInt() == dictT[c]!!.toInt()) {
                formed++
            }

            // Try and contract the window till the point where it ceases to be 'desirable'.
            while (l <= r && formed == required) {
                c = s[l]
                // Save the smallest window until now.
                if (ans[0] == -1 || r - l + 1 < ans[0]) {
                    ans[0] = r - l + 1
                    ans[1] = l
                    ans[2] = r
                }

                // The character at the position pointed by the
                // `Left` pointer is no longer a part of the window.
                windowCounts[c] = windowCounts[c]!! - 1
                if (dictT.containsKey(c) && windowCounts[c]!!.toInt() < dictT[c]!!.toInt()) {
                    formed--
                }

                // Move the left pointer ahead, this would help to look for a new window.
                l++
            }

            // Keep expanding the window once we are done contracting.
            r++
        }
        return if (ans[0] == -1) "" else s.substring(ans[1], ans[2] + 1)
    }
}