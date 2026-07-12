class Solution {
    int[] dx={1,-1,0,0};
    int[] dy={0,0,-1,1};
    public int numIslands(char[][] grid) {
        int R=grid.length;
        int C=grid[0].length;
        int count=0;
        for(int row=0;row<R;row++){
            for(int col=0;col<C;col++){
                if(grid[row][col]=='1'){
                    bfs(grid,row,col,R,C);
                    count++;
                }
            }
        }
        return count;
    }
    public void bfs(char[][] grid,int r,int c,int R,int C){
        Queue<int[]> q=new LinkedList<>();
        q.offer(new int[]{r,c});
        grid[r][c]='0';
        while(!q.isEmpty()){
            int[] curr=q.poll();
            int row=curr[0];
            int col=curr[1];
            for(int k=0;k<4;k++){
              int nr=row+dx[k];
               int nc=col+dy[k];
               if(nr>=0 && nc>=0 && nr<R && nc<C && grid[nr][nc]=='1'){
                q.offer(new int[]{nr,nc});
                grid[nr][nc]='0';
               }
            }
        }
    }
}