package com.emerald.financialmodelingprep.common.utils;

import com.emerald.financialmodelingprep.common.params.Company;

public class FinancialModelingPrepUtils
{
	public static Company tickerNameAsCompany(String ticker)
	{
		Company cm = new Company();
		cm.setSymbol(ticker);
		return cm;
	}
}	
