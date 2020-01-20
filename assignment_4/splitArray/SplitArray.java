package splitArray;

/**
 * Splits array On basis of sum of elements where total of each half is equal.
 * @author Martand
 *
 */
public class SplitArray {

	/**
	 * This function checks if array can be partitioned in equal halves or not.
	 * @param splitArray array on which split operation is performed.
	 * @return the index where sum of two halves become equal.
	 * @throws AssertionError when array is empty.
	 */
	public static int returnIndexWhenSumEquals(int[] splitArray) throws AssertionError{
		int index,sum,tempSum=0;
		if(splitArray == null)
			throw new AssertionError("Array is Empty");
		else{
			sum = sumOfArray(splitArray);
			if(sum%2 != 0)
				return -1;
			tempSum = sum/2;
			for(index = 0; index < splitArray.length; index++){
				if(tempSum == sum)
					break;
				else if(tempSum>sum)
					return -1;
				else
					sum -= splitArray[index];
			}
		}
		return index;
	}

	/**
	 * To calculate sum of elements of array.
	 * @param arrayToAdd array on which addition is done.
	 * @return sum of elements.
	 */
	private static int sumOfArray(int[] arrayToAdd){
		int sum =0;
		for(int i= 0; i < arrayToAdd.length; i++){
			sum += arrayToAdd[i];
		}
		return sum;
	}
}
