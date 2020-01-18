package com.emerald.financialmodelingprep.services.ratings.impl;

import org.junit.platform.commons.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emerald.financialmodelingprep.api.noargs.ratings.model.CompanyRatingAPI;
import com.emerald.financialmodelingprep.common.params.CompanyRating;
import com.emerald.financialmodelingprep.common.utils.ValidationUtils;
import com.emerald.financialmodelingprep.services.impl.JsonDeserializerImpl;
import com.emerald.financialmodelingprep.services.model.URLConnectionService;
import com.emerald.financialmodelingprep.services.ratings.model.CompanyRatingService;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Service
@Getter
@Setter
@Accessors(chain = true)
public class CompanyRatingServiceImpl implements CompanyRatingService
{
	@Autowired
	private CompanyRatingAPI		companyRatingAPI;
	@Autowired
	private URLConnectionService	urlConnectionService;
	private static final String		RATING			= "rating";
	private static final String		RATING_DETAILS	= "ratingDetails";
	private static final String		PB				= "P/B";
	private static final String		ROA				= "ROA";
	private static final String		DCF				= "DCF";
	private static final String		DE				= "D/E";
	private static final String		PE				= "P/E";
	private static final String		ROE				= "ROE";

	@Override
	public CompanyRating getCompanyRating(String ticker)
	{
		ValidationUtils.validateTicker(ticker);
		String url = this.getCompanyRatingAPI().buildAPIURL(ticker);
		String json = this.getUrlConnectionService().get(url);
		CompanyRating companyRating = getCompanyRatingFromJsonResponse(json);
		return companyRating;
	}

	private CompanyRating getCompanyRatingFromJsonResponse(String json)
	{
		if (StringUtils.isBlank(json))
		{
			return null;
		}
		CompanyRating companyRating = null;
		JsonObject jObj = null;
		JsonElement jElem = null;
		JsonArray jArr = null;
		jElem = JsonParser.parseString(json);
		if (jElem != null && jElem.isJsonObject())
		{
			jObj = jElem.getAsJsonObject();
		}
		if (jObj != null)
		{
			companyRating = jObj.has(RATING)
					? JsonDeserializerImpl.getGson().fromJson(jObj.get(RATING), CompanyRating.class)
					: null;
					// TODO
		}
		return companyRating;
	}

}
