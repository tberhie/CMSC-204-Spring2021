
    /**
     * This application maintains a network of towns and the roads connecting them.
     * The application will use Dijkstra’s Shortest Path algorithm to find the shortest distance between any two towns
     * @author tsega
     * */
import java.util.ArrayList;
import java.io.File;
import java.util.*;
import java.util.HashSet;
import java.util.Set;

public class Graph implements GraphInterface<Town, Road> {


    private Set<Town> towns = new HashSet<>();
    private Set<Road> roads = new HashSet<>();
    private ArrayList<String> shortestPath = new ArrayList<>();
    private Town destination;
    private int firstTown;
    private int lastTown;

    /**
     * Returns an edge connecting source vertex to target vertex if such
     * vertices and such edge exist in this graph. Otherwise returns
     * null. If any of the specified vertices is null
     * returns null
     *
     * In undirected graphs, the returned edge may have its source and target
     * vertices in the opposite order.
     *
     * @param sourceVertex source vertex of the edge.
     * @param destinationVertex target vertex of the edge.
     *
     * @return an edge connecting source vertex to target vertex.
     */

    @Override
    public Road getEdge(Town sourceVertex, Town destinationVertex) {
        Road road = null;
        for (Road road1 : roads) {
            if (road1.contains(sourceVertex) && road1.contains(destinationVertex)) {
                road = road1;
            }
        }
        return road;
    }

    /**
     * Creates a new edge in this graph, going from the source vertex to the
     * target vertex, and returns the created edge.
     *
     * The source and target vertices must already be contained in this
     * graph. If they are not found in graph IllegalArgumentException is
     * thrown.
     *
     *
     * @param sourceVertex source vertex of the edge.
     * @param destinationVertex target vertex of the edge.
     * @param weight weight of the edge
     * @param description description for edge
     *
     * @return The newly created edge if added to the graph, otherwise null.
     *
     * @throws IllegalArgumentException if source or target vertices are not
     * found in the graph.
     * @throws NullPointerException if any of the specified vertices is null.
     */
    @Override
    public Road addEdge(Town sourceVertex, Town destinationVertex, int weight, String description) {

		if (sourceVertex == null || destinationVertex == null) {
			throw new NullPointerException();
		}

		if (!towns.contains(sourceVertex) || !towns.contains(destinationVertex)) {
			throw new IllegalArgumentException();
		}

        Road road = new Road(sourceVertex, destinationVertex, weight, description);
        roads.add(road);

        return road;
    }

    /**
     * Adds the specified vertex to this graph if not already present. More
     * formally, adds the specified vertex, v, to this graph if
     * this graph contains no vertex u such that
     * u.equals(v). If this graph already contains such vertex, the call
     * leaves this graph unchanged and returns false. In combination
     * with the restriction on constructors, this ensures that graphs never
     * contain duplicate vertices.
     *
     * @param v vertex to be added to this graph.
     *
     * @return true if this graph did not already contain the specified
     * vertex.
     *
     * @throws NullPointerException if the specified vertex is null.
     */

    @Override
    public boolean addVertex(Town v) {

        if (v == null) {
            throw new NullPointerException();
        }

        if (!towns.contains(v)) {
            towns.add(v);
            return true;
        }

        return false;
    }

    /**
     * Returns true if and only if this graph contains an edge going
     * from the source vertex to the target vertex. In undirected graphs the
     * same result is obtained when source and target are inverted. If any of
     * the specified vertices does not exist in the graph, or if is
     * null, returns false.
     *
     * @param sourceVertex source vertex of the edge.
     * @param destinationVertex target vertex of the edge.
     *
     * @return true if this graph contains the specified edge.
     */

