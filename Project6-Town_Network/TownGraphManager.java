import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
/**
 * Project 6: Town Network
 * CMSC 204 Professor Thai
 * TownGraphManager.java
 * Manager for a Graph representing a network of roads and Towns
 * @author Alec Felix
 *
 */
public class TownGraphManager implements TownGraphManagerInterface {
	private Graph roadNetwork;

	/**
	 * 
	 */
	public TownGraphManager() {
		roadNetwork = new Graph();
	}// constructor

	@Override
	public boolean addRoad(String town1, String town2, int weight, String roadName) {

		if (roadNetwork.addEdge(new Town(town1), new Town(town2), weight, roadName) == null)
			return false;

		return true;

	}// addRoad

	@Override
	public String getRoad(String town1, String town2) {
		return roadNetwork.getEdge(new Town(town1), new Town(town2)).getName();
	}// getRoad

	@Override
	public boolean addTown(String v) {
		return roadNetwork.addVertex(new Town(v));
	}// addTown

	@Override
	public Town getTown(String name) {
		return roadNetwork.getVertex(new Town(name));
	}// getTown

	@Override
	public boolean containsTown(String v) {
		return roadNetwork.containsVertex(new Town(v));
	}// containsTown

	@Override
	public boolean containsRoadConnection(String town1, String town2) {
		return roadNetwork.containsEdge(new Town(town1), new Town(town2));
	}// containsRoadConnection

	@Override
	public ArrayList<String> allRoads() {
		ArrayList<String> roads = new ArrayList<String>();

		for (Road road : roadNetwork.edgeSet()) {
			roads.add(road.getName());
		}
		if (roads.size() <= 0)
			return roads;

		Collections.sort(roads);

		return roads;
	}// allRoads

	@Override
	public boolean deleteRoadConnection(String town1, String town2, String road) {
		if (roadNetwork.removeEdge(new Town(town1), new Town(town2), 0, road) == null)
			return false;

		return true;
	}// deleteRoadConnection

	@Override
	public boolean deleteTown(String v) {
		return roadNetwork.removeVertex(new Town(v));
	}// deleteTown

	@Override
	public ArrayList<String> allTowns() {
		ArrayList<String> towns = new ArrayList<String>();

		for (Town town : roadNetwork.vertexSet()) {
			towns.add(town.getName());
		}
		if (towns.size() <= 0)
			return towns;

		Collections.sort(towns);

		return towns;
	}// allTowns

	@Override
	public ArrayList<String> getPath(String town1, String town2) {
		return roadNetwork.shortestPath(new Town(town1), new Town(town2));
	}// getPath

	public void populateTownGraph(File selectedFile) throws FileNotFoundException, IOException {
		String[] tokens;
		String currentLine;

		Scanner fileReader = new Scanner(selectedFile);

		while (fileReader.hasNextLine()) {
			currentLine = fileReader.nextLine();
			tokens = currentLine.split(";|,");
			roadNetwork.addVertex(new Town(tokens[2]));
			roadNetwork.addVertex(new Town(tokens[3]));
			roadNetwork.addEdge(new Town(tokens[2]), new Town(tokens[3]), Integer.parseInt(tokens[1]), tokens[0]);
		} // loop to read file
		
		fileReader.close();

	}//populateTownGraph

}
