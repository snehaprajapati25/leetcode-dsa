class Solution {
    public int reverse(int x) {
        int rev = 0;
        while(x != 0){
            int digit = x % 10;

            //overflow condition
//“Before doing rev = rev * 10 + digit, I check whether multiplying the current result by 10 will exceed the integer limits. If the current value is greater than Integer.MAX_VALUE / 10, then multiplying by 10 will definitely overflow. If it is equal to MAX_VALUE / 10, then I check whether the next digit exceeds the last allowed digit, which is 7. Similarly, for negative numbers, I check against Integer.MIN_VALUE / 10 and the last digit -8.
            
            if(rev > Integer.MAX_VALUE/10 || rev == Integer.MAX_VALUE/10 && digit > 7){
                return 0;
            }

            if(rev < Integer.MIN_VALUE/10 || rev == Integer.MIN_VALUE/10 && digit < -8){
                return 0;
            }

             rev = rev * 10 + digit;
            x/=10;
        }

        return rev;
    }
}