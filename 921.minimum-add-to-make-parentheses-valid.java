/*
 * @lc app=leetcode id=921 lang=java
 *
 * [921] Minimum Add to Make Parentheses Valid
 */

// @lc code=start
class Solution {
    public int minAddToMakeValid(String s) {
        Stack<Character>stack =  new Stack<>();
        for(int i=0; i<s.length(); i++){
            if(!stack.isEmpty() && s.charAt(i) == ')' && stack.peek() == '(')stack.pop();
            else stack.push(s.charAt(i)); 
        }
        return stack.size();
    }
}
// @lc code=end

