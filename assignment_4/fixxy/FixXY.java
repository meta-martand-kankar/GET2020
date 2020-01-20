package fixxy;

/**
 * Rearranges the position of X and Y in the array .
 * @author Martand
 *
 */
public class FixXY {

	/**
	 * This function rearranges the position of Y in accordance of X in the given Array.
	 * @param fixXYInArray Array to be rearranged.
	 * @param xForRearrange value of X.
	 * @param yForRearrange value of Y.
	 * @return the array with rearranged positions of X and Y.
	 * @throws AssertionError for "Empty Array"; "X at last Index"; "Adjacent X in array"; "Unequal X and Y in array";
	 */
	public static int[] rearrangeXY(int[] fixXYInArray,int xForRearrange, int yForRearrange) throws AssertionError{
		int countOfX =0, countOfY =0;
		System.out.println("length : "+fixXYInArray.length);
		if(fixXYInArray.length == 0){
			throw new AssertionError("array is empty");
		}
		else if(fixXYInArray[fixXYInArray.length-1] == xForRearrange){
			throw new AssertionError("x present at last index");
		}
		else{
			for(int i = 0;i < fixXYInArray.length; i++){
				if(fixXYInArray[i] == xForRearrange && fixXYInArray[i+1] != yForRearrange){
					countOfX++;
					for(int j = 0; j < fixXYInArray.length; j++){
						if(j-1 >= 0 && fixXYInArray[j] == yForRearrange && fixXYInArray[j-1] != xForRearrange){
							countOfY++;
							fixXYInArray[j]=fixXYInArray[i+1];
							fixXYInArray[i+1] = yForRearrange;
							break;
						}
						else if(fixXYInArray[j] == yForRearrange && j==0){
							countOfY++;
							fixXYInArray[j]=fixXYInArray[i+1];
							fixXYInArray[i+1] = yForRearrange;
							break;
						}
					}
				}
				else if(fixXYInArray[i] == xForRearrange && fixXYInArray[i+1] == xForRearrange){
					throw new AssertionError("adjacent x's found");
				}
			}
			if(countOfX != countOfY){
				throw new AssertionError("counts are different");
			}
		}
		for( int j =0; j< fixXYInArray.length ; j++){
			System.out.println("output : " + fixXYInArray[j]);	
		}

		return fixXYInArray;

	}
}
