/**
 * Project 6: Town Network CMSC 204 Professor Thai Road.java Represents the
 * edges of a Undirected Graph of Town's. Has references to two vertices,
 * distance between vertices, and name
 * 
 * @author Alec Felix
 */
public class Road implements Comparable<Road> {
	private Town source, destination;
	private int degrees;
	private String name;

	/**
	 * Constructor
	 * 
	 * @param source      One town on the road
	 * @param destination Another town on the road
	 * @param degrees     Distance from one town to another
	 * @param name        The name of the road
	 */
	public Road(Town source, Town destination, int degrees, String name) {
		this.source = new Town(source);
		this.destination = new Town(destination);

		this.name = name;
		this.degrees = degrees;
	}// constructor

	/**
	 * Constructor with default edge weight of 1.
	 * 
	 * @param source      One town on the road
	 * @param destination Another town on the road
	 * @param name        The name of the road
	 */
	public Road(Town source, Town destination, String name) {
		this.source = new Town(source);
		this.destination = new Town(destination);

		this.name = name;
		this.degrees = 1;
	}// constructor

	/**
	 * {@inheritDoc}
	 * 
	 * @return 0 if the road names are the same, positive or negative number if road names are not the same
	 */
	@Override
	public int compareTo(Road otherRoad) {
		return this.name.compareTo(otherRoad.name);
	}// compareTo

	/**
	 * Tells whether this road contains the specified town
	 * 
	 * @param town the vertex of the graph
	 * @return true if the edge is connected to the given vertex
	 */
	public boolean contains(Town town) {
		return this.source.equals(town) || this.destination.equals(town);
	}// contains

	/**
	 * {@inheritDoc}
	 * 
	 * @return String representation of road 
	 */
	@Override
	public String toString() {
		return source.getName() + " via " + name + " to " + destination.getName() + " " + degrees + " mi";
	}// toString

	/**
	 * Getter for name this road name attribute
	 * 
	 * @return the name of this road
	 */
	public String getName() {
		return name;
	}// getName

	/**
	 * Getter for destination town
	 * 
	 * @return the destination town
	 */
	public Town getDestination() {
		return destination;
	}// getDestination

	/**
	 * Getter for source town
	 * 
	 * @return the source town
	 */
	public Town getSource() {
		return source;
	}// getSource

	/**
	 * Getter for edge weight
	 * 
	 * @return the edge weight
	 */
	public int getWeight() {
		return degrees;
	}// getWeight

	/**
	 * {@inheritDoc}
	 * 
	 * @return true if the ends of this road are the same as the ends of the given
	 *         road
	 */
	@Override
	public boolean equals(Object obj) {
		if (obj == this)
			return true;

		if (!(obj instanceof Road))
			return false;

		Road r = (Road) obj;

		return (this.source.equals(r.source) && this.destination.equals(r.destination))
				|| (this.source.equals(r.destination) && this.destination.equals(r.source));
	}// equals
	
	/**
	 * {@inheritDoc}
	 * @return the hashCode of the road name (String)
	 */
	@Override
	public int hashCode() {
		return name.hashCode();
	}//hashCode

}// Road
