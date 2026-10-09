class Solution {
    public ArrayList<Integer> preGreaterEle(int[] arr) {
        // code here
        ArrayList<Integer> a=new ArrayList<>();
        Stack<Integer> st=new Stack();
        st.push(arr[0]);
        a.add(-1);
        for(int i=1;i<arr.length;i++){
            while(!st.empty()&&st.peek()<=arr[i]){
                st.pop();
            }
            if(st.empty()){
                a.add(-1);
            }
            else{
                a.add(st.peek());
            }
            st.push(arr[i]);
        }
        return a;
    }
}
