package leetcode.simplifypath

import java.util.*

/*
Given a string path, which is an absolute path (starting with a slash '/') to a file or directory in a Unix-style file system, convert it to the simplified canonical path.
 */

class Solution {
    fun simplifyPath(path: String): String {
        val pathStack = Stack<String>()
        for(word in path.split('/')) {
            if(word == "" || word == ".") {
                continue
            }
            if(word == "..") {
                if(!pathStack.empty()) {
                    pathStack.pop()
                }
                continue
            }
            pathStack.push(word)
        }
        if(pathStack.empty()) {
            return "/"
        }
        val sb = StringBuilder()
        for(word in pathStack) {
            sb.append("/$word")
        }
        return sb.toString()
    }
}