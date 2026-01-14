class Solution {
    public boolean checkValidString(String s) {
        
        int cntMin = 0; //no of opening brackets
        int cntMax = 0; //no of closing brackets

        for(char i: s.toCharArray()){
           
            if(i == '('){
                cntMin++;
                cntMax++;
            }else if(i == ')'){
                cntMin--;
                cntMax--;
            }else if(i == '*'){
                cntMax++; // treat '*' as '('
                cntMin--; // treat '*' as ')' become `` then nothing happens
            }

            if(cntMax < 0)return false; //We have closed more brackets than we could ever open or invalid case
            if(cntMin < 0) cntMin = 0;
        }
        return cntMin == 0;
    }
}