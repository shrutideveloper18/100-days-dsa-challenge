class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        int n = nums1.length;
        long totalK = (long) k1 + k2;
        
        // Step 1: Calculate absolute differences and their frequencies
        // Max possible difference is 10^5 based on constraints
        long[] count = new long[100005];
        long maxDiff = 0;
        
        for (int i = 0; i < n; i++) {
            int diff = Math.abs(nums1[i] - nums2[i]);
            count[diff]++;
            if (diff > maxDiff) {
                maxDiff = diff;
            }
        }
        
        // Step 2: Greedily reduce the largest differences
        for (long d = maxDiff; d > 0 && totalK > 0; d--) {
            if (count[(int) d] == 0) continue;
            
            // Determine how many elements of difference `d` we can reduce
            long take = Math.min(totalK, count[(int) d]);
            
            count[(int) d] -= take;
            count[(int) d - 1] += take;
            totalK -= take;
        }
        
        // Step 3: Calculate the final minimum sum of squared differences
        long minSum = 0;
        for (int d = 1; d <= maxDiff; d++) {
            if (count[d] > 0) {
                minSum += count[d] * (long) d * d;
            }
        }
        
        return minSum;
    }
}