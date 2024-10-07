/*
 * @lc app=leetcode id=2696 lang=java
 *
 * [2696] Minimum String Length After Removing Substrings
 */
C:\Users\VINAYAK SHUKLA\.leetcode\2696.minimum-string-length-after-removing-substrings.java
// @lc code=start
class Solution {
    public int minLength(String s) {
        Stack<Character>stack = new Stack<>();
        int i=0;
        while(i<s.length()){
            if(stack.isEmpty()){
                stack.push(s.charAt(i));
            }
            else if(s.charAt(i) == 'D' && stack.peek() == 'C'){
                stack.pop();
            }
            else if(s.charAt(i) == 'B' && stack.peek() == 'A'){
                stack.pop();
            }
            else{ 
                stack.push(s.charAt(i));
            }
            i++;
            // System.out.println(stack);
        }
        return stack.size();
    }
}
// @lc code=end

