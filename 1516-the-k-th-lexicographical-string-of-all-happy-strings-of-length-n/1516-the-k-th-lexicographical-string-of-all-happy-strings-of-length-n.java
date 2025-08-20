class Solution {
    public String getHappyString(int n, int k) {
        Queue<String>queue = new LinkedList<>();
        do{
            String curr = queue.isEmpty()?"":queue.poll();
            for(char ch='a'; ch<='c'; ch++){
                if(!curr.isEmpty() && curr.charAt(curr.length()-1) == ch)continue;
                if(curr.length() == n)return "";
                if(curr.length()+1 == n)k--;
                String res = curr+ch;
                if(k == 0)return res;
                queue.offer(res);
            }
        }while(!queue.isEmpty());
        return "";
    }
}