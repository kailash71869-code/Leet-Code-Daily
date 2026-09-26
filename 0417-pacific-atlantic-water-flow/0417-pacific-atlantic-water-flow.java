class Solution {
    List<List<Integer>> ans=new ArrayList<>();
    int[] dx={-1,1,0,0};
    int[] dy={0,0,-1,1};
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        if(heights.length==0){
            return ans;
        }
        int n=heights.length;
        int m=heights[0].length;
        boolean[][] pac=new boolean[n][m];
        boolean[][] alt=new boolean[n][m];

        for(int row=0;row<n;row++){
            dfs(heights,row,0,pac);
            dfs(heights,row,m-1,alt);              
        }

        for(int col=0;col<m;col++){
            dfs(heights,0,col,pac);
            dfs(heights,n-1,col,alt);
        }

        for(int row=0;row<n;row++){
            for(int col=0;col<m;col++){
                if(alt[row][col] && pac[row][col]){
                    ans.add(Arrays.asList(row,col));
                }
            }
        }
        return ans;
    }
    public void dfs(int[][] sea,int r,int c,boolean[][] vis){
        vis[r][c]=true;
        for(int dir=0;dir<4;dir++){
            int nr=r+dx[dir];
            int nc=c+dy[dir];

            if(nr>=0 && nc>=0 && nr<sea.length && nc<sea[0].length && !vis[nr][nc] && sea[nr][nc]>=sea[r][c]){
                dfs(sea,nr,nc,vis);
            }
        }
    }
}