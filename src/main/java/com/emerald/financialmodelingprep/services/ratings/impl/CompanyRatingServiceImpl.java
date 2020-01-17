package com.emerald.financialmodelingprep.services.ratings.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emerald.financialmodelingprep.api.noargs.ratings.model.CompanyRatingAPI;
import com.emerald.financialmodelingprep.common.params.CompanyRating;
import com.emerald.financialmodelingprep.common.utils.ValidationUtils;
import com.emerald.financialmodelingprep.services.impl.JsonDeserializerImpl;
import com.emerald.financialmodelingprep.services.model.URLConnectionService;
import com.emerald.financialmodelingprep.services.ratings.model.CompanyRatingService;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Service @Getter @Setter @Accessors(chain = true)
public class CompanyRatingServiceImpl implements CompanyRatingService
{
	@Autowired
	private CompanyRatingAPI		companyRatingAPI;
	@Autowired
	private URLConnectionService	urlConnectionService;

	@Override
	public CompanyRating getCompanyRating(String ticker)
	{
		ValidationUtils.validateTicker(ticker);
		String url = this.getCompanyRatingAPI().buildAPIURL(ticker);
		String json = this.getUrlConnectionService().get(url);
		return JsonDeserializerImpl.getGson().fromJson(json, CompanyRating.class);
	}

}
