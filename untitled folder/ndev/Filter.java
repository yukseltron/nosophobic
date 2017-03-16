package ndev;
import java.util.ArrayList;

public class Filter {
	
	public ArrayList<CDI> filterDisease(ArrayList<CDI> cdis, String disease){
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
		int first = 0;
		int last = 0;
		
		for (int i = 0; i < cdis.length(); i++){
			if (cdis[i+1] == state)
				first = cdis[i];
			if (cdis[i-1] == state && cdis[i+1] != state)
				last = cdis[i];
		}
		ArrayList<CDI> filteredStates = cdis.subArray(cdis[first], cdis[last]);
		return filteredStates;

	}
	
	
	
	

}
