package ndev;
import java.util.ArrayList;

public class Filter {
	
	public ArrayList<CDI> filterDisease(ArrayList<CDI> cdis, String disease){
		cdis = DataCollection.getList();
		int first = 0;
		int last = 0;
		
		for (int i = 0; i < cdis.length(); i++){
			if (cdis[i+1] == disease)
				first = cdis[i];
			if (cdis[i-1] == disease && cdis[i+1] != disease)
				last = cdis[i];
		}
		ArrayList<CDI> filteredCdis = cdis.subArray(cdis[first], cdis[last]);
		return filteredCdis;
	}
	
	public ArrayList<CDI> filterState(ArrayList<CDI> cdis, String state){
		ArrayList<CDI> filteredStates = new ArrayList<CDI>();
		for (int i = 0; i < cdis.length(); i++){
			if (cdis[i] == state)
				filteredStates.add(cdis[i]);
		}
		
		return filteredStates;

	}
	
	
	
	

}
