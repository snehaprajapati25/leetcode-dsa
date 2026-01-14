class Solution {
    public boolean checkValidString(String s) {
        int cntMin = 0;
        int cntMax = 0;

        for(char i: s.toCharArray()){
           
            if(i == '('){
                cntMin++;
                cntMax++;
            }else if(i == ')'){
                cntMin--;
                cntMax--;
            }else if(i == '*'){
                cntMax++; //'*' could be treated as a single left parenthesis ')' 
                cntMin--; //'*' could be treated as a single right parenthesis ')' // if `*` become `` then nothing happens
            }

            if(cntMax < 0)return false;
            if(cntMin < 0) cntMin = 0;
        }
        return cntMin == 0;
    }
}