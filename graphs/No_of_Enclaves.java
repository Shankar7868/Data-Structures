public class No_of_Enclaves
{
    static void dfs(int row,int col,boolean[][] Visited,int[][] grid)
    {
        Visited[row][col] = true;
        if(row>0 && !Visited[row-1][col] && grid[row-1][col]==1)
            dfs(row-1,col,Visited,grid);
        if(col>0 && !Visited[row][col-1] && grid[row][col-1]==1)
            dfs(row,col-1,Visited,grid);
        if(row<grid.length-1 && !Visited[row+1][col] && grid[row+1][col]==1)
            dfs(row+1,col,Visited,grid);
        if(col<grid[row].length-1 && !Visited[row][col+1] && grid[row][col+1]==1)
            dfs(row,col+1,Visited,grid);
    }
    static int numEnclaves(int[][] grid)
    {
        int m = grid.length ,n = grid[0].length;
        boolean[][] Visited = new boolean[m][n];
        for(int i=0;i<m;i++)
            for(int j=0;j<n;j++)
                Visited[i][j] = false;
        
        for(int i=0;i<n;i++)
            if(grid[0][i]==1 && !Visited[0][i])
                dfs(0,i,Visited,grid);
        for(int i=0;i<m;i++)
            if(grid[i][0]==1 && !Visited[i][0])
                dfs(i,0,Visited,grid);
        for(int i=0;i<m;i++)
            if(grid[i][n-1]==1 && !Visited[i][n-1])
                dfs(i,n-1,Visited,grid);
        for(int i=0;i<n;i++)
            if(grid[m-1][i]==1 && !Visited[m-1][i])
                dfs(m-1,i,Visited,grid);

        int count=0;
        for(int i=0;i<m;i++)
            for(int j=0;j<n;j++)
                if(!Visited[i][j] && grid[i][j]==1)
                    count++;
        return count;
    
    }
    public static void main(String[] args) {
        //Enter your input here 

        // Leetcode question no : 1020
    }
}
