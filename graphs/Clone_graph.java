
import java.util.*;

class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}

public class Clone_graph
{
    private HashMap<Node,Node> hm = new HashMap<>();
    public Node cloneGraph(Node node)
    {
        if(node==null)
            return node;
        if(hm.containsKey(node))
            return hm.get(node);

        Node dup = new Node(node.val);
        hm.put(node,dup);

        for(int i=0;i<node.neighbors.size();i++)
            dup.neighbors.add(cloneGraph(node.neighbors.get(i)));
        return dup;
    }
    public static void main(String ...args)
    {
        // add input to the above function;

        // clone graph is based on dfs algorithm
    }
}