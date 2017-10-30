import com.mindorks.java.graph.*;

/**
 * Created by janisharali on 26/10/17.
 */
public class Demo {

    public static void main(String[] args) {
        testGraph();
    }

    public static void testGraph() {
        Graph graph = new UGraph(7);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(0, 6);
        graph.addEdge(6, 4);
        graph.addEdge(4, 3);
        graph.addEdge(4, 5);
        graph.addEdge(5, 3);
        graph.addEdge(0, 5);

        Paths paths = new DepthFirstPaths(graph, 0);
        print(paths.pathTo(5));


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
