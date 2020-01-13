package com.emerald.financialmodelingprep.services.model;

public interface JsonDeserializer
{
	public <T> T fromJson(String json);
}
