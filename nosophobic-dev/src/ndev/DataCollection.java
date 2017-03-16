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
	    		String[] data = line.split(",");
	    		CDI cdi = new CDI(data[3], data[5], data[8], (float) 9.5, (float) 9.5, (float) 9.5, (float) 9.5, (float) 9.5);
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
