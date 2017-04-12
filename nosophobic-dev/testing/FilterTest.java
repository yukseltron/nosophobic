package ndev;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class FilterTest {
	
	CDI cdi = new CDI(2000, "Alabama", "Disease1", "Datatype", 2, 5, 9, 4, 7);
	CDI cdi1 = new CDI(2000, "California", "Disease1", "Datatype", 2, 5, 9, 4, 7);
	CDI cdi2 = new CDI(2000, "New York", "Disease2", "Datatype", 2, 5, 9, 4, 7);
	CDI cdi3 = new CDI(2000, "New York", "Disease1", "Datatype", 2, 5, 9, 4, 7);
	CDI cdi4 = new CDI(2000, "New York", "Disease3", "Datatype", 2, 5, 9, 4, 7);
	CDI cdi5 = new CDI(2000, "Tennessee", "Disease2", "Datatype", 2, 5, 9, 4, 7);
	CDI cdi6 = new CDI(2000, "Florida", "Disease2", "Datatype", 2, 5, 9, 4, 7);
	CDI cdi7 = new CDI(2000, "Flordia", "Disease2", "Datatype", 2, 5, 9, 4, 7);
	CDI cdi8 = new CDI(2000, "Wisconson", "Disease3", "Datatype", 2, 5, 9, 4, 7);
	CDI cdi9 = new CDI(2000, "New York", "Disease1", "Datatype", 2, 5, 9, 4, 7);
	CDI cdi10 = new CDI(2000, "Vermont", "Disease2", "Datatype", 2, 5, 9, 4, 7);
	CDI cdi11 = new CDI(2000, "New York", "Disease3", "Datatype", 2, 5, 9, 4, 7);
	CDI cdi12 = new CDI(2000, "Utah", "Disease2", "Datatype", 2, 5, 9, 4, 7);
	CDI cdi13 = new CDI(2000, "Florida", "Disease2", "Datatype", 2, 5, 9, 4, 7);
	CDI cdi14 = new CDI(2000, "New York", "Disease3", "Datatype", 2, 5, 9, 4, 7);
	CDI cdi15 = new CDI(2000, "Tennessee", "Disease1", "Datatype", 2, 5, 9, 4, 7);
	CDI cdi16 = new CDI(2000, "Florida", "Disease1", "Datatype", 2, 5, 9, 4, 7);
	CDI cdi17 = new CDI(2000, "Flordia", "Disease3", "Datatype", 2, 5, 9, 4, 7);
	CDI cdi18 = new CDI(2000, "Alabama", "Disease2", "Datatype", 2, 5, 9, 4, 7);
	CDI cdi19 = new CDI(2000, "Florida", "Disease3", "Datatype", 2, 5, 9, 4, 7);
	private ArrayList<CDI> testList1 = new ArrayList<CDI>();
	private ArrayList<CDI> testList2 = new ArrayList<CDI>();
	private ArrayList<CDI> testList3 = new ArrayList<CDI>();


	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test //Will search for Disease3, will return an Arraylist of all CDI instances containing Disease3
	public void testFilterDisease() throws Exception {
		ArrayList<CDI> expectedOutput = new ArrayList<CDI>();
		expectedOutput.add(cdi4);
		expectedOutput.add(cdi8);
		expectedOutput.add(cdi11);
		expectedOutput.add(cdi14);
		expectedOutput.add(cdi17);
		expectedOutput.add(cdi19);
		testList1.add(cdi);
		testList1.add(cdi1);
		testList1.add(cdi2);
		testList1.add(cdi3);
		testList1.add(cdi4);
		testList1.add(cdi5);
		testList1.add(cdi6);
		testList1.add(cdi7);
		testList1.add(cdi8);
		testList1.add(cdi9);
		testList1.add(cdi10);
		testList1.add(cdi11);
		testList1.add(cdi12);
		testList1.add(cdi13);
		testList1.add(cdi14);
		testList1.add(cdi15);
		testList1.add(cdi16);
		testList1.add(cdi17);
		testList1.add(cdi18);
		testList1.add(cdi19);
		ArrayList<CDI> filterDiseases = Filter.filterDisease(testList1, "Disease3");
		assertEquals(expectedOutput, filterDiseases);
	}
	
	@Test //Will search for Disease2, will return an Arraylist of all CDI instances containing Disease2
	public void testFilterDisease2() throws Exception {
		ArrayList<CDI> expectedOutput = new ArrayList<CDI>();
		expectedOutput.add(cdi2);
		expectedOutput.add(cdi5);
		expectedOutput.add(cdi6);
		expectedOutput.add(cdi7);
		expectedOutput.add(cdi10);
		expectedOutput.add(cdi12);
		expectedOutput.add(cdi13);
		expectedOutput.add(cdi18);
		testList2.add(cdi);
		testList2.add(cdi1);
		testList2.add(cdi2);
		testList2.add(cdi3);
		testList2.add(cdi4);
		testList2.add(cdi5);
		testList2.add(cdi6);
		testList2.add(cdi7);
		testList2.add(cdi8);
		testList2.add(cdi9);
		testList2.add(cdi10);
		testList2.add(cdi11);
		testList2.add(cdi12);
		testList2.add(cdi13);
		testList2.add(cdi14);
		testList2.add(cdi15);
		testList2.add(cdi16);
		testList2.add(cdi17);
		testList2.add(cdi18);
		testList2.add(cdi19);
		ArrayList<CDI> filterDiseases = Filter.filterDisease(testList2, "Disease2");
		assertEquals(expectedOutput, filterDiseases);
	}

	@Test //Will search for the state of New York, will return an Arraylist with all CDI instances containing New York
	public void testFilterState() throws Exception {
		ArrayList<CDI> expectedOutput = new ArrayList<CDI>();
		expectedOutput.add(cdi2);
		expectedOutput.add(cdi3);
		expectedOutput.add(cdi4);
		expectedOutput.add(cdi9);
		testList1.add(cdi);
		testList1.add(cdi1);
		testList1.add(cdi2);
		testList1.add(cdi3);
		testList1.add(cdi4);
		testList1.add(cdi5);
		testList1.add(cdi6);
		testList1.add(cdi7);
		testList1.add(cdi8);
		testList1.add(cdi9);
		ArrayList<CDI> filterStates = Filter.filterState(testList1, "New York");
		assertEquals(expectedOutput, filterStates);
	}
	
	@Test //Will search for the state of Wisconson, will return an Arraylist of size 1
	public void testFilterState2() throws Exception {
		ArrayList<CDI> expectedOutput = new ArrayList<CDI>();
		expectedOutput.add(cdi8);
		testList1.add(cdi);
		testList1.add(cdi);
		testList1.add(cdi1);
		testList1.add(cdi2);
		testList1.add(cdi3);
		testList1.add(cdi4);
		testList1.add(cdi5);
		testList1.add(cdi6);
		testList1.add(cdi7);
		testList1.add(cdi8);
		testList1.add(cdi9);
		testList1.add(cdi10);
		testList1.add(cdi11);
		testList1.add(cdi12);
		testList1.add(cdi13);
		testList1.add(cdi14);
		testList1.add(cdi15);
		testList1.add(cdi16);
		testList1.add(cdi17);
		testList1.add(cdi18);
		testList1.add(cdi19);
		ArrayList<CDI> filterStates = Filter.filterState(testList1, "Wisconson");
		assertEquals(expectedOutput, filterStates);
	}
	
	@Test (expected = IllegalStateException.class)//Will throw an exception because the input list is empty
	public void testFilterDiseaseException() throws Exception {
		ArrayList<CDI> filterStates = Filter.filterState(testList3, "New York");
	}
	
	@Test //Will return an empty Arraylist because the disease being searched is not in the list.
	public void testFilterDiseaseNotInList() throws Exception {
		ArrayList<CDI> expectedOutput = new ArrayList<CDI>();
		testList2.add(cdi);
		testList2.add(cdi1);
		testList2.add(cdi2);
		testList2.add(cdi3);
		testList2.add(cdi4);
		testList2.add(cdi5);
		testList2.add(cdi6);
		testList2.add(cdi7);
		testList2.add(cdi8);
		testList2.add(cdi9);
		testList2.add(cdi10);
		testList2.add(cdi11);
		testList2.add(cdi12);
		testList2.add(cdi13);
		testList2.add(cdi14);
		testList2.add(cdi15);
		testList2.add(cdi16);
		testList2.add(cdi17);
		testList2.add(cdi18);
		testList2.add(cdi19);
		//Disease4 is not a valid disease
		ArrayList<CDI> filterDiseases = Filter.filterDisease(testList2, "Disease4");
		assertEquals(expectedOutput, filterDiseases);
	}
	
	@Test //Will return an empty Arraylist because the state being searched is not in the list.
	public void testFilterStateNotInList() throws Exception {
		ArrayList<CDI> expectedOutput = new ArrayList<CDI>();
		testList2.add(cdi);
		testList2.add(cdi1);
		testList2.add(cdi2);
		testList2.add(cdi3);
		testList2.add(cdi4);
		testList2.add(cdi5);
		testList2.add(cdi6);
		testList2.add(cdi7);
		testList2.add(cdi8);
		testList2.add(cdi9);
		testList2.add(cdi10);
		testList2.add(cdi11);
		testList2.add(cdi12);
		testList2.add(cdi13);
		testList2.add(cdi14);
		testList2.add(cdi15);
		testList2.add(cdi16);
		testList2.add(cdi17);
		testList2.add(cdi18);
		testList2.add(cdi19);
		// Ontario is not a valid state
		ArrayList<CDI> filterStates = Filter.filterState(testList2, "Ontario");
		assertEquals(expectedOutput, filterStates);
	}
	
	

}
