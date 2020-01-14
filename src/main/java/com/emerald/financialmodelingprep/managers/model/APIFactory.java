package com.emerald.financialmodelingprep.managers.model;

import com.emerald.financialmodelingprep.api.FinancialModelingPrepAPI;
import com.emerald.financialmodelingprep.common.constants.APICallType;

public interface APIFactory
{
	public FinancialModelingPrepAPI getAPIOfType(APICallType callType);
}
