package com.emerald.financialmodelingprep.common.params;

import java.math.BigDecimal;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter @Setter @Accessors(chain = true)
public class CryptocurrencyCoin
{
    private String ticker;
    private String name;
    private BigDecimal price;
    private BigDecimal changes;
    private Long marketCapitalization;
}
