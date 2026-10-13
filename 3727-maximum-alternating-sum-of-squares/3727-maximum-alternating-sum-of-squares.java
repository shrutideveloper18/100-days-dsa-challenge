import java.util.Arrays;

class Solution {
    public long maxAlternatingSum(int[] nums) {
        int n = nums.length;
        long[] squares = new long[n];
        
        for (int i = 0; i < n; i++) {
            squares[i] = (long) nums[i] * nums[i];
        }
        
        Arrays.sort(squares);
        
        long score = 0;
        int mid = n / 2;
        
        // Subtract the first half (smallest squares)
        for (int i = 0; i < mid; i++) {
            score -= squares[i];
        }
        
        // Add the second half (largest squares)
        for (int i = mid; i < n; i++) {
            score += squares[i];
        }
        
        return score;
    }
}