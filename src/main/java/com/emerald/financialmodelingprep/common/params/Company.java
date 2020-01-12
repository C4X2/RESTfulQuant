package com.emerald.financialmodelingprep.common.params;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * To represent a company
 * 
 * @author C4X2
 * @version 1.0
 */
@Getter @Setter @Accessors(chain = true)
public class Company
{
	private String	symbol;
	private String	name;
}
