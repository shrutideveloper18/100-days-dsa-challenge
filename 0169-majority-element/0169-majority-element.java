class Solution {
    public int majorityElement(int[] nums) {
        int res=nums[0];
        int f=nums.length/2;
        Arrays.sort(nums);
        int freq=1;
        for(int i=0;i<nums.length-1;i++){
            
            if(nums[i]==nums[i+1]){
                freq++;
            }
            else{
                freq=1;
            }
            if(freq>f){
                res=nums[i];
                break;
            }
        }
        return res;
    }
}