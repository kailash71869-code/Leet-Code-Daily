class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[][] mat=new int[n][n];
        for(int i=0;i<mat.length;i++)
        Arrays.fill(mat[i],Integer.MAX_VALUE);

        for(int[] e:edges){
            mat[e[0]][e[1]]=e[2];
            mat[e[1]][e[0]]=e[2];
        }

        for(int k=0;k<n;k++){
        for(int row=0;row<n;row++){
            for(int col=0;col<n;col++){
                if(row==col){
                    mat[row][col]=0;
                }
                if(mat[row][k]==Integer.MAX_VALUE || mat[k][col]==Integer.MAX_VALUE){
                    continue;
                }

                mat[row][col]=Math.min(mat[row][col],mat[row][k]+mat[k][col]);
            }
        }
        }

        int cities=-1;
        int min=Integer.MAX_VALUE;

        for(int src=0;src<n;src++){
            int count=0;
            for(int j=0;j<n;j++){
                if(mat[src][j]<=distanceThreshold){
                    count++;
                }
            }
            if(count<=min){
                min=count;
                cities=src;
            }
        }

        return cities;
    }
}