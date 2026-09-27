class Solution {
    String str = "";
    public String reverseParentheses(String s) {
        Stack<Character>stack = new Stack<>();
        for(int i=0; i<s.length(); i++){
            str="";
            if(s.charAt(i) == ')'){
                while(stack.peek()!='('){
                    str += stack.pop();
                }stack.pop();
                for(int j=0;j<str.length(); j++){
                    stack.push(str.charAt(j));
                }
            }else{
                stack.push(s.charAt(i));
            }
        }
        str="";
        while(!stack.isEmpty()){
            str = stack.pop() + str;
        }
        return str;
    }
}