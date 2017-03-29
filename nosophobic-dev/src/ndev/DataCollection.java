package ndev;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class DataCollection {
	private static String file = "data/uscdi.csv";
    private static BufferedReader br = null;
    private static ArrayList<CDI> cdis = new ArrayList<CDI>();

    
    public static void readFile() {
	    try {
	    	br = new BufferedReader(new FileReader(file));
	    	String line = "";
	    	while ((line = br.readLine()) != null) {
	    		String[] data = line.split(",");//  year,      state,   topic, dataType, valueAv, valueLc,  valueHc, lo, la.
	    		
	    		for (int i = 0; i < data.length; i++) {
	    			data[i] = data[i].isEmpty() || data[i].contains("C")? "0.0" : data[i];
	    		}
	    		
	    		String[] coord = new String[2];
	    		coord[0] = data[23].isEmpty() || data[23].contains("C") ? "0.0" : data[23].replace("\"", "");
	    		coord[0] = coord[0].replace("(", "");
	    		coord[1] = data[24].isEmpty() || data[24].contains("C") ? "0.0" : data[24].replace("\"", "");
	    		coord[1] = coord[1].replace(")", "");
	    		coord[1] = coord[1].replace("(", "");
	    		System.out.println(coord[0]);
	    		CDI cdi = new CDI(Integer.parseInt(data[0]), data[3], data[5], data[8], 
	    				Float.parseFloat(data[12]), 
	    				Float.parseFloat(data[15]), 
	    				Float.parseFloat(data[16]), 
	    				Float.parseFloat(coord[0]), 
	    				Float.parseFloat(coord[1]));
	    		cdis.add(cdi);
	    	}
	    	br.close();
	    } catch (IOException e) {
	    	e.printStackTrace();
	    }
    }
    
    public static ArrayList<CDI> getList() throws Exception {
    	if (cdis.isEmpty())
    		throw new Exception ("IT'S EMPTY!");
		return cdis;
    }

}
