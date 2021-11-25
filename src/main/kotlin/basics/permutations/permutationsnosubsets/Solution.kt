package basics.permutations.permutationsnosubsets

class Solution {
    fun permutations(str: String): List<String> {
        return permutation("", str, mutableListOf())
    }

    private fun permutation(prefix: String, str: String, currentPermutations: MutableList<String>): MutableList<String> {
        if(str.isEmpty()) {
            currentPermutations.add(prefix)
            return currentPermutations
        }
        for(i in str.indices) {
            permutation(prefix + str[i], str.substring(0, i) + str.substring(i+1, str.length), currentPermutations)
        }
        return currentPermutations
    }
}