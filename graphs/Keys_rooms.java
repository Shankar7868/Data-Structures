import java.util.*;
public class Keys_rooms
{
    static boolean canVisitAllRooms(List<List<Integer>> rooms)
    {
        boolean[] Visited = new boolean[rooms.size()];
        for(int i=0;i<rooms.size();i++)
            Visited[i] = false;

        Queue<Integer> q = new ArrayDeque<>();
        q.offer(0);
        Visited[0] = true;
        while(!q.isEmpty())
        {
            int u = q.poll();
            for(int j=0;j<rooms.get(u).size();j++)
            {
                int k = rooms.get(u).get(j);
                if(!Visited[k])
                {
                    q.offer(k);
                    Visited[k]=true;
                }
            }
        }        

        for(int i=0;i<rooms.size();i++)
            if(!Visited[i])
                return false;
        return true;
    }   
    public static void main(String ...args)
    {
        // Enter your input here

        // Leetcode question no : 841
    } 
}
