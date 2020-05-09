import java.util.ArrayList;

/**
 * Project 6: Town Network
 * CMSC 204 Professor Thai
 * Town.java
 * Stores name of the town and all adjacent towns and other fields as desired
 * Two towns are the same if their name is the same
 * @author Alec Felix
 *
 */
public class Town implements Comparable<Town>{
	private String name;
	private ArrayList<Town> adjacentTowns;
	
	/**
	 * Constructor requiring the Town's name
	 * @param name The name of this Town
	 */
	public Town(String name) {
		this.name = name;
		adjacentTowns = new ArrayList<Town>();
	}//constructor
	
	/**
	 * Constructor that copies the fields of another Town
	 * @param templateTown The town to be copied
	 */
	public Town(Town templateTown) {
		this.name = templateTown.name;
		
		this.adjacentTowns = new ArrayList<Town>();
		
		for(Town t: templateTown.adjacentTowns) {
			this.adjacentTowns.add(t);
		}//copy adjacent towns from TemplateTown
	}// copy constructor
	
	/**
	 * {@inheritDoc}
	 * @return 0 if names are equal, positive or negative integer if names are not equal
	 */
	@Override
	public int compareTo(Town t) {
		return name.compareTo(t.name);
	}// compareTo
	
	/**
	 * {@inheritDoc}
	 * @return the Town's name
	 */
	@Override
	public String toString() {
		return name;
	}//toString
	
	/**
	 * {@inheritDoc}
	 * @return the hashcode of the name data member (String) 
	 */
	@Override
	public int hashCode() {
		return name.hashCode();
	}//hashCode
	
	/**
	 * {@inheritDoc}
	 * @return if this Town's name is equal to the given Town's name
	 */
	@Override
	public boolean equals(Object obj) {
		if(obj == this)
			return true;
		
		if(!(obj instanceof Town))
			return false;
		
		Town t = (Town) obj;
		
		return this.name.equals(t.name);
			
	}//equals
	
	/**
	 * Return the Town's name
	 * @return the name of this road
	 */
	public String getName() {
		return name;
	}//getName
	
	/**
	 * Adds a new town to the list of adjacent towns if not already present
	 * @param t The town to be added
	 */
	public void addAdjacentTown(Town t) {
		if(adjacentTowns.contains(t))
			return;
		
		adjacentTowns.add(t);
	}//addAdjacentTown
	
	/**
	 * Removes a town from the list of adjacent towns
	 * @param t The town to be removed
	 */
	public void removeAdjacentTown(Town t) {
		adjacentTowns.remove(t);
	}//removeAdjacentTown
	
	/**
	 * Returns true if the given town is within the adjacent town list
	 * @param t The town to be checked
	 * @return whether the town is adjacent
	 */
	public boolean isAdjacentTo(Town t) {
		return adjacentTowns.contains(t);
	}//isAdjacentTo
	
	
}//Town
