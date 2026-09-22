class Solution {
    static class Node{
        int prod=1;
        int[][] count=new int[5][5];
    }
    private Node[] tree;
    private int K;
    private void merge(Node parent, Node left, Node right) {
        parent.prod = (left.prod * right.prod) % K;
        for (int initial = 0; initial < K; ++initial) {
            int rightInitial = (initial * left.prod) % K;
            for (int target = 0; target < K; ++target) {
                parent.count[initial][target] = left.count[initial][target] + right.count[rightInitial][target];
            }
        }
    }

    private void build(int node, int start, int end, int[] nums) {
        tree[node] = new Node();
        if (start == end) {
            int val = nums[start] % K;
            tree[node].prod = val;
            for (int initial = 0; initial < K; ++initial) {
                int res = (initial * val) % K;
                tree[node].count[initial][res] = 1;
            }
            return;
        }
        int mid = start + (end - start) / 2;
        build(2 * node, start, mid, nums);
        build(2 * node + 1, mid + 1, end, nums);
        merge(tree[node], tree[2 * node], tree[2 * node + 1]);
    }

    private void update(int node, int start, int end, int idx, int val) {
        if (start == end) {
            int modVal = val % K;
            tree[node].prod = modVal;
            for (int initial = 0; initial < K; ++initial) {
                for (int target = 0; target < K; ++target) {
                    tree[node].count[initial][target] = 0;
                }
                int res = (initial * modVal) % K;
                tree[node].count[initial][res] = 1;
            }
            return;
        }
        int mid = start + (end - start) / 2;
        if (idx <= mid) {
            update(2 * node, start, mid, idx, val);
        } else {
            update(2 * node + 1, mid + 1, end, idx, val);
        }
        merge(tree[node], tree[2 * node], tree[2 * node + 1]);
    }

    private int query(int node, int start, int end, int ql, int qr, int[] currentRem, int targetX) {
        if (ql <= start && end <= qr) {
            int ans = tree[node].count[currentRem[0]][targetX];
            currentRem[0] = (currentRem[0] * tree[node].prod) % K;
            return ans;
        }
        int mid = start + (end - start) / 2;
        int ans = 0;
        if (ql <= mid) {
            ans += query(2 * node, start, mid, ql, qr, currentRem, targetX);
        }
        if (qr > mid) {
            ans += query(2 * node + 1, mid + 1, end, ql, qr, currentRem, targetX);
        }
        return ans;
    }
    public int[] resultArray(int[] nums, int k, int[][] queries) {
        int n = nums.length;
        int[] result = new int[queries.length];
        if (k == 1) {
        for (int i = 0; i < queries.length; i++) {
            int startIdx = queries[i][2];
            int targetX = queries[i][3];
            
            // If target_x is 0 (since x % 1 == 0), count of valid subarrays is n - startIdx
            result[i] = (targetX == 0) ? (n - startIdx) : 0;
        }
        return result;
    }
        this.K = k;
        this.tree = new Node[4 * n];

        build(1, 0, n - 1, nums);

        
        for (int i = 0; i < queries.length; i++) {
            int idx = queries[i][0];
            int val = queries[i][1];
            int startIdx = queries[i][2];
            int targetX = queries[i][3];

            update(1, 0, n - 1, idx, val);

            int[] currentRem = new int[]{1};
            result[i] = query(1, 0, n - 1, startIdx, n - 1, currentRem, targetX); 
        }
        return result;      
    }
}