public class IsBipartite
{
    static boolean dfs(int idx , int[][] graph, int[] color,int col)
    {
        color[idx] = col;
        for(int i=0;i<graph[idx].length;i++)
        {
            if(color[graph[idx][i]]==-1)
            {
                color[graph[idx][i]] = 1-col;
                if(!dfs(graph[idx][i],graph,color,1-col))
                    return false;
            }
            else
            {
                if(color[graph[idx][i]] == col)
                    return false;
            }
        }
        return true;
    }
    static boolean isBipartite(int[][] graph)
    {
        int[] color = new int[graph.length];
        for(int i=0;i<graph.length;i++)
            color[i]=-1;

        for(int i=0;i<graph.length;i++)
        {
            if(color[i] == -1)
                if(!dfs(i,graph,color,0))
                    return false;
        }
        return true;
    }
    public static void main(String[] args) {
        //Enter your input here
        
        // Leetcode question no : 785
    }   
}
