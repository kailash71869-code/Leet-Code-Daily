class Solution {
    int[] dx={-1,1,0,0};
    int[] dy={0,0,-1,1};
    public int countIslands(int[][] grid, int k) {
        int count=0;
        int R=grid.length;
        int C=grid[0].length;
         for(int row=0;row<R;row++){
            for(int col=0;col<C;col++){
                if(grid[row][col]!=0){
                    long total=dfs(grid,row,col);
                    if(total%k==0){
                        count++;
                    }
                }
            }
         }
         return count;
    }
    public long dfs(int[][] grid,int row,int col){
        if(row<0 || col<0 || row>=grid.length || col>=grid[0].length ||             grid[row][col]==0){
            return 0;
        }

        long sum=grid[row][col];
        grid[row][col]=0;

        for(int dir=0;dir<4;dir++){
            int nr=row+dx[dir];
            int nc=col+dy[dir];

            sum+=dfs(grid,nr,nc);
        }
        return sum;
    }
}