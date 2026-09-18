class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int best1=nums[0];
        int maxsum=nums[0];
        int best2=nums[0];
        int minsum=nums[0];
        int res=nums[0];
        int sum=nums[0];
        for(int i=1;i<nums.length;i++){
            sum+=nums[i];
        }
        for(int i=1;i<nums.length;i++){
        int v11=nums[i]+best1;
        int v12=nums[i];
        best1=Math.max(v11,v12);
        maxsum=Math.max(maxsum,best1);
        int v21=nums[i]+best2;
        int v22=nums[i];
        best2=Math.min(v21,v22);
        minsum=Math.min(minsum,best2);
        }
        if(maxsum<0){
            return maxsum;
        }
        return Math.max(maxsum,sum-minsum);
    }
}