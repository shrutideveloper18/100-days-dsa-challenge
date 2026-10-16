import java.util.HashMap;
import java.util.Map;

class Solution {
    static final int MOD = 1000000007;

    // Segment tree nodes to store sum of squares and sum of elements
    long[] sumSq;
    long[] sumVals;
    long[] lazy;

    public int sumCounts(int[] nums) {
        int n = nums.length;
        sumSq = new long[4 * n];
        sumVals = new long[4 * n];
        lazy = new long[4 * n];

        Map<Integer, Integer> lastPos = new HashMap<>();
        long totalSum = 0;
        long currentTotalSq = 0;

        for (int j = 0; j < n; j++) {
            int val = nums[j];
            int p = lastPos.getOrDefault(val, -1);
            
            // Update range [p + 1, j] by adding 1
            if (p + 1 <= j) {
                update(1, 0, n - 1, p + 1, j, 1);
            }
            lastPos.put(val, j);

            // sumSq[1] holds the total sum of squares of distinct counts ending at current index j
            totalSum = (totalSum + sumSq[1]) % MOD;
        }

        return (int) totalSum;
    }

    private void pushDown(int node, int l, int r) {
        if (lazy[node] != 0) {
            int mid = (l + r) / 2;
            apply(2 * node, l, mid, lazy[node]);
            apply(2 * node + 1, mid + 1, r, lazy[node]);
            lazy[node] = 0;
        }
    }

    private void apply(int node, int l, int r, long v) {
        long len = (r - l + 1);
        // (c + v)^2 = c^2 + 2*c*v + v^2
        sumSq[node] = (sumSq[node] + 2 * v * sumVals[node] + v * v * len) % MOD;
        sumVals[node] = (sumVals[node] + v * len) % MOD;
        lazy[node] = (lazy[node] + v) % MOD;
    }

    private void update(int node, int l, int r, int ql, int qr, long v) {
        if (ql <= l && r <= qr) {
            apply(node, l, r, v);
            return;
        }
        pushDown(node, l, r);
        int mid = (l + r) / 2;
        if (ql <= mid) update(2 * node, l, mid, ql, qr, v);
        if (qr > mid) update(2 * node + 1, mid + 1, r, ql, qr, v);
        
        sumSq[node] = (sumSq[2 * node] + sumSq[2 * node + 1]) % MOD;
        sumVals[node] = (sumVals[2 * node] + sumVals[2 * node + 1]) % MOD;
    }
}