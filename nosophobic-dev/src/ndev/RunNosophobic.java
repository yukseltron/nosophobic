package ndev;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Puts all of the modules together and runs the project.
 * 
 * @author Bartosz Kosakowski, Owen Mitchell
 *
 */
public class RunNosophobic {
	public static void main(String[] args) throws Exception {
		DataCollection.readFile();
		Scanner userIn = new Scanner(System.in);
		System.out.println("Enter either a state, a disease, or both");
		String userSelection = userIn.nextLine();
		
		if (userSelection.toLowerCase().equals("both")){
			ArrayList<CDI> listNodes;
			CDI[] arrayNodes;
			System.out.println("Enter a state: ");
			String stateChosen = userIn.nextLine();
			System.out.println("Enter a disease: ");
			String diseaseChosen = userIn.nextLine();
			
			listNodes = Filter.filterDisease(Filter.filterState(DataCollection.getList(), stateChosen), diseaseChosen);
			arrayNodes = new CDI[listNodes.size()];
			for (int i = 0; i < arrayNodes.length; i++){
				arrayNodes[i] = listNodes.get(i);
			}
			
			Sort.sort(arrayNodes, "danger");
			System.out.println("Top 10 CID's for " + diseaseChosen + " in " + stateChosen);
			for (int i = arrayNodes.length - 1; i > arrayNodes.length - 11; i--){
				System.out.printf("Danger: %f	Longitude: %f	Latitude: %f\n", arrayNodes[i].getDanger(), arrayNodes[i].getLo(), arrayNodes[i].getLa());
			}
		}
		/**
		 * if the user enters just by state, then the output will be the CDIs with the top
		 * three highest total danger levels
		 */
		else if (userSelection.toLowerCase().equals("state")){
			ArrayList<CDI> listNodes;
			System.out.println("Enter a state: ");
			String stateChosen = userIn.nextLine();
			
			//filters out data to be only the specified state
			listNodes = Filter.filterState(DataCollection.getList(), stateChosen);
			
			//sorts it by disease
			CDI[] arrayNodes = new CDI[listNodes.size()];
			arrayNodes = listNodes.toArray(arrayNodes);
			Sort.sort(arrayNodes, "disease");
			
			//sums up danger value for each cdi in the sorted data and stores it in a new array
			Float[] outputData = new Float[arrayNodes.length];
			ArrayList<CDI> sortedData = new ArrayList<CDI>(Arrays.asList(arrayNodes));
			System.out.println(listNodes.size());
			System.out.println(arrayNodes[0].getTopic());
			System.out.println(arrayNodes[0].getState());
			System.out.println(sumDanger(sortedData, arrayNodes[0].getState(), arrayNodes[0].getTopic()));
			int j = 0;
			for (int i = 0; i < arrayNodes.length-1; i++){
				if (!(arrayNodes[i].getTopic().equals(arrayNodes[i+1].getTopic()))){
					outputData[j] = sumDanger(sortedData, arrayNodes[i+1].getState(), arrayNodes[i+1].getTopic());
				}
			}
		}
	}//end of main method
	
	public static float sumDanger(ArrayList<CDI> cdis, String state, String disease) throws Exception{
		ArrayList<CDI> tempCDIs = Filter.filterState(cdis, state);
		tempCDIs = Filter.filterDisease(tempCDIs, disease);
		float sumDanger = 0;
		for (CDI c : tempCDIs){
			sumDanger += c.getDanger();
		}
		return sumDanger;
	}//end of sumDanger
	
}//end of RunNosophobic
