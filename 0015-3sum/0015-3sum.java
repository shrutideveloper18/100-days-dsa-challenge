class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        
        
        for(int i=0;i<nums.length;i++){
            int l=i+1;
            int r=nums.length-1;
            int sum=-1*nums[i];
            
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            while(l<r){
                int s=nums[l]+nums[r];
                if(s==sum){
                    ans.add(Arrays.asList(
                        nums[i],
                        nums[l],
                        nums[r]
                    ));
                    while(l<r && nums[l]==nums[l+1]){
                        l++;
                        }
                    while(r>l&&nums[r]==nums[r-1]){
                        r--;
                        }
                    l++;
                    r--;
                }
                
                else if(s<sum){
                l++;
            }
            else{
                r--;
            }
                }
            
            
        }
        return ans;
    }
}