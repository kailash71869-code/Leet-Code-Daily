class Solution {
    int[] dx={-1,-1,-1, 0, 1,1,1,0};
    int[] dy={-1, 1, 0,-1,-1,1,0,1};
    public int shortestPathBinaryMatrix(int[][] grid) {
        if(grid.length==0){
            return -1;
        }
        if(grid[0][0]==1){
            return -1;
        }
        int R=grid.length;
        int C=grid[0].length;
        boolean[][] vis=new boolean[R][C];

        Queue<int[]> q=new LinkedList<>();
        q.offer(new int[]{0,0,1});
        vis[0][0]=true;

        int min=Integer.MAX_VALUE;

        while(!q.isEmpty()){
           int[] val=q.poll();
           int r=val[0];
           int c=val[1];
           int dis=val[2];

           if(R-1==r && C-1==c){
            return dis;
           }

           for(int dir=0;dir<8;dir++){
            int nr=r+dx[dir];
            int nc=c+dy[dir];

            if(nr>=0 && nc>=0 && nr<R && nc<C && grid[nr][nc]==0 && !vis[nr][nc]){
                q.offer(new int[]{nr,nc,dis+1});
                vis[nr][nc]=true;
            }
           }
        }
        return -1;
    }
}