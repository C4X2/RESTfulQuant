package com.emerald.financialmodelingprep.managers.impl;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.emerald.financialmodelingprep.common.exceptions.UninitializedException;

public class PropertyManager
{
	List<Properties> cachedProperties;

	public PropertyManager(String filename) throws IOException
	{
		cachedProperties = new ArrayList<Properties>();
		FileInputStream fis = new FileInputStream(filename);
		Properties prop = new Properties();
		prop.load(fis);
		cachedProperties.add(prop);
	}

	public void flush()
	{
		this.cachedProperties = new ArrayList<Properties>();
	}

	public void addPropertyFile(String filename)
			throws IOException, FileNotFoundException, SecurityException, IllegalArgumentException
	{
		FileInputStream fis = new FileInputStream(filename);
		Properties prop = new Properties();
		prop.load(fis);
		if (this.cachedProperties == null)
		{
			cachedProperties = new ArrayList<Properties>();
		}
		cachedProperties.add(prop);
	}

	public Object getProperty(String key) throws UninitializedException
	{
		if (this.cachedProperties == null)
		{
			throw new UninitializedException("The class property of cachedProperties has not be initialized");
		}

		Object value = null;

		for (Properties property : cachedProperties)
		{
			value = property.get(key);
			if (value != null)
			{
				break;
			}
		}
		return value;
	}

}
