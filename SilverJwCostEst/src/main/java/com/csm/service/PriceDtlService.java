package com.csm.service;

import java.util.List;

import com.csm.dto.PriceSlab;
import com.csm.model.PriceDtl;

public interface PriceDtlService {
	public PriceDtl convertPriceSlabToPriceDtl(PriceSlab ps);

	public List<PriceDtl> saveAllPriceDtls(List<PriceDtl> priceDtls);

	public List<PriceDtl> getAllList();

}
