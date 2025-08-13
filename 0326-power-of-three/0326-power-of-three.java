class Solution {
    public boolean isPowerOfThree(int n) {
        int i=0;
        while(i<=40){
            if(Math.pow(3,i)==n)return true;
            i++;
        }
        return false;
    }
}