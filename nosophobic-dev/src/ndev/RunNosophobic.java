package ndev;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

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
		System.out.println("Enter either \"state\", or \"both\" for state and disease:");
		String userSelection = userIn.nextLine();

		if (userSelection.toLowerCase().equals("both")) {
			doBoth();
		}
		/**
		 * if the user enters just by state, then the output will be the CDIs
		 * with the top three highest total danger levelss
		 */
		else if (userSelection.toLowerCase().equals("state")) {
			doState();
		} // end of "state" branch
		userIn.close();
	}// end of main method

	private static void doBoth() throws Exception {
		Scanner userIn = new Scanner(System.in);
		System.out.println("Enter a US state abbreviation: ");
		String stateChosen = userIn.nextLine();
		System.out.println("Enter a disease: ");
		String diseaseChosen = userIn.nextLine();

		ArrayList<CDI> listNodes = Filter.filterDisease(Filter.filterState(DataCollection.getList(), stateChosen), diseaseChosen);
		CDI[] arrayNodes = new CDI[listNodes.size()];
		
		for (int i = 0; i < arrayNodes.length; i++) {
			arrayNodes[i] = listNodes.get(i);
		}

		Sort.sort(arrayNodes, "danger");
		System.out.println("Top 10 CID's for " + diseaseChosen + " in " + stateChosen);
		
		for (int i = arrayNodes.length - 1; i > arrayNodes.length - 11; i--) {
			System.out.printf("Danger: %f	Longitude: %f	Latitude: %f\n", arrayNodes[i].getDanger(),
					arrayNodes[i].getLo(), arrayNodes[i].getLa());
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
	}// end of sumDanger

}// end of RunNosophobic
