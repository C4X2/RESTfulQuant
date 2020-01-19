package com.emerald.financialmodelingprep.common.constants;

public enum Period
{
	QUARTER;

	@Override
	public String toString()
	{
		return name().toLowerCase();
	}
}
