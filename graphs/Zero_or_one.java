import java.util.*;
 class Pair
{
    int x,y,z;
    Pair(int k1,int k2,int k3)
    {
        x=k1;
        y=k2;
        z=k3;
    }
    public int getX(){return x;}
    public int getY(){return y;}
    public int getZ(){return z;}
}
public class Zero_or_one
{
    static int[][] updateMatrix(int[][] mat)
    {
        int m = mat.length , n = mat[0].length;
        boolean[][] Visited = new boolean[m][n];
        int[][] result = new int[m][n];
        Queue<Pair> q = new ArrayDeque<>();
        for(int i=0;i<m;i++)
            for(int j=0;j<n;j++)
            {
                if(mat[i][j]==0)
                {
                    q.offer(new Pair(i,j,0));
                    Visited[i][j]=true;
                }
                else
                    Visited[i][j]=false;
            }
        
        while(!q.isEmpty())
        {
            Pair p = q.poll();
            int row = p.getX(),col = p.getY(),val= p.getZ();
            result[row][col] = val;
            if(col>0 && !Visited[row][col-1])
            {
                q.offer(new Pair(row,col-1,val+1));
                Visited[row][col-1]=true;
            }
            if(col<n-1 && !Visited[row][col+1])
            {
                q.offer(new Pair(row,col+1,val+1));
                Visited[row][col+1]=true;
            }
            if(row>0 && !Visited[row-1][col])
            {
                q.offer(new Pair(row-1,col,val+1));
                Visited[row-1][col]=true;
            }
            if(row<m-1 && !Visited[row+1][col])
            {
                q.offer(new Pair(row+1,col,val+1));
                Visited[row+1][col]=true;
            }
        }
        return result;
    }
    public static void main(String[] args) {
        // Enter your input here 

        // leetcode qno : 542
    }
}  
