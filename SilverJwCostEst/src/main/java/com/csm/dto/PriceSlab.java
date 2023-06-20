package com.csm.dto;

import java.util.Date;

import com.csm.model.ProductDtl;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class PriceSlab {
	
	private int productId;
	  private double makingChargesPerGram;
	  private double gstPercent;
	  private double discountOnMakingCharges;
	  private double todaySilverRate;

}
