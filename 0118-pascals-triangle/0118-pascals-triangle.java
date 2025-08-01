class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>>ans = new ArrayList<>();
        for(int i=0; i<numRows; i++){
            List<Integer>lst = new ArrayList<>();
            for(int j=0; j<=i; j++){
                lst.add(nCr(i, j));
            }
            ans.add(lst);
        }
        return ans;
    }

    public int nCr(int n, int r){
        if(n-r < r)r = n-r;
        int val = 1;
        for(int i=0; i<r; i++){
            val *= (n-i);
            val /= i+1;
        }
        return val;
    }

}