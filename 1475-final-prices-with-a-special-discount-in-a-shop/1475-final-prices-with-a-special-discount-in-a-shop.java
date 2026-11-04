class Solution {
    public int[] finalPrices(int[] prices) {
        Stack<Integer> st=new Stack<>();
        int[] res=new int[prices.length];
        for(int i=0;i<prices.length;i++){
            int c=prices[i];
            int j=i+1;
            while(j<prices.length){
                int d=prices[j];
                if(c>=d){
                    c=c-d;
                    break;
                }
                j++;  
            }
            st.push(c);
            res[i]=c;
        }
        return res;
    }
}