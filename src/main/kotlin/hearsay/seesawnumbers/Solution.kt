package hearsay.seesawnumbers

class Solution {
    fun numberOfSeesawPatterns(nums: List<Int>): Int {
        var prev: Int? = null
        var prevPrev: Int? = null
        var currentRun = 0
        var total = 0
        for(num in nums) {
            if (isSeeSaw(prevPrev, prev, num)) {
                currentRun += 1
                total += currentRun
            } else {
                currentRun = 0
            }
            prevPrev = prev
            prev = num
        }
        return total
    }

    private fun isSeeSaw(prevPrev: Int?, prev: Int?, num: Int): Boolean {
        if (prevPrev == null || prev == null) {
            return false
        }
        if(prevPrev > prev && prev < num
            || prevPrev < prev && prev > num) {
            return true
        }
        return false
    }
}