class Solution {
    int[] dx={-1,1,0,0};
    int[] dy={0,0,-1,1};
    public void solve(char[][] board) {
        int r=board.length;
        int c=board[0].length;
        boolean[][] vis=new boolean[r][c];
        for(int col=0;col<c;col++){
            if(board[0][col]=='O' && !vis[0][col]){
                dfs(board,vis,0,col);
            }
            if(board[r-1][col]=='O' && !vis[r-1][col]){
                dfs(board,vis,r-1,col); 
            }
        }
        for(int row=0;row<r;row++){
            if(board[row][0]=='O' && !vis[row][0]){
                dfs(board,vis,row,0);
            }
            if(board[row][c-1]=='O' && !vis[row][c-1]){
                dfs(board,vis,row,c-1);
            }
        }
        for(int row=0;row<r;row++){
            for(int col=0;col<c;col++){
                if(board[row][col]=='O' && !vis[row][col]){
                    board[row][col]='X';
                }
            }
        }
    }
    public void dfs(char[][] board,boolean[][] vis,int row,int col){
        vis[row][col]=true;
        for(int i=0;i<4;i++){
            int r=row+dx[i];
            int c=col+dy[i];
            if(r>=0 && c>=0 && r<board.length && c<board[0].length && board[r][c]=='O' && !vis[r][c]){
                dfs(board,vis,r,c);
            }
        }
    }
}