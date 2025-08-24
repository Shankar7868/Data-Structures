import java.util.*;

class Pair
{
    int x, y;
    public Pair(int k1, int k2) {
        x = k1;
        y = k2;
    }
    public int getX() { return x; }
    public int getY() { return y; }
}

public class cycle_detection_undirected1
{
    static boolean bfs(List<List<Integer>> al, int start, List<Boolean> visited) {
        Queue<Pair> q = new ArrayDeque<>();
        visited.set(start, true);
        q.offer(new Pair(start, -1));

        while (!q.isEmpty()) {
            Pair p = q.poll();
            int node = p.getX();
            int parent = p.getY();

            for (int neighbor : al.get(node)) {
                if (!visited.get(neighbor)) {
                    visited.set(neighbor, true);
                    q.offer(new Pair(neighbor, node));
                } else if (neighbor != parent) {
                    return true; // Cycle detected
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of nodes:");
        int n = sc.nextInt();

        List<List<Integer>> al = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            al.add(new ArrayList<>());
        }

        // Sample edges (undirected)
        al.get(0).addAll(Arrays.asList(1, 2));
        al.get(1).addAll(Arrays.asList(0, 3, 6));
        al.get(2).addAll(Arrays.asList(0, 4));
        al.get(3).addAll(Arrays.asList(1, 5));
        al.get(4).addAll(Arrays.asList(2, 5));
        al.get(5).addAll(Arrays.asList(3, 4));
        al.get(6).addAll(Arrays.asList(1));

        List<Boolean> visited = new ArrayList<>(Collections.nCopies(n, false));
        boolean hasCycle = false;

        for (int i = 0; i < n; i++) {
            if (!visited.get(i)) {
                if (bfs(al, i, visited)) {
                    hasCycle = true;
                    break;
                }
            }
        }

        System.out.println("Cycle detected: " + hasCycle);
    }
}
