public class Surrounded_regions 
{
    static void dfs(int row,int col,boolean[][] Visited,char[][] board)
    {
        Visited[row][col] = true;
        if(row>0 && !Visited[row-1][col] && board[row-1][col]=='O')
            dfs(row-1,col,Visited,board);
        if(row<board.length-1 && !Visited[row+1][col] && board[row+1][col]=='O')
            dfs(row+1,col,Visited,board);
        if(col>0 && !Visited[row][col-1] && board[row][col-1]=='O')
            dfs(row,col-1,Visited,board);
        if(col<board[row].length-1 && !Visited[row][col+1] && board[row][col+1]=='O')
            dfs(row,col+1,Visited,board);
    }
    static void solve(char[][] board)
    {
        int m = board.length,n=board[0].length;
        boolean[][] Visited = new boolean[m][n];
        for(int i=0;i<m;i++)
            for(int j=0;j<n;j++)
                Visited[i][j] = false;
        for(int i=0;i<n;i++)
            if(board[0][i]=='O' && !Visited[0][i])
                dfs(0,i,Visited,board);
        for(int i=0;i<m;i++)
            if(board[i][0]=='O' && !Visited[i][0])
                dfs(i,0,Visited,board);
        for(int i=0;i<n;i++)
            if(board[m-1][i]=='O' && !Visited[m-1][i])
                dfs(m-1,i,Visited,board);
        for(int i=0;i<m;i++)
            if(board[i][n-1]=='O' && !Visited[i][n-1])
                dfs(i,n-1,Visited,board);
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(!Visited[i][j])
                    board[i][j]= 'X';
            }
        }
    }
    public static void main(String[] args) {
        //Enter your input here 

        // Leetcode question no : 130
    }
}
