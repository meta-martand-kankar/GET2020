package stringOperations;

import java.util.*;

public class StringUtility {

	/**
	 * This function compares the String and return the result based on there equality.
	 * @param str1 First string provided to compare.
	 * @param str2 Second string provided to compare.
	 * @return result after comparing str1 and str2 , i. e., 1 if strings are equala and else 0;
	 */
	public int compareStrings(String str1, String str2){
		int flag = 0;
		if(str1.length() != str2.length()){
			flag = 0;
		}
		else{
			for(int i = 0; i < str1.length(); i++){
				if(str1.charAt(i) == str2.charAt(i)){
					flag = 1;
				}
				else{
					flag = 0;
					break;
				}
			}
		}
		return flag;
	}

	/**\
	 * This function reverses the string. 	
	 * @param str string which is to be reversed.
	 * @return the reverse of String str.
	 */
	public String reverseString(String str){
		StringBuilder reversed = new StringBuilder();
		for(int i = str.length() - 1 ; i >= 0; i--){
			reversed.append(str.charAt(i));
		}
		reversed.append(str.charAt(str.length()-1));
		String result = reversed.toString();
		return result;
	}

	/**
	 * This function works on changing lower cases with upper cases and vice-versa.
	 * @param str String on which conversion is to be performed.
	 * @return the result after converting lower cases to upper cases and vice-versa.
	 */
	public String changeCase(String str){
		StringBuilder changeCase = new StringBuilder();
		char ch;
		for(int i = 0; i < str.length(); i++){
			ch = str.charAt(i);
			if('a' <= str.charAt(i) && str.charAt(i) <= 'z'){
				changeCase.append(Character.toUpperCase(ch));
			}
			else{
				changeCase.append(Character.toLowerCase(ch));
			}
		}

		String result = changeCase.toString();
		return result;
	}

	/**
	 * 	This function finds the lasrgest occuring word in the string.
	 * @param str on which largest occuring word is to found.
	 * @return the largest occuring word in index based on last occuring index when words have same length.
	 */
	public String largestWord(String str){
		int[] frequency = new int[26];
		ArrayList<Integer> lastIndex = new ArrayList<Integer>();
		ArrayList<String> word = new ArrayList<String>();
		int max = 0,index = 0;
		str.toLowerCase();
		for(int i = 0; i < str.length(); i++){
			frequency[str.charAt(i) - 'a']++;
		}

		for(int i = 0; i < 26 ;i++){
			if(max < frequency[i]){
				max = frequency[i];
			}
		}

		for(int i = 0;i< 26; i++){
			if(frequency[i] == max){
				lastIndex.add(str.lastIndexOf('a'+i));
				word.add(Integer.toString('a' + i));
			}
		}
		max = 0;
		for(int i = 0; i < lastIndex.size();i++){
			if(max < lastIndex.get(i)){
				max = lastIndex.get(i);
				index = i;
			}
		}
		return word.get(index);
	}
}
