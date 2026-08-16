class Solution {
    int[] dx={-1,1,0,0};
    int[] dy={0,0,-1,1};
    public int nearestExit(char[][] maze, int[] entrance) {
        int R=maze.length;
        int C=maze[0].length;
        int move=0;

        Queue<int[]> q=new LinkedList<>();
        q.offer(new int[]{entrance[0],entrance[1]});
        maze[entrance[0]][entrance[1]]='+';

        while(!q.isEmpty()){
            int size=q.size();
            move++;
            for(int i=0;i<size;i++){
            int[] value=q.poll();
            int r=value[0];
            int c=value[1];

            for(int dir=0;dir<4;dir++){
                int nr=r+dx[dir];
                int nc=c+dy[dir];

                if(nr<0 || nc<0 || nr>=R || nc>=C){
                    continue;
                } 
                if(maze[nr][nc]=='+'){
                    continue;
                }

                maze[nr][nc]='+';
                if(nr==0 || nc==0 || nc==C-1 || nr==R-1){
                    return move;
                }
                q.offer(new int[]{nr,nc});
            }
            }
        }
        return -1;
    }
}