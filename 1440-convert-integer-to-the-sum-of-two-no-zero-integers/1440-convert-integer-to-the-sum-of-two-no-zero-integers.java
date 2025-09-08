class Solution {

    public boolean check(int a, int b){
        while(a!=0){
            int d = a%10;
            if(d == 0)return false;
            a/=10;
        }
        a=b;
        while(a!=0){
            int d = a%10;
            if(d == 0)return false;
            a/=10;
        }
        return true;
    }

    public int[] getNoZeroIntegers(int n) {
        int []ans = new int[2];
        for(int i=1; i<n; i++){
            int val = n-i;
            if(check(i, n-i)){
                ans[0] = i;
                ans[1] = n-i;
                return ans;
            }
        }
        return ans;
    }
}