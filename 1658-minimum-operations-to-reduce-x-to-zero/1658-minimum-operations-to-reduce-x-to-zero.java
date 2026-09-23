class Solution {
    public int minOperations(int[] nums, int x) {
        int sum=0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
        }
        int target=sum-x;
        if(target==0){
            return nums.length;
        }
        if(target<0){
            return -1;
        }
        int currentsum=0;
        int maxlen=-1;
        int left=0;
        for(int right=0;right<nums.length;right++){
            currentsum+=nums[right];
            while(currentsum>target&&left<right){
                currentsum-=nums[left];
                left++;
            }
            if(currentsum==target){
                maxlen=Math.max(maxlen,right-left+1);
            }
        }
        return maxlen==-1?-1:nums.length-maxlen;
    }
}