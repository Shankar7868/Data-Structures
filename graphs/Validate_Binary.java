public class Validate_Binary
{
    static boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild)
    {
        int[] indegree = new int[n];
        for (int i = 0; i < n; i++)
        {
            if (leftChild[i] != -1)
            {
                indegree[leftChild[i]]++;
                if (indegree[leftChild[i]] > 1)
                    return false;
            }
            if (rightChild[i] != -1)
            {
                indegree[rightChild[i]]++;
                if (indegree[rightChild[i]] > 1) return false;
            }
        }
        
        int root = -1;
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                if (root == -1) root = i;
                else return false;
            }
        }
        if (root == -1)
            return false;

        boolean[] visited = new boolean[n];
        if (!dfs(leftChild, rightChild, root, visited))
            return false;

        for (boolean v : visited)
            if (!v) return false;

        return true;
    }

    static boolean dfs(int[] leftChild, int[] rightChild, int node, boolean[] visited)
    {
        if (visited[node]) return false;
        visited[node] = true;

        if (leftChild[node] != -1 && !dfs(leftChild, rightChild, leftChild[node], visited))         return false;
        if (rightChild[node] != -1 && !dfs(leftChild, rightChild, rightChild[node], visited))           return false;

        return true;
    }    
    public static void main(String ...args)
    {
        // Enter your input here

        // Leetcode question no : 1361
    }
}
