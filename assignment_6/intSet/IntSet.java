package intSet;

import java.util.*;

/**
 * This class performs operations on set of integer in range of 1-1000.
 * @author Martand
 *
 */
public class IntSet {
	private final int[] SET_OF_INTEGERS;
	
	/**
	 * To access the immutable variables SET_OF_INTEGERS.
	 * @return
	 */
	public int[] getSET_OF_INTEGERS() {
		return SET_OF_INTEGERS.clone();
	}
	
	/**
	 * This constructor initializes the SET_OF_INTEGERS array.
	 * @param initializingArray integer set provided by user.
	 */
	IntSet(int[] initializingArray){
		SET_OF_INTEGERS = initializingArray.clone();
	}
	
	/**
	 * This function checks for the integer value present in the SET_OF_INTEGERS.
	 * @param checkNum value to be checked.
	 * @return if checkNum is a member of SET_OF_INTEGERS then true else false.
	 */
	public boolean isMember(int checkNum){
		for(int i = 0; i < getSET_OF_INTEGERS().length; i++){
			if(getSET_OF_INTEGERS()[i] == checkNum)
				return true;
		}
		return false;
	}
	
	/**
	 * This function provides the size of integer set.
	 * @return size of set.
	 */
	public int size(){
		return getSET_OF_INTEGERS().length;
	}
	
	/**
	 * This Function checks if the object is subset of SET_OF_INTEGERS.
	 * @param checkSet object which is to be checked for subset.
	 * @return true if is subset else false.
	 */
	public boolean isSubSet(IntSet checkSet){
		int i,j;
		for(i = 0; i < checkSet.getSET_OF_INTEGERS().length; i++){
			for(j = 0; j < this.getSET_OF_INTEGERS().length; j++){
				if(checkSet.getSET_OF_INTEGERS()[i] == this.getSET_OF_INTEGERS()[j])
					break;
			}
			if(j == this.getSET_OF_INTEGERS().length)
				return false;
		}
		return true;
	}
	
	/**
	 * This function finds the complement of given set.
	 * @return object of complement of set.
	 */
	public IntSet getComplement(){
		int[] newArray = new int[1000-SET_OF_INTEGERS.length];
		int k =0;
		for(int i=1 ;i<= 1000; i++){
			if(!isMember(i) && k < newArray.length)
				newArray[k++] = i;
		}
		IntSet newObj = new IntSet(newArray);
		return newObj;
	}
	
	/**
	 * This function calculates the union of two sets.
	 * @param obj_1 Object on which union is to be performed.
	 * @param obj_2 Object on which union is to be performed.
	 * @return object containing union of both objects.
	 */
	public static IntSet getUnion(IntSet obj_1, IntSet obj_2){
		ArrayList<Integer> unionList = new ArrayList<Integer>();

		for(int i = 0; i < obj_1.getSET_OF_INTEGERS().length; i++){
			unionList.add(obj_1.getSET_OF_INTEGERS()[i]);
		}
		
		for(int i =0; i < obj_2.getSET_OF_INTEGERS().length; i++){
			if(!obj_1.isMember(obj_2.getSET_OF_INTEGERS()[i]))
				unionList.add(obj_2.getSET_OF_INTEGERS()[i]);
		}
		int[] unionArray = new int[unionList.size()];
		for(int i=0;i<unionList.size(); i++){
			unionArray[i] = unionList.get(i);
		}
		IntSet unionObj = new IntSet(unionArray);
		return unionObj;
	}
	
}
