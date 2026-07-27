class Solution {
    public int latestDayToCross(int R, int C, int[][] cells) {
        int[] leader=new int[R*C+2];
        boolean[] water=new boolean[R*C+2];
        for(int i=0;i<R*C+2;i++){
            leader[i]=i;
        }
        int days=0;
        int[][] diff={{0,-1},{-1,-1},{-1,0},{-1,1},{0,1},{1,1},{1,0},{1,-1}};
        for(int[] cell:cells){
            int row=cell[0],col=cell[1];
            row--;
            col--;
            water[row*C+col+1]=true;
            for(int[] d:diff){
                int rdiff=d[0]+row,cdiff=d[1]+col;
                if(rdiff<0 || cdiff<0 || rdiff==R || cdiff==C)
                    continue;
                if(!water[rdiff*C+cdiff+1])
                    continue;

                join(leader,row*C+col+1,rdiff*C+cdiff+1);
            }
            if(col==0){
                join(leader,0,row*C+1);
            }else if(col==C-1){
                join(leader,row*C+C,R*C+1);
            }
            if(find(leader,0)==find(leader,R*C+1))
                break;
            else
                days++;
        }
        return days;
    }
    private void join(int[] leader,int left,int right){
        leader[find(leader,right)]=leader[find(leader,left)];
    }
    private int find(int[] leader,int node){
        if(leader[node]==node){
            return node;
        }
        leader[node]=find(leader,leader[node]);
        return leader[node];
    }
}