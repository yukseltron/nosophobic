package ndev;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class DataCollection {
	private static String file = "nosophobic-dev/data/uscdi.csv";
    private static BufferedReader br = null;
    private static ArrayList<CDI> cdis = new ArrayList<CDI>();
    private static int counter = 0;
    
    public static void readFile() {
	    try {
	    	br = new BufferedReader(new FileReader(file));
	    	String line = "";
	    	while ((line = br.readLine()) != null) {
	    		String[] data = line.split(",");//  year, state, topic, dataType, valueAv, valueLc,  valueHc, lo, la.
	    		int year = 0;
	    		int state = 2;
	    		int topic = 5;
	    		int dataType = 8;
	    		int valueAv = 12;
	    		int valueLc = 15;
	    		int valueHc = 16;
	    		int lat = 23;
	    		int lon = 24;
	    		
	    		if (data.length == 30){
	    			lat = 22;
	    			lon = 23;
	    		} else if (data.length == 32 || data.length == 36) {
	    			lat = 24;
	    			lon = 25;
	    		} else if (data.length == 33) {
	    			valueAv = 13;
	    			valueLc = 17;
	    			valueHc = 18;
	    			lat = 25;
	    			lon = 26;
	    		} else if (data.length == 34) {
	    			valueAv = 10;
	    			valueLc = 10;
	    			valueHc = 10;
	    			lat = 10;
	    			lon = 10;
	    		} else if (data.length == 35) {
	    			valueAv = 10;
	    		} else if (data.length == 37) {
	    			lat = 25;
	    			lon = 26;
	    			valueLc = 7;
	    		} else if (data.length == 38) {
	    			lat = 26;
	    			lon = 27;
	    			valueAv= 7;
	    			valueHc = 7;
	    			valueLc = 7;
	    		}
	    		
	    		data[valueAv] = data[valueAv].replaceAll("[^0-9\\.]","");
	    		data[valueLc] = data[valueLc].replaceAll("[^0-9\\.\\-]","");
	    		data[valueHc] = data[valueHc].replaceAll("[^0-9\\.\\-]","");
	    		data[lat] = data[lat].replaceAll("[^0-9\\.\\-]","");
	    		data[lon] = data[lon].replaceAll("[^0-9\\.\\-]","");
	    		
	  		
	    		CDI cdi = new CDI(Integer.parseInt(data[year]), data[state], data[topic], data[dataType], //year, state, topic, dataType
	    				isFloat(data[valueAv]), //valueAv
	    				isFloat(data[valueLc]), //valueLc
	    				isFloat(data[valueHc]), //valueHc
	    				isFloat(data[lat]),//lat
	    				isFloat(data[lon]));//lon
	    		cdis.add(cdi);
	    	}
	    	br.close();
	    } catch (IOException e) {
	    	e.printStackTrace();
	    }
    }
    
    public static float isFloat(String s) {
    	try
    	{
    		if (s.equals(""))
    			return 0;
    		Float.parseFloat(s);
    	}
    	catch(NumberFormatException e)
    	{
    		return 0;
    	}
    	return Float.parseFloat(s);
    }
    
    public static ArrayList<CDI> getList() throws Exception {
    	if (cdis.isEmpty())
    		throw new Exception ("IT'S EMPTY!");
		return cdis;
    }

}
