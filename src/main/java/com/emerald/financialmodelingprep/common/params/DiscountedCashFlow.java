package com.emerald.financialmodelingprep.common.params;

import java.math.BigDecimal;
import java.util.Date;

import com.google.gson.annotations.SerializedName;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter @Setter @Accessors(chain = true)
public class DiscountedCashFlow
{
	private String		symbol;
	private Date		date;
	@SerializedName(value = "Stock Price")
	private BigDecimal	stockPrice;
	@SerializedName(value = "DCF")
	private BigDecimal	dcf;
}
