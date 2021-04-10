package `4sum`

class Solution {
    fun fourSum(nums: IntArray, target: Int): List<List<Int>> {
        val fourSumSets = mutableSetOf<List<Int>>()
        val runningSet = mutableSetOf<Int>()
        var current: Int
        for(i in nums.indices) {
            for(j in i+1 until nums.size) {
                for(k in j+1 until nums.size) {
                    current = nums[i] + nums[j] + nums[k]
                    if(runningSet.contains(target - current)) {
                        fourSumSets.add(listOf(nums[i], nums[j], nums[k], target - current).sorted())
                    }
                    runningSet.add(nums[k])
                }
                runningSet.clear()
            }
        }
        return fourSumSets.map { it.toList() }
    }
}