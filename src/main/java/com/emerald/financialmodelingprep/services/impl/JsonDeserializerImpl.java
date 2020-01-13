package com.emerald.financialmodelingprep.services.impl;

import com.google.gson.Gson;

/**
 * A weak wrapper of the Gson {@link Gson#fromJson(String, Class)} to a static service.
 * @version 1.0
 *
 */
public class JsonDeserializerImpl
{
	private static Gson gson = new Gson();

	public static Gson getGson()
	{
		if (gson == null)
		{
			gson = new Gson();
		}
		return gson;
	}
}
