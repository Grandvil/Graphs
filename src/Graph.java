import java.util.ArrayList;
import java.util.List;

public class Graph {
    private List<List<Integer>> verticesInfo;
    private int V;

    public Graph(int V) {
        this.V = V;
        this.verticesInfo = new ArrayList<>(V);

        for (int i = 0; i < V; i++) {
            verticesInfo.add(new ArrayList<>());
        }
    }

    public void addEdge(int a, int b) {
        verticesInfo.get(a).add(b);
        verticesInfo.get(b).add(a);
    }

    public List<Integer> adjacent(int v) {
        return verticesInfo.get(v);
    }

    public int size() {
        return V;
    }
}
