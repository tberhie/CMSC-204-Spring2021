    /**
     * The class Road  represent the edges of a Graph of Towns.
     * @author tsega
     * 
     **/

public class Road implements Comparable<Road>{
   
    private Town source;
    private Town destination;
    private int degree;
    private String name;


    public Road(Town source, Town destination, int degree, String name) {
        this.source = source;
        this.destination = destination;
        this.degree = degree;
        this.name = name;
    }


    public Road(Town source, Town destination, String name) {
        this.source = source;
        this.destination = destination;
        this.name = name;
    }
    
    public boolean contains(Town town) {
        return source.getName().equals(town.getName()) ||
                destination.getName().equals(town.getName());
    }
    
    @Override
    public String toString() {
        return name + "-" + degree + "-" + source + "-" + destination;
    }

    public String getName() {
        return name;
    }
    
    public Road(Road templateRoad) {
        this(templateRoad.source, templateRoad.destination,
                templateRoad.degree, templateRoad.name);
    }

    public boolean equals(Object r) {
        Road road = (Road) r;
        return (road.destination.equals(this.destination)
                && road.source.equals(this.source)) ||
                (road.destination.equals(this.source)
                        && road.source.equals(this.destination));
    }
    
    public int getWeight() {
        return degree;
    }
    
    @Override
    public int compareTo(Road o) {
        return this.name.compareTo(o.name);
    }
    
}
