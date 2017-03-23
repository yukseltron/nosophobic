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
	 * @param cdis
	 * @param disease
	 * @return Returns a filtered list of diseases.
	 * @throws Exception
	 */
	public ArrayList<CDI> filterDisease(ArrayList<CDI> cdis, String disease) throws Exception{
		cdis = DataCollection.getList();
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
	public ArrayList<CDI> filterState(ArrayList<CDI> cdis, String state) throws Exception{
		cdis = DataCollection.getList();
		ArrayList<CDI> filteredStates = new ArrayList<CDI>();
		for (int i = 0; i < cdis.size(); i++){
			if (cdis.get(i).getState() == state)
				filteredStates.add(cdis.get(i));
		}
		
		return filteredStates;

	}
	

}
