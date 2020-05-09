import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;
/**
 * Project 6: Town Network
 * CMSC 204 Professor Thai
 * Graph.java
 * Represents a network of roads and towns as a Graph of Towns
 * @author Alec Felix
 *
 */
public class Graph implements GraphInterface<Town, Road> {
	// private HashMap<String,Town> adjacencyList;

	private HashMap<String, Town> towns; // store each town which contains list of adjacent towns key= town name
	private HashSet<Road> roads;// store all edges of the graph
	private HashMap<Town, ArrayList<String>> listOfPaths;
	private HashMap<Town, Integer> dist;
	private final int INFINITY = -1;// represent infinity in the dist Map since for djkstra edges must be positive
									// values

	/**
	 * Constructor
	 */
	public Graph() {
		towns = new HashMap<String, Town>();
		roads = new HashSet<Road>();
	}// constructor

	@Override
	public Road getEdge(Town sourceVertex, Town destinationVertex) {
		if (sourceVertex == null || destinationVertex == null)
			return null;

		if (!containsVertex(sourceVertex) || !containsVertex(destinationVertex))
			return null;
		// System.out.println(roads);
		// System.out.println(edgesOf(sourceVertex));
		for (Road r : edgesOf(sourceVertex)) {
			if (r.getDestination().equals(destinationVertex))
				return r;
		} // look through adjacent vertices

		return null;
	}//getEdge
	
	/**
	 * Returns the Town if contained in the graph
	 * @param vertex Town to get
	 * @return Town or null if nonexsistant
	 */
	public Town getVertex(Town vertex) {
		return towns.get(vertex.getName());
	}//getVertex

	@Override
	public Road addEdge(Town sourceVertex, Town destinationVertex, int weight, String description) {
		Road newRoad;

		if (sourceVertex == null || destinationVertex == null)
			throw new NullPointerException();

		if (!containsVertex(sourceVertex) || !containsVertex(destinationVertex))
			throw new IllegalArgumentException();

		newRoad = new Road(sourceVertex, destinationVertex, weight, description);

		// update towns adjacent towns list
		towns.get(sourceVertex.getName()).addAdjacentTown(destinationVertex);
		towns.get(destinationVertex.getName()).addAdjacentTown(sourceVertex);

		roads.add(newRoad);

		return newRoad;
	}// addEdge

	@Override
	public boolean addVertex(Town v) {
		if (v == null)
			throw new NullPointerException();

		if (containsVertex(v))
			return false;

		towns.put(v.getName(), new Town(v));

		return true;
	}// addVertex

	@Override
	public boolean containsEdge(Town sourceVertex, Town destinationVertex) {
		if (!containsVertex(sourceVertex) || !containsVertex(destinationVertex))
			return false;

		return towns.get(sourceVertex.getName()).isAdjacentTo(destinationVertex);
	}// containsEdge

	@Override
	public boolean containsVertex(Town v) {
		if(v == null)
			return false;
		
		return towns.containsKey(v.getName());
	}// containsVertex

	@Override
	public Set<Road> edgeSet() {
		return roads;
	}// edgeSet

	@Override
	public Set<Road> edgesOf(Town vertex) {
		Set<Road> adjacencies;
		if (vertex == null)
			throw new NullPointerException();

		if (!containsVertex(vertex))
			throw new IllegalArgumentException();

		adjacencies = new HashSet<Road>();

		for (Road road : roads) {
			if (road.getSource().equals(vertex))
				adjacencies.add(road);
			else if (road.getDestination().equals(vertex))
				adjacencies.add(new Road(vertex, road.getSource(), road.getWeight(), road.getName()));
		} // add the road with vertex as the source town

		return adjacencies;
	}// edgesOf

	@Override
	public Road removeEdge(Town sourceVertex, Town destinationVertex, int weight, String description) {
		boolean noRoadsBetween = true;
		
		if(sourceVertex == null || destinationVertex == null)
			return null;
		
		Road removedRoad = new Road(sourceVertex, destinationVertex, weight, description);

		if (roads.remove(removedRoad)) {

			for (Road road : roads) {
				if (road.contains(sourceVertex) && road.contains(destinationVertex))
					noRoadsBetween = false;
			} // check if no more roads between two towns

			if (noRoadsBetween) {
				towns.get(sourceVertex.getName()).removeAdjacentTown(destinationVertex);
				towns.get(destinationVertex.getName()).removeAdjacentTown(sourceVertex);
			}
		} // successful removal

		return null;
	}//removeEdge

