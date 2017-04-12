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
	
	/**
	 * 
	 * @param year The year the data was collected
	 * @param state The state the data is relevant to
	 * @param topic The chronic disease
	 * @param dataType The format the data is store in
	 * @param valueAv The average rating for how prevalent a chronic disease is
	 * @param valueLc The lowest rating for how prevalent a chronic disease is
	 * @param valueHc The highest rating for how prevalent a chronic disease is
	 * @param lo The longitude data
	 * @param la The latitude data
	 */
	public CDI (int year, String state, String topic, String dataType, float valueAv, float valueLc, float valueHc, float la, float lo) {
		this.year = year;
		this.state = state;
		this.topic = topic;
		this.dataType = dataType;
		this.valueAv = valueAv;
		this.valueLc = valueLc;
		this.valueHc = valueHc;
		this.la = la;
		this.lo = lo;
		findDanger();
	}
	
	/**
	 * @return the year
	 */
	public int getYear() {
		return year;
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
	 * @return the value average
	 */
	public float getValueAv() {
		return valueAv;
	}
	/**
	 * @return the value high-count
	 */
	public float getValueHc() {
		return valueHc;
	}
	/**
	 * @return the value low-count
	 */
	public float getValueLc() {
		return valueLc;
	}
	/**
	 * @return the longitude
	 */
	public float getLo() {
		return lo;
	}
	/**
	 * @return the latitude
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
	
	/**
	 * sets the Danger value. ;
	 */
	public void findDanger() {
		if (this.dataType.equals("%")){
			this.danger = valueAv;
		}
	}
	
	/**
	 * @return String representation of the data
	 */
	public String toString() {
		return year + ", " + state + ", " + topic + ", " + dataType + ", " + valueAv + ", " + valueHc + ", " + valueLc + ", " + lo + ", " + la + ", " + danger;
	}
}
