class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>>ans = new ArrayList<>();

        for(int i=1; i<=numRows; i++){
            ans.add(generateRow(i));
        }
        return ans;
    }

    public List<Integer>generateRow(int n){
        List<Integer>row = new ArrayList<>();
        row.add(1); //add first element

        int ans = 1;
        for(int col=1; col<n; col++){//add all ele of rows
            ans *= (n-col);
            ans /= col;
            row.add(ans);
        }

        return row;
    }
}