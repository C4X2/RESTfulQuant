package com.emerald.financialmodelingprep.services.impl;

import com.google.gson.Gson;

/**
 * A weak wrapper of the {@link Gson} dependency to transform it into a static
 * service.
 * 
 * @version 1.1
 *
 */
public class JsonDeserializerImpl
{
	private static Gson gson;

	public static Gson getGson()
	{
		// Check to see if the current instance of Gson is null
		if (gson == null)
		{
			// If it is null, lock down this class and check again
			synchronized (JsonDeserializerImpl.class)
			{
				if (gson == null)
				{
					gson = new Gson();
				}
			}
		}
		return gson;
	}
}
