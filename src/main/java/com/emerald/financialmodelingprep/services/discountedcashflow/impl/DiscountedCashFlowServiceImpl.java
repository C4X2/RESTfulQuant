package com.emerald.financialmodelingprep.services.discountedcashflow.impl;

import org.springframework.stereotype.Service;

import com.emerald.financialmodelingprep.api.args.discountedcashflow.model.DiscountedCashFlowAPI;
import com.emerald.financialmodelingprep.services.discountedcashflow.model.DiscountedCashFlowService;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Service @Getter @Setter @Accessors(chain = true)
public class DiscountedCashFlowServiceImpl implements DiscountedCashFlowService
{
	private DiscountedCashFlowAPI discountedCashFlowAPI;
}
