class Solution {
    public int calPoints(String[] operations) {
        Stack<Integer> stack = new Stack<>();
        int totalSum = 0;
        for (String op : operations) {
            if (op.equals("+")) {
                int top = stack.pop();
                int newScore = top + stack.peek();
                stack.push(top); 
                stack.push(newScore);
                totalSum += newScore;
            } else if (op.equals("D")) {
                int newScore = 2 * stack.peek();
                stack.push(newScore);
                totalSum += newScore;
            } else if (op.equals("C")) {
                totalSum -= stack.pop();
            } else {
                int score = Integer.parseInt(op);
                stack.push(score);
                totalSum += score;
            }
        }

        return totalSum;
    }
}