class Solution {
    public int romanToInt(String s) {
        int number=0;
        HashMap<Character,Integer> f=new HashMap<>();
        f.put('I',1);
        f.put('V',5);
        f.put('X',10);
        f.put('L',50);
        f.put('C',100);
        f.put('D',500);
        f.put('M',1000);
        for(int i=0;i<s.length();i++){
            if(i<s.length()-1&&f.get(s.charAt(i))<f.get(s.charAt(i+1))){
                number-=f.get(s.charAt(i));
            }
            else{
                number+=f.get(s.charAt(i));
            }
        }
        return number;
    }
}