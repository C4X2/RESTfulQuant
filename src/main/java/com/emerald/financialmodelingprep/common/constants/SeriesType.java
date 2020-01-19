package com.emerald.financialmodelingprep.common.constants;

import com.emerald.financialmodelingprep.api.args.RESTfulURLArgumentParameters;

public enum SeriesType implements RESTfulURLArgumentParameters
{
	LINE;

	@Override
	public String toString()
	{
		return name().toLowerCase();
	}
}
