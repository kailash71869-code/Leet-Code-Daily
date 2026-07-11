class Solution {
    public int orangesRotting(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;

        Queue<int[]> q=new LinkedList<>();
        int fresh=0;
        for(int row=0;row<n;row++){
            for(int col=0;col<m;col++){
                if(grid[row][col]==1){
                    fresh++;
                }else if(grid[row][col]==2){
                    q.offer(new int[]{row,col});
                }
            }
        }
        if(fresh==0){
            return 0;
        }
        int min=0;
        int[] dx={-1,1,0,0};
        int[] dy={0,0,-1,1};
        while(!q.isEmpty() && fresh>0){
            int size=q.size();
            for(int i=0;i<size;i++){
                int[] k=q.poll();
                int r=k[0];
                int c=k[1];
                for(int j=0;j<4;j++){
                    int nr=r+dx[j];
                    int nc=c+dy[j];
                    if(nr>=0 && nc>=0 && nr<n && nc<m && grid[nr][nc]==1){
                        grid[nr][nc]=2;
                        fresh--;
                        q.offer(new int[]{nr,nc});
                    }
                }
            }
                min++;
    
        }
        return fresh==0?min:-1;
    }
}