
class Solution {
    public int kConcatenationMaxSum(int[] arr, int k) {
        long mod = 1000000007;
        long total = 0;
        for (int num : arr) {
            total += num;
        }
        long curr = 0;
        long maxSum = 0;
        int limit = (k == 1) ? 1 : 2;
        for (int i = 0; i < arr.length * limit; i++) {
            curr = Math.max(0, curr + arr[i % arr.length]);
            maxSum = Math.max(maxSum, curr);
        }
        if (k > 2 && total > 0) {
            maxSum += (long)(k - 2) * total;
        }
        return (int)(maxSum % mod);
    }
}
