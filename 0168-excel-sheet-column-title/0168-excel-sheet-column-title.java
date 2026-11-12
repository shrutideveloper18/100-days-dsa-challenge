class Solution {
    public String convertToTitle(int columnNumber) {
        StringBuilder res=new StringBuilder();
        while(columnNumber>0){
            columnNumber--;
            char current=(char)('A'+(columnNumber%26));
            res.append(current);
            columnNumber/=26;
        }
        return res.reverse().toString();
    }
}