class Solution {
    public int maxSubarraySum(int[] arr, int k) {
        // Code here
        int low=0;
        int high=k-1;
        int sum=0;
        int res=Integer.MIN_VALUE;
        for(int i=low;i<=high;i++){
            sum+=arr[i];
        }
        while(high<arr.length){
                res=Math.max(res,sum);
                low++;
                high++;
                if(high==arr.length){
                    break;
                }
                sum=sum+arr[high]-arr[low-1];
            }
        return res;
    }
}
