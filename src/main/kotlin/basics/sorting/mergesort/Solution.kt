package basics.sorting.mergesort

class Solution {
    fun mergesort(input: IntArray): IntArray {
        val helper = IntArray(input.size)
        val sortedArray = input.copyOf()
        mergesort(sortedArray, helper, 0, sortedArray.size - 1)
        return sortedArray
    }

    private fun mergesort(input: IntArray, helper: IntArray, lo: Int, hi: Int) {
        if(lo < hi) {
            val mid = (lo + hi) / 2
            mergesort(input, helper, lo, mid)
            mergesort(input, helper, mid + 1, hi)
            merge(input, helper, lo, mid, hi)
        }
    }

    private fun merge(input: IntArray, helper: IntArray, lo: Int, mid: Int, hi: Int) {
        for(i in lo..hi) {
            helper[i] = input[i]
        }

        var helperLeft = lo
        var helperRight = mid + 1
        var inputPosition = lo

        while(helperLeft <= mid && helperRight <= hi) {
            if(helper[helperLeft] <= helper[helperRight]) {
                input[inputPosition] = helper[helperLeft]
                helperLeft += 1
            } else {
                input[inputPosition] = helper[helperRight]
                helperRight += 1
            }
            inputPosition += 1
        }

        val remaining = mid - helperLeft
        for(i in 0..remaining) {
            input[inputPosition + i] = helper[helperLeft + i]
        }
    }
}