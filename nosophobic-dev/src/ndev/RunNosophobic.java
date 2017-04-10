package ndev;

import java.util.ArrayList;
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
		
		if (userSelection.toLowerCase().equals("disease")){
			System.out.println("Enter a disease: ");
			String diseaseChosen = userIn.nextLine();
			ArrayList<CDI> nodes = Filter.filterDisease(DataCollection.getList(), diseaseChosen);
			//sort the diseases by state, then sum the danger for each state, then return
			CDI[] arrayNodes = (CDI[]) nodes.toArray();
			Sort.sort(arrayNodes, "state");
			
			
			
			
			
			
			
		}
		
		
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
	}
	
	public float sumDanger(CDI[] cdiList){
		float totalDanger = 0;
		for (CDI i : cdiList){
			totalDanger += i.getDanger();
		}
		return totalDanger;
		
	}
}//end of RunNosophobic
