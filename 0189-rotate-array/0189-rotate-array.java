class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        int beg = 0, end = n-1;
        k = k%n;
        while(beg<end){
            int temp = nums[beg];
            nums[beg] = nums[end];
            nums[end] = temp;
            beg++;end--;
        }

        // reverse(nums, n-k);
        beg = 0; end = k-1;
        while(beg<end){
            int temp = nums[beg];
            nums[beg] = nums[end];
            nums[end] = temp;
            beg++;
            end--;
        }

        beg = k; end = n-1;
        while(beg<end){
            int temp = nums[beg];
            nums[beg] = nums[end];
            nums[end] = temp;
            beg++;
            end--;
        }

    }
}