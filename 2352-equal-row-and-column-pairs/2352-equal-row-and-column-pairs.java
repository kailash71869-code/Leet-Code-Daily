class Solution {
    public int equalPairs(int[][] grid) {
        int n=grid.length;
        Map<List<Integer>,Integer> map=new HashMap<>();
        for(int row=0;row<n;row++){
            List<Integer> rowset=new ArrayList<>();
            for(int col=0;col<n;col++){
                rowset.add(grid[row][col]);
            }
            map.put(rowset,map.getOrDefault(rowset,0)+1);
        }
        int count=0;
        for(int col=0;col<n;col++){
            List<Integer> colset=new ArrayList<>();
            for(int row=0;row<n;row++){
                colset.add(grid[row][col]);
            }
            count+=map.getOrDefault(colset,0);
        }
        return count;
    }
}