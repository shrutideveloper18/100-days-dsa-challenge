class Solution {
    public int maxSubArray(int[] nums) {
        int bestend=nums[0];
        int res=nums[0];
        for(int i=1;i<nums.length;i++){
            int v1=bestend+nums[i];
            int v2=nums[i];
            bestend=Math.max(v1,v2);
            res=Math.max(bestend,res);
        }
        return res;
    }
}