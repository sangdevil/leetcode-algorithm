package Graph;

import java.util.ArrayList;
import java.util.*;

/*
// Definition for a Node.

*/
class Clone_Graph {
    static class Node {
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

    public Node dfs(Node node, HashMap<Integer, Node> map) {
        if (node == null) {
            return null;
        }
        System.out.printf("dfs called for node %d\n", node.val);
        Node clonedNode;
        if (map.containsKey(node.val)) {
            clonedNode = map.get(node.val);
        } else {
            clonedNode = new Node(node.val);
            System.out.printf("node %d cloned\n", node.val);
            map.put(node.val, clonedNode);
            for (Node neighbor : node.neighbors) {
                System.out.printf("neighbor %d cloned\n", neighbor.val);
                Node clonedNeighbor = dfs(neighbor, map);
                clonedNode.neighbors.add(clonedNeighbor);
            }
        }
        return clonedNode;
    }
    public Node cloneGraph(Node node) {
       HashMap<Integer, Node> map = new HashMap<>();

        return dfs(node, map);
    }
}