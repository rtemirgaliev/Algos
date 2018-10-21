package dfs;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        Node d1 = new Node("d1");
        Node c1 = new Node("c1");
        Node c2 = new Node("c2");
        Node c3 = new Node("c3");
        Node c4 = new Node("c4");
        Node b1 = new Node("b1");
        Node b2 = new Node("b2");
        Node a1 = new Node("a1");


        Set<Node> visited = new HashSet<>();
        NodeContainer result = new NodeContainer();
        bfs(a1, "c1", result, visited);
        System.out.println("Result: " + result.node.value);

    }


    static void dfs(Node node, String str, NodeContainer result, Set<Node> visited) {

        if (node == null) return;

        visited.add(node);
        System.out.println("Current: " + node.value);
        if (node.value.equals(str)) {
            System.out.println("found!");
            result.node = node;
            return;
        }

        for( Node adj : node.adj) {
            dfs(adj, str, result, visited);
        }

    }


    static void bfs(Node node, String str, NodeContainer result, Set<Node> visited) {

        Queue<Node> queue = new LinkedList<>();
        queue.add(node);

        while (!queue.isEmpty()) {

            Node current = queue.remove();
            visited.add(current);

            System.out.println("Current: " + current.value);
            if (current.value.equals(str)) {
                System.out.println("found");
                result.node = current;
                return;
            }

            for (Node adj : current.adj) {
                if (!visited.contains(adj)) {
                    queue.add(adj);
                }
            }

        }
    }

}
