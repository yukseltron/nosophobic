package ndev;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.io.File;
import java.util.Map;
import java.util.Scanner;

public class Graph {
	
	private final String[] states = {
			"AL",
			"AK",
			"AZ",
			"AR",
			"CA",
			"CO",
			"CT",
			"DE",
			"FL",
			"GA",
			"HI",
			"ID",
			"IL",
			"IN",
			"IA",
			"KS",
			"KY",
			"LA",
			"ME",
			"MD",
			"MA",
			"MI",
			"MN",
			"MS",
			"MO",
			"MT",
			"NE",
			"NV",
			"NH",
			"NJ",
			"NM",
			"NY",
			"NC",
			"ND",
			"OH",
			"OK",
			"OR",
			"PA",
			"RI",
			"SC",
			"SD",
			"TN",
			"TX",
			"UT",
			"VT",
			"VA",
			"WA",
			"WV",
			"WI",
			"WY"
	};
	
	private Map<String, List<String>> edges = new HashMap<String, List<String>>();
	
	
	
	public Graph(){
		String[] states;
		String state;
		ArrayList<String> connected;
		
		try{
			Scanner input = new Scanner(new File("data\\edges.txt"));
			while (input.hasNextLine()){
			connected = new ArrayList<String>();
			states = input.nextLine().split(",");
			state = states[0];
			
			for (int i = 1; i < states.length; i++){
				connected.add(states[i]);
			}
			this.edges.put(state, connected);
			}
			
			input.close();
		} catch (Exception e){
			e.printStackTrace();
		}
			
		
	} 

	public String[] getStates(){
		return this.states;
	}

	public boolean invalidState(String state){
		for (String cmpState : states){
			if(state.equals(cmpState)){
				return false;
			}
		}
		return true;
	}
	
	public String[] getEdges(String state){
		String[] edges = new String[this.edges.get(state).size()];
		for (int i = 0; i < this.edges.get(state).size(); i++){
			edges[i] = this.edges.get(state).get(i);
		}
		return edges;
	}	
}

