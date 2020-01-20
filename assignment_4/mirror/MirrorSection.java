package mirror;

/**
 * This class holds the method to calculate longest mirror subsequence in the array.
 * @author Martand
 *
 */
public class MirrorSection {

	/**
	 * This function reverses the string.
	 * @param firstString string to be reversed.
	 * @return the reversed string.
	 */
	private static String reverse(String firstString){
		String newString="";
		for ( int i=firstString.length()-1; i>=0; i--)
			newString += firstString.charAt(i);
		return newString;
	}

	/**
	 * This function finds the longest mirror substring in given integer array by converting it into string.
	 * @param checkMirror on which mirror is to be find.
	 * @return the maximum mirror length found in array.
	 * @throws AssertionError when array is empty.
	 */
	public static int maxMirror(int[] checkMirror) throws AssertionError{
		if ( checkMirror.length == 0)
			throw new AssertionError();

		int indexOfReversedString=0,countOfMirror=0,maxMirror=-1;
		String intToString ="",reversedSubString="";
		for (int i=0; i<checkMirror.length; i++ )
			intToString+= String.valueOf(checkMirror[i]); 

		for (int i=0; i<intToString.length(); i++ ){
			for (int j=i; j<intToString.length(); j++ ){

				reversedSubString=intToString.substring(i,j+1);
				reversedSubString=reverse(reversedSubString);

				for(int k=0; k<intToString.length(); k++){
					if(indexOfReversedString>=reversedSubString.length())
						break;
					if(reversedSubString.charAt(indexOfReversedString)==intToString.charAt(k)){
						countOfMirror++;
						indexOfReversedString++;
					}
					else{
						indexOfReversedString=0;
						if(countOfMirror>maxMirror)
							maxMirror=countOfMirror;
						countOfMirror=0;
					}
				}
				if(countOfMirror>maxMirror)
					maxMirror=countOfMirror;
				indexOfReversedString=0;
				countOfMirror=0;
			}
		}		
		return maxMirror;
	}
}