    @Override
    public boolean containsEdge(Town sourceVertex, Town destinationVertex) {
        for (Road r : roads) {
            if (r.contains(sourceVertex) && r.contains(destinationVertex)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Returns true if this graph contains the specified vertex. More
     * formally, returns true if and only if this graph contains a
     * vertex u such that u.equals(v). If the
     * specified vertex is null returns false.
     *
     * @param v vertex whose presence in this graph is to be tested.
     *
     * @return true if this graph contains the specified vertex.
     */

    @Override
    public boolean containsVertex(Town v) {
        return towns.contains(v);
    }
    /**
     * Returns a set of the edges contained in this graph. The set is backed by
     * the graph, so changes to the graph are reflected in the set. If the graph
     * is modified while an iteration over the set is in progress, the results
     * of the iteration are undefined.
     *
     *
     * @return a set of the edges contained in this graph.
     */
    @Override
    public Set<Road> edgeSet() {
        return roads;
    }
    /**
     * Returns a set of all edges touching the specified vertex (also
     * referred to as adjacent vertices). If no edges are
     * touching the specified vertex returns an empty set.
     *
     * @param vertex the vertex for which a set of touching edges is to be
     * returned.
     *
     * @return a set of all edges touching the specified vertex.
     *
     * @throws IllegalArgumentException if vertex is not found in the graph.
     * @throws NullPointerException if vertex is null.
     */
    @Override
    public Set<Road> edgesOf(Town vertex) {
        Set<Road> edges = new HashSet<>();
        for (Road r : roads) {
            if (r.contains(vertex)) {
                edges.add(r);
            }
        }
        return edges;
    }

    /**
     * Removes the specified vertex from this graph including all its touching
     * edges if present. More formally, if the graph contains a vertex
     * u such that u.equals(v), the call removes all edges
     * that touch u and then removes u itself. If no
     * such u is found, the call leaves the graph unchanged.
     * Returns true if the graph contained the specified vertex. (The
     * graph will not contain the specified vertex once the call returns).
     *
     * If the specified vertex is null returns false.
     *
     * @param v vertex to be removed from this graph, if present.
     *
     * @return true if the graph contained the specified vertex;
     * false otherwise.
     */
    @Override
    public Road removeEdge(Town sourceVertex, Town destinationVertex,
                           int weight, String description) {

        if (sourceVertex == null || destinationVertex == null || description == null) {
            throw new NullPointerException();
        }

        if (!towns.contains(sourceVertex) || !towns.contains(destinationVertex)) {
            throw new IllegalArgumentException();
        }

        Road road = null;
        for (Road r : roads) {
            if (r.contains(sourceVertex) && r.contains(destinationVertex) &&
                    r.getWeight() == weight && r.getName().equals(description)) {
                road = r;
            }
        }
        return roads.remove(road) ? road : null;
    }

    @Override
    public boolean removeVertex(Town v) {
        return towns.remove(v);
    }
    /**
     * Returns a set of the vertices contained in this graph.
     * @return a set view of the vertices contained in this graph.
     */
    @Override
    public Set<Town> vertexSet() {
        return towns;
    }
    
    /**
     * Find the shortest path from the sourceVertex to the destinationVertex
     * call the dijkstraShortestPath with the sourceVertex
     * @param sourceVertex starting vertex
     * @param destinationVertex ending vertex
     * @return An arraylist of Strings that describe the path from sourceVertex
     * to destinationVertex
   :
     * Vertex_1 via Edge_2 to Vertex_3 4 (first string in ArrayList)
     * Vertex_3 via Edge_5 to Vertex_8 2 (second string in ArrayList)
     * Vertex_8 via Edge_9 to Vertex_10 2 (third string in ArrayList)
     */
    @Override
    public ArrayList<String> shortestPath(Town sourceVertex, Town destinationVertex) {
        String shortPath = "";
        int inMile = 0;
        destination = destinationVertex;
        dijkstraShortestPath(sourceVertex);


        for (int index = 0; index < shortestPath.size() - 1; index++) {
            Town source = new Town(shortestPath.get(index));
            Town d = new Town(shortestPath.get(index + 1));
            Road r = getEdge(source, d);
            inMile += r.getWeight();
            shortPath += source + " via " + r.getName() + " to " + d
                    + " " + r.getWeight() + " mi;";
        }
        shortestPath.clear();
        for (String step : shortPath.split(";")) {
            shortestPath.add(step);
        }
        shortestPath.add("Total miles: " + inMile + " mi");
        return shortestPath;
    }
    
    /**
     * Dijkstra's Shortest Path Method. 
     * @param sourceVertex the vertex to find shortest path from
     *
     */
    @Override
    public void dijkstraShortestPath(Town sourceVertex) {
    	int[][] adjMatrix = new int[towns.size()][towns.size()];
		Town[] twn = new Town[towns.size()];
		int size = 0;
		for (Town town : towns) {
			twn[size] = new Town(town);
			size++;
		}

		for (int i = 0; i < adjMatrix.length; i++) {
			for (int j = 0; j < adjMatrix[i].length; j++) {
				if (i == j || !containsEdge(twn[i], twn[j])) {
					adjMatrix[i][j] = 0;
				} else {
					int weight = getEdge(twn[i], twn[j]).getWeight();
					adjMatrix[i][j] = adjMatrix[j][i] = weight;
				}
			}
		}
    }
}