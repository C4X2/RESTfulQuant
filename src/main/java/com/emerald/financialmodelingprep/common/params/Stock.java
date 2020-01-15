package com.emerald.financialmodelingprep.common.params;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * A param class represting the reponse from the {@link com.emerald.financialmodelingprep.api.args.stocks.model.StocksAPI StocksAPI} url.
 * @author C4X2
 * @version 1.0.1
 */
@Getter @Setter @Accessors(chain = true)
public class Stock
{
	private String	symbol;
	private String	price;
}
