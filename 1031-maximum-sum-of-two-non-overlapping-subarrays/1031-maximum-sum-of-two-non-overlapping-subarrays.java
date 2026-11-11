
class Solution {
    public int maxSumTwoNoOverlap(int[] nums, int firstLen, int secondLen) {
        return Math.max(
            findMax(nums, firstLen, secondLen),
            findMax(nums, secondLen, firstLen)
        );
    }
    public int findMax(int[] nums, int L, int M) {
        int n = nums.length;
        int sumL = 0;
        int sumM = 0;
        int maxL = 0;
        int ans = 0;
        for (int i = 0; i < L + M; i++) {
            if (i < L) {
                sumL += nums[i];
            } else {
                sumM += nums[i];
            }
        }
        maxL = sumL;
        ans = sumL + sumM;
        for (int i = L + M; i < n; i++) {
            sumL += nums[i - M] - nums[i - M - L];
            sumM += nums[i] - nums[i - M];
            maxL = Math.max(maxL, sumL);
            ans = Math.max(ans, maxL + sumM);
        }
        return ans;
    }
}
