package com.emerald.financialmodelingprep.common.utils;

import java.util.Collection;
import java.util.Objects;

public class ValidationUtils
{
    /**
     * <code>ValidationUtils</code> should not normally be instantiated.
     */
	private ValidationUtils() {}
	
	/**
	 * Checks the input to see if any of the supplied arguments are null, if they
	 * are a NullPointerException is thrown.
	 * 
	 * @param objects an array of objects
	 */
	public static void nullCheck(Object... objects)
	{
		for (Object obj : objects)
		{
			Objects.requireNonNull(obj, "The supplied method parameter cannot be null!");
		}
	}

}
