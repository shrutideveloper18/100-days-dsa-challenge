class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int max=Integer.MAX_VALUE;
        Arrays.sort(nums);
        int sum=nums[0]+nums[1]+nums[2];
        
        for(int i=0;i<nums.length;i++){
            int l=i+1;
            int r=nums.length-1;
            while(l<r){
                int s=nums[i]+nums[l]+nums[r];
                if(Math.abs(s-target)<Math.abs(sum-target)){
                sum=s;}
                
                if(s<target){
                    l++;
                }
                else if(s>target){
                    r--;
                }
                else{
                    return s;
                }
            }
        }
        return sum;
        
    }
}