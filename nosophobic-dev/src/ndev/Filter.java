package ndev;
import java.util.ArrayList;

/**
 * 
 * @author Anthony Xavier Mella
 * Searching Algorithm Implementation
 */
public class Filter {
	private static ArrayList<CDI> filteredCdis;
	private static ArrayList<CDI> filteredStates;
	/**
	 * Method implements a linear searching algorithm to filter out chronic disease indicators
	 * based on the string input. The method will return an arraylist containing the CDI's 
	 * that contain the input disease.
	 * 
	 * @param cdis a sorted list of chronic disease indicators
	 * @param disease the specific disease being searched for
	 * @return Returns a filtered list of CDI's that contain the disease we are searching for
	 * @throws Exception
	 */
	public static ArrayList<CDI> filterDisease(ArrayList<CDI> cdis, String disease) throws Exception{
		filteredCdis = new ArrayList<CDI>();
		
		if (cdis.size() == 0){
			throw new IllegalStateException();
		}

		for (int i = 0; i < cdis.size(); i++){
			if (cdis.get(i).getTopic() == disease)
				filteredCdis.add(cdis.get(i));
		}
		return filteredCdis;
	}
	
	/**
	 * Method implements a linear searching algorithm to filter out chronic disease indicators
	 * based on the string input. The method will return an arraylist containing the CDI's 
	 * that contain the input state.
	 * 
	 * @param cdis a sorted list of chronic disease indicators
	 * @param state a string of the state being searched for
	 * @return Returns a list of filtered CDI's containing the state being searched for
	 * @throws Exception 
	 */
	public static ArrayList<CDI> filterState(ArrayList<CDI> cdis, String state) throws Exception{
		filteredStates = new ArrayList<CDI>();
		
		if (cdis.size() == 0){
			throw new IllegalStateException();
		}
		
		for (int i = 0; i < cdis.size(); i++){
			if (cdis.get(i).getState() == state)
				filteredStates.add(cdis.get(i));
		}
		return filteredStates;

	}
	
	/**
	 * Getter for list of CDIs by disease
	 * @return ArrayList<CDI> filtered by disease
	 */
	public static ArrayList<CDI> getFilteredDiseases(){
		return filteredCdis;
	}
	
	/**
	 * Getter for list of CDIs by state
	 * @return ArrayList<CDI> filtered by state
	 */
	public static ArrayList<CDI> getFilteredStates(){
		return filteredStates;
	}
}
