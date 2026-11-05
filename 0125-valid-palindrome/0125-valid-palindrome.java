class Solution {
    public boolean isPalindrome(String s) {
        int i=0;
        int j=s.length()-1;
        while(i<j){
            if(Character.isLetterOrDigit(s.charAt(i))&&Character.isLetterOrDigit(s.charAt(j))){
                if(Character.toLowerCase(s.charAt(i))==Character.toLowerCase(s.charAt(j))){
                    i++;
                    j--;
                }
                else{
                    return false;
                }
            }
            else if(Character.isLetterOrDigit(s.charAt(i))==false){
                i++;
            }
            else{
                j--;
            }

        }
        return true;

    }
}