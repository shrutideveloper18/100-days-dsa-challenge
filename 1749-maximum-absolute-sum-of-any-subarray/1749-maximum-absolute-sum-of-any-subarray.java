class Solution {
    public int maxAbsoluteSum(int[] nums) {
        int maxsum=nums[0];
        int minsum=nums[0];
        int res=Math.abs(nums[0]);
        for(int i=1;i<nums.length;i++){
            int v1=nums[i]+maxsum;
            int v2=nums[i];
            maxsum=Math.max(v1,v2);

            int v3=minsum+nums[i];
            int v4=nums[i];
            minsum=Math.min(v3,v4);

            res=Math.max(res,Math.max(maxsum,Math.abs(minsum)));
        }
        return res;
    }
}