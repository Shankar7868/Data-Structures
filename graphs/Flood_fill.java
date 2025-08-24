import java.util.*;
public class Flood_fill
{
    static int default_color;
    static int[][] floodFill(int[][] image, int sr, int sc, int color)
    {
        default_color = image[sr][sc];
        if(image[sr][sc]==color)
            return image;
        dfs(image,sr,sc,color);
        return image;
    }
    static void dfs(int[][] image,int row,int col,int color)
    {
        if(row<0 || row>=image.length || col<0 ||col>=image[row].length) 
            return;
        if(image[row][col] != default_color)
            return;
        image[row][col] = color;
        dfs(image,row-1,col,color);
        dfs(image,row+1,col,color);
        dfs(image,row,col-1,color);
        dfs(image,row,col+1,color);
    }
    public static void main(String ...args) 
    {
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter rows and columns");
        int m = sc.nextInt();
        int n = sc.nextInt();
        int[][] image = new int[m][n];

        System.out.println("Enter the pixels matrix");
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                image[i][j] = sc.nextInt();
            }
        }
        System.out.println("Enter the starting pixel row and col and color to be changed");
        int new_image[][] = floodFill(image, sc.nextInt(), sc.nextInt(), sc.nextInt());
        System.out.println("Final image obtained is :");
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
                System.out.print(new_image[i][j]);
            System.out.println();
        }
    }   
}
