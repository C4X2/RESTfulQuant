package com.emerald.financialmodelingprep.services.profile.impl;

import org.junit.platform.commons.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emerald.financialmodelingprep.api.noargs.profile.model.CompanyProfileAPI;
import com.emerald.financialmodelingprep.common.params.CompanyProfile;
import com.emerald.financialmodelingprep.common.utils.ValidationUtils;
import com.emerald.financialmodelingprep.services.impl.JsonDeserializerImpl;
import com.emerald.financialmodelingprep.services.model.URLConnectionService;
import com.emerald.financialmodelingprep.services.profile.model.CompanyProfileService;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Service @Getter @Setter @Accessors(chain = true)
public class CompanyProfileServiceImpl implements CompanyProfileService
{
	@Autowired
	private CompanyProfileAPI		companyProfileAPI;
	@Autowired
	private URLConnectionService	urlConnectionService;
	private static final String		PROFILE	= "profile";
	private static final String		SYMBOL	= "symbol";

	@Override
	public CompanyProfile getCompanyProfile(String ticker)
	{
		ValidationUtils.validateTicker(ticker);
		String url = getCompanyProfileAPI().buildAPIURL(ticker);
		String json = getUrlConnectionService().get(url);
		CompanyProfile companyProfile = getCompanyProfileFromJsonResponse(json);
		return companyProfile;
	}

	/**
	 * This is need to properly deserialize the response from the Financial Prep API
	 * b/c they format all the Company Profile in a JSON array.
	 * 
	 * @param json json to be deserialized
	 * @return a CompanyProfile object representing the json
	 */
	private CompanyProfile getCompanyProfileFromJsonResponse(final String json)
	{
		if (StringUtils.isBlank(json))
		{
			return null;
		}
		CompanyProfile companyProfile = null;
		JsonObject jObj = null;
		JsonArray jArr = null;
		JsonElement jElem = JsonParser.parseString(json);
		if (jElem.isJsonObject())
		{
			jObj = jElem.getAsJsonObject();
		}
		if (jObj != null && jObj.has(PROFILE))
		{
			companyProfile = JsonDeserializerImpl.getGson().fromJson(jObj.get(PROFILE), CompanyProfile.class);
		}
		if (jObj != null && jObj.has(SYMBOL))
		{
			companyProfile.setSymbol(jObj.get(SYMBOL).getAsString());
		}
		return companyProfile;
	}

}
