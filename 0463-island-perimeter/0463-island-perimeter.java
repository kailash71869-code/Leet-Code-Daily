class Solution {
    public int islandPerimeter(int[][] grid) {
        int count=0;
        int[] dx={-1,1,0,0};
        int[] dy={0,0,-1,1};

        for(int row=0;row<grid.length;row++){
            for(int col=0;col<grid[0].length;col++){
                if(grid[row][col]==1){
                    for(int i=0;i<4;i++){
                        int r=row+dx[i];
                        int c=col+dy[i];

                        if(r<0 || c<0 || r>=grid.length || c>=grid[0].length || grid[r][c]==0){ 
                            count++;
                        }
                    }
                }
            }
        }
        return count;
    }
}