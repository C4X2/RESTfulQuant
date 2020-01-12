package com.emerald.financialmodelingprep.common.utils;

import java.util.Collection;

import com.emerald.financialmodelingprep.common.utils.ValidationUtils;

public class FinancialModelPrepCollectionUtils
{
    /**
     * <code>FinancialModelPrepCollectionUtils</code> should not normally be instantiated.
     */
	private FinancialModelPrepCollectionUtils() {	}
	
	/**
	 * <p>
	 * Convience method for turing a collection into a String with the standard
	 * character delimiter of ','.
	 * </p>
	 * 
	 * @param collection collection to be turned into a string.
	 * @return a String whose elements are delimited by the ',' character.
	 */
	public static String collectionToDelimitedString(Collection collection)
	{
		return collectionToDelimitedString(collection, ',');
	}
	
	/**
	 * <p>
	 * Convience method for turing a collection into a String with the standard
	 * character delimiter of ','.
	 * </p>
	 * 
	 * @param collection collection to be turned into a string.
	 * @return a String whose elements are delimited by the ',' character.
	 */
	public static String collectionToDelimitedString(Collection collection, char delimiter)
	{
		ValidationUtils.nullCheck(collection);
		String returnVal = "";
		for (Object item : collection)
		{
			returnVal += (String) item + delimiter;
		}
		returnVal = returnVal.substring(0, returnVal.length() - 2);
		return returnVal;
	}
}
