class Solution {
    public String makeGood(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);
            if (!stack.isEmpty() && Math.abs(stack.peek() - currentChar) == 32) {
                stack.pop(); 
            } else {
                stack.push(currentChar);
            }
        }
        StringBuilder result = new StringBuilder();
        for (char c : stack) {
            result.append(c);
        }
        return result.toString();
    }
}