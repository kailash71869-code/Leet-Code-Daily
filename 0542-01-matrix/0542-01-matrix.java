class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int n=mat.length;
        int m=mat[0].length;
        Queue<int[]> q=new LinkedList<>();
        for(int row=0;row<n;row++){
            for(int col=0;col<m;col++){
                if(mat[row][col]==0){
                    q.offer(new int[]{row,col});
                }else if(mat[row][col]==1){
                    mat[row][col]=-1;
                }
            }
        }
        int[] dx={-1,1,0,0};
        int[] dy={0,0,-1,1};
        while(!q.isEmpty()){
            int[] curr=q.poll();
            int r=curr[0];
            int c=curr[1];
            for(int i=0;i<4;i++){
                int nr=r+dx[i];
                int nc=c+dy[i];

                if(nr<n && nc<m && nr>=0 && nc>=0 && mat[nr][nc]==-1){
                    mat[nr][nc]=mat[r][c]+1;
                    q.offer(new int[]{nr,nc});
                }
            }
        }
        return mat;
    }
}