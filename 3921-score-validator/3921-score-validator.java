class Solution {
    public int[] scoreValidator(String[] events) {
        int score = 0;
        int counter = 0;

        for(String i: events){
            if(counter == 10){
               break;
            }
            
            if (i.equals("W")){
                counter++;
            }else if(i.equals("WD") || i.equals("NB")){
                score++;
            }else{
                score += Integer.parseInt(i);
            }
        }

        return new int[]{score, counter}; 
    }
}