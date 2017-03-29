package ndev;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class DataCollection {
	private static String file = "data/uscdi.csv";
    private static BufferedReader br = null;
    private static ArrayList<CDI> cdis = new ArrayList<CDI>();
    private static int counter = 0;
    
    public static void readFile() {
	    try {
	    	br = new BufferedReader(new FileReader(file));
	    	String line = "";
	    	while ((line = br.readLine()) != null) {
	    		String[] data = line.split(",");//  year,      state,   topic, dataType, valueAv, valueLc,  valueHc, lo, la.
	    		data[12] = data[12].replaceAll("[^0-9\\d*$]","");
	    		data[15] = data[15].replaceAll("[^0-9]","");
	    		data[16] = data[16].replaceAll("[^0-9]","");
	    		data[23] = data[23].replaceAll("[^0-9]","");
	    		data[24] = data[24].replaceAll("[^0-9]","");
	    		
	    		System.out.println(counter++ + ":"+data[12] + " " +data[12].isEmpty());
	    		CDI cdi = new CDI(Integer.parseInt(data[0]), data[3], data[5], data[8], //year, state, topic, dataType
	    				Float.parseFloat(data[12].isEmpty() ? "0" : data[12]), //valueAv
	    				Float.parseFloat(data[15].isEmpty() ? "0" : data[15]), //valueLc
	    				Float.parseFloat(data[16].isEmpty() ? "0" : data[16]), //valueHc
	    				Float.parseFloat(data[23].isEmpty() ? "0" : data[23]),//lo
	    				Float.parseFloat(data[24].isEmpty() ? "0" : data[24]));//la
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
