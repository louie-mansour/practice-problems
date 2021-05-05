package leetcode.prefixandsuffixsearch

/*
Design a special dictionary which has some words and allows you to search the words in it by a prefix and a suffix.

Implement the WordFilter class:

    WordFilter(string[] words) Initializes the object with the words in the dictionary.
    f(string prefix, string suffix) Returns the index of the word in the dictionary which has the prefix prefix and the suffix suffix.
    If there is more than one valid index, return the largest of them. If there is no such word in the dictionary, return -1.
 */

class WordFilter(words: Array<String>) {
    private val prefixSuffixDictionary = mutableMapOf<String, MutableMap<String, String>>()
    private val inputMap = mutableMapOf<String, Int>()
    private var pos = 0

    init {
        for(word in words) {
            inputMap[word] = pos
            pos += 1
            for(i in word.indices) {
                val prefix = word.substring(0..i)
                if(prefixSuffixDictionary[prefix] == null) {
                    prefixSuffixDictionary[prefix] = mutableMapOf()
                }
                for(j in word.indices) {
                    val suffix = word.substring(j until word.length)
                    val existingWord = getWord(prefix, suffix)
                    if(existingWord != null && existingWord.length > word.length) {
                        prefixSuffixDictionary[prefix]!![suffix] = existingWord
                    } else {
                        prefixSuffixDictionary[prefix]!![suffix] = word
                    }
                }
            }
        }
    }

    private fun getWord(prefix: String, suffix: String): String? {
        return prefixSuffixDictionary[prefix]?.get(suffix)
    }

    fun f(prefix: String, suffix: String): Int {
        val res = inputMap[getWord(prefix, suffix)]?: -1
        return res
    }
}