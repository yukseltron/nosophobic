package ndev;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		DataCollection.readFile();
		ArrayList<CDI> cdis = DataCollection.getList();
		
		for (CDI c : cdis) {
			System.out.println(c.toString());
		}
	}

}