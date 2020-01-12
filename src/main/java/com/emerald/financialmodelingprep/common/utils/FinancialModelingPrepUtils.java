package com.emerald.financialmodelingprep.common.utils;

import com.emerald.financialmodelingprep.common.params.Company;

public class FinancialModelingPrepUtils
{
	/**
	 * <code>FinancialModelingPrepUtils</code> should not normally be instantiated.
	 */
	private FinancialModelingPrepUtils()
	{}

	/**
	 * Builds a company object from a ticker screen.
	 * 
	 * @param ticker a String representing the stock ticker for a company.
	 * @return a company object with the ticker value equal to the supplied
	 *         argument.
	 */
	public static Company tickerNameAsCompany(String ticker)
	{
		Company cm = new Company();
		cm.setSymbol(ticker);
		return cm;
	}
}
