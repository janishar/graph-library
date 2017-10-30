import com.mindorks.java.graph.*;

/**
 * Created by janisharali on 26/10/17.
 */
public class Demo {

    public static void main(String[] args) {
        testGraph();
    }

    public static void testGraph() {

//        testDFS(getTestGraph());
        testBFS(getTestGraph());
    }

    private static Graph getTestGraph() {
        Graph graph = new UGraph(7);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(0, 6);
        graph.addEdge(6, 4);
        graph.addEdge(4, 3);
        graph.addEdge(4, 5);
        graph.addEdge(5, 3);
        graph.addEdge(0, 5);
        return graph;
    }

    private static void testDFS(Graph graph) {
        Paths paths = new DepthFirstPaths(graph, 0);
        print(paths.pathTo(5));
    }

    private static void testBFS(Graph graph) {
        BreathFirstPaths paths = new BreathFirstPaths(graph, 0);
        print(paths.pathTo(4));// will give the shortest path
    }

    public static void testBag() {
        Bag<String> bag = new Bag<>();
        bag.put("Janishar");
        bag.put("Ali");
        bag.put("Anwar");
        bag.put("Anwar");
        bag.put("is");
        bag.put("awesome");

        System.out.println(bag.get() + bag.get());

        for (String item : bag) {
            System.out.println(item);
        }
    }

    public static <T> void print(T t) {
        System.out.println(t);
    }
}
