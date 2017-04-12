package ndev;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

import com.sun.corba.se.impl.orbutil.graph.Graph;

/**
 * Puts all of the modules together and runs the project.
 * 
 * @author Bartosz Kosakowski, Owen Mitchell, Hamid Yuksel
 *
 */
public class RunNosophobic {
	public static void main(String[] args) throws Exception {
		DataCollection.readFile();
		Scanner userIn = new Scanner(System.in);
		System.out.println("Enter either \"state\", \"disease\", or \"both\":");
		String userSelection = userIn.nextLine();

		if (userSelection.toLowerCase().equals("both")) {
			System.out.println("Enter either info or graph");
			userSelection = userIn.nextLine();
			doBoth(userSelection);
		}
		/**
		 * if the user enters just by state, then the output will be the CDIs
		 * with the top three highest total danger levelss
		 */
		else if (userSelection.toLowerCase().equals("state")) {
			doState();
		}
		else if (userSelection.toLowerCase().equals("disease")) {
			doDisease();
		}
		userIn.close();
	}// end of main method

	private static void doBoth(String userSelection) throws Exception {
		Scanner userIn = new Scanner(System.in);
		System.out.println("Enter a US state abbreviation: ");
		String stateChosen = userIn.nextLine();
		System.out.println("Enter a disease: ");
		String diseaseChosen = userIn.nextLine();
		
		if (userSelection.equals("info")){
			ArrayList<CDI> listNodes;
			CDI[] arrayNodes;
			listNodes = Filter.filterDisease(Filter.filterState(DataCollection.getList(), stateChosen), diseaseChosen);
			arrayNodes = new CDI[listNodes.size()];
			
			for (int i = 0; i < arrayNodes.length; i++) {
				arrayNodes[i] = listNodes.get(i);
			}

			Sort.sort(arrayNodes, "danger");
			System.out.println("Top 10 CID's for " + diseaseChosen + " in " + stateChosen);
			
			for (int i = arrayNodes.length - 1; i > arrayNodes.length - 11; i--) {
				System.out.printf("Danger: %f	Longitude: %f	Latitude: %f\n", arrayNodes[i].getDanger(),
						arrayNodes[i].getLo(), arrayNodes[i].getLa());
			}
		}
		
		else if (userSelection.equals("graph")){
			System.out.println("Determaining safest path");
			ArrayList<String> path = new ArrayList<String>();
			Graph america = new Graph();
			String state = stateChosen;
			path.add(state);
			
			while (betterEdge(state, diseaseChosen, america, DataCollection.getList()) != state){
				state = betterEdge(state, diseaseChosen, america, DataCollection.getList());
				path.add(state);
			}
			
			System.out.println("Outputting path");
			
			for (int i = 0; i < path.size(); i++)
				System.out.println(path.get(i));
			
		}
		userIn.close();
	}
	
	private static void doState() throws Exception {
		Scanner userIn = new Scanner(System.in);
		ArrayList<CDI> listNodes;
		System.out.println("Enter a US state abbreviation: ");
		String stateChosen = userIn.nextLine();

		// filters out data to be only the specified state
		listNodes = Filter.filterState(DataCollection.getList(), stateChosen);

		// sorts data by disease
		CDI[] arrayNodes = new CDI[listNodes.size()];
		arrayNodes = listNodes.toArray(arrayNodes);
		Sort.sort(arrayNodes, "disease");
		
		ArrayList<CDI> listData = getListData(arrayNodes);
		
		CDI[] finalDataArray = new CDI[listData.size()];
		finalDataArray = listData.toArray(finalDataArray);
		Sort.sort(finalDataArray, "danger");
		listData = new ArrayList<CDI>(Arrays.asList(finalDataArray));
		//removes any duplicated data points so that there is only unique values 
		boolean repititionsPresent = true;
		
		while (repititionsPresent) {
			for (int i = 0; i < listData.size() - 1; i++) {
				if (listData.get(i).getDanger() == listData.get(i + 1).getDanger()) {
					listData.remove(i);
					repititionsPresent = true;
				}
				else{
					repititionsPresent = false;
				}
			}
		}
		/**
		 * Prints the data to the console
		 * MODIFY HERE IF YOU WANT TO PUT STUFF ONTO MAPS OR WHATEVER; listData STORES
		 * THE DESIRED DATA (that is, the sum of a given disease's danger values, in
		 * decreasing order).
		 */
		System.out.printf("The top 3 most prevalent CDI's for " + stateChosen + " are: \n(CDI, sum of danger value)\n");
		for (int i = 0; i < 3; i++ ) {
			System.out.println(listData.get(i).getTopic() + ", " + listData.get(i).getDanger());
		}
		
		userIn.close();
	}
	
