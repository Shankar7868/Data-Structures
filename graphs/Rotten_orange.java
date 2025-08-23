import java.util.*;
class Pair
{
    int x,y,tm;
    Pair(int i,int j,int k){x=i;y=j;tm=k;}
    public int getX(){return x;}
    public int getY(){return y;}
    public int getTm(){return tm;}
}
public class Rotten_orange
{
    static int m,n;
    static Scanner sc = new Scanner(System.in);
    static List<List<Integer>> adjMat  = new ArrayList<>();
    static int orangesRotting()
    {
        int fresh=0;
        Queue<Pair> q = new LinkedList<>();
        for(int i=0;i<adjMat.size();i++)
            for(int j=0;j<adjMat.get(i).size();j++)
                if(adjMat.get(i).get(j)==2)
                    q.offer(new Pair(i,j,0));
                else if(adjMat.get(i).get(j)==1)
                    fresh++;

        int tm = 0;
        while(!q.isEmpty())
        {
            Pair p = q.poll();
            int t = p.getTm();
            tm = Math.max(tm,t);
            int row = p.getX(),col = p.getY();
            if(col-1>=0 && adjMat.get(row).get(col-1)==1)
            {
                adjMat.get(row).set(col-1,2);
                q.offer(new Pair(row,col-1,tm+1));
                fresh--;
            }
            if(col+1<adjMat.get(row).size() && adjMat.get(row).get(col+1)==1)
            {
                adjMat.get(row).set(col+1,2);
                q.offer(new Pair(row,col+1,tm+1));
                fresh--;
            }
            if(row-1>=0 && adjMat.get(row-1).get(col)==1)
            {
                adjMat.get(row-1).set(col,2);
                q.offer(new Pair(row-1,col,tm+1));
                fresh--;
            }
            if(row+1<adjMat.size() && adjMat.get(row+1).get(col)==1)
            {
                adjMat.get(row+1).set(col,2);
                q.offer(new Pair(row+1,col,tm+1));
                fresh--;
            }
        }
        if(fresh==0)
            return tm;
        else
            return -1;
    }
    public static void main(String[] args)
    {
        System.out.println("Enter the no of rows and columns");
        m = sc.nextInt();
        n = sc.nextInt();
        System.out.println("Enter the adjacency matrix");
        for(int i=0;i<m;i++)
        {
            List<Integer> li = new ArrayList<>();
            for(int j=0;j<n;j++)
                li.add(sc.nextInt());
            adjMat.add(li);
        }
        int k = orangesRotting();
        if(k==-1)
            System.out.println("Fresh oranges Still exists");
        else    
            System.out.println("time elapsed to rotten all the oranges is : "+k);
    }
}
