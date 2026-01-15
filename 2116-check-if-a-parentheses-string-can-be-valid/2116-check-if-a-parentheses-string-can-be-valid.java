class Solution {
    public boolean canBeValid(String s, String locked) {
// We use two greedy passes. In the first pass, we ensure no prefix has more closing than opening brackets by treating unlocked characters as '('; 

        if(s.length() % 2 != 0){
            return false;
        } 

        int bal = 0;
        for(int i=0; i<s.length(); i++){
            if(locked.charAt(i) == '0' || s.charAt(i) == '('){
                bal++;
            }else{
                bal--;
            }

            if(bal < 0) return false;
        }
//in the second pass, we ensure no suffix has more opening than closing brackets by treating unlocked characters as ')'.
        bal = 0;
        for(int i=s.length()-1; i>=0;  i--){
            if(locked.charAt(i) == '0' || s.charAt(i) == ')'){
                bal++;
            }else{
                bal--;
            }

            if(bal < 0) return false;
        }
        return true;
    }

}