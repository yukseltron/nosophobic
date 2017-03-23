package ndev;

/**
 *@author Hamid Yuksel
 */

public class CDI {
	private int year;
	private String state;
	private String topic;
	private String dataType;
	private float valueAv;
	private float valueHc;
	private float valueLc;
	private float lo;
	private float la;
	private float danger;
	
	CDI (int year, String state, String topic, String dataType, float valueAv, float valueHc, float valueLc, float lo, float la) {
		this.year = year;
		this.state = state;
		this.topic = topic;
		this.dataType = dataType;
		this.valueAv = valueAv;
		this.valueHc = valueHc;
		this.valueLc = valueLc;
		this.lo = lo;
		this.la = la;
		findDanger();
	}
	
	/**
	 * @return the year
	 */
	public String getYear() {
		return state;
	}
	
	/**
	 * @return the state
	 */
	public String getState() {
		return state;
	}
	/**
	 * @return the topic
	 */
	public String getTopic() {
		return topic;
	}
	/**
	 * @return the dataType
	 */
	public String getDataType() {
		return dataType;
	}
	/**
	 * @return the valueAv
	 */
	public float getValueAv() {
		return valueAv;
	}
	/**
	 * @return the valueHc
	 */
	public float getValueHc() {
		return valueHc;
	}
	/**
	 * @return the valueLc
	 */
	public float getValueLc() {
		return valueLc;
	}
	/**
	 * @return the lo
	 */
	public float getLo() {
		return lo;
	}
	/**
	 * @return the la
	 */
	public float getLa() {
		return la;
	}
	/**
	 * @return the danger
	 */
	public float getDanger() {
		return danger;
	}
	
	public void findDanger() {
		//IMPLEMENT
	}
	
	public String toString() {
		return year + ", " + state + ", " + topic + ", " + dataType + ", " + valueAv + ", " + valueHc + ", " + valueLc + ", " + lo + ", " + la;
	}
}
