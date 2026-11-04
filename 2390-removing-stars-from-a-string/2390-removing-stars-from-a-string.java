class Solution {
    public String removeStars(String s) {
        int n=s.length();
        Stack<Character> st=new Stack<>();
        StringBuilder res=new StringBuilder();
        for(int i=0;i<n;i++){
            char c=s.charAt(i);
            if(c=='*'){
                if(!st.empty()){
                    st.pop();
                }
            }
            else{
                st.push(c);
            }
        }
        for(char c:st){
            res.append(c);
        }
        return res.toString();
    }
}