class Solution {
    public long[] resultArray(int[] nums, int k) {
        long[] ans=new long[k];
        long[] dp=new long[k];
        for(int n:nums){
            long[] nextdp=new long[k];
            int mod=n%k;
            nextdp[mod]++;
            for(int r=0;r<k;++r){
                if(dp[r]>0){
                    int nextmod=(r*mod)%k;
                    nextdp[nextmod]+=dp[r];
                }
            }
            for(int r=0;r<k;r++){
                ans[r]+=nextdp[r];
            }
            dp=nextdp;
        }
        
        return ans;
    }
    
}