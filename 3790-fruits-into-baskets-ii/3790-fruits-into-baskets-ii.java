class Solution {
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        int n = fruits.length;
        int ans = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(baskets[j] == -1)continue;
                if(baskets[j]>=fruits[i]){
                    baskets[j] = -1;
                    fruits[i] = 0;
                    break;
                }   
            }
            if(fruits[i] != 0)ans++;

        }
        return ans;
    }
}