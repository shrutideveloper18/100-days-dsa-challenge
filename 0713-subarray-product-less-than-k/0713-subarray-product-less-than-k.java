class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int res=0;
        int low=0;
        int pr=1;
        if(k<=1){
            return 0;
        }
        for(int high=0;high<nums.length;high++){
            pr=pr*nums[high];
            while(pr>=k){
                pr=pr/nums[low];
                low++;
            }
            res=res+high-low+1;
        }
        return res;
    }
}