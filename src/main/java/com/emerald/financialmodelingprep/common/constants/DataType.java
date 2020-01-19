package com.emerald.financialmodelingprep.common.constants;

public enum DataType
{
	CSV, JSON;

	@Override
	public String toString()
	{
		return name().toLowerCase();
	}
}
