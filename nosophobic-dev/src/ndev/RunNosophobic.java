package ndev;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Puts all of the modules together and runs the project.
 * 
 * @author Bartosz Kosakowski
 *
 */
public class RunNosophobic {
	public static void main(String[] args) throws Exception {
		DataCollection.readFile();
		
		Scanner userIn = new Scanner(System.in);
		System.out.println("Enter either a state, a disease, or both");
		String userSelection = userIn.nextLine();
		
		
		if (userSelection.toLowerCase().equals("both")){
			System.out.println("Enter a state: ");
			String stateChosen = userIn.nextLine();
			System.out.println("Enter a disease: ");
			String diseaseChosen = userIn.nextLine();
		}
	}
}//end of RunNosophobic
