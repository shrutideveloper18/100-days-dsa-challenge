class Solution {
    public int removeDuplicates(int[] nums) {
        int unique=1;
        int i=0;
        int j=i+1;
        int n=nums.length;
        while(j<n){
            if(nums[j]==nums[j-1]){
                j++;
                continue;
            }
            nums[i+1]=nums[j];
            i++;
            j++;
            unique++;
        }
        return unique;
    }
}