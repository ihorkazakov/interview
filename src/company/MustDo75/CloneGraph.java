package company.MustDo75;

import java.util.*;

/**
 * Given a reference of a node in a connected undirected graph.
 *
 * Return a deep copy (clone) of the graph.
 *
 * Each node in the graph contains a value (int) and a list (List[Node]) of its neighbors.
 */
public class CloneGraph {
    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }

        Map<Node, Node> map = new HashMap<>();
        Queue<Node> q = new LinkedList<>();
        q.add(node);
        map.put(node, new Node(node.val));

        while (!q.isEmpty()) {
            Node curr = q.poll();
            for (Node n : curr.neighbors) {
                if (!map.containsKey(n)) {
                    map.put(n, new Node(n.val));
                    q.add(n);
                }

                map.get(curr).neighbors.add(map.get(n));
            }
        }

        return map.get(node);
    }

    class Node {
        public int val;
        public List<Node> neighbors;

        public Node(int val) {
            this.val = val;
            neighbors = new ArrayList<>();
        }
    }
}
