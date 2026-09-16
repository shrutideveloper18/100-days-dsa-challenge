class Solution {
    public int minSubarraySum(int[] arr) {
        // code here
       int bestend=arr[0];
       int res=arr[0];
       for(int i=1;i<arr.length;i++){
           int v1=arr[i]+bestend;
           int v2=arr[i];
           bestend=Math.min(v1,v2);
           res=Math.min(bestend,res);
       }
       return res;
    }
}
