package com.emerald.financialmodelingprep.common.utils;

import java.util.Collection;
import java.util.Objects;

public class ValidationUtils
{
	public static void nullCheck(Object ...objects)
	{
		for (Object obj : objects)
		{
			Objects.requireNonNull(obj, "The supplied method parameter cannot be null!");
		}
	}
	
	public static String collectionToDelimitedString(Collection collection)
	{
		return collectionToDelimitedString(collection, ',');
	}
	
	public static String collectionToDelimitedString(Collection collection, char delimiter)
	{
		nullCheck(collection);
		String returnVal = "";
		for (Object item : collection)
		{
			returnVal += (String) item + delimiter;
		}
		returnVal = returnVal.substring(0, returnVal.length() - 2);
		return returnVal;
	}
}
