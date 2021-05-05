/**
 *  TownGraphManager will hold an object of our Graph
 * 
 * @author tsega
 */

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class TownGraphManager implements TownGraphManagerInterface {

    private Graph graph = new Graph();



    @Override
    public ArrayList<String> getPath(String town1, String town2) {
        return graph.shortestPath(new Town(town1), new Town(town2));
    }
    /**
     * Adds a road with 2 towns and a road name
     * @param town1 name of town 1 (lastname, firstname)
     * @param town2 name of town 2 (lastname, firstname)
     * @param roadName name of road
     * @return true if the road was added successfully
     */
    @Override
    public boolean addRoad(String town1, String town2, int weight, String roadName) {
        return graph.addEdge(new Town(town1), new Town(town2), weight, roadName) != null;
    }

    /**
     * Returns the name of the road that both towns are connected through
     * @param town1 name of town 1 (lastname, firstname)
     * @param town2 name of town 2 (lastname, firstname)
     * @return name of road if town 1 and town2 are in the same road, returns null if not
     */
    @Override
    public String getRoad(String town1, String town2) {
        return graph.getEdge(new Town(town1), new Town(town2)).getName();
    }

    /**
     * Adds a town to the graph
     * @param v the town's name  (lastname, firstname)
     * @return true if the town was successfully added, false if not
     */

    @Override
    public boolean addTown(String v) {
        return graph.addVertex(new Town(v));
    }

    /**
     * Gets a town with a given name
     * @param name the town's name
     * @return the Town specified by the name, or null if town does not exist
     */
    @Override
    public Town getTown(String name) {
        Town town = null;
        for (Town townName : graph.vertexSet()) {
            if (townName.getName().equals(name)) {
                town = townName;
            }
        }
        return town;
    }
    /**
     * Determines if a town is already in the graph
     * @param v the town's name
     * @return true if the town is in the graph, false if not
     */
    @Override
    public boolean containsTown(String v) {
        return graph.containsVertex(getTown(v));
    }

    /**
     * Determines if a road is in the graph
     * @param town1 name of town 1 (lastname, firstname)
     * @param town2 name of town 2 (lastname, firstname)
     * @return true if the road is in the graph, false if not
     */
    @Override
    public boolean containsRoadConnection(String town1, String town2) {
        return graph.containsEdge(new Town(town1), new Town(town2));
    }

    /**
     * Creates an arraylist of all road titles in sorted order by road name
     * @return an arraylist of all road titles in sorted order by road name
     */
    @Override
    public ArrayList<String> allRoads() {
        ArrayList<String> roads = new ArrayList<>();
        for (Road rd : graph.edgeSet()) {
            roads.add(rd.getName());
        }
        Collections.sort(roads);
        return roads;
    }

    /**
     * Deletes a road from the graph
     * @param town1 name of town 1 (lastname, firstname)
     * @param town2 name of town 2 (lastname, firstname)
     * @param road the road name
     * @return true if the road was successfully deleted, false if not
     */

    @Override
    public boolean deleteRoadConnection(String town1, String town2, String road) {
        int weight = 0;
        for (Road rd : graph.edgeSet()) {
            if (rd.getName().equals(getRoad(town1, town2))) {
                weight = rd.getWeight();
            }
        }
        return graph.removeEdge(new Town(town1),
                new Town(town2), weight, road) != null;
    }

    /**
     * Deletes a town from the graph
     * @param v name of town (lastname, firstname)
     * @return true if the town was successfully deleted, false if not
     */

    @Override
    public boolean deleteTown(String v) {
        return graph.removeVertex(getTown(v));
    }

    /**
     * Creates an arraylist of all towns in alphabetical order (last name, first name)
     * @return an arraylist of all towns in alphabetical order (last name, first name)
     */
    @Override
    public ArrayList<String> allTowns() {
        ArrayList<String> towns = new ArrayList<>();
        for (Town t : graph.vertexSet()) {
            towns.add(t.getName());
        }
        Collections.sort(towns);
        return towns;  
    }
    
    
	public void populateTownGraph(File selectedFile) throws IOException, FileNotFoundException {
		// TODO Auto-generated method stub
	   Scanner keyboard = new Scanner(selectedFile);
       String[] st;
       String line;

       while(keyboard.hasNextLine())
       {
           line = keyboard.nextLine();
           st = line.split(";|,");
           graph.addEdge(new Town(st[2]), new Town(st[3]), Integer.parseInt(st[1]), st[0]);
       }
		
	}
}

