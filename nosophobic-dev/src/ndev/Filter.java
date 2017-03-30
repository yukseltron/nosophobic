package ndev;
import java.util.ArrayList;

/**
 * 
 * @author Anthony Xavier Mella
 * Both are currently in linear time - subject to change
 */
public class Filter {
	
	/**
	 * 
	 * @param cdis List of chronic disease indicators
	 * @param disease
	 * @return Returns a filtered list of diseases.
	 * @throws Exception
	 */
	public static ArrayList<CDI> filterDisease(ArrayList<CDI> cdis, String disease) throws Exception{
		ArrayList<CDI> filteredCdis = new ArrayList<CDI>();

		for (int i = 0; i < cdis.size(); i++){
			if (cdis.get(i).getTopic() == disease)
				filteredCdis.add(cdis.get(i));
		}
		return filteredCdis;
	}
	
	/**
	 * 
	 * @param cdis
	 * @param state
	 * @return Returns a list of filtered states
	 * @throws Exception 
	 */
	public static ArrayList<CDI> filterState(ArrayList<CDI> cdis, String state) throws Exception{
		ArrayList<CDI> filteredStates = new ArrayList<CDI>();
		
		for (int i = 0; i < cdis.size(); i++){
			if (cdis.get(i).getState() == state)
				filteredStates.add(cdis.get(i));
		}
		return filteredStates;

	}

}