	private static void doDisease() throws Exception {
		Scanner userIn = new Scanner(System.in);
		ArrayList<CDI> sameDiseaseCDI;
		System.out.println("Enter a disease: ");
		String diseaseChosen = userIn.nextLine();

		// Filters out the data that isn't associated with the given disease
		sameDiseaseCDI = Filter.filterDisease(DataCollection.getList(), diseaseChosen);

		CDI[] sameDiseaseCDIArray = new CDI[sameDiseaseCDI.size()];
		sameDiseaseCDIArray = sameDiseaseCDI.toArray(sameDiseaseCDIArray);
		Sort.sort(sameDiseaseCDIArray, "state");
		ArrayList<CDI> sortedList = new ArrayList<CDI>(Arrays.asList(sameDiseaseCDIArray));
		int totalStates = 0;

		// Stores the states and the danger level in a HashMap
		HashMap<String, String> map = new HashMap<String, String>();
		for (int i = 0; i < sameDiseaseCDIArray.length - 1; i++){
			if (sameDiseaseCDIArray[i].getState() != sameDiseaseCDIArray[i+1].getState()){
				float dangerLevel = sumDanger(sameDiseaseCDI, sameDiseaseCDIArray[i].getState(), diseaseChosen);
				map.put(sameDiseaseCDIArray[i].getState(), String.valueOf(dangerLevel));
			}
		}
		
		System.out.println("\nThe sum of the CDI's pertaining to the disease " + diseaseChosen + " for each state are: ");
		System.out.println("(State, Danger level)");
		
		for (String name: map.keySet()){
	        String key =name.toString();
	        String value = map.get(name).toString();
			System.out.println(key + " " + value);
		}
		userIn.close();
	}
	
	/**
	 * Sums up the danger values for all of the diseases in a given state and stores them
	 * in outputData. sortedData is needed for sumDanger to compute the sum of the danger
	 * values; the final data gets stored in listData
	 */
	static ArrayList<CDI> getListData(CDI[] arrayNodes) throws Exception {
		int j = 0;
		ArrayList<CDI> listData = new ArrayList<CDI>();
		ArrayList<CDI> sortedData = new ArrayList<CDI>(Arrays.asList(arrayNodes));
		ArrayList<Float> outputData = new ArrayList<Float>();
		
		for (int i = 0; i < arrayNodes.length - 1; i++) {
			outputData.add(j, sumDanger(sortedData, arrayNodes[i].getState(), arrayNodes[i].getTopic()));
			CDI temp = new CDI(0, arrayNodes[i].getState(), arrayNodes[i].getTopic(), "%", outputData.get(j), 0.0f,
					0.0f, 0.0f, 0.0f);
			listData.add(j, temp);
			
			if (!(arrayNodes[i].getTopic().equals(arrayNodes[i + 1].getTopic()))) {
				j++;
			}
		}
		return listData;
	}
	
	public static float sumDanger(ArrayList<CDI> cdis, String state, String disease) throws Exception {
		ArrayList<CDI> tempCDIs = Filter.filterState(cdis, state);
		tempCDIs = Filter.filterDisease(tempCDIs, disease);
		float sumDanger = 0;
		for (CDI c : tempCDIs) {
			sumDanger += c.getDanger();
		}
		return sumDanger;
	}

	public static String betterEdge(String state, String disease, Graph graph, ArrayList<CDI> cdis){
		float currentVal, cmpVal, minVal;
		String minState;
		try{
			currentVal = sumDanger(cdis, state, disease);
			minState = state;
			minVal = currentVal;
			for (String contigState : graph.getEdges(state)){
				cmpVal = sumDanger(cdis, contigState, disease);
				if (cmpVal < minVal){
					minVal = cmpVal;
					minState = contigState;
				}
			}
			return minState;
		} catch (Exception e){
			e.printStackTrace();
		}
		return state;
	}
}
