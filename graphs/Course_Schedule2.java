import java.util.*;


// Used DFS and Topology sort


public class Course_Schedule2
{
    static Stack<Integer> stk = new Stack<>();
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
        stk.push(start);
        return false;
    }

    static int[] findOrder(int numCourses, int[][] prerequisites)
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
        boolean k = true;
        for(int i=0;i<numCourses;i++)
            if(Visited.get(i)==0 && k)
                if(dfs(adjList,i,Visited))
                    k = false;
        int[] result = new int[numCourses];
        if(k)
        {
            int k1=0;
            while(!stk.isEmpty())
            {
                result[k1++]=stk.peek();
                stk.pop();
            }
            return result;
        }
        else
            return new int[0];
    }
    public static void main(String[] args) {
        // Enter the input here 
    }

     // used Kahn's Algorithm 
// BFS + Indegree usage
    public int[] findOrder(int numCourses, int[][] prerequisites)
    {
        List<List<Integer>> adjList = new ArrayList<>();
        int[] inDegree = new int[numCourses];
        for (int i = 0; i < numCourses; i++)
        {
            adjList.add(new ArrayList<>());
            inDegree[i]=0;
        }
        for (int i=0;i<prerequisites.length;i++)
        {
            adjList.get(prerequisites[i][1]).add(prerequisites[i][0]);
            inDegree[prerequisites[i][0]]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < numCourses; i++)
            if (inDegree[i] == 0) // Assume topo sort left most element will not have any indegree
                q.offer(i);

        int[] result = new int[numCourses];
        int idx = 0;

        while (!q.isEmpty())
        {
            int course = q.poll();
            result[idx++] = course;
            for (int k=0;k<adjList.get(course).size();k++)
            {
                int i = adjList.get(course).get(k);
                inDegree[i]--;
                if (inDegree[i] == 0)
                    q.offer(i);
            }
        }
        return idx == numCourses ? result : new int[0]; // cycle check
    }
}

