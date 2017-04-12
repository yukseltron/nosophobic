package ndev;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class SortTest {
	
	//used to test sort by year
	CDI year1;
	CDI year2;
	CDI year3;
	CDI year4;
	CDI year5;
	CDI year6;
	CDI year7;
	CDI year8;
	CDI year9;
	CDI year10;
	CDI[] allYears;
	
	//used to test sort by state
	CDI state1;
	CDI state2;
	CDI state3;
	CDI state4;
	CDI state5;
	CDI state6;
	CDI state7;
	CDI state8;
	CDI state9;
	CDI state10;
	CDI[] allStates;
	
	//used to test sort by disease
	CDI disease1;
	CDI disease2;
	CDI disease3;
	CDI disease4;
	CDI disease5;
	CDI disease6;
	CDI disease7;
	CDI disease8;
	CDI disease9;
	CDI disease10;
	CDI[] allDiseases;
	//used to test sort by danger
	CDI danger1;
	CDI danger2;
	CDI danger3;
	CDI danger4;
	CDI danger5;
	CDI danger6;
	CDI danger7;
	CDI danger8;
	CDI danger9;
	CDI danger10;
	CDI[] allDanger;
	
	//sets up stuff to be tested
	@Before
	public void setUp() throws Exception {
		 year1 = new CDI(2007, "Idaho", "cancer", "%", 7.0f, 7.0f, 7.0f, 7.0f, 7.0f);
		 year2 = new CDI(2011, "Idaho", "cancer", "%", 7.0f, 7.0f, 7.0f, 7.0f, 7.0f);
		 year3 = new CDI(2001, "Idaho", "cancer", "%", 7.0f, 7.0f, 7.0f, 7.0f, 7.0f);
		 year4 = new CDI(2013, "Idaho", "cancer", "%", 7.0f, 7.0f, 7.0f, 7.0f, 7.0f);
		 year5 = new CDI(2013, "Idaho", "cancer", "%", 7.0f, 7.0f, 7.0f, 7.0f, 7.0f);
		 year6 = new CDI(2008, "Idaho", "cancer", "%", 7.0f, 7.0f, 7.0f, 7.0f, 7.0f);
		 year7 = new CDI(2003, "Idaho", "cancer", "%", 7.0f, 7.0f, 7.0f, 7.0f, 7.0f);
		 year8 = new CDI(2001, "Idaho", "cancer", "%", 7.0f, 7.0f, 7.0f, 7.0f, 7.0f);
		 year9 = new CDI(2005, "Idaho", "cancer", "%", 7.0f, 7.0f, 7.0f, 7.0f, 7.0f);
		 year10 = new CDI(2007, "Idaho", "cancer", "%", 7.0f, 7.0f, 7.0f, 7.0f, 7.0f);
		 allYears = new CDI[]{year1,year2,year3,year4,year5,year6,year7,year8,year9,year10};
		 
		 state1 = new CDI(2007, "Idaho", "cancer", "%", 7.0f, 7.0f, 7.0f, 7.0f, 7.0f);
		 state2 = new CDI(2007, "California", "cancer", "%", 7.0f, 7.0f, 7.0f, 7.0f, 7.0f);
		 state3 = new CDI(2007, "Texas", "cancer", "%", 7.0f, 7.0f, 7.0f, 7.0f, 7.0f);
		 state4 = new CDI(2007, "Idaho", "cancer", "%", 7.0f, 7.0f, 7.0f, 7.0f, 7.0f);
		 state5 = new CDI(2007, "Arkansa", "cancer", "%", 7.0f, 7.0f, 7.0f, 7.0f, 7.0f);
		 state6 = new CDI(2007, "Mississipi", "cancer", "%", 7.0f, 7.0f, 7.0f, 7.0f, 7.0f);
		 state7 = new CDI(2007, "Illinois", "cancer", "%", 7.0f, 7.0f, 7.0f, 7.0f, 7.0f);
		 state8 = new CDI(2007, "New York", "cancer", "%", 7.0f, 7.0f, 7.0f, 7.0f, 7.0f);
		 state9 = new CDI(2007, "Nebraska", "cancer", "%", 7.0f, 7.0f, 7.0f, 7.0f, 7.0f);
		 state10 = new CDI(2007, "Texas", "cancer", "%", 7.0f, 7.0f, 7.0f, 7.0f, 7.0f);
		 allStates = new CDI[]{state1,state2,state3,state4,state5,state6,state7,state8,state9,state10};
		 
		 disease1 = new CDI(2007, "Idaho", "mental HEALTH", "%", 7.0f, 7.0f, 7.0f, 7.0f, 7.0f);
		 disease2 = new CDI(2007, "Idaho", "Alcoholism", "%", 7.0f, 7.0f, 7.0f, 7.0f, 7.0f);
		 disease3 = new CDI(2007, "Idaho", "cAnCeR", "%", 7.0f, 7.0f, 7.0f, 7.0f, 7.0f);
		 disease4 = new CDI(2007, "Idaho", "Chronic Obstructive Pulmonary Disease", "%", 7.0f, 7.0f, 7.0f, 7.0f, 7.0f);
		 disease5 = new CDI(2007, "Idaho", "cancer", "%", 7.0f, 7.0f, 7.0f, 7.0f, 7.0f);
		 disease6 = new CDI(2007, "Idaho", "Diabetes", "%", 7.0f, 7.0f, 7.0f, 7.0f, 7.0f);
		 disease7 = new CDI(2007, "Idaho", "", "%", 7.0f, 7.0f, 7.0f, 7.0f, 7.0f);
		 disease8 = new CDI(2007, "Idaho", "cancer", "%", 7.0f, 7.0f, 7.0f, 7.0f, 7.0f);
		 disease9 = new CDI(2007, "Idaho", "oral health", "%", 7.0f, 7.0f, 7.0f, 7.0f, 7.0f);
		 disease10 = new CDI(2007, "Idaho", "Arthritis", "%", 7.0f, 7.0f, 7.0f, 7.0f, 7.0f);
		 allDiseases = new CDI[]{disease1, disease2, disease3, disease4, disease5, disease6, disease7, disease8, disease9, disease10};
		 
		 danger1 = new CDI(2007, "Idaho", "Arthritis", "%", 7.0f, 7.0f, 7.0f, 7.0f, 7.0f);
		 danger2 = new CDI(2007, "Idaho", "Arthritis", "%", 37.0f, 7.0f, 7.0f, 7.0f, 7.0f);
		 danger3 = new CDI(2007, "Idaho", "Arthritis", "%", 0.0f, 7.0f, 7.0f, 7.0f, 7.0f);
		 danger4 = new CDI(2007, "Idaho", "Arthritis", "%", -3.0f, 7.0f, 7.0f, 7.0f, 7.0f);
		 danger5 = new CDI(2007, "Idaho", "Arthritis", "%", 25.0f, 7.0f, 7.0f, 7.0f, 7.0f);
		 danger6 = new CDI(2007, "Idaho", "Arthritis", "%", 81.0f, 7.0f, 7.0f, 7.0f, 7.0f);
		 danger7 = new CDI(2007, "Idaho", "Arthritis", "%", 0.01f, 7.0f, 7.0f, 7.0f, 7.0f);
		 danger8 = new CDI(2007, "Idaho", "Arthritis", "%", 99.0f, 7.0f, 7.0f, 7.0f, 7.0f);
		 danger9 = new CDI(2007, "Idaho", "Arthritis", "%", 1111.0f, 7.0f, 7.0f, 7.0f, 7.0f);
		 danger10 = new CDI(2007, "Idaho", "Arthritis", "%", -12.0f, 7.0f, 7.0f, 7.0f, 7.0f);
		 allDanger = new CDI[]{danger1, danger2, danger3, danger4, danger5, danger6, danger7, danger8, danger9, danger10};
	}

	@After
	public void tearDown() throws Exception {
		
	}

	@Test
	public void testYearSort() {
		System.out.println("Sort by year:");
		Sort.sort(allYears, "year");
		assertTrue(Sort.isSorted(allYears, "year"));
		toString(allYears);
	}//end of testStateSort
	
	@Test
	public void testStateSort(){
		System.out.println("Sort by state:");
		Sort.sort(allStates, "states");
		assertTrue(Sort.isSorted(allStates, "states"));
		toString(allStates);
	}//end of testStateSort
	
	@Test
	public void testDiseaseSort(){
		System.out.println("Sort by disease:");
		Sort.sort(allDiseases, "disease");
		assertTrue(Sort.isSorted(allDiseases, "disease"));
		toString(allDiseases);
	}//end of testDiseaseSort
	
	@Test
	public void testDangerSort(){
		System.out.println("Sort by danger:");
		Sort.sort(allDanger, "danger");
		assertTrue(Sort.isSorted(allDanger, "danger"));
		toString(allDanger);
	}//end of testDiseaseSort
	
	private void toString(CDI[] data){
		for (CDI i : data){
			System.out.println(i.getState() + " | " + i.getYear() + " | " + i.getTopic() + " | " + i.getDanger());
		}
		System.out.println("============================");
	}
}
