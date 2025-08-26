import java.util.*;

public class All_path_from_source_to_dest
{
    static int dest;
    static void dfs(List<Integer> cur,int[][] graph,List<List<Integer>> result,boolean[] Visited,int u)
    {
        if(u == dest)
        {
            result.add(new ArrayList<>(cur));
            return;
        }

        for(int v=0;v<graph[u].length;v++)
        {
            int k = graph[u][v];
            if(!Visited[k])
            {
                cur.add(k);
                Visited[k] =true;
                dfs(cur,graph,result,Visited,k);
                Visited[k] =false;
                cur.remove(cur.size()-1);
            }
        }
    }
    static List<List<Integer>> allPathsSourceTarget(int[][] graph)
    {
        dest = graph.length-1;
        boolean[] Visited = new boolean[graph.length];
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        cur.add(0);
        Visited[0]=true;
        dfs(cur,graph,result,Visited,0);

        return result;
    }
    public static void main(String[] args) {
        // Enter your input here

        // Leetcode question no : 797
    }
}
