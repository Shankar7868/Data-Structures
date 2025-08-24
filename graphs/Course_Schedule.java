import java.util.*;

public class Course_Schedule
{
    static boolean dfs(List<List<Integer>> adjList,int start,List<Integer> Visited)
    {
        if(Visited.get(start)==1)
            return true;
        if(Visited.get(start)==2)
            return false;
        Visited.set(start,1);
        for(int i=0;i<adjList.get(start).size();i++)
            if(dfs(adjList,adjList.get(start).get(i),Visited))
                return true;
        Visited.set(start,2);
        return false;
    }
    static boolean canFinish(int numCourses, int[][] prerequisites)
    {
        List<List<Integer>> adjList = new ArrayList<>();
        List<Integer> Visited = new ArrayList<>();
        for(int i=0;i<numCourses;i++)
        {
            Visited.add(0);
            adjList.add(new ArrayList<>());
        }
        for(int i=0;i<prerequisites.length;i++)
        {
            int x = prerequisites[i][0];
            int y = prerequisites[i][1];
            adjList.get(y).add(x);
        }
        for(int i=0;i<numCourses;i++)
            if(Visited.get(i)==0)
                if(dfs(adjList,i,Visited))
                    return false;
        return true;
    }
    public static void main(String[] args) {
        // Type your input code  here 
    }
}
