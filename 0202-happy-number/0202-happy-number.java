class Solution {
    int fn(int n){
        int sum=0;
        while(n>0){
            int d=n%10;
            n=n/10;
            sum=sum+d*d;
        }
        return sum;
    }
    public boolean isHappy(int n) {
        int slow=n;
        int fast=n;
        while(fast!=1){
            slow=fn(slow);
            fast=fn(fast);
            fast=fn(fast);
            if(slow==fast && slow!=1){
                return false;
            }
        }
        return true;
    }
}