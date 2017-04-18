/**
 * @author Hamid Yuksel
 */
package ndev;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Random;

import org.junit.Before;
import org.junit.Test;

public class testIntegration {

	ArrayList<CDI> cdis1 = new ArrayList<CDI>();
	ArrayList<CDI> cdis2 = new ArrayList<CDI>();
	ArrayList<CDI> cdis3 = new ArrayList<CDI>();
	ArrayList<CDI> cdis4 = new ArrayList<CDI>();
	
	@Before
	public void setUp() throws Exception {
		int year = 2001;
		String state = "NY";
		String topic = "Alcohol";
		String dataType = "%";
		float valueAv = (float) 10.5;
		float valueLc = (float) 5.5;
		float valueHc = (float) 12.5;
		float la = (float) 70.89;
		float lo = (float) 12.98;
		
		for (int i=0; i < 10; i++) {
			CDI cdi = new CDI(year, state, topic, dataType, valueAv, valueLc, valueHc, la, lo);
			cdis1.add(cdi);
		}
		
		year = 2023;
		state = "Kobe";
		topic = "Bryant";
		dataType = "?";
		valueAv = (float) 20.3;
		valueLc = (float) -14.7;
		valueHc = (float) 22.3;
		la = (float) -70.89;
		lo = (float) -12.98;
		
		for (int i=0; i < 10; i++) {
			CDI cdi = new CDI(year, state, topic, dataType, valueAv, valueLc, valueHc, la, lo);
			cdis2.add(cdi);
		}
		
		Random rand = new Random();
		year = rand.nextInt(4000);
		state = "NY";
		topic = "Addiction";
		dataType = "#";
		valueAv = (float) rand.nextInt(100);
		valueLc = (float) rand.nextInt(100);
		valueHc = (float) rand.nextInt(100);
		la = (float) rand.nextInt(100);
		lo = (float) rand.nextInt(100);
		
		for (int i=0; i < 10; i++) {
			CDI cdi = new CDI(year, state, topic, dataType, valueAv, valueLc, valueHc, la, lo);
			cdis3.add(cdi);
		}
		
		year = rand.nextInt(4000);
		state = "NY";
		topic = "Alcohol";
		dataType = "#";
		valueAv = (float) rand.nextInt((40 - -40) + 1) + -40;
		valueLc = (float) rand.nextInt((30 - -20) + 1) + -20;
		valueHc = (float) rand.nextInt((50 - -10) + 1) + -10;
		la = (float) rand.nextInt((100 - -100) + 1) + -100;
		lo = (float) rand.nextInt((100 - -100) + 1) + -100;
		
		for (int i=0; i < 10; i++) {
			CDI cdi = new CDI(year, state, topic, dataType, valueAv, valueLc, valueHc, la, lo);
			cdis4.add(cdi);
		}
	}

	@Test
	public void testSumDanger1() throws Exception {
		float n = RunNosophobic.sumDanger(cdis1, "NY", "Alcohol");
		assertEquals(105,Math.round(n));
	}
	
	@Test(expected=IllegalStateException.class)
	public void testSumDanger2() throws Exception {
		float n = RunNosophobic.sumDanger(cdis2, "AL", "Depression");
	}
	
	@Test
	public void testSumDanger3() throws Exception {
		float n = RunNosophobic.sumDanger(cdis3, "NY", "Alcohol");
		assertEquals(0,Math.round(n));
	}
	
	@Test
	public void testSumDanger4() throws Exception {
		float n = RunNosophobic.sumDanger(cdis4, "NY", "Alcohol");
		assertEquals(0,Math.round(n));
	}
}
