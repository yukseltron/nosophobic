package ndev;
/**
 * @author Bartosz Kosakowski
 *	This class is used to sort the data based on either state, disease,
 *	and the frequency of the disease. Uses a mergesort since it is
 *	guarenteed to have O(NlogN) sorting time.
 */
public class Sort {
	/**
	 * aux is a CDI array that will store the temp array needed by merge sort
	 */
	private static CDI[] aux;
	
	/**
	 * mergeSort takes a Comparable[] array containing the CDI's and sorts
	 * them by state, disease, and frequency of the disease
	 * @param myData - a Comparable array containing the CDI data
	 * @param sortBy - a string indicating which field to sort the 
	 */
	/*public static void mergeSort(Comparable[] myData, String sortBy){
		aux = new Comparable[myData.length];
	}*/
	
	/**
	 * Sorts the data by a given criteria: s == by state, d == by disease
	 * @param myData - an array containing the data we want to sort
	 * @param sortBy - a char indicating how we want to sort the data
	 */
	public static void sortData(CDI[] myData, char sortBy){
		if (sortBy == 's')
			sortByState(myData, 0, myData.length);
		else if (sortBy == 'd')
			sortByDisease(myData, 0, myData.length);
	}
	
	/**
	 * Sorts the data by disease, alphabetically (lexigraphically)
	 * @param myData - Comparable array holding the data needed to be sorted
	 */
	private static void sortByState(CDI[] myData, int lo, int hi){
		if (hi <= lo)
			return;
		int mid = lo + (hi - lo) / 2;
		sortByState(myData, lo, mid);
		sortByState(myData, mid + 1, hi);
		byState(myData, lo, mid, hi);
	}//end of byState
	
	/**
	 * used in the merge sort to merge the two sub-arrays.
	 * @param myData - the input array containing times of jobs that need to be sorted.
	 * @param lo - lowest end of the first sub-array.
	 * @param mid - middle of the array; mid is the end of the first sub-array, mid+1 is the start of the second sub-array.
	 * @param hi - end of the second sub-array.
	 */
	public static void byState(CDI[] myData, int lo, int mid, int hi) {
		int i = lo, j = mid + 1;
		for (int k = lo; k <= hi; k++)
			aux[k] = (CDI) myData[k];
		for (int k = lo; k <= hi; k++)
			if (i > mid)
				myData[k] = aux[j++];
			else if (j > hi)
				myData[k] = aux[i++];
			else if (lesserString(aux[j].getTopic(), aux[i].getTopic())) //CORRECT THIS
				myData[k] = aux[j++];
			else
				myData[k] = aux[i++];
	}//end of merge
	
	
	/**
	 * used to perform a merge sort on a given array
	 * @param myData - the input array containing times of jobs that need to be sorted.
	 * @param lo - start of the array
	 * @param hi - end of the array
	 */
	private static void sortByDisease(CDI[] myData, int lo, int hi) {
		if (hi <= lo)
			return;
		int mid = lo + (hi - lo) / 2;
		sortByDisease(myData, lo, mid);
		sortByDisease(myData, mid + 1, hi);
		byDisease(myData, lo, mid, hi);
	}//end of mergeSort
	
	/**
	 * used in the merge sort to merge the two sub-arrays.
	 * @param myData - the input array containing times of jobs that need to be sorted.
	 * @param lo - lowest end of the first sub-array.
	 * @param mid - middle of the array; mid is the end of the first sub-array, mid+1 is the start of the second sub-array.
	 * @param hi - end of the second sub-array.
	 */
	public static void byDisease(CDI[] myData, int lo, int mid, int hi) {
		int i = lo, j = mid + 1;
		for (int k = lo; k <= hi; k++)
			aux[k] = (CDI) myData[k];
		for (int k = lo; k <= hi; k++)
			if (i > mid)
				myData[k] = aux[j++];
			else if (j > hi)
				myData[k] = aux[i++];
			else if (lesserString(aux[j].getTopic(), aux[i].getTopic()))
				myData[k] = aux[j++];
			else
				myData[k] = aux[i++];
	}//end of merge
	
	/**
	 * Takes two strings, current and next, and compares them
	 * @param current - the current string the sort is looking at
	 * @param next - the string ahead of the current one
	 * @return Returns a boolean value depending on the comparison result: 
	 * if current < next, or if they are the same, then false is returned,
	 * otherwise true, indicating current is out of place
	 */
	//modify this so that it takes a string
	private static boolean lesserString(String current, String next){
		int comparisonResult = current.compareToIgnoreCase(next);
		if (comparisonResult < 0)
			return false;
		else if (comparisonResult == 0)
			return false;
		else
			return true;
	}
}//end of Sort class
