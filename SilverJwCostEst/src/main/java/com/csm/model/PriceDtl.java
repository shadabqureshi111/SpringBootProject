package com.csm.model;

import java.io.Serializable;
import javax.persistence.*;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;


/**
 * The persistent class for the price_dtls database table.
 * 
 */

@Entity
@Table(name="price_dtls")
@Getter
@Setter
@ToString
public class PriceDtl implements Serializable {
	

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="sl_no")
	private Integer slNo;

	
	@Column(name="current_dat")
	private Date currentDate;

	@Column(name="current_rate_per_gram")
	private Double currentRatePerGram;

	@Column(name="gross_amount")
	private Double grossAmount;

	@Column(name="gst_amount")
	private Double gstAmount;

	@Column(name="making_charge_after_discount")
	private Double makingChargeAfterDiscount;

	@Column(name="net_price")
	private Double netPrice;

	
	@ManyToOne
	@JoinColumn(name="productId")
	private ProductDtl productDtl;
	
	
	
	

}