package deikstra;

import java.util.LinkedList;
import java.util.List;

public class Node {

    public String value;

    public List<Edge> edges = new LinkedList<>();

    public Node(String value) {
        this.value = value;
    }
}
