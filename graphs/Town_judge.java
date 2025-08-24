
import java.util.Scanner;


public class Town_judge
{
    static int findJudge(int n, int[][] trust)
    {
        int[] trust_Count = new int[n+1];
        for(int i=0;i<=n;i++)
            trust_Count[i]=0;
        for(int i=0;i<trust.length;i++)
        {
            trust_Count[trust[i][0]]--;
            trust_Count[trust[i][1]]++;
        }
        for(int i=1;i<=n;i++)
            if(trust_Count[i]==n-1)
                return i;
        return -1;
    }    
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter no of people");
        int n = sc.nextInt();
        System.out.print("Enter no of trust inputs ");
        int x = sc.nextInt();
        int[][] trust = new int[x][2];
        System.out.println("Enter the trust matrix");
        for(int i=0;i<x;i++)
            for(int j=0;j<2;j++)
                trust[i][j] = sc.nextInt();
        int k = findJudge(n, trust);
        if(k==-1)
            System.out.print("No town judge exist");
        else
            System.out.print("Town judge is  : "+k);  
    }
}
