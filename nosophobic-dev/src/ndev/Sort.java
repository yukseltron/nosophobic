package ndev;

/**
 * This class is used to sort the data based on either state, 
 * disease, and the frequency of the disease using quicksort.
 * @author Bartosz Kosakowski 
 */
public class Sort {
	//############## USED FOR TESTING
	//int year, String state, String topic, String dataType, float valueAv, float valueHc, float valueLc, float lo, float la
	public static void main (String [] args){
		CDI test1 = new CDI(10, "Bartoszland", "Aids", "wat", 7, 6, 7, 6, 7);
		CDI test2 = new CDI(10, "California", "Cancer", "wat", 7, 6, 7, 6, 7);
		CDI test3 = new CDI(10, "Illinois", "Alcoholism", "wat", 7, 6, 7, 6, 7);
		CDI test4 = new CDI(10, "Georgia", "Syphillis", "wat", 7, 6, 7, 6, 7);
		CDI test5 = new CDI(10, "Texas", "Gangern", "wat", 7, 6, 7, 6, 7);
		
		CDI[] sortTest = {test3, test5, test1, test4, test2};
		
		System.out.println("state:");
		Sort.toString(sortTest);
		System.out.println("============================");
		Sort.sort(sortTest, "state");
		Sort.toString(sortTest);
		System.out.println("\n");
		
		System.out.println("disease:");
		Sort.toString(sortTest);
		System.out.println("============================");
		Sort.sort(sortTest, "disease");
		Sort.toString(sortTest);
	}//end of main
	
	/**
	 * Main sorting function, calls all other functions required to perfomr a quicksort.
	 * @param data - a CDI array to be sorted.
	 * @param sortBy - string representing how the data is to be sorted (disease, state, danger)
	 */
	public static void sort(CDI[] data, String sortBy) {
		sort(data, 0, data.length - 1, sortBy);
	}

	private static void sort(CDI[] data, int lo, int hi, String sortBy) {
		if (hi <= lo)
			return;
		int j = partition(data, lo, hi, sortBy); // Partition (see page 291).
		sort(data, lo, j - 1, sortBy); // Sort left part data[lo .. j-1].
		sort(data, j + 1, hi, sortBy); // Sort right part data[j+1 .. hi].
	}

	private static int partition(CDI[] data, int lo, int hi, String sortBy) { 
		int i = lo, j = hi + 1; // left datand right scan indices
		CDI v = data[lo]; // partitioning item
		while (true) { // Scan right, scan left, check for scan complete, datand
						// exchange.
			while (lessBy(data[++i], v, sortBy))
				if (i == hi)
					break;
			while (lessBy(v, data[--j], sortBy))
				if (j == lo)
					break;
			if (i >= j)
				break;
			swap(data, i, j);
		}
		swap(data, lo, j); // Put v = data[j] into position
		return j;
	}
	
	/**
	 * Compares two values and output boolean representing which is lower than the other.
	 * If sortBy is not "disease" or "state", it automatically sorts by danger
	 * @param current - the current CDI being compared.
	 * @param next - the next CDI being compared.
	 * @param sortBy - the search criteria do be sorted by.
	 * @return boolean value indicating if the value of current is less than the value of next (true if so, else false).
	 */
	private static boolean lessBy(CDI current, CDI next, String sortBy) {
		if (sortBy.equalsIgnoreCase("disease"))
			return (current.getTopic().compareToIgnoreCase(next.getTopic())<0);
		else if (sortBy.equalsIgnoreCase("state"))
			return (current.getState().compareToIgnoreCase(next.getState()) < 0);
		else 
			return (current.getDanger() < next.getDanger());
	}// end of lessBy method

	private static void swap(CDI[] data, int i, int j) {
		CDI t = data[i];
		data[i] = data[j];
		data[j] = t;
	}// end of swap method
	
	public static void toString(CDI[] data){
		for (int i = 0; i < data.length; i++)
			System.out.println(data[i].getTopic() + " | " + data[i].getState());
	}
}// end of Sort class
