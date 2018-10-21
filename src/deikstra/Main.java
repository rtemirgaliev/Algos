package deikstra;


import java.util.*;

@SuppressWarnings("Duplicates")
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

        a1.edges.add(new Edge(b1, 1));
        a1.edges.add(new Edge(b2, 2));
        b1.edges.add(new Edge(c1, 3));
        b1.edges.add(new Edge(c2, 6));
        b2.edges.add(new Edge(c2, 1));
        b2.edges.add(new Edge(c3, 2));
        b2.edges.add(new Edge(c4, 4));
        b2.edges.add(new Edge(d1, 4));
        c1.edges.add(new Edge(d1, 2));
        c3.edges.add(new Edge(d1, 7));


        Set<Node> visited = new HashSet<>();

        Map<Node, Integer> paths = new HashMap<>();
        paths.put(a1, Integer.MAX_VALUE);
        paths.put(b1, Integer.MAX_VALUE);
        paths.put(b2, Integer.MAX_VALUE);
        paths.put(c1, Integer.MAX_VALUE);
        paths.put(c2, Integer.MAX_VALUE);
        paths.put(c3, Integer.MAX_VALUE);
        paths.put(c4, Integer.MAX_VALUE);
        paths.put(d1, Integer.MAX_VALUE);

        deikstra(a1, paths);

        paths.forEach((n, i) -> System.out.println( n.value + ": " + i   ));

    }



    static void deikstra(Node node, Map<Node, Integer> paths) {

        Set<Node> completed = new HashSet<>();

        paths.put(node, 0);

        while (node != null) {

            PriorityQueue<Edge> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o.weight));

            queue.addAll(node.edges);

            if (queue.size() == 0) return;

            Node nodeMin = null;

            for (Edge edge : queue) {

                if (completed.contains(edge.node)) continue;

                int sum = paths.get(node) + edge.weight;

                if (sum < paths.get(edge.node)) {
                    paths.replace(edge.node, sum);
                }

                if (nodeMin == null) nodeMin = edge.node;

                if (paths.get(edge.node) < paths.get(nodeMin)) nodeMin = edge.node;
            }

            completed.add(node);

            node = nodeMin;

        }



    }


}
