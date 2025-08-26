import java.util.*;
public class TSP
{
    static int n,best=Integer.MAX_VALUE;
    static List<Integer> path = new ArrayList<>();
    static List<Integer> opti_path = new ArrayList<>();
    static void tsp(int cost,boolean[] Visited,int[][] mat)
    {
        int u = path.get(path.size()-1);
        if(path.size() == n)
        {
            cost += mat[u][0];
            if(cost < best)
            {
                best = cost;
                opti_path = new ArrayList<>(path);
                opti_path.add(0);
            }
            return;
        }
        int bound=0;
        for(int i=0;i<n;i++)
        {
            if(!Visited[i])
            {
                int min = Integer.MAX_VALUE;
                for(int j=0;j<n;j++)
                {
                    if(i!=j)
                        min = Math.min(min,mat[i][j]);
                }
                bound += min;
            }
        }
        if(bound +cost >= best)
            return;
        for(int v=0;v<n;v++)
        {
            if(!Visited[v])
            {
                Visited[v]=true;
                path.add(v);
                tsp(cost+mat[u][v] , Visited,mat);
                path.remove(path.size()-1);
                Visited[v] = false;
            }
        }
    }
    public static void main(String ...args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter no  airports");
        n = sc.nextInt();
        boolean[] Visited = new boolean[n];
        int[][] mat = new int[n][n];
        for(int i=0;i<n;i++)
            Visited[i] = false;
        for(int i=0;i<n;i++)
            for(int j=0;j<n;j++)
                mat[i][j] = sc.nextInt();
        path.add(0);
        Visited[0]=true;
        tsp(0,Visited,mat);
        System.out.println("Optimal value  : "+best);
        System.out.print("Optimal path : ");
        for(int i=0;i<opti_path.size();i++)
            System.out.print(opti_path.get(i)+" ");
    }    
}
