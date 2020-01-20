package clumps;

/**
 * This class counts the clumps in given array.
 * @author Martand
 *
 */
public class Clump {
	/**
	 * This function counts the total clumps in the array.
	 * @param clumps holds the array in which clumps are to be calculated.
	 * @return total count of clumps and 0 if length of array is < 2.
	 * @throws AssertionError for empty array.
	 */
	public static int countClumpsInArrayList( int[] clumps) throws AssertionError{
		if(clumps == null)
			throw new AssertionError("Array length is insufficient");
		else if(clumps.length < 2)
			return 0;
		int countClumps =0;
		for(int i = 0; i<clumps.length-1; i++){
			if(clumps[i] == clumps[i+1]){
				while(i < clumps.length-1 && clumps[i] == clumps[i+1]){
					i++;
				}
				countClumps++;
			}
			else{
				continue;
			}
		}
		return countClumps;
	}
}
