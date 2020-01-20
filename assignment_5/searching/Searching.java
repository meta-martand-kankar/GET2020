package searching;

/**
 * This class searches element in array using linear search and binary search.
 * @author Martand
 *
 */
public class Searching {
	private int i = 0 ;
	private int mid =0,begin = 0,end =0;

	/**
	 * This function finds the element present in array using Linear Search.
	 * @param searchArray in which element os to be searched.
	 * @param searchElement element to be searched.
	 * @return the index if element found in array else gives -1.
	 */
	public int findElementUsingLinearSearch(int[] searchArray, int searchElement){
		if(searchArray[i] == searchElement)
			return i +1;
		else if(i == searchArray.length-1)
			return -1;
		else{
			i++;
			return findElementUsingLinearSearch(searchArray, searchElement);
		}
	}


	/**
	 * This function finds the element present in array using Binary Search.
	 * @param searchArray in which element is to be searched.
	 * @param searchElement element to be searched.
	 * @return the index if element found in array else gives -1.
	 */
	public int findElementUsingBinarySearch(int[] searchArray, int searchElement){
		if(mid == 0 && begin == 0 && end ==0){
			begin = 0;
			end = searchArray.length;
		}
		mid = (begin+end)/2;
		if(searchArray[mid] == searchElement)
			return mid+1;
		else if(begin >= end || searchArray[searchArray.length-1] < searchElement)
			return -1;
		else if(searchArray[mid] < searchElement)
			begin = mid+1;
		else if(searchArray[mid] > searchElement)
			end = mid-1;
		return findElementUsingBinarySearch(searchArray, searchElement);
	}
}
