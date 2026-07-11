class Solution {
    private int[] dx={-1,1,0,0};
    private int[] dy={0,0,-1,1};
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int oldcolor=image[sr][sc];
        if(oldcolor==color){
            return image;
        }
        dfs(image,sr,sc,color,oldcolor);
        return image;
    }
    public void dfs(int[][] image,int sr,int sc,int color,int oldcolor){
        if(sr<0 || sc<0 || sr>=image.length || sc>=image[0].length){
            return;
        }
        if(image[sr][sc]!=oldcolor){
            return;
        }
        image[sr][sc]=color;
        for(int i=0;i<4;i++){
            dfs(image,sr+dx[i],sc+dy[i],color,oldcolor);
        }
    }
}