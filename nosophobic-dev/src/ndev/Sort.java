package ndev;
/**
 * @author Bartosz Kosakowski
 *	This class is used to sort the data based on either state, disease,
 *	and the frequency of the disease. Uses a mergesort since it is
 *	guarenteed to have O(NlogN) sorting time.
 */
public class Sort {
	/**
	 * sortedData is a Comparable array that will store the sorted array
	 */
	private static Comparable[] sortedData;
	private static Comparable[] aux;
	
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
	public static void sortData(Comparable[] myData, char sortBy){
		if (sortBy == 's')
			System.out.println("Sorting by state");
		else if (sortBy == 'd')
			System.out.println("Sorting by disease");
	}
	
	/**
	 * Sorts the data by disease, alphabetically (lexigraphically)
	 * @param myData - Comparable array holding the data needed to be sorted
	 */
	private static void byState(Comparable[] myData, int lo, int hi){
	}//end of byState
	
	/**
	 * Sorts the data by disease, alphabetically (lexigraphically)
	 * @param myData - Comparable array holding the data needed to be sorted
	 */
	private static void byDisease(Comparable[] myData, int lo, int hi){
	}//end of byDisease
	
	/**
	 * used to perform a merge sort on a given array
	 * @param x - the input array containing times of jobs that need to be sorted.
	 * @param lo - start of the array
	 * @param hi - end of the array
	 */
	private static void mergeSort(Comparable[] x, int lo, int hi) {
		if (hi <= lo)
			return;
		int mid = lo + (hi - lo) / 2;
		mergeSort(x, lo, mid);
		mergeSort(x, mid + 1, hi);
		merge(x, lo, mid, hi);
	}//end of mergeSort
	
	/**
	 * used in the merge sort to merge the two sub-arrays.
	 * @param x - the input array containing times of jobs that need to be sorted.
	 * @param lo - lowest end of the first sub-array.
	 * @param mid - middle of the array; mid is the end of the first sub-array, mid+1 is the start of the second sub-array.
	 * @param hi - end of the second sub-array.
	 */
	public static void merge(Comparable[] x, int lo, int mid, int hi) {
		int i = lo, j = mid + 1;
		for (int k = lo; k <= hi; k++)
			aux[k] = x[k];
		for (int k = lo; k <= hi; k++)
			if (i > mid)
				x[k] = aux[j++];
			else if (j > hi)
				x[k] = aux[i++];
			else if (lesserString(aux[j], aux[i]))
				x[k] = aux[j++];
			else
				x[k] = aux[i++];
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
	private static boolean lesserString(Comparable current, Comparable next){
		int comparisonResult = current.compareTo(next);//current.compareToIgnoreCase(next);
		if (comparisonResult < 0)
			return false;
		else if (comparisonResult == 0)
			return false;
		else
			return true;
	}
}//end of Sort class
