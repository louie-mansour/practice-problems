package basics.sorting.quicksort

class Solution {
    fun quicksort(input: IntArray): IntArray {
        val sortingArray = input.copyOf()
        quicksort(sortingArray, 0, sortingArray.size - 1)
        return sortingArray
    }

    private fun quicksort(input: IntArray, left: Int, right: Int) {
        if(left >= right) {
            return
        }
        val index = partition(input, left, right)
        quicksort(input, left, index - 1)
        quicksort(input, index, right)
    }

    private fun partition(input: IntArray, left: Int, right: Int): Int {
        var l = left
        var r = right
        val pivot = input[(left + right) / 2]
        var tmp: Int
        while(l <= r) {
            while(input[l] < pivot) {
                l += 1
            }
            while(input[r] > pivot) {
                r -= 1
            }
            if(l <= r) {
                tmp = input[l]
                input[l] = input[r]
                input[r] = tmp
                l += 1
                r -= 1
            }
        }
        return l
    }
}