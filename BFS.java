
import java.util.*;

public class BFS
{
    static int n;
    static Scanner sc = new Scanner(System.in);
    static void bfs_traversal(List<List<Integer>> al)
    {
        List<Boolean> col = new ArrayList<>();
        for(int i=0;i<=n;i++)
            col.add(false);
        Queue<Integer> q = new ArrayDeque<>();
        q.add(1);
        col.set(1,true);
        while(!q.isEmpty())
        {
            int u = q.poll();
            for(int i=1;i<=n;i++)
                if(al.get(u).get(i)!=0 && !col.get(i))
                {
                    q.add(i);
                    col.set(i,true);
                }
            System.out.println(u);
        }
    }
    public static void main(String[] args) 
    {
        System.out.println("Enter no of vertices");
        n = sc.nextInt();
        List<List<Integer>> al = new ArrayList<>();
        for(int i=0;i<=n;i++)
        {
            List<Integer> res = new ArrayList<>();
            for(int j=0;j<=n;j++)
                res.add(0);
            al.add(res);
        }
        System.out.println("Enter the adjacency matrix");
        for(int i=1;i<=n;i++)
        {
            for(int j=1;j<=n;j++)
            {
                al.get(i).set(j,sc.nextInt());
            }
        }
        bfs_traversal(al);
    }    
}
