class Solution {
    public String removeDuplicates(String s) {
        Stack<Character> st=new Stack<>();
        StringBuilder res=new StringBuilder();
        for(int i=0;i<s.length();i++){
            if(st.empty()){
                st.push(s.charAt(i));
                continue;
            }
            if(st.peek()==s.charAt(i)){
                st.pop();
                continue;
            }
            else{
                char c = s.charAt(i);
                st.push(c);
            }
        }
        for(char c:st){
            res.append(c);
        }
        return res.toString();
    }
}