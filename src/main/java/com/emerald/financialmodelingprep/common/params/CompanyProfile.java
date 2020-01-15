package com.emerald.financialmodelingprep.common.params;

import java.math.BigDecimal;
import java.math.BigInteger;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * A param class representing the response from the
 * {@link com.emerald.financialmodelingprep.api.noargs.profile.model.CompanyProfileAPI
 * CompanyProfileAPI} url.
 *
 * @author C4X2
 * @version 1.0
 */
@Getter
@Setter
@Accessors(chain = true)
public class CompanyProfile
{
	private BigDecimal	beta;
	private String		ceo;
	private BigDecimal	changes;
	private String		changesPercentage;
	private String		companyName;
	private String		description;
	private String		exchange;
	private String		image;
	private String		industry;
	private BigDecimal	lastDiv;
	private BigInteger	mktCap;
	private BigDecimal	price;
	/**
	 * This represents the range of the stock price over the period of time, usually
	 * a year. Delimited by the '-' character.
	 */
	private String		range;
	private String		sector;
	private String		symbol;
	private Long		volAvg;
	private String		website;
}
