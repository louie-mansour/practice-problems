package basics.permutationsofsets

class Solution {
    fun permutations(str: String): List<String> {
        return permutation("", str, mutableListOf())
    }

    private fun permutation(prefix: String, str: String, currentPermutations: MutableList<String>): MutableList<String> {
        if(!prefix.isEmpty()) {
            currentPermutations.add(prefix)
        }
        for(i in str.indices) {
            permutation(prefix + str[i], str.substring(i+1, str.length), currentPermutations)
        }
        return currentPermutations
    }
}