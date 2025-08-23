import java.util.*;
public class No_of_provinces 
{
    static int n;
    static Scanner sc=new Scanner(System.in);
    static List<List<Integer>> adjMat = new ArrayList<>();
    static void dfs(List<List<Integer>> adjMat,int k,ArrayList<Boolean> Visited)
    {
        Visited.set(k,true);
        for(int v = 0;v<adjMat.get(k).size();v++)
        {
            if(adjMat.get(k).get(v)==1 && Visited.get(v)==false)
                dfs(adjMat,v,Visited);
        }
    }
    static int No_of_components(List<List<Integer>> adjMat)
    {
        ArrayList<Boolean> Visited = new ArrayList<>();
        for(int i=0;i<adjMat.size();i++)
            Visited.add(false);
        int count=0;
        for(int i =0;i<n;i++)
        {
            if(Visited.get(i)==false)
            {
                count++;
                dfs(adjMat,i,Visited);
            }
        }    
        return count;
    }
    public static void main(String[] args)
    {
        System.out.println("Enter no of nodes?");
        n = sc.nextInt();
        System.out.println("Enter the adjacency matrix");
        for(int i=0;i<n;i++)
        {
            List<Integer> rs = new ArrayList<>();
            for(int j=0;j<n;j++)
            {
                rs.add(sc.nextInt());
            }
            adjMat.add(rs);
        }
        System.out.println("No of components : "+No_of_components(adjMat));
    }    
}
