import java.util.Stack;

class Solution {
    // Helper class to store character and its frequency pair
    static class Pair {
        char character;
        int count;

        Pair(char character, int count) {
            this.character = character;
            this.count = count;
        }
    }

    public String removeDuplicates(String s, int k) {
        int n = s.length();
        Stack<Pair> st = new Stack<>();

        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);

            // If stack is empty
            if (st.isEmpty()) {
                st.push(new Pair(c, 1));
                continue;
            }

            // If top character doesn't match current character
            if (st.peek().character != c) {
                st.push(new Pair(c, 1));
                continue;
            }

            // If top character matches and frequency is less than k - 1
            if (st.peek().count < k - 1) {
                Pair p = st.peek();
                st.pop();
                st.push(new Pair(p.character, p.count + 1));
                continue;
            }

            // If frequency reaches k - 1, remove the element (pops the (k-1)th element)
            st.pop();
        }

        // Reconstruct the final string from the stack
        StringBuilder sb = new StringBuilder();
        for (Pair p : st) {
            sb.append(String.valueOf(p.character).repeat(p.count));
        }

        return sb.toString();
    }
}