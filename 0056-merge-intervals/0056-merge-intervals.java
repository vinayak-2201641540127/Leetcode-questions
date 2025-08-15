class Solution {
    public int[][] merge(int[][] intervals) {
       Arrays.sort(intervals, (a, b)->{
        if(a[0] != b[0])return Integer.compare(a[0], b[0]);
        else return Integer.compare(a[1], b[1]);
       }); 

       int prev[] = intervals[0];
       int n = intervals.length;
       List<int[]>lst = new ArrayList<>();
       for(int i=1; i<n; i++){
        int curr[] = intervals[i];
        if(curr[0] <= prev[1]){
            prev[1] = Math.max(prev[1], curr[1]);
        }else{
            lst.add(prev);
            prev = curr;
        }
       }
       lst.add(prev);
       int ans[][] = new int[lst.size()][2];
       int j = 0;
       for(int []ar: lst){
        ans[j++] = ar;
       }
       return ans;
    }
}