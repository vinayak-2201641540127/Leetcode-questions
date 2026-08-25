class Solution {
    public int missingMultiple(int[] nums, int k) {
        TreeSet<Integer>set = new TreeSet<>();
        for(int i:nums){
            set.add(i);
        }

        int mult = 1;
        while(true){
            if(set.contains(k*mult)){
                set.remove(k*mult);
                mult++;

            }else return k*mult;
        }
        // return k;
    }
}