/**
 * The class Town represents an town as a node of a graph
 * @author tsega
 */
import java.util.ArrayList;

	//  Represents an town as a node of a graph.
public class Town implements Comparable<Town> {
	
	private ArrayList<Road> roadArrayList;

	private String name;

	public Town(String name) {
		this.name = name;
		roadArrayList = new ArrayList<Road>();
	}

	public Town(Town templateTown) {
		this(templateTown.name);
	}
	
	public String getName() {
		return name;
	}

	@Override
	public int compareTo(Town o) {
		return this.name.compareTo(o.name);
	}

	@Override
	public String toString() {
		return name;
	}
	
	@Override
	public int hashCode() {
		return name.hashCode();
	}
	
	@Override
	public boolean equals(Object obj) {
		Town town = (Town) obj;
		return this.name.compareTo(town.name) == 0;
	}
	
}
