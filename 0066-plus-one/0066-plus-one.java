class Solution {
    public int[] plusOne(int[] digits) {
        int j=0; int num = 0;

        for(int i=digits.length-1; i>=0; i--){
            //if digits[i] is less than 9 i.e last digit is less than 9
            if(digits[i]<9){
                digits[i]++;
                return digits;
            }

            //if it equals to 9
            digits[i] = 0; 
        }

        //if all digits are 9 like 999 then no becomes 1000
        int res[] = new int[digits.length+1];
        res[0] = 1;
        return res;
    }

}