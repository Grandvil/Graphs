import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        int v = 6;
        Graph graph = new Graph(v);

        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(3, 4);

        calcPaths(graph);
    }

    public static int dfs(Graph graph, int v, int mark, int[] marks, boolean[] visited) {
        visited[v] = true;
        marks[v] = mark;
        int size = 1;
        for (int vv : graph.adjacent(v)) {
            if (!visited[vv]) {
                size += dfs(graph, vv, mark, marks, visited);
            }
        }
        return size;
    }

    public static void calcPaths(Graph graph) {
        int[] marks = new int[graph.size()];
        boolean[] visited = new boolean[graph.size()];
        List<Integer> markSizes = new ArrayList<>();

        for (int v = 0; v < graph.size(); v++) {
            if (!visited[v]) {
                int nextMark = markSizes.size();
                int size = dfs(graph, v, nextMark, marks, visited);
                markSizes.add(size);
            }
        }

        int[] answer = new int[graph.size()];

        for (int i = 0; i < graph.size(); i++) {
            answer[i] = markSizes.get(marks[i]) - 1;
        }

        System.out.println("Сколько достижимо городов для каждого города: " + Arrays.toString(answer));
    }
}