	@Override
	public boolean removeVertex(Town v) {
		Road currentRoad;
		if (!containsVertex(v))
			return false;

		Iterator<Road> iter = roads.iterator();
		while (iter.hasNext()) {
			currentRoad = iter.next();

			if (currentRoad.contains(v))
				iter.remove();
		} // remove all connecting roads

		towns.remove(v.getName());

		return true;
	}// removeVertex

	@Override
	public Set<Town> vertexSet() {
		Set<Town> vertexSet = new HashSet<Town>();

		towns.forEach((k, v) -> vertexSet.add(v));

		return vertexSet;
	}// vertexSet

	@Override
	public ArrayList<String> shortestPath(Town sourceVertex, Town destinationVertex) {
		
		dijkstraShortestPath(sourceVertex);

		if (dist.get(destinationVertex) == INFINITY) {
			return new ArrayList<String>();
		}//path is unreachable

		return listOfPaths.get(destinationVertex);//return path to destinationVertex
	}// shortestPath

	@Override
	public void dijkstraShortestPath(Town sourceVertex) {
		HashMap<Town, Boolean> visitedTowns = new HashMap<Town, Boolean>();// store whether this town has already been
																			// visited
		dist = new HashMap<Town, Integer>();// store the minimum found distance to each town from the source
		listOfPaths = new HashMap<Town, ArrayList<String>>();// store the list Towns in each shortestPath
		PriorityQueue<Vector2D> queue = new PriorityQueue<Vector2D>();// used to determine which node to visit next
		Vector2D currentTown;
		int newDist;
		// initialize dist to all infinity and visitedTowns to false
		for (Map.Entry<String, Town> entry : towns.entrySet()) {
			visitedTowns.put(entry.getValue(), false);
			dist.put(entry.getValue(), INFINITY);
		} // initialze values

		dist.put(sourceVertex, 0);
		queue.add(new Vector2D(sourceVertex, 0));

		while (!queue.isEmpty()) {
			currentTown = queue.poll();
			visitedTowns.replace(currentTown.town, true);// show that we have visited this town

			if (dist.get(currentTown.town) != INFINITY && dist.get(currentTown.town) < currentTown.distance)
				continue;// skip this town since we've already found a shorter path through other nodes

			for (Road road : edgesOf(currentTown.town)) {

				if (visitedTowns.get(road.getDestination()) == true)
					continue;// skip town if we have already visited it because the shortest path has been
								// found

				newDist = dist.get(currentTown.town) + road.getWeight();// distance to each adjacent vertex from this
																		// vertex

				if (newDist < dist.get(road.getDestination()) || dist.get(road.getDestination()) == INFINITY) {
					// change min distance in dist Map to newDist
					dist.replace(road.getDestination(), newDist);
					queue.add(new Vector2D(road.getDestination(), newDist));
					// update path to this adj town with path to currentTown plus adjTown
					if (listOfPaths.get(currentTown.town) == null) {
						// if there is no path to the current town create a fresh path for this adj town
						listOfPaths.put(road.getDestination(), new ArrayList<String>());
					} else {
						// Otherwise the path to this adj town is the path to the current town plus the
						// adj town
						listOfPaths.put(road.getDestination(),
								new ArrayList<String>(listOfPaths.get(currentTown.town)));
					}
					listOfPaths.get(road.getDestination()).add(road.toString());
				} // the new dist is less than previously found minimum distance

			} // loop through all roads from current town
		} // loop until queue of next vertices to visit is empty
	}// dijkstraShortestPath
	
	/**
	 * Private inner class used to store a (Town,int) together as a Vector
	 * Used within the Djkstra algorithm to determine which town to visit next based on which
	 * has the lowest distance
	 * @author Alec Felix
	 *
	 */
	private class Vector2D implements Comparable<Vector2D> {
		Town town;
		int distance;
		
		/**
		 * 
		 * @param town the town data
		 * @param distance the in distance
		 */
		public Vector2D(Town town, int distance) {
			this.town = town;
			this.distance = distance;
		}// constructor
		
		/**
		 * {@inheritDoc}
		 * @return this.distance - other.distance
		 */
		@Override
		public int compareTo(Vector2D otherVector) {
			return this.distance - otherVector.distance;
		}// compareTo

	}// inner class to store Town,distance pair as 2D vector

}// TownGraph
