class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        int m = matrix.length;
        int n = matrix[0].length;
        int top = 0; 
        int bottom = m-1;
        int left = 0;
        int right = n-1;

        while(top<=bottom && left<=right){
            //first row
            for(int j=left; j<=right; j++){
                ans.add(matrix[top][j]);
            }
            top++;

            //last col
            for(int i=top; i<=bottom; i++){
                ans.add(matrix[i][right]);
            }
            right--;

            if(top<=bottom){
                //last row
                for(int j=right; j>=left; j--){
                    ans.add(matrix[bottom][j]);
                }
                bottom--;
            }

            if(left<=right){
                //1st col
                for(int i=bottom; i>=top; i--){
                    ans.add(matrix[i][left]);
                }
                left++;
            }
        }

        return ans;
    }
}