
//it also provide topological sort order
import java.util.*;

public class DFS
{
    static Scanner sc = new Scanner(System.in);
    static int n;
    static ArrayList<Integer> pi = new ArrayList<>();
    static Stack<Integer> stk = new Stack<>();
    static ArrayList<Integer> visited = new ArrayList<>();
    static void DFS_Visit(List<List<Integer>> am,int time,int u)
    {
        time++;
        visited.set(u,1);
        for(int v=0;v<n;v++)
            if(am.get(u).get(v)!=0 && visited.get(v)==0)
            {
                pi.set(v,u);
                DFS_Visit(am, time, v);
            }
        time++;
        stk.add(u);
        visited.set(u,2);

    }
    static void dfs(List<List<Integer>> am)
    {
        
        for(int i=0;i<n;i++)
        {
            visited.add(0);
            pi.add(-1);
        }
        int time=0;
        for(int i=0;i<n;i++)
            if(visited.get(i)==0)
                DFS_Visit(am,time,i);
    }
     public static void main(String[] args) {
        System.out.println("Enter  no of vertices");
        n = sc.nextInt();
        System.out.println("Enter the adjacency matrix");     
        List<List<Integer>> am = new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            List<Integer> res = new ArrayList<>();
            for(int j=0;j<n;j++)
            {
                res.add(sc.nextInt());
            }
            am.add(res);
        }
        dfs(am);

        System.out.println("Topological sort : ");
        while(!stk.isEmpty())
            System.err.print(stk.pop()+" ");
     }   
}
