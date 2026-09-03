class Solution {
    public boolean isPalindrome(int x) {
        String n=String.valueOf(x);
        String r=new StringBuilder(n).reverse().toString();
        return n.equals(r);
    }
}