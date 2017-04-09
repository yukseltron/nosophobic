package ndev;

/**
 * This class is used to sort the data based on either state, 
 * disease, and the frequency of the disease using quicksort.
 * @author Bartosz Kosakowski 
 */
public class Sort {	
	/**
	 * Main sorting function, calls all other functions required to perfomr a quicksort
	 * @param data - a CDI array to be sorted.
	 * @param sortBy - string representing how the data is to be sorted (disease, state, danger)
	 */
	public static void sort(CDI[] data, String sortBy) {
		sort(data, 0, data.length - 1, sortBy);
	}//end of sort

	/**
	 * Used to sort the data by whatever is specified by sortBy
	 * @param data - CDI array to be sorted
	 * @param lo - int value representing the left-most value of the array
	 * @param hi - int value representing the right-most value of the array
	 * @param sortBy - String representing how the data should be sorted (disease, state, danger (default sort type))
	 */
	private static void sort(CDI[] data, int lo, int hi, String sortBy) {
		if (hi <= lo)
			return;
		int j = partition(data, lo, hi, sortBy); // Partition (see page 291).
		sort(data, lo, j - 1, sortBy); // Sort left part data[lo .. j-1].
		sort(data, j + 1, hi, sortBy); // Sort right part data[j+1 .. hi].
	}//end of sort

	/**
	 * Performs a partition of a given array
	 * @param data - CDI array to be partitioned
	 * @param lo - low end of the array
	 * @param hi - high end of the array
	 * @param sortBy - String representing how the data should be sorted (disease, state, danger (default sort type))
	 * @return int representing the new pivot value to use in further partitions
	 */
	private static int partition(CDI[] data, int lo, int hi, String sortBy) { 
		int i = lo, j = hi + 1; // left datand right scan indices
		CDI v = data[lo]; // partitioning item
		while (true) { // Scan right, scan left, check for scan complete, datand
						// exchange.
			while (greater(data[++i], v, sortBy))
				if (i == hi)
					break;
			while (greater(v, data[--j], sortBy))
				if (j == lo)
					break;
			if (i >= j)
				break;
			swap(data, i, j);
		}
		swap(data, lo, j); // Put v = data[j] into position
		return j;
	}//end of partition
	
	/**
	 * Compares two values and output boolean representing which is lower than the other.
	 * If sortBy is not "disease" or "state", it automatically sorts by danger
	 * @param current - the current CDI being compared.
	 * @param next - the next CDI being compared.
	 * @param sortBy - String representing how the data should be sorted (disease, state, danger (default sort type))
	 * @return boolean value indicating if the value of current is less than the value of next (true if so, else false).
	 */
	private static boolean greater(CDI current, CDI next, String sortBy) {
		if (sortBy.toLowerCase().contains("disease"))
			return (current.getTopic().compareToIgnoreCase(next.getTopic()) > 0);
		else if (sortBy.toLowerCase().contains("state"))
			return (current.getState().compareToIgnoreCase(next.getState()) > 0);
		else if (sortBy.toLowerCase().contains("year"))
			return (current.getYear() > next.getYear());
		else 
			return (current.getDanger() > next.getDanger());
	}// end of greater method
	
	/**
	 * Performs a swap on the values in the array
	 * @param data - CDI array to be sorted
	 * @param i - index of first element to be swapped
	 * @param j - index of second element to be swapped
	 */
	private static void swap(CDI[] data, int i, int j) {
		CDI t = data[i];
		data[i] = data[j];
		data[j] = t;
	}// end of swap method
	
	/**
	 * Prints the data to the console
	 * @param data - CDI array to be printed
	 */
	public static void toString(CDI[] data){
		for (int i = 0; i < data.length; i++)
			System.out.println(data[i].getTopic() + " | " + data[i].getState());
	}//end of toString
	
	/**
	 * Used to check if the data is sorted correctly by a given sorting criteria
	 * @param data - the data we want to sort
	 * @param sortBy - String representing how the data should be sorted (disease, state, danger (default sort type))
	 * @return boolean value indicating if the data was sorted correctly or not (true/false, respectively)
	 */
	public static boolean isSorted(CDI[] data, String sortBy){
		for (int i = 1; i < data.length; i++)
			if (sortBy.toLowerCase().equals("disease"))
				if (!(data[i-1].getTopic().compareToIgnoreCase(data[i].getTopic())>=0))
					return false;
			else if (sortBy.toLowerCase().equals("state"))
				if (!(data[i-1].getState().compareToIgnoreCase(data[i].getState())>=0))
					return false;
			else if (sortBy.toLowerCase().equals("year"))
				if (!(data[i-1].getYear()>=data[i].getYear()))
					return false;
			else
				if (!(data[i-1].getDanger() >= data[i].getDanger()))
					return false;
		return true;
	}//end of isSorted
}// end of Sort class
